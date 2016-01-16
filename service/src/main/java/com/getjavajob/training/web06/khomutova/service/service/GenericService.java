package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.CrudDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.GenericDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericService<T extends BaseEntity> implements CrudDao<T> {
    protected GenericDao<T> dao;

    public void setDao(GenericDao<T> dao) {
        this.dao = dao;
    }

    public GenericService(GenericDao<T> dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void add(T entity) {
            dao.add(entity);
    }

    @Transactional
    @Override
    public void update(T entity) {
            dao.update(entity);
    }

    @Transactional
    @Override
    public void delete(int id) {
            dao.delete(id);
    }

    @Override
    public T get(int id) {
        return dao.get(id);
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }
}
