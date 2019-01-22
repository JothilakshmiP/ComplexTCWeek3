package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdverAddPOM {
private WebDriver driver; 
	
	public AdverAddPOM(WebDriver driver) {
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
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td/fieldset/table/tbody/tr/td[2]/input")
	private WebElement mngAdvertBtn;
	
	@FindBy(id="newButton")
	private WebElement newAdvBtn;
	
	@FindBy(name="ad(title)")
	private WebElement adTitle;
	
	@FindBy(name="ad(price)")
	private WebElement adPrice;
	
	@FindBy(id="notExpirableCheck")
	private WebElement notExpirCheck;

	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/div[2]/div/span/span[2]/span/table/tbody/tr[2]/td/iframe")
	private WebElement description;
	
	@FindBy(xpath="//*[@id='saveButton']")
	private WebElement saveNewAdvBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[2]/ul/li[16]/span[2]")
	private WebElement logoutBtn;
	
	@FindBy(id="menu1")
	private WebElement personal;
	
	@FindBy(id="submenu1.2")
	private WebElement advertisements;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div[3]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/div[3]")
	private WebElement savedDesc;
	
	//   -------> Methods <------
	
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
	
	public void clickMngAdvert() {
		this.mngAdvertBtn.click(); 
	}
	
	public void clickNewAdvert() {
		this.newAdvBtn.click(); 
	}
	
	public void sendAdverTitle(String adTitle) {
		this.adTitle.clear(); 
		this.adTitle.sendKeys(adTitle); 
	}
	
	public void selectAdverCategory() {
		Select newAdverCateg = new Select(driver.findElement(By.name("ad(category)")));
		newAdverCateg.selectByValue("1");
	}
	
	public void sendAdverPrice(String adPrice) {
		this.adPrice.clear(); 
		this.adPrice.sendKeys(adPrice); 
	}
	
	public void selectNotExpir() {
		this.notExpirCheck.click(); 
	}
	
	public void sendAdverDesc(String description) {
		this.description.sendKeys(description);
	}
	
	public void clickSaveNewAdvBtn() {
		this.saveNewAdvBtn.click(); 
	}
	
	public void handleSaveAdvertAlert() {
		Alert alert1 = driver.switchTo().alert();
		String actmsg = alert1.getText();
		alert1.accept();
		String expmsg = "Advertisement inserted";
		Assert.assertEquals(actmsg, expmsg);
	}
	
	public void clickLogout() {
		this.logoutBtn.click(); 
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
	}
	
	public void clickPersonal() {
		this.personal.click(); 
	}
	
	public void clickAdvertisements() {
		this.advertisements.click(); 
	}
	
	public void newAdvertSaveCheck() {
		String expDesc = "new offer for member";
		String actDesc = savedDesc.getText();
		Assert.assertEquals(expDesc,actDesc);
	}
}
