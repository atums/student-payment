package com.apys.learning.student.business;

import com.apys.learning.student.dao.StreetRepository;
import com.apys.learning.student.dao.StudentOrderRepository;
import com.apys.learning.student.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository dao;

    @Autowired
    private StreetRepository daoStreet;

    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setHusband(buildPerson(false));
        studentOrder.setWife(buildPerson(true));
        dao.save(studentOrder);

    }

    @Transactional
    public void testGet() {
        List<StudentOrder> all = dao.findAll();
        LOGGER.info(all.get(0).getWife().getGivenName());
    }

    private Adult buildPerson(boolean wife) {
        Adult person = new Adult();

        Address address = new Address();
        address.setPostCode("6000");
        address.setBuilding("1133");
        address.setExtension("1");
        address.setApartment("13");
        Street one = daoStreet.getOne(1L);
        address.setStreet(one);
        person.setAddress(address);

        if (wife) {
            person.setSurName("Tums");
            person.setGivenName("Marina");
            person.setPatronymic("B");
            person.setPassportSeria("Wife_S");
            person.setPassportNumber("Wife_N");
            person.setIssueDate(LocalDate.now());

        } else {
            person.setSurName("Tums");
            person.setGivenName("Alex");
            person.setPatronymic("A");
            person.setPassportSeria("Hus_S");
            person.setPassportNumber("Hus_N");
            person.setIssueDate(LocalDate.now());
        }
        person.setDateOfBirth(LocalDate.now());
        return person;
    }
}
