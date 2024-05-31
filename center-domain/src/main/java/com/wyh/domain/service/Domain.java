package com.wyh.domain.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Domain {

    @PostConstruct
    public void test(){
        System.out.println("DOMAIN");
    }
}
