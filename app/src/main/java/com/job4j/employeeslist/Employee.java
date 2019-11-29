package com.job4j.employeeslist;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Profession profession;

    public Employee(String firstName, String lastName, Date birthDate, Profession profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.profession = profession;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public Date getBirthDate() {
        return birthDate;
    }


    public Profession getProfession() {
        return profession;
    }

}
