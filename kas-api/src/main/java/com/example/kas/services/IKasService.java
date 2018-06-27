package com.example.kas.services;

import com.example.kas.model.OpenDataResponse;

public interface IKasService {

    OpenDataResponse findAllPackages();

    OpenDataResponse findPackagesByCode(String code);
}
