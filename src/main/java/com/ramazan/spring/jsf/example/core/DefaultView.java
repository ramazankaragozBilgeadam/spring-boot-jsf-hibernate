package com.ramazan.spring.jsf.example.core;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.PostConstruct;

/**
 * @Author Ramazan Karagöz
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class DefaultView implements WebMvcConfigurer {

    public DefaultView() {

    }

    @PostConstruct
    public void init() {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/")
                .setViewName("forward:/index.xhtml");

        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        registry.addViewController("/home").setViewName("forward:/home.xhtml");
    }


}
