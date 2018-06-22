package com.example.kas.api;

import com.example.kas.services.IKasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kas")
public class KasController {

    @Autowired
    private IKasService kasService;

    @GetMapping("/")
    public String findAllPackages() {
        return kasService.findAllPackages();
    }
}