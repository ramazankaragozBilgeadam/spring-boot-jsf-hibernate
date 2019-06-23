package com.ramazan.spring.jsf.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDAO<T> extends JpaRepository<T,Long> {
}
