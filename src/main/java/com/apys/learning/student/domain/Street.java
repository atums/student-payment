package com.apys.learning.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jc_street")
public class Street {
    @Id
    @Column(name = "street_code")
    private long street_code;
    @Column(name = "street_name")
    private String street_name;

    public long getStreet_code() {
        return street_code;
    }

    public void setStreet_code(long street_code) {
        this.street_code = street_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }
}
