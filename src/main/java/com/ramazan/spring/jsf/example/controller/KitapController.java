package com.ramazan.spring.jsf.example.controller;

import com.ramazan.spring.jsf.example.entity.Kitap;
import com.ramazan.spring.jsf.example.entity.KitapBilgi;
import com.ramazan.spring.jsf.example.service.KitapService;
import lombok.Data;
import org.primefaces.event.SelectEvent;
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
        if (selectedKitap!=null) {
            kitap.setId(selectedKitap.getId());
            kitapBilgi.setId(selectedKitap.getKitapBilgi().getId());
            kitap.setKitapBilgi(kitapBilgi);
            kitapService.update(kitap);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,"Güncelleme Başarılı",""));
        }
    }

    public void onDelete(){
        if (selectedKitap!=null) {
            kitapService.sil(selectedKitap);
            onListele();
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,"Silme İşlemi Başarılı",""));
        }
    }

    public void onListele(){
        kitapList=kitapService.findAll();
    }


    public void onRowSelected(SelectEvent selectEvent){
        if (selectEvent.getObject()!=null){
            this.kitap=selectedKitap;
            this.kitapBilgi=selectedKitap.getKitapBilgi();
        }
    }

    public void onTemizle(){
        this.kitap=new Kitap();
        this.kitapBilgi=new KitapBilgi();
        this.kitapList=new ArrayList<>();
    }


}
