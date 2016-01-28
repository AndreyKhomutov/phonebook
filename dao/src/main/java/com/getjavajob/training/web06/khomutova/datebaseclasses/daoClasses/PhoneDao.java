package com.getjavajob.training.web06.khomutova.datebaseclasses.daoClasses;


import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class PhoneDao implements CrudDao<Phone> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void add(Phone entity) {
        entityManager.merge(entity);
    }

    @Override
    public void update(Phone entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(int id) {
        Phone phone = entityManager.find(Phone.class, id);
        entityManager.remove(phone);

    }

    @Override
    public Phone get(int id) {
        return entityManager.find(Phone.class, id);
    }

    @Override
    public List<Phone> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> criteriaQuery = criteriaBuilder.createQuery(Phone.class);
        CriteriaQuery<Phone> select = criteriaQuery.select(criteriaQuery.from(Phone.class));
        return entityManager.createQuery(select).getResultList();
    }
}
