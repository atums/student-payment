package com.apys.learning.student.business;

import com.apys.learning.student.dao.*;
import com.apys.learning.student.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository dao;

    @Autowired
    private StreetRepository daoStreet;

    @Autowired
    private StudentOrderStatusRepository daoStatus;

    @Autowired
    private PassportOfficeRepository daoPassportOffice;

    @Autowired
    private UniversityRepository daoUniversity;

    @Autowired
    private RegisterOfficeRepository daoRegisterOffice;

    @Autowired
    private StudentOrderChildRepository daoOrderChild;


    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderDate(LocalDateTime.now());
        studentOrder.setStatus(daoStatus.getOne(1L));

        studentOrder.setHusband(buildPerson(false));
        studentOrder.setWife(buildPerson(true));

        studentOrder.setCertificateNumber("Cert123");

        studentOrder.setRegisterOffice(daoRegisterOffice.getOne(1L));

        studentOrder.setMarriageDate(LocalDate.now());

        dao.save(studentOrder);

        StudentOrderChild studentOrderChild = buildChild(studentOrder);

        daoOrderChild.save(studentOrderChild);

    }

    @Transactional
    public void testGet() {
        List<StudentOrder> all = dao.findAll();
        LOGGER.info(all.get(0).getWife().getGivenName());
        LOGGER.info(all.get(0).getChildren().get(0).getChild().getGivenName());
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
            person.setPatronymic("V");
            person.setPassportSeria("Wife_S");
            person.setPassportNumber("Wife_N");
            person.setPasportOffice(daoPassportOffice.getOne(1L));
            person.setIssueDate(LocalDate.now());
            person.setStudentNumber("12345");
            person.setUniversity(daoUniversity.getOne(1L));

        } else {
            person.setSurName("Tums");
            person.setGivenName("Alex");
            person.setPatronymic("V");
            person.setPassportSeria("Hus_S");
            person.setPassportNumber("Hus_N");
            person.setPasportOffice(daoPassportOffice.getOne(1L));
            person.setIssueDate(LocalDate.now());
            person.setStudentNumber("09876");
            person.setUniversity(daoUniversity.getOne(1L));
        }
        person.setDateOfBirth(LocalDate.now());
        return person;
    }

    private StudentOrderChild buildChild(StudentOrder studentOrder) {
        StudentOrderChild person = new StudentOrderChild();
        person.setStudentOrder(studentOrder);

        Child child = new Child();

        child.setDateOfBirth(LocalDate.now());
        child.setSurName("Tums");
        child.setGivenName("Nika");
        child.setPatronymic("A");

        child.setCertificateDate(LocalDate.now());
        child.setCertificateNumber("1029384756");
        child.setRegisterOffice(daoRegisterOffice.getOne(1L));

        Address address = new Address();
        address.setPostCode("6000");
        address.setBuilding("1133");
        address.setExtension("1");
        address.setApartment("13");
        Street one = daoStreet.getOne(1L);
        address.setStreet(one);
        child.setAddress(address);

        person.setChild(child);

        return person;
    }
}
