package com.getjavajob.training.web06.khomutova.service.service;

import com.getjavajob.training.web06.khomutova.datebaseclasses.connectClasses.ConnectionPool;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.CrudDao;
import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.GenericDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.BaseEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GenericService<T extends BaseEntity> implements CrudDao<T> {
    protected GenericDao<T> dao;

    public GenericService(GenericDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public void add(T entity) {
        Connection connection = ConnectionPool.POOL.getConnection();
        dao.add(entity);
        try {
            connection.commit();
        } catch (SQLException e) {

        } finally {
            try {
                connection.rollback();
            } catch (SQLException e) {

            }
        }
        ConnectionPool.POOL.release();
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionPool.POOL.getConnection();
        try {
            dao.delete(id);
            connection.commit();
        } catch (SQLException e) {

        } finally {
            try {
                connection.rollback();
            } catch (SQLException e) {

            }
        }
        ConnectionPool.POOL.release();
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
