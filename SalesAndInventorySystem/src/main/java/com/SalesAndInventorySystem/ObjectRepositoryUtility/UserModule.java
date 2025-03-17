package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserModule {
	WebDriver driver;
	public UserModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Others")
	private WebElement OthersModule;
	
	@FindBy(xpath = "//h6[contains(text(),'Apple MacBook Pro_44107')]/..//input[@value='Add']")
	private WebElement addButton;
	
	@FindBy(xpath = "//select[@name='customer']")
	private WebElement customerDropdown;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//input[@name='cash']")
	private WebElement cashField;
	
	@FindBy(xpath = "//button[text()='PROCEED TO PAYMENT']")
	private WebElement proceedToPayBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOthersModule() {
		return OthersModule;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getCustomerDropdown() {
		return customerDropdown;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getCashField() {
		return cashField;
	}

	public WebElement getProceedToPayBtn() {
		return proceedToPayBtn;
	}
	
	
}
