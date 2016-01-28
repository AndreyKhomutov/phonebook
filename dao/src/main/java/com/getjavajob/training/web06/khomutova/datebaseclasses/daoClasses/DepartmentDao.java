package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;


import com.getjavajob.training.web06.khomutova.phonebookclasses.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class DepartmentDao implements CrudDao<Department> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void add(Department entity) {
        entityManager.merge(entity);
    }

    @Override
    public void update(Department entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(int id) {
        Department department = entityManager.find(Department.class, id);
        entityManager.remove(department);

    }

    @Override
    public Department get(int id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public List<Department> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        CriteriaQuery<Department> select = criteriaQuery.select(criteriaQuery.from(Department.class));
        return entityManager.createQuery(select).getResultList();
    }
}
