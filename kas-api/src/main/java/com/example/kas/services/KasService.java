package com.example.kas.services;

import com.example.kas.model.OpenDataResponse;
import com.example.kas.utils.KasConstants;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KasService implements IKasService {

    public OpenDataResponse findAllPackages() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(KasConstants.SEARCH_PACKAGES_URI, OpenDataResponse.class);
    }

    @CachePut(value="packages", key="#code")
    public OpenDataResponse findPackagesByCode(String code) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(KasConstants.SEARCH_PACKAGES_BY_CODE_URI, code), OpenDataResponse.class);
    }
}
