package com.job4j.employeeslist;

import androidx.fragment.app.Fragment;

public class EmployeeActivity extends BaseActivity {
    @Override
    public Fragment loadFragment() {
        return EmployeeFragment.of((Employee) getIntent().getSerializableExtra(Employee.class.getSimpleName()));
    }
}
