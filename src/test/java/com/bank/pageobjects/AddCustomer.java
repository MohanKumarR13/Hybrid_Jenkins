package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	WebDriver driver;

	public AddCustomer(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkAddcustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement customerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement dob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement address;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement pinno;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement telephoneno;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement emailid;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup 
	WebElement password;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement sub;

	@FindBy(how = How.NAME, using = "res")
	@CacheLookup
	WebElement res;
	
	public void clickCustomer() {
		linkAddcustomer.click();
	}
	public void customerName(String cName) {
		customerName.sendKeys(cName);
	}
	public void gender(String cGender) {
		rdGender.click();
	}
	public void dob(String mm,String dd,String yy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	public void address(String cAddress) {
		address.sendKeys(cAddress);
	}
	
	public void city(String cCity) {
		city.sendKeys(cCity);
	}
	public void state(String cState) {
		state.sendKeys(cState);
	}
	public void pinNo(String cPinNo) {
		pinno.sendKeys(String.valueOf(cPinNo));
	}
	public void telephone(String cTelephoneno) {
		telephoneno.sendKeys(cTelephoneno);
	}
	public void emailId(String cEmailID) {
		emailid.sendKeys(cEmailID);
	}
	public void password(String cPwd) {
		password.sendKeys(cPwd);
	}
	public void submit() {
		sub.click();
	}
	public void reset() {
		res.click();
	}
}
