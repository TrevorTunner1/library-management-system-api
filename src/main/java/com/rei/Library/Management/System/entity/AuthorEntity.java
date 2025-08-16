package com.rei.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    @SequenceGenerator(
            name = "author_id_seq",
            sequenceName = "author_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "authorEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookEntity> books;  // must be a Collection type

}

