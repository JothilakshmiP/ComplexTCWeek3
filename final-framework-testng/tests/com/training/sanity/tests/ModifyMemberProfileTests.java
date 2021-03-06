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
import com.training.pom.ModifyMemberProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ModifyMemberProfileTests {

	private WebDriver driver;
	private String baseUrl;
	private ModifyMemberProfilePOM modifyMemberProfilePOM;
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
		modifyMemberProfilePOM = new ModifyMemberProfilePOM(driver); 
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
	public void validLoginTest() {
		modifyMemberProfilePOM.sendUserName("manzoor");
		modifyMemberProfilePOM.sendPassword("manzoor");
		screenShot.captureScreenShot("CYTC_005_First");	
		modifyMemberProfilePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("CYTC_005_First");
		modifyMemberProfilePOM.clickMyProfile();
		screenShot.captureScreenShot("CYTC_005_Second");
		modifyMemberProfilePOM.clickChangeProfile();
		screenShot.captureScreenShot("CYTC_005_Third");
		modifyMemberProfilePOM.modifyAddress("yeshwanthapur");
		screenShot.captureScreenShot("CYTC_005_Fourth");
		modifyMemberProfilePOM.clickSaveProfile();
		screenShot.captureScreenShot("CYTC_005_Fifth");
		modifyMemberProfilePOM.profileModAlert();
		screenShot.captureScreenShot("CYTC_005_Sixth");
	}
}
