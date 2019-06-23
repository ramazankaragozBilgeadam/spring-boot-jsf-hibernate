package com.ramazan.spring.jsf.example.controller;

import com.ramazan.spring.jsf.example.service.KitapService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Data
@Controller
@Scope("view")
public class KitapController {

    private final KitapService kitapService;

    @Autowired
    public KitapController(KitapService kitapService) {
        this.kitapService = kitapService;
    }
}
