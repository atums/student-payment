package com.apys.learning.student.dao;

import com.apys.learning.student.domain.StudentOrderChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrderChildRepository extends JpaRepository<StudentOrderChild, Long> {
}
