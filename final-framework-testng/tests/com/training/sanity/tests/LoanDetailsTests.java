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
import com.training.pom.LoanDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoanDetailsTests {
	private WebDriver driver;
	private String baseUrl;
	private LoanDetailsPOM loanDetailsPOM;
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
		loanDetailsPOM = new LoanDetailsPOM(driver); 
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
	public void loanDetailsTest() throws InterruptedException {
		loanDetailsPOM.sendUserName("admin");
		loanDetailsPOM.sendPassword("12345");
//		screenShot.captureScreenShot("CYTC_006_First");	
		loanDetailsPOM.clickLoginBtn(); 
//		screenShot.captureScreenShot("CYTC_006_Second");
		loanDetailsPOM.sendMemberLogin("manzoor");
	//	Thread.sleep(2000);
		loanDetailsPOM.clickGrantLoan();
		loanDetailsPOM.sendAmount("100001");
		loanDetailsPOM.sendDescription("home loan test");
		loanDetailsPOM.clickSubmitBtn();
		loanDetailsPOM.verifyLoanSubmit();
		loanDetailsPOM.clickConfirmSubmitBtn();
		loanDetailsPOM.handleLoanAlert();
		loanDetailsPOM.clickViewLoans();
		}
}
