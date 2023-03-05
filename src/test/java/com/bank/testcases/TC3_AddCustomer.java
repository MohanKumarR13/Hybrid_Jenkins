package com.bank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bank.pageobjects.AddCustomer;
import com.bank.pageobjects.LoginPage;

public class TC3_AddCustomer extends BaseClass {
	@Test
	public void addCustomer() throws InterruptedException, IOException {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("Enter User Name");
		loginPage.setPassword(password);
		logger.info("Enter Password");

		loginPage.setClick();
		//addCustomer.clickCustomer();
		driver.navigate().to("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		//driver.navigate().refresh();
		//driver.navigate().refresh();
		Thread.sleep(3000);
		//addCustomer.clickCustomer();
		logger.info("Provide Customer Details.....");
		AddCustomer addCustomer=new AddCustomer(driver);

		addCustomer.customerName("John");
		addCustomer.gender("male");
		addCustomer.dob("10", "11", "1998");
		Thread.sleep(3000);
		addCustomer.address("INDIA");
		addCustomer.city("HYD");
		addCustomer.state("AP");
		addCustomer.pinNo("500074");
		addCustomer.telephone("987261287"); 
		
		String email=randomestring()+"@gmail.com";
		addCustomer.emailId(email);
		addCustomer.password("abcdef");
		addCustomer.submit();
		Thread.sleep(3000);
		logger.info("Validation Started");

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Test Passed");

		}else {
			logger.info("Test Failed");

			captureScreen(driver, "addCustomer");
			Assert.assertTrue(false);

		}
	}
	
	}

