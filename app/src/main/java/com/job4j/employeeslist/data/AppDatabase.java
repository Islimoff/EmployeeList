package com.job4j.employeeslist.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.job4j.employeeslist.dao.EmployeeDao;
import com.job4j.employeeslist.dao.ProfessionDao;
import com.job4j.employeeslist.models.Employee;
import com.job4j.employeeslist.models.Profession;

@Database(entities = {Employee.class, Profession.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    public abstract ProfessionDao professionDao();
}
