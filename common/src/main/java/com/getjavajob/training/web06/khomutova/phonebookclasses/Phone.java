package com.getjavajob.training.web06.khomutova.phonebookclasses;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EntityType entityType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phoneID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
}
