package com.bank.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.pageobjects.LoginPage;
import com.bank.utills.XLutils;

public class TC2_LoginTest extends BaseClass {
	@Test(dataProvider="Login")
	public void loginDDT(String userName,String pwd) {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(pwd);
		loginPage.setClick();
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			//Assert.assertTrue(false);
		}else {
			//Assert.assertTrue(true);
			loginPage.logOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
		
	}
	@DataProvider(name="Login")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/bank/testdata/LoginExcel.xlsx";
		
		int rowNum=XLutils.getRowCount(path, "Sheet1");
		int columnNum=XLutils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rowNum][columnNum];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<columnNum;j++) {
				loginData[i-1][j]=XLutils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}

