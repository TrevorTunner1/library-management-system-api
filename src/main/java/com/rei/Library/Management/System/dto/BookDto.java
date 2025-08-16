package com.rei.Library.Management.System.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rei.Library.Management.System.entity.AuthorEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;

    private String title;

    private String isbn;

    private String genre;

    private Integer totalCopies;

    private AuthorDto authorDto;

//    public BookDto(Long id, String title, String isbn, String genre, Integer totalCopies, AuthorDto authorDto) {
//        this.id = id;
//        this.title = title;
//        this.isbn = isbn;
//        this.genre = genre;
//        this.totalCopies = totalCopies;
//        this.authorDto = authorDto;
//    }
//
//    public BookDto() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public Integer getTotalCopies() {
//        return totalCopies;
//    }
//
//    public void setTotalCopies(Integer totalCopies) {
//        this.totalCopies = totalCopies;
//    }
//
//    public AuthorDto getAuthorDto() {
//        return authorDto;
//    }
//
//    public void setAuthorDto(AuthorDto authorDto) {
//        this.authorDto = authorDto;
//    }
}
