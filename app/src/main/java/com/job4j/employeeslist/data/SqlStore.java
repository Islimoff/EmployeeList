package com.job4j.employeeslist.data;

import java.util.List;

public interface SqlStore<T> {

    void add(T object);

    void update(T object);

    void delete(long id);

    T getById(long id);

    List<T> getAll();
}
