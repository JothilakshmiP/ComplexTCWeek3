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
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTests {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
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
		registerPOM = new RegisterPOM(driver); 
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
	public void validRegisterTest() throws InterruptedException {
		screenShot.captureScreenShot("CYTC_001_First");
		registerPOM.clickLoginButtton();
		registerPOM.sendLoginName("Jothi");
		registerPOM.sendfullName("Jothi");
		registerPOM.sendEmail("jothipjl@gmail.com"); 
		registerPOM.sendDtOfBirth("16/07/1992");
		registerPOM.selectRadioButton();
		registerPOM.sendAddress("Bangalore");
		registerPOM.sendPostalCode("560054");
		screenShot.captureScreenShot("CYTC_001_Second");
		registerPOM.sendCity("Bangalore");
		registerPOM.selectArea();
		registerPOM.sendPhoneNumber("9876543211");
		registerPOM.sendMobileNumber("9876543211");
		registerPOM.sendFax("9876543211");
		registerPOM.sendUrl("www.google.com");
		registerPOM.sendPassword("jothi123");
		registerPOM.sendConfirmPassword("jothi123");
		Thread.sleep(10000);
		screenShot.captureScreenShot("CYTC_001_Third");
		registerPOM.clickSubmit();
		screenShot.captureScreenShot("CYTC_001_Fourth");
	}
}
