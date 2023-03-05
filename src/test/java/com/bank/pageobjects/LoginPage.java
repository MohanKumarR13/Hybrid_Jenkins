package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	 WebDriver driver;
	public LoginPage(WebDriver rdriver){
	driver=rdriver;
	PageFactory.initElements(rdriver, this);
}
	@FindBy(name="uid")
	@CacheLookup
	public static WebElement userName;
	@FindBy(name="password")
	@CacheLookup
	public static WebElement password;
	@FindBy(name="btnLogin")
	@CacheLookup
	public static WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	public static WebElement btnLogOut;
	public void setUserName(String uName) {
		userName.sendKeys(uName);
		
	}
	public void setPassword(String pword) {
		password.sendKeys(pword);
		
	}
	public void setClick() {
		btnLogin.click();
		
	}
	public void logOut() {
		btnLogOut.click();
		
	}
}