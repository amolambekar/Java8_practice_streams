package com.javapractice.example.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.javapractice.example.domain.Company;

public class AverageCalculator {
	//collect a map of companies grouped by location and credit rating respectively
	public Map<String,Map<String,BigDecimal>> calculateAverage(Set <Company> companySet){
		 Map<String, Map<String, BigDecimal>> averageMap=null;
		
	 Map<String, Map<String, List<Company>>> GroupedCompanyMap = companySet.parallelStream().collect(
				 Collectors.groupingBy(
						 Company::getLocation,Collectors
						 .groupingBy(Company::getCreditRating)));
	 //transform the map into another map by caluclating average and replace list of company objects  with list of BigDecimals
	 averageMap= GroupedCompanyMap
			 .entrySet()
			 .parallelStream()
			 .collect(Collectors
			 .toMap( e -> e.getKey(),
			            e -> average(e.getValue())));
		
		return averageMap;
	}
	
	
	
	public static BigDecimal covertToEuro(Company company){
		//First convert the amount to USD and then convert to EURO
		Double exchangeRate =CurrencyExchangeRate
				.valueOf(company
						.getCurrency()
						.getCurrencyCode())
				        .getRate();
		BigDecimal amountInUSD = company
				                 .getAmount()
				                 .multiply(BigDecimal
				                 .valueOf(exchangeRate));
		
		BigDecimal amountinEuro = amountInUSD.
				divide(BigDecimal.
						valueOf(CurrencyExchangeRate.EUR.getRate()),2, BigDecimal.ROUND_HALF_EVEN);
		
		return amountinEuro;
		
	}
	
	
	public Map<String, BigDecimal>  average(Map<String, List<Company>> map) {
		return map.entrySet().parallelStream().collect(Collectors.toMap( e -> e.getKey(),
	            e -> calculateAvg(e.getValue())));
	    
	}
	
	public BigDecimal calculateAvg(List<Company> comanyList){
		 BigDecimal sum = comanyList.parallelStream()
			        .map(company->covertToEuro(company))
			        .reduce(BigDecimal.ZERO, BigDecimal::add);
			    return  sum.divide(new BigDecimal(comanyList.size()), BigDecimal.ROUND_HALF_EVEN);
		
	}

	
}

  
  
	
	


