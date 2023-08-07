package com.apys.learning.student.dao;

import com.apys.learning.student.domain.PasportOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportOfficeRepository extends JpaRepository<PasportOffice, Long> {
}
