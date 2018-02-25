package com.javapractice.example.util;

import java.math.BigDecimal;

public class ExchangeRateConverter {
	
	
	//not used yet
	public static BigDecimal covertToUSD(BigDecimal amount,Double rate){
		return amount.multiply(BigDecimal.valueOf(rate));
	}
	//not used yet
	public static  BigDecimal ConvertToEuroFromUSD(BigDecimal amount){
		return amount.multiply(BigDecimal.valueOf(CurrencyExchangeRate.EUR.getRate()));
	
	
	}
}
	


