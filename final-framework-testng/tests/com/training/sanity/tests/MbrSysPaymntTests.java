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
import com.training.pom.LoginPOM;
import com.training.pom.MbrSysPaymntPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MbrSysPaymntTests {

	private WebDriver driver;
	private String baseUrl;
	private MbrSysPaymntPOM mbrSysPaymntPOM;
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
		mbrSysPaymntPOM = new MbrSysPaymntPOM(driver); 
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
	public void mbrSysPaymntTest() {
		mbrSysPaymntPOM.sendUserName("manzoor");
		mbrSysPaymntPOM.sendPassword("manzoor");
//		screenShot.captureScreenShot("CYTC_004_First");	
		mbrSysPaymntPOM.clickLoginBtn(); 
//		screenShot.captureScreenShot("First");
		mbrSysPaymntPOM.clickMbrAccount();
		mbrSysPaymntPOM.clickMbrSystemPayment();
		mbrSysPaymntPOM.sendPayAmount("500");
		mbrSysPaymntPOM.selectTxnType();
		mbrSysPaymntPOM.sendDescription("Charity test");
		mbrSysPaymntPOM.clickPaymentSubmit();
		mbrSysPaymntPOM.checkPaymntConfirm();
		mbrSysPaymntPOM.verifyPaymnt();
		mbrSysPaymntPOM.clickAccountInfo();
		mbrSysPaymntPOM.verifyTxnAdded("Charity test");
	}
}
