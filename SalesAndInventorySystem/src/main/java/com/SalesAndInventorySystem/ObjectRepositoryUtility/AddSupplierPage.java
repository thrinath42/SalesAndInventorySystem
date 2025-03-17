package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSupplierPage {
	WebDriver driver;
	public AddSupplierPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "companyname")
	private WebElement companyname;
	
	@FindBy(name = "phonenumber")
	private WebElement phonenumber;
	
	@FindBy(xpath = "//select[@name='province']")
	private WebElement province;
	
	@FindBy(xpath = "//select[@name='city']")
	private WebElement city;
	
	@FindBy(xpath = "(//button[text()='Save'])[1]")
	private WebElement saveBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}
	
	public WebElement getProvince() {
		return province;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
		
}
