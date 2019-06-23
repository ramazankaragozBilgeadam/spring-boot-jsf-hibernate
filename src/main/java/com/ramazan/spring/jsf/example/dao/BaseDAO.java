package com.ramazan.spring.jsf.example.dao;

import com.ramazan.spring.jsf.example.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDAO<T extends BaseEntity> extends JpaRepository<T,Long> {
}
