package com.example.tradingexchange.api.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "currencies")
@EntityListeners(AuditingEntityListener.class)
public class Currency extends  BaseDatabaseModel{
    public String code;
    public String name;

    public Currency(){}
    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
