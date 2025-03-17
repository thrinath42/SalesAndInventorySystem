package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Home']")
	private WebElement homeLink;
	
	@FindBy(xpath="//span[text()='Employee']")
	private WebElement employeeLink;
	
	@FindBy(xpath="//span[text()='Product']")
	private WebElement productLink;
	
	@FindBy(xpath="//span[text()='Supplier']")
	private WebElement supplierLink;
	
	@FindBy(xpath="//span[text()='Accounts']")
	private WebElement accountsLink;
	
	@FindBy(xpath="//span[text()='Inventory']")
	private WebElement inventoryLink;
	
	@FindBy(xpath="//img[@class='img-profile rounded-circle']")
	private WebElement profileimage;
	
	@FindBy(xpath="//h5[contains(text(),'Ready to Leave?')]/../..//a[text()='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logOut;

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getEmployeeLink() {
		return employeeLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getSupplierLink() {
		return supplierLink;
	}

	public WebElement getAccountsLink() {
		return accountsLink;
	}

	public WebElement getInventoryLink() {
		return inventoryLink;
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProfileimage() {
		return profileimage;
	}

	
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public void logout() {
		profileimage.click();
		logOut.click();
		logoutBtn.click();
	}
}
