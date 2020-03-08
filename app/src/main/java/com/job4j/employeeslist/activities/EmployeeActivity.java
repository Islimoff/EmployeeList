package com.job4j.employeeslist.activities;

import androidx.fragment.app.Fragment;

import com.job4j.employeeslist.models.Employee;
import com.job4j.employeeslist.fragments.EmployeeFragment;

public class EmployeeActivity extends BaseActivity {
    @Override
    public Fragment loadFragment() {
        return EmployeeFragment.of((Employee) getIntent().getSerializableExtra(Employee.class.getSimpleName()));
    }
}
