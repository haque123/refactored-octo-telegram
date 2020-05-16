package com.covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class CovidController {

	@Autowired
	CovidService CovidService;

    //Happy path, an Covid is returned as response
	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Covid  getCasesForCountry()  {
		 
		
		Covid covid=CovidService.getCasesForCountry("US");
		/*
		 * Covid covid =new Covid(500000.0,56885.0,3883.0,73.0);
		 */
			 return covid;
	}
	
	
	
	  //Happy path, an Covid is returned as response
		@RequestMapping(value = "/country/{stateCode}", method = RequestMethod.GET)
		public Covid getCasesForState(@PathVariable String stateCode)  {
						
			Covid covid=CovidService.getCasesForState(stateCode);
			//	Covid covid =new Covid(500000.0,56885.0,3883.0,73.0);

				 return covid;
		}
		

}