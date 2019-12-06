package com.job4j.employeeslist;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class EmployeesActivity extends BaseActivity implements EmployeesFragment.EmployeeSelect {

    @Override
    public Fragment loadFragment() {
        return new EmployeesFragment();
    }

    @Override
    public void selected(Employee employee) {
        if (findViewById(R.id.detail) == null) {
            Intent intent = new Intent(this, EmployeeActivity.class);
            intent.putExtra(Employee.class.getSimpleName(), employee);
            startActivity(intent);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.detail, EmployeeFragment.of(employee))
                    .commit();
        }
    }
}

