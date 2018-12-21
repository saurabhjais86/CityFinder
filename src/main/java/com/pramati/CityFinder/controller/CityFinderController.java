package com.pramati.CityFinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.CityFinder.service.CityFinderService;
import com.pramati.CityFinder.util.CityFinderException;

@RestController
@RequestMapping("/cityFinder")
public class CityFinderController {
	
	@Autowired
	private CityFinderService cityFinderService;
	
	/**
	 * 
	 * @param start : characters the city name start with
	 * @param atmost : maximum number of suggestions
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/suggest_cities", produces="text/plain")
	public String suggestCities( @RequestParam("start") String start, @RequestParam("atmost") String atmost) throws CityFinderException{
		String suggestCities = null;
		try{
			suggestCities = cityFinderService.suggestCities(start, Integer.parseInt(atmost));
		}
		catch(NumberFormatException ne){
			throw new CityFinderException("Value of Atmost is incorrect...");
		}
		catch (Exception e) {
			throw new CityFinderException("Internal Application Exception..");
		}
	
		return suggestCities;
	}

}
