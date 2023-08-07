package com.apys.learning.student.dao;

import com.apys.learning.student.domain.StudentOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrderStatusRepository extends JpaRepository<StudentOrderStatus, Long> {
}
