package com.job4j.employeeslist.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.job4j.employeeslist.models.Profession;

import java.util.List;

@Dao
public interface ProfessionDao {

    @Query("SELECT * FROM profession")
    List<Profession> getAll();

    @Query("SELECT * FROM profession WHERE id = :id")
    Profession getById(long id);

    @Insert
    void insert(Profession profession);

    @Update
    void update(Profession profession);

    @Delete
    void delete(Profession profession);
}
