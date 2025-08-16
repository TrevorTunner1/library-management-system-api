package com.rei.Library.Management.System.controllers;

import com.rei.Library.Management.System.dto.LoanDto;
import com.rei.Library.Management.System.entity.LoanEntity;
import com.rei.Library.Management.System.mapper.LoanMapper;
import com.rei.Library.Management.System.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanController {
    
    private LoanMapper loanMapper;
    
    private LoanService loanService;

    public LoanController(LoanMapper loanMapper, LoanService loanService) {
        this.loanMapper = loanMapper;
        this.loanService = loanService;
    }

    @PutMapping("/loan/{userId}/{bookId}")
    public ResponseEntity<LoanDto>
    savedLoan (@PathVariable Long userId,
               @PathVariable Long bookId,
               @RequestBody LoanDto loanDto) throws Exception {
        LoanEntity loan =  loanMapper.mapFrom(loanDto);
        LoanEntity savedLoan = loanService.loanBook(loan,userId,bookId);
        LoanDto requestedLoan = loanMapper.mapTo(savedLoan);
        return new ResponseEntity<>(requestedLoan,HttpStatus.CREATED);
    }

    @GetMapping("/loan")
    public Page<LoanDto> findAllLoans (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ){
        Page<LoanEntity> findAllLoan = loanService.findAll(page,size,sortBy);
        return  findAllLoan.map(loanMapper::mapTo);
    }

    @GetMapping("/loans/{id}")
    public ResponseEntity<LoanDto> findOneLoan(@PathVariable Long id){
      return loanService.findOne(id).map(loanEntity -> {

           LoanDto mappedLoan  =  loanMapper.mapTo(loanEntity);
           return new ResponseEntity<>(mappedLoan,HttpStatus.OK);

        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/loans/{id}")
    public ResponseEntity<LoanDto> partialUpdate(@PathVariable Long id, @RequestBody LoanDto loanDto){
        if (!loanService.exist(id))
            return ResponseEntity.notFound().build();

        LoanEntity loan = loanMapper.mapFrom(loanDto);
        LoanEntity updateLoan = loanService.partialUpdate(id,loan);
        return new ResponseEntity<>(loanMapper.mapTo(updateLoan),HttpStatus.OK);
    }

    @DeleteMapping("/loans/{id}")
    public ResponseEntity<LoanDto> deleteLoan(@PathVariable Long id){
        loanService.deleteBook(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
