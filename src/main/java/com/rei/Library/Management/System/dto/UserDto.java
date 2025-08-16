package com.rei.Library.Management.System.dto;

import com.rei.Library.Management.System.entity.LoanEntity;
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
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private LocalDate memberSince;

    private List<LoanDto> loanDto;
}
