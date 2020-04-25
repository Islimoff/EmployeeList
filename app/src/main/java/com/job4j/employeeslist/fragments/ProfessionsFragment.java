package com.job4j.employeeslist.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.job4j.employeeslist.adapters.ProfessionsAdapter;
import com.job4j.employeeslist.R;
import com.job4j.employeeslist.data.ProfessionStore;
import com.job4j.employeeslist.models.Employee;
import com.job4j.employeeslist.models.Profession;
import com.job4j.employeeslist.models.Test;
import com.job4j.employeeslist.retrofit.JsonPlaceHolderApi;
import com.job4j.employeeslist.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ProfessionsFragment extends Fragment {

    private RecyclerView professionsList;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Retrofit retrofit = RetrofitClient.getInstance();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        jsonPlaceHolderApi.getEmployees()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Test>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Test> professions) {
                        System.out.println(professions);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        professionsList = (RecyclerView) inflater.inflate(R.layout.fragment_professions, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        professionsList.setLayoutManager(layoutManager);
//        professionsList.setAdapter(new ProfessionsAdapter(ProfessionStore.getStore().getAll()
//                ,getContext()));
        return professionsList;
    }
}
