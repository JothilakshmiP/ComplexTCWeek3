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
import com.training.pom.LoanRepayPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoanRepayTests {

	private WebDriver driver;
	private String baseUrl;
	private LoanRepayPOM loanRepayPOM;
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
		loanRepayPOM = new LoanRepayPOM(driver); 
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
	public void LoanRepayTest() throws InterruptedException {
		loanRepayPOM.sendUserName("manzoor");
		loanRepayPOM.sendPassword("manzoor");
//		screenShot.captureScreenShot("CYTC_004_First");	
		loanRepayPOM.clickLoginBtn(); 
	//	screenShot.captureScreenShot("First");
		loanRepayPOM.clickAccountMenu();
		loanRepayPOM.clickLoansLink();
		loanRepayPOM.clickViewLoan();
		loanRepayPOM.sendAmount("200");
		String remainingLoanAmtMbr = loanRepayPOM.clickRepayBtn();
		loanRepayPOM.clickLogout();
		loanRepayPOM.sendUserName("admin");
		loanRepayPOM.sendPassword("12345");
		loanRepayPOM.clickLoginBtn();
		loanRepayPOM.sendMemberLogin("manzoor");
		loanRepayPOM.clickViewLoansAdmin();
		loanRepayPOM.checkRepayment(remainingLoanAmtMbr);
		
	}
}
