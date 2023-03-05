package com.bank.testcases;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bank.pageobjects.LoginPage;

public class TC1_LoginTest extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		driver.get(baseURL);
		logger.info("URL is Opened");
		lp.setUserName(userName);
		logger.info("Enter User Name");

		lp.setPassword(password);
		logger.info("Enter Password");
		lp.setClick();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Passed");

		}else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Failed");

			
		}
		
		
	}
}
