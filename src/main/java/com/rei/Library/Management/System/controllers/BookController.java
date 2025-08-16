package com.rei.Library.Management.System.controllers;

import com.rei.Library.Management.System.dto.BookDto;
import com.rei.Library.Management.System.entity.BookEntity;
import com.rei.Library.Management.System.mapper.BookMapper;
import com.rei.Library.Management.System.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    BookMapper bookMapper;

    BookService bookService;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto savedBook = bookService.saveBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/books")
    public Page<BookDto>
    findAllBooks(@RequestParam(defaultValue ="0") int page,
                 @RequestParam(defaultValue = "10") int size,
                 @RequestParam(defaultValue = "name") String sortBy){
        Page<BookEntity> foundBook = bookService.findAll(page,size, sortBy);
        return foundBook.map(bookEntity -> bookMapper.mapTo(bookEntity));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> findOneBook(@PathVariable Long id){
     return   bookService.findOne(id).map(bookEntity -> {

            BookDto foundBookDto =  bookMapper.mapTo(bookEntity);
            return new ResponseEntity<>(foundBookDto,HttpStatus.OK);

        }).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDto> updateBooks(@PathVariable Long id, @RequestBody BookDto bookDto){
        if (!bookService.exist(id)){
            return ResponseEntity.notFound().build();
        }

        BookDto updatedBook = bookService.updateBook(id,bookDto);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<BookDto> partialUpdate(@PathVariable Long id, @RequestBody BookDto bookDto){
        if (!bookService.exist(id))
            return ResponseEntity.notFound().build();

        BookEntity book = bookMapper.mapFrom(bookDto);
        BookEntity updateBook = bookService.partialUpdate(id,book);
        return new ResponseEntity<>(bookMapper.mapTo(updateBook),HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
