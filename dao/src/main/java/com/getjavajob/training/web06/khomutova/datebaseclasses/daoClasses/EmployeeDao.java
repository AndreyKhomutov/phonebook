package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;


import com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses.CrudDao;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class EmployeeDao implements CrudDao<Employee> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void add(Employee entity) {
        entityManager.merge(entity);
    }

    @Override
    public void update(Employee entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

    }

    @Override
    public Employee get(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        CriteriaQuery<Employee> select = criteriaQuery.select(criteriaQuery.from(Employee.class));
        return entityManager.createQuery(select).getResultList();
    }
}
