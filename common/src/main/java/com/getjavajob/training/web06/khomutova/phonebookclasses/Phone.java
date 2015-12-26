package com.getjavajob.training.web06.khomutova.phonebookclasses;

public class Phone extends BaseEntity {
    private String number;
    private EntityType entityType;

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
