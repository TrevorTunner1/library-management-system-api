package com.rei.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity

@Table (name = "users")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(
            name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

    private String email;

    private LocalDate memberSince;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoanEntity> loanEntities;  // must be a Collection type

}
