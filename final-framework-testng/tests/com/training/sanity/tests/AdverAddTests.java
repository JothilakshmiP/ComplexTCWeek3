package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminAccesstoUserPOM;
import com.training.pom.AdverAddPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdverAddTests {
	
	private WebDriver driver;
	private String baseUrl;
	private AdverAddPOM adverAddPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adverAddPOM = new AdverAddPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void adverAddTest() throws InterruptedException {
		adverAddPOM.sendUserName("admin");
		adverAddPOM.sendPassword("12345");
//		screenShot.captureScreenShot("CYTC_006_First");	
		adverAddPOM.clickLoginBtn(); 
//		screenShot.captureScreenShot("CYTC_006_Second");
		adverAddPOM.sendMemberLogin("manzoor");
	//	Thread.sleep(2000);
		adverAddPOM.clickMngAdvert();
		adverAddPOM.clickNewAdvert();
		adverAddPOM.sendAdverTitle("new offer");
		adverAddPOM.selectAdverCategory();
		adverAddPOM.sendAdverPrice("7");
		adverAddPOM.selectAdverCategory();
		adverAddPOM.selectNotExpir();
		adverAddPOM.sendAdverDesc("new offer for member");
		adverAddPOM.clickSaveNewAdvBtn();
		adverAddPOM.handleSaveAdvertAlert();
		adverAddPOM.clickLogout();
		adverAddPOM.sendUserName("manzoor");
		adverAddPOM.sendPassword("manzoor");
		adverAddPOM.clickLoginBtn();
		adverAddPOM.clickPersonal();
		adverAddPOM.clickAdvertisements();
		adverAddPOM.newAdvertSaveCheck();
	}
}

  