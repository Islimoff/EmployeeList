package com.job4j.employeeslist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder> {

    private final List<Employee> employees;
    private final EntityGenerator generator = EntityGenerator.getGenerator();
    private final Context parent;

    public EmployeesAdapter(Context parent, String professionName) {
        this.employees = generator.filterEmployees(professionName);
        this.parent = parent;
    }

    @NonNull
    @Override
    public EmployeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.employee_profession, parent, false);
        return new EmployeesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeesViewHolder holder, int position) {
        Employee employee = this.employees.get(position);
        TextView employeeText = holder.view.findViewById(R.id.employee);
        TextView profession = holder.view.findViewById(R.id.profession);
        employeeText.setText(employee.getFirstName());
        profession.setText(employee.getProfession().getName());
        employeeText.setOnClickListener(view -> addEmployee(view,employee));
    }

    private void addEmployee(View view,Employee employee){
            Intent intent = new Intent(parent, EmployeeActivity.class);
            intent.putExtra(Employee.class.getSimpleName(), employee);
            parent.startActivity(intent);
        }

    @Override
    public int getItemCount() {
        return this.employees.size();
    }

    class EmployeesViewHolder extends RecyclerView.ViewHolder {

        private View view;

        public EmployeesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
