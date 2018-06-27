package com.example.kas.services;

import com.example.kas.model.OpenDataResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@EnableCaching
@RunWith(SpringRunner.class)
public class KasServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(KasServiceTest.class);

    public static final String TRAMS_CODE = "trams*";
    public static final String QUALITAT_AIRE_CODE = "qualitat_aire_detall";

    public static final String CACHE_ID = "packages";

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public IKasService employeeService() {
            return new KasService();
        }

        @Bean
        public CacheManager cacheManager() {
            return new ConcurrentMapCacheManager(CACHE_ID);
        }
    }

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private IKasService kasService;

    @Test
    public void testGetAllPackages() {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Start testGetAllPackages");
        }

        OpenDataResponse packages = this.kasService.findAllPackages();
        assertThat(packages).isNotNull();
        assertThat(packages.getResult().getResults().size()).isEqualTo(10);

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("End testGetAllPackages");
        }
    }

    @Test
    public void testGetPackagesByCode() {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Start testGetPackagesByCode");
        }

        OpenDataResponse packages = this.kasService.findPackagesByCode(QUALITAT_AIRE_CODE);
        assertThat(packages).isNotNull();
        assertThat(packages.getResult().getResults().size()).isEqualTo(1);

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("End testGetPackagesByCode");
        }
    }

    @Test
    public void testGetPackagesByAsteriskCode() {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Start testGetPackagesByAsteriskCode");
        }

        OpenDataResponse packages = this.kasService.findPackagesByCode(TRAMS_CODE);
        assertThat(packages).isNotNull();
        assertThat(packages.getResult().getResults().size()).isEqualTo(1);

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("End testGetPackagesByAsteriskCode");
        }
    }

    @Test
    public void testCachePackages() {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Start testCachePackages");
        }

        Cache cache = this.cacheManager.getCache(CACHE_ID);
        assertThat(cache.get(QUALITAT_AIRE_CODE)).isNull();
        this.kasService.findPackagesByCode(QUALITAT_AIRE_CODE);

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug(String.format("Cache content: %s", cache.getNativeCache().toString()));
        }

        assertThat(cache.get(QUALITAT_AIRE_CODE)).isNotNull();
        assertThat(cache.get(QUALITAT_AIRE_CODE, OpenDataResponse.class).getResult().getResults().size()).isEqualTo(1);

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("End testCachePackages");
        }
    }
}
