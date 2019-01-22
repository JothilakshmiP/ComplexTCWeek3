package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MemberPaymntDetailsPOM {
private WebDriver driver; 
	
	public MemberPaymntDetailsPOM(WebDriver driver) {
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
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td/fieldset/table/tbody/tr[2]/td[2]/input")
	private WebElement paymntSystemtoUser;
	
	@FindBy(id="amount")
	private WebElement amount;
	
//	@FindBy(id="type")
//	private WebElement transactionType;
	
	@FindBy(id="description")
	private WebElement description;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	@FindBy (xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input")
	private WebElement confirmSubmit;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[1]/td")
	private WebElement paymntSuccessfulMsg;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/ul/li[16]/span[2]")
	private WebElement logoutBtn;
	
	@FindBy(id="menu2")
	private WebElement account;
	
	@FindBy(id="submenu2.0")
	private WebElement accountInfo;
	
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
		Thread.sleep(12000);
		this.memberLogin.sendKeys(Keys.RETURN);
	}
	
	public void clickPaymnttoUserBtn() {
		this.paymntSystemtoUser.click(); 
	}
	
	public void sendAmount(String amount) throws InterruptedException {
		this.amount.clear();
		Thread.sleep(2000);
		this.amount.sendKeys(amount);
		Thread.sleep(2000);
	}
	
	public void selectTransactionType() {
		Select trantype = new Select(driver.findElement(By.id("type")));
		trantype.selectByValue("14");
	}
	
	public void sendDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public void clickSubmitBtn() {
		this.submitButton.click(); 
	}
	
	public void clickConfirmSubmitBtn() {
		this.confirmSubmit.click(); 
	}
	
	public void checkPaymntSuccessful() {
		String actmsg = this.paymntSuccessfulMsg.getText();
		String expmsg = "The payment has been performed";
		Assert.assertEquals(actmsg, expmsg);
	}
	
	public void clickLogout() {
		this.logoutBtn.click(); 
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
	}
	
	public void clickAccount() {
		this.account.click(); 
	}
	
	public void clickAccountInfo() {
		this.accountInfo.click(); 
	}
}
