package com.job4j.employeeslist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class EntityGenerator {

    private static EntityGenerator generator;
    private static List<Profession> professions = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();

    private EntityGenerator() {
        generateProfessions();
        generateEmployees();
    }

    public static List<Profession> getProfessions() {
        return professions;
    }

    public static EntityGenerator getGenerator() {
        if (generator == null) {
            generator = new EntityGenerator();
        }
        return generator;
    }

    private void generateProfessions() {
        for (int i = 0; i != 50; i++) {
            professions.add(new Profession("Prof" + i, i));
        }
    }

    private void generateEmployees() {
        for (int i = 0; i != 600; i++) {
            employees.add(new Employee(i,"Fname" + i, "Lname" + i, new Date(), gerRandomProfession()));
        }
    }

    public List<Employee> filterEmployees(String profession) {
        List<Employee> certainEmployees = new ArrayList<>();
        for (int i = 0; i != employees.size(); i++) {
            if (employees.get(i).getProfession().getName().equals(profession)) {
                certainEmployees.add(employees.get(i));
            }
        }
        return certainEmployees;
    }

    private Profession gerRandomProfession() {
        Random random = new Random();
        return professions.get(random.nextInt(professions.size()));
    }
}
