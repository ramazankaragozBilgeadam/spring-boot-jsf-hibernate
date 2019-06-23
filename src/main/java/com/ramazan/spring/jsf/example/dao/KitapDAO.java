package com.ramazan.spring.jsf.example.dao;

import com.ramazan.spring.jsf.example.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitapDAO extends BaseDAO<Kitap> {
}
