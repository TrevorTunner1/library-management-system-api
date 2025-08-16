package com.rei.Library.Management.System.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rei.Library.Management.System.entity.BookEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    private String name;

    private List<BookDto> books;

}
