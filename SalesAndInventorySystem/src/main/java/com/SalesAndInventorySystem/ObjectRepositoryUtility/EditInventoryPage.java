package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditInventoryPage {
	WebDriver driver;
	public EditInventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement updateBtn;
	
	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement quantity;
	
	@FindBy(xpath = "//input[@placeholder='On Hand']")
	private WebElement onHand;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getOnHand() {
		return onHand;
	}
		
}
