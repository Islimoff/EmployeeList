package com.job4j.employeeslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.Format;
import java.text.SimpleDateFormat;

public class EmployeeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee, container, false);
        Bundle arguments = getActivity().getIntent().getExtras();
        Employee employee = (Employee) arguments.getSerializable(Employee.class.getSimpleName());
        Format formatter = new SimpleDateFormat("dd-MMM-yy");
        TextView firstName = view.findViewById(R.id.first_name);
        TextView lastName = view.findViewById(R.id.last_name);
        TextView date = view.findViewById(R.id.date);
        firstName.setText(employee.getFirstName());
        lastName.setText(employee.getLastName());
        date.setText(formatter.format(employee.getBirthDate()));
        return view;
    }
}