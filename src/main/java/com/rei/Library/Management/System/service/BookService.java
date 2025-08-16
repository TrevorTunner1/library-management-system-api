package com.rei.Library.Management.System.service;

import com.rei.Library.Management.System.dto.BookDto;
import com.rei.Library.Management.System.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {

    BookDto saveBook(BookDto book);


    Page<BookEntity> findAll(int page, int size, String sortBy);

    Optional<BookEntity> findOne(Long id);

    boolean exist(Long id);

    BookDto updateBook(Long id , BookDto book);

    BookEntity partialUpdate(Long id, BookEntity book);

    void deleteBook(Long id);
}
