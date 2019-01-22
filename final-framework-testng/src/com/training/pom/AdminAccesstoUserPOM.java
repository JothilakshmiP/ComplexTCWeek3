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

public class AdminAccesstoUserPOM {
	private WebDriver driver; 
	
	public AdminAccesstoUserPOM(WebDriver driver) {
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
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td/fieldset/table/tbody/tr[2]/td[2]/input")
	private WebElement prmngrpSubmitBtn;
	
	@FindBy(name="comments")
	private WebElement comments;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/input")
	private WebElement mbrGroupBtn;
	
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
		Thread.sleep(2000);
		this.memberLogin.sendKeys(Keys.RETURN);
	}
	
	public void prmngrpSubmitBtn() {
		this.prmngrpSubmitBtn.click(); 
	}
	
	public void selectNewGroupId(){
		Select newGroupId = new Select(driver.findElement(By.name("newGroupId")));
		newGroupId.selectByValue("5");
		//	newGroupId.selectByVisibleText("Full members");
	}
	
	public void sendComments(String comments){
		this.comments.clear();
		this.comments.sendKeys(comments);
	}
	
	public void clickMbrGroupBtn(){
		this.mbrGroupBtn.click();
	}
	
	public void acceptChangeGroup(){
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		String expected = "The member's group was changed";
		Assert.assertEquals(expected, alertMessage);
	}
	
	
}
