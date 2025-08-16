package com.rei.Library.Management.System.mapper;

import com.rei.Library.Management.System.dto.LoanDto;
import com.rei.Library.Management.System.entity.LoanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanEntity mapFrom(LoanDto loanDto);

    LoanDto mapTo(LoanEntity loanEntity);
}
