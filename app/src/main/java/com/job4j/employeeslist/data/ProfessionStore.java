package com.job4j.employeeslist.data;

import com.job4j.employeeslist.dao.ProfessionDao;
import com.job4j.employeeslist.models.Profession;

import java.util.List;

public class ProfessionStore implements SqlStore<Profession> {

    private static ProfessionStore STORE;
    private AppDatabase db;
    private ProfessionDao professionDao;

    private ProfessionStore() {
        db = App.getInstance().getDatabase();
        professionDao = db.professionDao();
    }

    public static ProfessionStore getStore() {
        if (STORE == null) {
            STORE = new ProfessionStore();
        }
        return STORE;
    }

    @Override
    public void add(Profession profession) {
        professionDao.insert(profession);
    }

    @Override
    public void update(Profession profession) {
        professionDao.update(profession);
    }

    @Override
    public void delete(long id) {
        professionDao.delete(professionDao.getById(id));
    }

    @Override
    public Profession getById(long id) {
        return professionDao.getById(id);
    }

    @Override
    public List<Profession> getAll() {
        return professionDao.getAll();
    }
}
