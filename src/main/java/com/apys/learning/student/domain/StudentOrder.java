package com.apys.learning.student.domain;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;

@Entity
@Table(name = "jc_student_order")
public class StudentOrder {

    @Id
    @Column(name = "student_order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentOrderId;

    public Long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(Long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }
}
