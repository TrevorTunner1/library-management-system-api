package com.rei.Library.Management.System.service;

import com.rei.Library.Management.System.entity.AuthorEntity;
import com.rei.Library.Management.System.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface AuthorService {
    Boolean exist(Long id);

    AuthorEntity saveAuthor(AuthorEntity author);


    Page<AuthorEntity> findAll(int page, int size, String sortBy);

    Optional<AuthorEntity> findById(Long id);

    AuthorEntity updateAuthor(AuthorEntity author);

    AuthorEntity partialUpdate(Long id, AuthorEntity author);

    void deleteAuthor(Long id);
}
