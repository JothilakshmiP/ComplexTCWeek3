package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterDBTest {
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
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
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs-register", dataProviderClass = LoginDataProviders.class)
	public void registerDBTest(String loginName, String fullName, String email,String DOB, String gender, String address, String postalCode, String city, String phNumber, String mbNumber, String fax, String url, String newPassword, String confPassword) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		registerPOM.clickLoginButtton();
		registerPOM.sendLoginName(loginName);
		registerPOM.sendfullName(fullName);
		registerPOM.sendEmail(email);
		registerPOM.sendDtOfBirth(DOB);
		registerPOM.selectRadioButton(gender);
		registerPOM.sendAddress(address);
		registerPOM.sendPostalCode(postalCode);
		registerPOM.sendCity(city);
		registerPOM.sendPhoneNumber(phNumber);
		registerPOM.sendMobileNumber(mbNumber);
		registerPOM.sendUrl(url);
		registerPOM.sendPassword(newPassword);
		registerPOM.sendConfirmPassword(confPassword);
		registerPOM.clickSubmit();
	}

}