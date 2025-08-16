package com.rei.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table (name = "loan")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_id_seq")
    @SequenceGenerator(
            name = "loan_id_seq",
            sequenceName = "loan_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key in bookEntity table
    private UserEntity users;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "book_id")
    private BookEntity bookEntity;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private Boolean returned;

    private LocalDate dueDate;

    private Double fine;
}
