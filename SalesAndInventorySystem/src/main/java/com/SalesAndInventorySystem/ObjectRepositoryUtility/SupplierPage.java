package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SalesAndInventorySystem.Generic.FileUtility.ExcelUtility;
import com.SalesAndInventorySystem.WebDriverUtility.UtilityClassObject;
import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;
import com.SalesAndInventorySystem.javautility.JavaUtility;
import com.aventstack.extentreports.Status;


public class SupplierPage {
	public String companyName;
	public String province;
	public String city;
	public String phone;
	
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	WebDriver driver;

	public SupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-target='#supplierModal']")
	private WebElement addProductBtn;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//h4[contains(text(),' Detail')]")
	private WebElement heading;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getPhone() {
		return phone;
	}

	public WebElement getHeading() {
		return heading;
	}

	public String createSupplier() throws Exception {
		SupplierPage sp = new SupplierPage(driver);
		AddSupplierPage asp = new AddSupplierPage(driver);
		HomePage hp = new HomePage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		
		companyName = eLib.getDataFromExcel("Supplier", 1, 0) + jLib.generateRandomNumber();
		province = eLib.getDataFromExcel("Supplier", 1, 1);
		city = eLib.getDataFromExcel("Supplier", 1, 2);
		phone = eLib.getDataFromExcel("Supplier", 1, 3);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate Supplier Module");
		hp.getSupplierLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to add Supplier Page");
		sp.getAddProductBtn().click();
		asp.getCompanyname().sendKeys(companyName);
		asp.getProvince().sendKeys(province);
		asp.getCity().sendKeys(city);
		asp.getPhonenumber().sendKeys(phone);
		asp.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Supplier named "+companyName+" Created");
		return companyName;
	}
}
