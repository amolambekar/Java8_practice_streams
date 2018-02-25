package com.javapractice.example.application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.javapractice.example.domain.Company;
import com.javapractice.example.util.AverageCalculator;

public class AverageCalculatorApplication {
	  public static void main(String[] args) throws IOException {
		  Set<Company> companySet = new HashSet<Company>();
		    try{
		     
		      InputStream inputFS = new FileInputStream("src/main/resources/FILE.DAT2.txt");
		      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
		      // skip the header of the csv
		      companySet = br.lines().skip(1).map(line->new Company(line)).collect(Collectors.toSet());
		      br.close();
		    } catch (IOException e) {
		     e.printStackTrace();
		    }
		   
		    AverageCalculator avgCalculator = new AverageCalculator();
		    Map<String,Map<String,BigDecimal>> averageMap = avgCalculator.calculateAverage(companySet);
		    System.out.println(averageMap);
		    
	        
	 
	  }
	  
	  
	
	}

