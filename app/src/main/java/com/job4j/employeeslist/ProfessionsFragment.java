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

import java.util.ArrayList;
import java.util.List;

public class ProfessionsFragment extends Fragment {

    private RecyclerView professionsList;
    private EntityGenerator generator=EntityGenerator.getGenerator();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        professionsList = (RecyclerView) inflater.inflate(R.layout.fragment_professions, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        professionsList.setLayoutManager(layoutManager);
        professionsList.setAdapter(new ProfessionsAdapter(generator.getProfessions(),getContext()));
        return professionsList;
    }
}
