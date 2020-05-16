package com.covid;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.tomcat.util.json.JSONParser;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import junit.framework.Assert;

public class CDCRestServiceTest {	 
	
	 ///   https://covidtracking.com/api/v1/us/current.json
	
	@Test
	public void testGetRestTemplate( ) throws URISyntaxException 
	{
		 HttpHeaders headers = new HttpHeaders();
		 
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

	        RestTemplate restTemplate = new RestTemplate();
	      
	        String uri = "https://covidtracking.com/api/v1/states/OH/current.json";
	 	   
	        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	        
	         
					//Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
					//String jsonString = "{'employee.name':'Bob','employee.salary':10000}";
					Gson gson = new Gson();
					Map map = gson.fromJson(result.getBody(), Map.class);
     	 
	        
  	Set entrySet = map.entrySet();
  	 
    // Obtaining an iterator for the entry set
    Iterator it = entrySet.iterator();
 
    // Iterate through HashMap entries(Key-Value pairs)
    System.out.println("HashMap Key-Value Pairs : ");
    
    Covid covid=new Covid();
    while(it.hasNext()){
    	
    	
       Map.Entry me = (Map.Entry)it.next();
       
       
       if(me.getKey().equals("totalTestResults")){
       System.out.println("Key is: "+me.getKey() + 
       " & " + 
       " value is: "+me.getValue().toString());
      covid.setTotalTestResult(Double.parseDouble(me.getValue().toString()));
       
       }
       if(me.getKey().equals("positive")){
           System.out.println("Key is: "+me.getKey() + 
           " & " + 
           " value is: "+me.getValue());
           covid.setPositive(Double.parseDouble(me.getValue().toString()));
           }
       if(me.getKey().equals("death")){
           System.out.println("Key is: "+me.getKey() + 
           " & " + 
           " value is: "+me.getValue());
           covid.setDeths(Double.parseDouble(me.getValue().toString()));
           }
       if(me.getKey().equals("negative")){
           System.out.println("Key is: "+me.getKey() + 
           " & " + 
           " value is: "+me.getValue());
           covid.setEngative(Double.parseDouble(me.getValue().toString()));
           }
       
       
       
   }
  	
  	
  	
  	System.out.println(" COVID detail"+covid);
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	   // Assert.assertEquals(true, result.getBody().contains("employeeList"));
	}
	 

	 
}
