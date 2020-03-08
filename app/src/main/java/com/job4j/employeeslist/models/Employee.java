package com.job4j.employeeslist.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee implements Serializable {

    @PrimaryKey
    private int id;
    private String firstName;
    private String lastName;
    private long birthDate;
    private Profession profession;

    public Employee(int id, String firstName, String lastName, Date birthDate, Profession profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.profession = profession;
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.firstName.equals(employee.firstName) &&
                this.lastName.equals(employee.lastName) &&
                this.birthDate.equals(employee.birthDate) &&
                this.profession.equals(employee.profession);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "First Name=" + firstName +
                ", Last Name='" + lastName + '\'' +
                ", Date=" + birthDate +
                ", Profession=" + profession +
                '}';
    }

}
