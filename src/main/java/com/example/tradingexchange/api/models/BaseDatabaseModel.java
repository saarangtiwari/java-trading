package com.example.tradingexchange.api.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
public class BaseDatabaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreatedDate
    public Date createdAt;


    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    public Date updatedAt;


    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


}
