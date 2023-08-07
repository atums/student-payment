package com.apys.learning.student.dao;

import com.apys.learning.student.domain.CountryArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryAreaRepository extends JpaRepository<CountryArea, String> {
}
