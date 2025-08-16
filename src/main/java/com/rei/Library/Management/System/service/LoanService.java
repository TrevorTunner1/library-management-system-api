package com.rei.Library.Management.System.service;

import com.rei.Library.Management.System.entity.AuthorEntity;
import com.rei.Library.Management.System.entity.LoanEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface LoanService {

    LoanEntity loanBook(LoanEntity loan, Long userId, Long bookId) throws Exception;

    Page<LoanEntity> findAll(int page, int size, String sortBy);

    Optional<LoanEntity> findOne(Long id);

    boolean exist(Long id);

    LoanEntity partialUpdate(Long id, LoanEntity loan);

    void deleteBook(Long id);
}
