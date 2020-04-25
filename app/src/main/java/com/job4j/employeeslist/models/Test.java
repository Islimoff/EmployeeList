package com.job4j.employeeslist.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity
public class Test implements Serializable {

    @PrimaryKey
    private int id;
    @SerializedName("f_name")
    private String firstName;
    @SerializedName("l_name")
    private String lastName;
    private String birthday;
    @SerializedName("specialty")
    private List<Profession> professionId;

    public Test(int id, String firstName, String lastName, String birthday, List<Profession> professionId) {
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


    public List<Profession> getProfessionId() {
        return professionId;
    }
}
