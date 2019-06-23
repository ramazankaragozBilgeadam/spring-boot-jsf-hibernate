package com.ramazan.spring.jsf.example.controller;

import com.ramazan.spring.jsf.example.entity.Kitap;
import com.ramazan.spring.jsf.example.entity.KitapBilgi;
import com.ramazan.spring.jsf.example.service.KitapService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@Scope("view")
public class KitapController {

    private final KitapService kitapService;
    private Kitap kitap=new Kitap();
    private KitapBilgi kitapBilgi=new KitapBilgi();
    private Kitap selectedKitap;
    private List<Kitap> kitapList=new ArrayList<>();

    @Autowired
    public KitapController(KitapService kitapService) {
        this.kitapService = kitapService;
    }

    public void onRedirect(){
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("kitapTanimlama");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onKaydet(){

        if (kitapBilgi.getFiyat()!=null){
            kitap.setKitapBilgi(kitapBilgi);
            kitapService.kaydet(kitap);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayıt Başarılı",""));
        }

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
