package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoanRepayPOM {
	private WebDriver driver; 
	
	public LoanRepayPOM(WebDriver driver) {
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
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/ul/li[3]/span[2]")
	private WebElement accountMenu;
	
	@FindBy(id="loansLink")
	private WebElement loansLink;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/img")
	private WebElement viewLoan;
	
	@FindBy(id="amountText")
	private WebElement amountText;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[2]/tbody/tr[2]/td/form/table/tbody/tr[3]/td/input")
	private WebElement repayBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/ul/li[7]/span[2]")
	private WebElement logoutBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td[4]")
	private WebElement remainingAmtMbr;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]")
	private WebElement remainingAmtAdmin;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[2]/input")
	private WebElement viewLoansAdmin;
	
	
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
	
	public void clickAccountMenu() {
		this.accountMenu.click(); 
	}
	
	public void clickLoansLink() {
		this.loansLink.click(); 
	}
	
	public void clickViewLoan() {
		this.viewLoan.click(); 
	}
	
	public void sendAmount(String amount) {
		this.amountText.clear();
		this.amountText.sendKeys(amount);
	}
	
	public String clickRepayBtn() {
		this.repayBtn.click();
		Alert alert1 = driver.switchTo().alert();
		String actMsg = alert1.getText();
		String expMsg = "Are you sure to repay 2,00 units?"+"\n"+"\n"+"Please, click OK to proceed";
		Assert.assertEquals(actMsg, expMsg);
		alert1.accept();
		Alert alert2 = driver.switchTo().alert();
		String actualMsg = alert2.getText();
		String expectedMsg = "The repayment was succesfully processed";
		Assert.assertEquals(actualMsg, expectedMsg);
		alert2.accept();
		return remainingAmtMbr.getText();
	} 
	
	public void clickLogout() {
		this.logoutBtn.click(); 
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
	}
	
	public void checkRepayment(String remainingLoanAmtMbr) {
		String remainingLoanAmtAdmin = this.remainingAmtAdmin.getText();
		Assert.assertEquals(remainingLoanAmtAdmin, remainingLoanAmtMbr);
	}
	
	public void clickViewLoansAdmin() {
		this.viewLoansAdmin.click(); 
	}
}
