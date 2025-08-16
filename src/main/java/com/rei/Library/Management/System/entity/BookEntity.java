package com.rei.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_id_seq")
    @SequenceGenerator(
            name = "books_id_seq",
            sequenceName = "books_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String title;

    private String isbn;

    private String genre;

    private Integer totalCopies;

    @ManyToOne
    @JoinColumn(name = "authors_id") // Foreign key in bookEntity table
    private AuthorEntity authorEntity;
}

