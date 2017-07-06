package com.creditharmony.core.users.entity;

import java.util.Date;

import com.creditharmony.core.persistence.DataEntity;

public class OnOff extends DataEntity<OnOff>{
    private String id;

    private String type;

    private String value;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

}