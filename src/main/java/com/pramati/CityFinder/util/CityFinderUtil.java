package com.pramati.CityFinder.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CityFinderUtil {

	public static Set<String> citySet = null;
	private final static String CITIES_FILENAME = "listOfCities.csv";

	public static void loadCities() throws FileNotFoundException, IOException {

		String st = null;
		BufferedReader br = null;
		try {
			citySet = new HashSet<>();
			File file = new File(CITIES_FILENAME);
			br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				citySet.add(st.trim());
			}
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch(IOException e){
				throw e;
			}
		}
	}

}
