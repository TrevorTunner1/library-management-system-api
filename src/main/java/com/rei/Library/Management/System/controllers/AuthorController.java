package com.rei.Library.Management.System.controllers;

import com.rei.Library.Management.System.dto.AuthorDto;
import com.rei.Library.Management.System.entity.AuthorEntity;
import com.rei.Library.Management.System.mapper.AuthorMapper;
import com.rei.Library.Management.System.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class AuthorController {



    private AuthorMapper authorMapper;


    private AuthorService authorService;

    public AuthorController(AuthorMapper authorMapper, AuthorService authorService) {
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }


    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody  AuthorDto author){
        AuthorEntity authors = authorMapper.mapFrom(author);
        AuthorEntity savedAuthor = authorService.saveAuthor(authors);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorMapper.mapTo(savedAuthor));
    }

    @GetMapping("/authors")
        public Page<AuthorDto> findAllAuthors(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size,
                @RequestParam(defaultValue = "name") String sortBy
    ){
        Page<AuthorEntity> foundAuthors = authorService.findAll(page,size,sortBy);
      return  foundAuthors.map(authorMapper::mapTo);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> findOneAuthor(@PathVariable Long id){
       return authorService.findById(id).map(
               author->{
           AuthorDto authorDtoFound =  authorMapper.mapTo(author);
           return new ResponseEntity<>(authorDtoFound,HttpStatus.OK);

        }).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, AuthorDto authorDto){
        AuthorEntity author = authorMapper.mapFrom(authorDto);
        boolean authorExist = authorService.exist(id);
        if (authorExist){
            AuthorEntity updatedAuthor = authorService.updateAuthor(author);
            AuthorDto requestedAuthor = authorMapper.mapTo(updatedAuthor);
            return new ResponseEntity<>(requestedAuthor,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> partialUpdate(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        if (!authorService.exist(id))
            return ResponseEntity.notFound().build();

        AuthorEntity author = authorMapper.mapFrom(authorDto);
        AuthorEntity updateAuthor = authorService.partialUpdate(id,author);
        return new ResponseEntity<>(authorMapper.mapTo(updateAuthor),HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
