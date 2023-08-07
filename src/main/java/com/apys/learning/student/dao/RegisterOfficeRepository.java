package com.apys.learning.student.dao;

import com.apys.learning.student.domain.RegisterOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterOfficeRepository extends JpaRepository<RegisterOffice, Long> {
}
