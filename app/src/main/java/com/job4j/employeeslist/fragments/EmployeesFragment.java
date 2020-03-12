package com.job4j.employeeslist.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.job4j.employeeslist.models.Employee;
import com.job4j.employeeslist.adapters.EmployeesAdapter;
import com.job4j.employeeslist.R;

public class EmployeesFragment extends Fragment {

    private RecyclerView employeesList;
    private int professionId;
    private EmployeeSelect select;

    public interface EmployeeSelect {
        void selected(Employee employee);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        professionId = getActivity().getIntent().getIntExtra("ProfessionId", 0);
        View view = inflater.inflate(R.layout.fragment_employees, container, false);
        employeesList = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        employeesList.setLayoutManager(layoutManager);
        employeesList.setAdapter(new EmployeesAdapter(getActivity(), select, professionId));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.select = (EmployeeSelect) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.select = null;
    }
}
