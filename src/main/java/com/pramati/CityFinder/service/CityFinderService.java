package com.pramati.CityFinder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pramati.CityFinder.util.CityFinderUtil;

@Service
public class CityFinderService {

	public String suggestCities(String start, int atmost) {
		List<String> filterCities = CityFinderUtil.citySet.stream()
				.filter(s -> s.toLowerCase().startsWith(start.toLowerCase()))
				.collect(Collectors.toList());
		return getNoOfSuggestedCities(filterCities, atmost);
	}

	private String getNoOfSuggestedCities(List<String> filterCities, int atmost){
	
		int count = 0;
		StringBuffer buff = new StringBuffer();
		
		if(filterCities.isEmpty()){
			return "No Cities found...";
		}
	
		for(String city : filterCities){
			buff.append(city);
			count++;
			
			if(count == atmost){
				break;
			}
			else if(count == filterCities.size()){
				buff.append("\n ---> End of Result <---");
			}
			else {
				buff.append("\n");
			}
		}
		
		return buff.toString();
	}
}
