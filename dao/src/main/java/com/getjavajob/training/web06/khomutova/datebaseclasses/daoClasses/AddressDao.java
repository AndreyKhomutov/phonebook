package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;


import com.getjavajob.training.web06.khomutova.phonebookclasses.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class AddressDao implements CrudDao<Address> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void add(Address entity) {
        entityManager.merge(entity);
    }

    @Override
    public void update(Address entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(int id) {
        Address address = entityManager.find(Address.class, id);
        entityManager.remove(address);
    }

    @Override
    public Address get(int id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public List<Address> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);
        CriteriaQuery<Address> select = criteriaQuery.select(criteriaQuery.from(Address.class));
        return entityManager.createQuery(select).getResultList();
    }
}
