package com.job4j.employeeslist.retrofit;

import com.job4j.employeeslist.models.Employee;
import com.job4j.employeeslist.models.Profession;
import com.job4j.employeeslist.models.Test;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("test-tasks/task-json/master/task.json")
    Observable<List<Test>> getEmployees();

    @GET("test-tasks/task-json/master/task.json")
    Observable<List<Profession>> getProffessions();
}
