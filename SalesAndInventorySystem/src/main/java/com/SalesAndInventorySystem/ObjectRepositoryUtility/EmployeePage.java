package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
	WebDriver driver;
	public EmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-target='#employeeModal']")
	private WebElement addEmployeeBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//a[contains(text(),'Details')]")
	private WebElement detailsBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddEmployeeBtn() {
		return addEmployeeBtn;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getDetailsBtn() {
		return detailsBtn;
	}
	
	
}
