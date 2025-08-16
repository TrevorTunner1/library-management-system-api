package com.rei.Library.Management.System.service.impl;

import com.rei.Library.Management.System.entity.AuthorEntity;
import com.rei.Library.Management.System.entity.LoanEntity;
import com.rei.Library.Management.System.exceptions.BookNotFoundException;
import com.rei.Library.Management.System.exceptions.UserNotFoundException;
import com.rei.Library.Management.System.repository.BooksRepository;
import com.rei.Library.Management.System.repository.LoanRepository;
import com.rei.Library.Management.System.repository.UserRepository;
import com.rei.Library.Management.System.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {



    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public LoanEntity loanBook(LoanEntity loan, Long userId, Long bookId) throws Exception {
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        var book = booksRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found with ID " + bookId));

        if (book.getTotalCopies() <= 0) {
            throw new BookNotFoundException("No copies available for book: " + book.getTitle());
        }

        loan.setUsers(user);
        loan.setBookEntity(book);
        loan.setBorrowDate(LocalDate.now());

        book.setTotalCopies(book.getTotalCopies() - 1);
        booksRepository.save(book);
        return loanRepository.save(loan);
    }

    @Override
    public Page<LoanEntity> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return loanRepository.findAll(pageable);
    }

    @Override
    public Optional<LoanEntity> findOne(Long id) {
        return loanRepository.findById(id);
    }

    @Override
    public boolean exist(Long id) {
        return loanRepository.existsById(id);
    }

    @Override
    public LoanEntity partialUpdate(Long id, LoanEntity loan) {
        loan.setId(id);
        return loanRepository.findById(id).map(loanExist->{
            Optional.ofNullable(loan.getBorrowDate()).ifPresent(loanExist::setBorrowDate);
            Optional.ofNullable(loan.getReturned()).ifPresent(loanExist::setReturned);
            Optional.ofNullable(loan.getFine()).ifPresent(loanExist::setFine);
            Optional.ofNullable(loan.getDueDate()).ifPresent(loanExist::setDueDate);
            return loanRepository.save(loanExist);
        }).orElseThrow(()-> new RuntimeException("loan instance was not found"));
    }

    @Override
    public void deleteBook(Long id) {
        loanRepository.deleteById(id);
    }


}
