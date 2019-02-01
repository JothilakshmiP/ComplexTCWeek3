package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminAccesstoUserPOM;
import com.training.pom.ComplexRegisterPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class NewMemberTests {
	private WebDriver driver;
	private String baseUrl;
	private ComplexRegisterPOM complexRegisterPOM;
	private LoginPOM loginPOM;
	private AdminAccesstoUserPOM adminAccesstoUserPOM;
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
		complexRegisterPOM = new ComplexRegisterPOM(driver);
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

	@Test(dataProvider = "excel-inputs-TC4", dataProviderClass = LoginDataProviders.class)
	public void newMemberTest(String loginName, String fullName, String email, String DOB, String Gender, String address, String postalCode, String city, String phNumber, String mbNumber, String fax, String URL, String newPassword, String confPassword, String userName, String password, String memberLogin, String comments, String admin, String adminPass) throws InterruptedException {
		complexRegisterPOM.clickLoginButtton();
		complexRegisterPOM.sendLoginName(loginName);
		complexRegisterPOM.sendfullName(fullName);
		complexRegisterPOM.sendEmail(email); 
		complexRegisterPOM.sendDtOfBirth(DOB);
		complexRegisterPOM.selectRadioButton(Gender);
		complexRegisterPOM.sendAddress(address);
		complexRegisterPOM.sendPostalCode(postalCode);
		complexRegisterPOM.sendCity(city);
		complexRegisterPOM.sendPhoneNumber(phNumber);
		complexRegisterPOM.sendMobileNumber(mbNumber);
		complexRegisterPOM.sendFax(fax);
		complexRegisterPOM.sendUrl(URL);
		complexRegisterPOM.newSendNewPassword(newPassword);
		complexRegisterPOM.sendConfirmPassword(confPassword);	
		Thread.sleep(10000);
		complexRegisterPOM.clickSubmit();
		driver.findElement(By.id("btn")).click();
//		driver.navigate().refresh();   
		complexRegisterPOM.sendUserName(userName);
		complexRegisterPOM.sendPassword(password);
		complexRegisterPOM.clickLoginBtn();
		complexRegisterPOM.sendMemberLogin(memberLogin);
		complexRegisterPOM.prmngrpSubmitBtn();
		complexRegisterPOM.selectNewGroupId();
		complexRegisterPOM.sendComments(comments);
		complexRegisterPOM.clickMbrGroupBtn();
		complexRegisterPOM.acceptChangeGroup();
		complexRegisterPOM.clickLogout();
		complexRegisterPOM.sendUserName(admin);
		complexRegisterPOM.sendPassword(adminPass);;
		complexRegisterPOM.clickLoginBtn();
		
	}
}