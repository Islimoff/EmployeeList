package com.job4j.employeeslist.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.job4j.employeeslist.R;
import com.job4j.employeeslist.activities.EmployeeActivity;
import com.job4j.employeeslist.data.EntityGenerator;
import com.job4j.employeeslist.fragments.EmployeesFragment;
import com.job4j.employeeslist.models.Employee;

import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder> {

    private final List<Employee> employees;
    private final EntityGenerator generator = EntityGenerator.getGenerator();
    private final EmployeesFragment.EmployeeSelect select;
    private final Context parent;

    public EmployeesAdapter(Context parent, EmployeesFragment.EmployeeSelect select, String professionName) {
        this.employees = generator.filterEmployees(professionName);
        this.select = select;
        this.parent = parent;
    }

    @NonNull
    @Override
    public EmployeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.employee_profession, parent, false);
        return new EmployeesViewHolder(view, select);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeesViewHolder holder, int position) {
        holder.bind(this.employees.get(position));
    }

    private void addEmployee(View view, Employee employee) {
        Intent intent = new Intent(parent, EmployeeActivity.class);
        intent.putExtra(Employee.class.getSimpleName(), employee);
        parent.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return this.employees.size();
    }

    class EmployeesViewHolder extends RecyclerView.ViewHolder {

        private final EmployeesFragment.EmployeeSelect select;
        private View view;

        public EmployeesViewHolder(@NonNull View itemView, EmployeesFragment.EmployeeSelect select) {
            super(itemView);
            this.select = select;
            this.view = itemView;
        }

        public void bind(Employee employee) {
            TextView employeeText = view.findViewById(R.id.employee);
            TextView profession = view.findViewById(R.id.profession);
            employeeText.setText(employee.getFirstName());
            profession.setText(employee.getProfession().getName());
            employeeText.setOnClickListener(view -> select.selected(employee));
        }
    }
}
