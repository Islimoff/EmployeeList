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
    private int professionId;

    public Employee(int id, String firstName, String lastName, long birthDate, int professionId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.professionId = professionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public long getBirthDate() {
        return birthDate;
    }


    public int getProfessionId() {
        return professionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.firstName.equals(employee.firstName) &&
                this.lastName.equals(employee.lastName) &&
                this.birthDate==employee.birthDate&&
                this.professionId==employee.professionId;
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
                ", ProfessionID=" + professionId +
                '}';
    }

}
