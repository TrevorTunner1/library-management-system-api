package com.rei.Library.Management.System.repository;

import com.rei.Library.Management.System.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BookEntity,Long> {
}
