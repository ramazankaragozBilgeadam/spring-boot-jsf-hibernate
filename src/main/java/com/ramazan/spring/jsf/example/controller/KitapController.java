package com.ramazan.spring.jsf.example.controller;

import com.ramazan.spring.jsf.example.entity.Kitap;
import com.ramazan.spring.jsf.example.service.KitapService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@Scope("view")
public class KitapController {

    private final KitapService kitapService;
    private Kitap kitap=new Kitap();
    private Kitap selectedKitap;
    private List<Kitap> kitapList=new ArrayList<>();

    @Autowired
    public KitapController(KitapService kitapService) {
        this.kitapService = kitapService;
    }

    public void onKaydet(){

        kitapService.kaydet(kitap);
    }

    public void onUpdate(){
        if (selectedKitap!=null)
        kitapService.update(selectedKitap);
    }

    public void onDelete(){
        if (selectedKitap!=null)
            kitapService.sil(selectedKitap);
    }

    public void onListele(){
        kitapList=kitapService.findAll();
    }


}
