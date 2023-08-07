package com.apys.learning.student.domain;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class Adult extends Person {
    private String passportSeria;
    private String passportNumber;
    private LocalDate issueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PasportOffice pasportOffice;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private University university;
    private String studentNumber;


    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PasportOffice getPasportOffice() {
        return pasportOffice;
    }

    public void setPasportOffice(PasportOffice pasportOffice) {
        this.pasportOffice = pasportOffice;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
