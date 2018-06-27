package com.example.kas.api;

import com.example.kas.model.OpenDataResponse;
import com.example.kas.services.IKasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/kas")
public class KasController {

    @Autowired
    private IKasService kasService;

    @GetMapping("/")
    public OpenDataResponse findAllPackages() {
        return kasService.findAllPackages();
    }

    @GetMapping("/code/{code}")
    public OpenDataResponse findPackagesByCode(@PathVariable("code") String code) throws UnsupportedEncodingException {
        return kasService.findPackagesByCode(URLDecoder.decode(code, "UTF-8"));
    }
}