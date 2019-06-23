package com.ramazan.spring.jsf.example.service;

import com.ramazan.spring.jsf.example.dao.KitapDAO;
import com.ramazan.spring.jsf.example.entity.Kitap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KitapServiceImpl implements KitapService {

    private final KitapDAO kitapDAO;

    @Autowired
    public KitapServiceImpl(KitapDAO kitapDAO) {
        this.kitapDAO = kitapDAO;
    }

    @Transactional
    @Override
    public List<Kitap> findAll() {
        return kitapDAO.findAll();
    }

    @Transactional
    @Override
    public Kitap kaydet(Kitap kitap) {
        return kitapDAO.save(kitap);
    }


    @Override
    public void sil(Kitap kitap) {

        if (kitap!=null&&kitap.getId()!=null){
            kitapDAO.delete(kitap);
        }

    }

    @Override
    public Kitap update(Kitap kitap) {
        return kitapDAO.save(kitap);
    }

    @Override
    public Kitap findById(Long id) {
        return kitapDAO.findById(id).get();
    }
}
