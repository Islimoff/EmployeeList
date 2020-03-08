package com.job4j.employeeslist.data;

import com.job4j.employeeslist.dao.EmployeeDao;
import com.job4j.employeeslist.models.Employee;

import java.util.List;

public class EmployeeStore implements SqlStore<Employee> {

    private static EmployeeStore STORE;
    private AppDatabase db;
    private EmployeeDao employeeDao;

    private EmployeeStore() {
        db = App.getInstance().getDatabase();
        employeeDao = db.employeeDao();
    }

    public static EmployeeStore getStore() {
        if (STORE == null) {
            STORE = new EmployeeStore();
        }
        return STORE;
    }

    @Override
    public void add(Employee employee) {
      employeeDao.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(long id) {
        employeeDao.delete(employeeDao.getById(id));
    }

    @Override
    public Employee getById(long id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }
}
