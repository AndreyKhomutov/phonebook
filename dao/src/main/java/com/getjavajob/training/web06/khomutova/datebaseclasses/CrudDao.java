package com.getjavajob.training.web06.khomutova.datebaseclasses;

import java.util.List;

public interface CrudDao<T> {
    void add(T entity);

    void update(T entity);

    void delete(int id);

    T get(int id);

    List<T> getAll();
}
