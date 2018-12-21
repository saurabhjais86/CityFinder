package com.pramati.CityFinder;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pramati.CityFinder.util.CityFinderUtil;

@SpringBootApplication
public class CityFinderApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(CityFinderApplication.class, args);
		CityFinderUtil.loadCities();
	}

}

