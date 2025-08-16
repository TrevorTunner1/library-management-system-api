package com.rei.Library.Management.System.mapper;

import com.rei.Library.Management.System.dto.UserDto;
import com.rei.Library.Management.System.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapping {

    UserEntity mapFrom(UserDto userDto);

    UserDto mapTo(UserEntity userEntity);

}
