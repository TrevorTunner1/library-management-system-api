package com.rei.Library.Management.System.service.impl;

import com.rei.Library.Management.System.entity.UserEntity;
import com.rei.Library.Management.System.repository.UserRepository;
import com.rei.Library.Management.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        userEntity.setMemberSince(LocalDate.now());
        return userRepository.save(userEntity);
    }

    @Override
    public Page<UserEntity> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<UserEntity> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean isExist(Long id) {
        return userRepository.existsById(id);
    }

    public UserEntity partialUpdate(Long id, UserEntity user) {
        user.setId(id);
        return userRepository.findById(id).map(userExist ->{
            Optional.ofNullable(user.getName()).ifPresent(userExist::setName);
            Optional.ofNullable(user.getEmail()).ifPresent(userExist::setEmail);
            Optional.ofNullable(user.getMemberSince()).ifPresent(userExist::setMemberSince);
            return userRepository.save(userExist);
        }).orElseThrow(()-> new RuntimeException("loan instance was not found"));
    }

    @Override
    public void deleteBook(Long id) {
        userRepository.deleteById(id);
    }
}
