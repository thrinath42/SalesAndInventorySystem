package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	@FindBy(xpath = "//input[@name='user']")
	private WebElement userNameTxtField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTxtField;
	
	@FindBy(xpath = "//button[@name='btnlogin']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	
	public void login(String un,String pwd) throws InterruptedException {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		userNameTxtField.sendKeys(un);
		passwordTxtField.sendKeys(pwd);
		loginBtn.click();

		Thread.sleep(500);
		switchToAlertAndAccept(driver);
	}
	
}
