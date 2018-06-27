package com.example.kas.api;

import com.example.kas.model.OpenDataResponse;
import com.example.kas.services.IKasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(KasController.class);

    @Autowired
    private IKasService kasService;

    @GetMapping("/")
    public OpenDataResponse findAllPackages() {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("GET findAllPackages");
        }
        return kasService.findAllPackages();
    }

    @GetMapping("/code/{code}")
    public OpenDataResponse findPackagesByCode(@PathVariable("code") String code) throws UnsupportedEncodingException {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("GET findPackagesByCode");
        }
        return kasService.findPackagesByCode(URLDecoder.decode(code, "UTF-8"));
    }
}