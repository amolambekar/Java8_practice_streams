package com.javapractice.example.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;

import static org.apache.commons.lang.StringUtils.*;

public class Company {
	
	private String companyCode;	
	private String account;	
	private String city;
	private String country;
	private String creditRating;
	private Currency currency;
	private BigDecimal amount;
	
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String cccount) {
		this.account = cccount;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getLocation(){
		return isNotEmpty(this.country)?this.country:this.city;
	}
	
	public Company(String data){
		 String[] split = data.split("	");
		 this.companyCode =split[0];	
			 this.account=split[1];	
			 this.city= split[2];
			 this.country=split[3];
			 this.creditRating=split[4];
			 this.currency=Currency.getInstance(split[5]);
			 StringUtils.isNotEmpty(split[6]);
			 this.amount=new BigDecimal(split[6]);
		
	}
	
	
	

}
