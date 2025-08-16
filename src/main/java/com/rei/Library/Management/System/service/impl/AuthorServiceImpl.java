package com.rei.Library.Management.System.service.impl;

import com.rei.Library.Management.System.dto.AuthorDto;
import com.rei.Library.Management.System.entity.AuthorEntity;
import com.rei.Library.Management.System.repository.AuthorRepository;
import com.rei.Library.Management.System.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Boolean exist(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorEntity saveAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }


    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return  authorRepository.findById(id);
    }

    @Override
    public AuthorEntity updateAuthor(AuthorEntity author) {

        return authorRepository.save(author);
    }

    @Override
    public AuthorEntity partialUpdate(Long id, AuthorEntity author) {
        author.setId(id);
        return authorRepository.findById(id).map(authorExist ->{
            Optional.ofNullable(author.getName()).ifPresent(authorExist::setName);
            return authorRepository.save(authorExist);
        }).orElseThrow(()-> new RuntimeException("Author doesn't exist"));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }


    @Override
    public Page<AuthorEntity> findAll(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));

        return authorRepository.findAll(pageable);
    }
}
