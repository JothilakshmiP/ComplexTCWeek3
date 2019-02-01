package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexRegisterTests {
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

	@Test(dataProvider = "excel-inputs-TC2", dataProviderClass = LoginDataProviders.class)
	public void registerDBTest(String loginName, String fullName, String email, String DOB, String Gender, String address, String postalCode, String city, String phNumber, String mbNumber, String fax, String URL, String password, String confPassword) throws InterruptedException {
		registerPOM.clickLoginButtton();
		registerPOM.sendLoginName(loginName);
		registerPOM.sendfullName(fullName);
		registerPOM.sendEmail(email); 
		registerPOM.sendDtOfBirth(DOB);
		registerPOM.selectRadioButton(Gender);
		registerPOM.sendAddress(address);
		registerPOM.sendPostalCode(postalCode);
//		screenShot.captureScreenShot("CYTC_001_Second");
		registerPOM.sendCity(city);
		registerPOM.sendPhoneNumber(phNumber);
		registerPOM.sendMobileNumber(mbNumber);
		registerPOM.sendFax(fax);
		registerPOM.sendUrl(URL);
		registerPOM.sendPassword(password);
		registerPOM.sendConfirmPassword(confPassword);	
		Thread.sleep(10000);
		registerPOM.clickSubmit();
	}
}