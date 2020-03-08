package com.job4j.employeeslist.activities;

import androidx.fragment.app.Fragment;

import com.job4j.employeeslist.fragments.ProfessionsFragment;

public class ProfessionsActivity extends BaseActivity {

    @Override
    public Fragment loadFragment() {
        return new ProfessionsFragment();
    }
}
