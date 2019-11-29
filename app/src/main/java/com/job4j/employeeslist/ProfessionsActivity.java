package com.job4j.employeeslist;

import androidx.fragment.app.Fragment;

public class ProfessionsActivity extends BaseActivity {

    @Override
    public Fragment loadFragment() {
        return new ProfessionsFragment();
    }
}
