package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProductPage {

	WebDriver driver;
	public EditProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[text()='Edit Product']")
	private WebElement heading;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHeading() {
		return heading;
	}
	
	
}
