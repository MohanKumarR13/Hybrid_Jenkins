package com.bank.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.bouncycastle.crypto.tls.HashAlgorithm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bank.utills.ReadConfig;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig config = new ReadConfig();
	public String baseURL = config.getUrl();
	public String userName = config.getUserName();
	public String password = config.getPwd();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = Logger.getLogger("E-Bank");
		PropertyConfigurator.configure("log4j.properties");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		Map<String,Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", prefs);
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	@AfterClass
	public void tearDown() {
		driver.quit(); 
	}
	public static void captureScreen(WebDriver driver,String tName) throws IOException {
//		String timeStamp=new SimpleDateFormat("dd-M-yyyy hh.mm.ss").format(new Date());
//		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		Files.copy(f, new File("C:\\Hybrid\\Hybrid_Framework_Selenium\\ScreenShots\\"+timeStamp+".jpg"));
//		System.out.println("ScreenShot taken");
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File fileile1=screenshot.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/ScreenShots/"+tName+".png");
		FileUtils.copyFile(fileile1, target);
		System.out.println("ScreenShot taken");
	}
	public String randomestring() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
		
		public static String randomenum() {
			String generatedNum=RandomStringUtils.randomNumeric(4);
			return generatedNum;
		}
}
