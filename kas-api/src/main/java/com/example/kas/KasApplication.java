package com.example.kas;

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

	public static void main(String[] args) {
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
