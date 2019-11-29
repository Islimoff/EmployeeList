package com.job4j.employeeslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeesFragment extends Fragment {

    private RecyclerView employeesList;
    private EntityGenerator generator=EntityGenerator.getGenerator();
    private String profession;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        profession=getActivity().getIntent().getStringExtra("ProfessionName");
        employeesList = (RecyclerView) inflater.inflate(R.layout.fragment_employees, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        employeesList.setLayoutManager(layoutManager);
        employeesList.setAdapter(new EmployeesAdapter(getContext(),profession));
        return employeesList;
    }
}
