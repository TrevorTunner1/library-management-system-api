package com.rei.Library.Management.System.mapper;

import com.rei.Library.Management.System.dto.AuthorDto;
import com.rei.Library.Management.System.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {



    AuthorEntity mapFrom(AuthorDto dto);

    AuthorDto mapTo(AuthorEntity authorEntity);
}
