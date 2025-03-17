package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetailsPage {
	WebDriver driver;
	public EmployeeDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[contains(text(),' Detail')]")
	private WebElement heading;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHeading() {
		return heading;
	}
	
	
}
