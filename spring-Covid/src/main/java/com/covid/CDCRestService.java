package com.covid;

import java.util.Arrays;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class CDCRestService {
	
	
	public static   ResponseEntity<String> getrestTemplate(String uri) {

	       
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        RestTemplate restTemplate = new RestTemplate();
      
       
        
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
         
        
        System.out.println("CONTRY"+result);
        return result;

    }
	
	public static   ResponseEntity<String> getrestTemplate1(String uri) {

	       
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        RestTemplate restTemplate = new RestTemplate();
      
       
        
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
         
        
        System.out.println("CONTRY"+result);
        return result;

    }

	/*
	 * public static String countryCase() { HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	 * 
	 * String uri = "https://covidtracking.com/api/v1/us/current.json";
	 * 
	 * 
	 * // String result = CDCRestService.getrestTemplate().getForObject(uri,
	 * String.class);
	 * 
	 * System.out.println(result);
	 * 
	 * return result;
	 * 
	 * }
	 * 
	 * public static String stateCase() {
	 * 
	 * 
	 * String uri = "https://covidtracking.com/api/v1/states/AK/current.json";
	 * 
	 * 
	 * // String result = CDCRestService.getrestTemplate().getForObject(uri,
	 * String.class);
	 * 
	 * System.out.println(result);
	 * 
	 * return result;
	 * 
	 * }
	 */

}
