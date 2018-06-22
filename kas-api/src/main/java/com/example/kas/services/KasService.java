package com.example.kas.services;

import com.example.kas.model.OpenDataResponse;
import com.example.kas.utils.KasConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KasService implements IKasService {

    public String findAllPackages() {
        RestTemplate restTemplate = new RestTemplate();
        OpenDataResponse openData = restTemplate.getForObject(KasConstants.SEARCH_PACKAGES_URI, OpenDataResponse.class);

        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String response = null;
        try {
            response = writer.writeValueAsString(openData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }
}
