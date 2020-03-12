package com.job4j.employeeslist.data;

import com.job4j.employeeslist.dao.EmployeeDao;
import com.job4j.employeeslist.dao.ProfessionDao;
import com.job4j.employeeslist.models.Employee;
import com.job4j.employeeslist.models.Profession;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class EntityGenerator {

    private static EntityGenerator generator;
    private AppDatabase db;
    private EmployeeDao employeeDao;
    private ProfessionDao professionDao;

    private EntityGenerator() {
        db = App.getInstance().getDatabase();
        employeeDao = db.employeeDao();
        professionDao = db.professionDao();
        if (professionDao.getAll().size() == 0) {
            generateProfessions();
            generateEmployees();
        }
    }

    public static EntityGenerator getGenerator() {
        if (generator == null) {
            generator = new EntityGenerator();
        }
        return generator;
    }

    private void generateProfessions() {
        for (int i = 1; i != 50; i++) {
            ProfessionStore.getStore().add(new Profession("Prof" + i));
        }
    }

    private void generateEmployees() {
        for (int i = 0; i != 600; i++) {
            EmployeeStore.getStore().add(new Employee(
                    i, "Fname" + i, "Lname" + i, System.currentTimeMillis(), gerRandomProfession().getId()));
        }
    }

    public List<Employee> filterEmployees(int professionId) {
        List<Employee> employees = EmployeeStore.getStore().getAll();
        List<Employee> certainEmployees = new ArrayList<>();
        for (int i = 0; i != employees.size(); i++) {
            if (employees.get(i).getProfessionId() == professionId) {
                certainEmployees.add(employees.get(i));
            }
        }
        return certainEmployees;
    }

    private Profession gerRandomProfession() {
        List<Profession> professions = ProfessionStore.getStore().getAll();
        Random random = new Random();
        return professions.get(random.nextInt(professions.size()));
    }
}
