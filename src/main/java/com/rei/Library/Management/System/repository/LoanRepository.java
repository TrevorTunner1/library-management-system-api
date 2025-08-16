package com.rei.Library.Management.System.repository;

import com.rei.Library.Management.System.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Long> {
}
