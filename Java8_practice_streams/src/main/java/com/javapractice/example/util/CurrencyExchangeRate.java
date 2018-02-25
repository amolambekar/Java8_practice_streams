package com.javapractice.example.util;

public enum CurrencyExchangeRate {
	  GBP (1.654),
			CHF ( 1.10),
			EUR ( 1.35);
			private double rate;
			
			CurrencyExchangeRate(double value){
				rate=value;
			}
			
			public double getRate(){
				return rate;
			}
			
			
	
	
	
}
