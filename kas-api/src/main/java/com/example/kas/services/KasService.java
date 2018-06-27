package com.example.kas.services;

import com.example.kas.model.OpenDataResponse;
import com.example.kas.utils.KasConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KasService implements IKasService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KasService.class);

    private RestTemplate restTemplate = new RestTemplate();

    public OpenDataResponse findAllPackages() {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Service findAllPackages");
        }
        return restTemplate.getForObject(KasConstants.SEARCH_PACKAGES_URI, OpenDataResponse.class);
    }

    @CachePut(value="packages", key="#code")
    public OpenDataResponse findPackagesByCode(String code) {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug(String.format("Service findPackagesByCode %s", code));
        }
        return restTemplate.getForObject(String.format(KasConstants.SEARCH_PACKAGES_BY_CODE_URI, code), OpenDataResponse.class);
    }
}
