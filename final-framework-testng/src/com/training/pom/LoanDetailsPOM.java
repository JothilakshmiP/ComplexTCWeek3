package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoanDetailsPOM {
  
private WebDriver driver; 
	
	public LoanDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td/input")
	private WebElement loginBtn; 
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")
	private WebElement grantLoan;
	
	@FindBy(name="loan(amount)")
	private WebElement amount;
	
	@FindBy(name="loan(description)")
	private WebElement description;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")
	private WebElement sumitBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td")
	private WebElement loanConfirmationMsg;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td/input")
	private WebElement confirmSubmitBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[2]/input")
	private WebElement viewLoans;
	
	
	
//  -------> Methods <------
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void sendMemberLogin(String memberLogin) throws InterruptedException{
		this.memberLogin.clear();
		this.memberLogin.sendKeys(memberLogin);
		Thread.sleep(5000);
		this.memberLogin.sendKeys(Keys.RETURN);
	}
	
	public void clickGrantLoan() {
		this.grantLoan.click(); 
	}
	
	public void sendAmount(String amount) {
		this.amount.clear(); 
		this.amount.sendKeys(amount); 
	}
	
	public void sendDescription(String description) {
		this.description.clear(); 
		this.description.sendKeys(description); 
	}
	
	public void clickSubmitBtn() {
		this.sumitBtn.click(); 
	}
	
	public void verifyLoanSubmit() {
		String actMsg = this.loanConfirmationMsg.getText();
		String expMsg = "You are about to grant the following loan:";
		Assert.assertEquals(actMsg, expMsg);
	}
	
	public void clickConfirmSubmitBtn() {
		this.confirmSubmitBtn.click();
	}
	
	public void handleLoanAlert() {
		Alert alert1 = driver.switchTo().alert();
		String actualMsg = alert1.getText();
		String expectedMsg = "The loan was successfully granted";
		Assert.assertEquals(actualMsg, expectedMsg);
		alert1.accept();
	}
	
	public void clickViewLoans() {
		this.viewLoans.click();
	}
}
