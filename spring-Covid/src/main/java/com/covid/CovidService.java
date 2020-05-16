package com.covid;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.covid.error.BookNotFoundException;
import com.covid.error.BookUnSupportedFieldPatchException;
import com.google.gson.Gson;

@Service
public class CovidService {
	
	 @Autowired
	    private CovidRepository repository;

	 
	 Covid getCasesForCountry(String country) {
	   String uri = "https://covidtracking.com/api/v1/"+country+"/current.json";

	   Covid covid=new Covid();
	   
	   ResponseEntity<String>  rs= CDCRestService.getrestTemplate(uri);
	  
	   
		//Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
		//String jsonString = "{'employee.name':'Bob','employee.salary':10000}";
		Gson gson = new Gson();
		Map map = gson.fromJson(rs.getBody(), Map.class);


Set entrySet = map.entrySet();

// Obtaining an iterator for the entry set
Iterator it = entrySet.iterator();
	   
	   
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
        return covid;//new Covid(500000.0,56885.0,3883.0,73.0);
    }

   

    // Find
    public Covid getCasesForState(String stCode) {
    	// CDCRestService.countryCase();
    	  String uri = "https://covidtracking.com/api/v1/states/"+stCode+"/current.json";
   	  
   	   ResponseEntity<String>  rs= CDCRestService.getrestTemplate(uri);
       	
   	   
		//Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
		//String jsonString = "{'employee.name':'Bob','employee.salary':10000}";
		Gson gson = new Gson();
		Map map = gson.fromJson(rs.getBody(), Map.class);


Set entrySet = map.entrySet();

//Obtaining an iterator for the entry set
Iterator it = entrySet.iterator();
	   
	   
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
   	  
    	 return covid;//new Covid(10000.0,565.0,383.0,73.0);
    }

  


}
