package com.job4j.employeeslist.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @PrimaryKey
    private int id;
    @SerializedName("f_name")
    private String firstName;
    @SerializedName("l_name")
    private String lastName;
    private String birthday;
    @SerializedName("specialty_id")
    private int professionId;

    public Employee(int id, String firstName, String lastName, String birthday, int professionId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
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


    public String getBirthday() {
        return birthday;
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
                this.birthday.equals(employee.birthday) &&
                this.professionId == employee.professionId;
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
                ", Date=" + birthday +
                ", ProfessionID=" + professionId +
                '}';
    }

}
