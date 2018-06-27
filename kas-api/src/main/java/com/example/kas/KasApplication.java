package com.example.kas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableCaching
public class KasApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(KasApplication.class);

	public static void main(String[] args) {
		if (LOGGER.isDebugEnabled()){
			LOGGER.debug("Start KasApplication");
		}

		SpringApplication.run(KasApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(
				new ConcurrentMapCache("packages")));
		return cacheManager;
	}
}
