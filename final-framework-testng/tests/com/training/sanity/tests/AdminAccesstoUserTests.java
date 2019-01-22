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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAccesstoUserTests {

	private WebDriver driver;
	private String baseUrl;
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
		adminAccesstoUserPOM = new AdminAccesstoUserPOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		adminAccesstoUserPOM.sendUserName("admin");
		adminAccesstoUserPOM.sendPassword("12345");
		screenShot.captureScreenShot("CYTC_003_First");	
		adminAccesstoUserPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("CYTC_003_Second");
		adminAccesstoUserPOM.sendMemberLogin("manzoor");
		screenShot.captureScreenShot("CYTC_003_Third");
		adminAccesstoUserPOM.prmngrpSubmitBtn();
		screenShot.captureScreenShot("CYTC_003_Fourth");
		adminAccesstoUserPOM.selectNewGroupId();
		adminAccesstoUserPOM.sendComments("full access to the member");
		screenShot.captureScreenShot("CYTC_003_Fifth");
		adminAccesstoUserPOM.clickMbrGroupBtn();
		screenShot.captureScreenShot();
		adminAccesstoUserPOM.acceptChangeGroup();
		screenShot.captureScreenShot();
	}
}
