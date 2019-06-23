package com.ramazan.spring.jsf.example.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();
    T kaydet(T t);
    void sil(T t);
    T update(T t);
    T findById(Long id);

}
