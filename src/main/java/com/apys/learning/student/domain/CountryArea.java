package com.apys.learning.student.domain;

import javax.persistence.*;

@Entity
@Table(name = "jc_country_struct")
public class CountryArea {
    @Id
    @Column(name = "area_id")
    private String  areaId;
    @Column(name = "area_name")
    private String ariaName;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAriaName() {
        return ariaName;
    }

    public void setAriaName(String ariaName) {
        this.ariaName = ariaName;
    }
}
