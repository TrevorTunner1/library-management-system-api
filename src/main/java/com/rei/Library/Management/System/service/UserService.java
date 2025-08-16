package com.rei.Library.Management.System.service;

import com.rei.Library.Management.System.dto.UserDto;
import com.rei.Library.Management.System.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    UserEntity saveUser(UserEntity userEntity);

    Page<UserEntity> findAll(int page, int size, String sortBy);

    Optional<UserEntity> findOne(Long id);

    Boolean isExist(Long id);

    UserEntity partialUpdate(Long id, UserEntity user);

    void deleteBook(Long id);
}
