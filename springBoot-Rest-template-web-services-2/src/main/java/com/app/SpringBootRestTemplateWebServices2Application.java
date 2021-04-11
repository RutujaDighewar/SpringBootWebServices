package com.app;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.app.entity.Employee;

public class SpringBootRestTemplateWebServices2Application {
	
	static RestTemplate restTemplate = new RestTemplate();
	
	private static final String baseURI = "http://localhost:4000/employee";
	
	public static void main(String[] args) {
		
		
		  Employee employee1=new Employee("Vinaya" , "Mumbai");
		  restTemplate.postForObject(baseURI, employee1, String.class);
		  
		  Employee employee2=new Employee("Dipali" , "Pune");
		  restTemplate.postForObject(baseURI, employee2, String.class);
		 
		
		List<?> employees = restTemplate.getForObject(baseURI, List.class);
		for (Object object : employees) {
			LinkedHashMap lhm = (LinkedHashMap) object;
			Set s=lhm.keySet();
			   for(Object keys : s) {
				   System.out.println(keys);
				   Object obj=lhm.get(keys);
				   System.out.println(obj);
			   }
			
		}
	}

}
