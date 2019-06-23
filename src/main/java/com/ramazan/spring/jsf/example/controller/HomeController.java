package com.ramazan.spring.jsf.example.controller;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.faces.context.FacesContext;
import java.io.IOException;

@Data
@Controller
@Scope("view")
public class HomeController {

    private String welcome="Welcome To JSF Spring Boot Integration App";

    public void onRedirect(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
