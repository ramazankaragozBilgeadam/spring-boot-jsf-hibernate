package com.ramazan.spring.jsf.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "kitap_bilgi")
public class KitapBilgi extends BaseEntity{

    @Column(name = "cilt_no",nullable = false)
    private Integer ciltNo;
    @Column(name = "fiyat",nullable = false)
    private Double fiyat;
    @Temporal(TemporalType.DATE)
    @Column(name = "yayin_tarihi",nullable = false)
    private Date yayinTarihi;
    @Column(name = "yayin_evi")
    private String yayinEvi;
    @Column(name = "sayfa_sayisi",nullable = false,length = 4)
    private Integer sayfaSayisi;

}
