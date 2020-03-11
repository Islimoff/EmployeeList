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
import com.job4j.employeeslist.activities.EmployeesActivity;
import com.job4j.employeeslist.models.Profession;

import java.util.List;

public class ProfessionsAdapter extends RecyclerView.Adapter<ProfessionsAdapter.ProfessionViewHolder> {

    private final List<Profession> professions;
    private final Context parent;

    public ProfessionsAdapter(List<Profession> professions, Context parent) {
        this.professions = professions;
        this.parent=parent;
    }

    @NonNull
    @Override
    public ProfessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.profession_info, parent, false);
        return new ProfessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionViewHolder holder, int position) {
        final Profession profession = this.professions.get(position);
        TextView professionName = holder.view.findViewById(R.id.profession_name);
        TextView professionId=holder.view.findViewById(R.id.profession_id);
        professionName.setText(profession.getName());
        professionId.setText(String.valueOf(profession.getId()));
        professionName.setOnClickListener(view->addProfession(view,profession));
    }

    public void addProfession(View view,Profession profession) {
        Intent intent = new Intent(parent, EmployeesActivity.class);
        intent.putExtra("ProfessionId",profession.getId());
        parent.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return this.professions.size();
    }

    class ProfessionViewHolder extends RecyclerView.ViewHolder {

        private View view;

        public ProfessionViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view=itemView;
        }
    }
}
