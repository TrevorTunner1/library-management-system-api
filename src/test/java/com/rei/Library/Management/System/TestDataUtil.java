package com.rei.Library.Management.System;

import com.rei.Library.Management.System.entity.AuthorEntity;
import com.rei.Library.Management.System.entity.BookEntity;

import javax.xml.crypto.Data;

public final class TestDataUtil {

//    AuthorEntity TestUtil Data
    public static AuthorEntity createAuthorA(){
        return AuthorEntity.builder()
                .name("Rei")
                .build();
    }

    public static  AuthorEntity createAuthorB(){
        return AuthorEntity.builder()
                .id(2L)
                .name("Akagami")
                .build();
    }

    public static BookEntity createBookA(){
        return BookEntity.builder()
                .title("The Summer Rei died")
                .isbn("rei22woi22")
                .genre("horror")
                .totalCopies(20)
                .authorEntity(null)
                .build();
    }

    public static BookEntity createBookB(){
        return BookEntity.builder()
                .title("Living with the akagami sisters")
                .isbn("aka-12100660")
                .genre("comedy")
                .totalCopies(10)
                .authorEntity(null)
                .build();
    }



}
