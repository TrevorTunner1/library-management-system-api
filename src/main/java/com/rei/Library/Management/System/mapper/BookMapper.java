package com.rei.Library.Management.System.mapper;


import com.rei.Library.Management.System.dto.BookDto;
import com.rei.Library.Management.System.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookEntity mapFrom(BookDto bookDto);

    BookDto mapTo(BookEntity bookEntity);
}
