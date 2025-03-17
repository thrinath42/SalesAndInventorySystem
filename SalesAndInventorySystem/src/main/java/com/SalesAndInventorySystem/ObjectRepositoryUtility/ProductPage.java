package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SalesAndInventorySystem.Generic.FileUtility.ExcelUtility;
import com.SalesAndInventorySystem.Generic.JavaScriptExecutorUtility.JavaScriptExecutorUtility;
import com.SalesAndInventorySystem.WebDriverUtility.UtilityClassObject;
import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;
import com.SalesAndInventorySystem.javautility.JavaUtility;
import com.aventstack.extentreports.Status;

public class ProductPage {
	public int prodCode;
	public String prodName;
	public String prodDes;
	public String quantity;
	public String onHand;
	public String price;
	public String category;
	public String supplier;
	public String dateStockIn;
	
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public JavaScriptExecutorUtility jsLib=new JavaScriptExecutorUtility();
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-target='#aModal']")
	private WebElement addProductBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBar;
	
	@FindBy(partialLinkText = "Edit")
	private WebElement editBtn;
	
	@FindBy(partialLinkText = "Details")
	private WebElement detailsBtn;
	
	@FindBy(xpath = "//div[@class='card shadow mb-4 col-xs-12 col-md-8 border-bottom-primary']//h4")
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

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getDetailsBtn() {
		return detailsBtn;
	}

	public WebElement getHeading() {
		return heading;
	}
	
	public String createProduct(String supplier) throws Exception {
		HomePage hp = new HomePage(driver);
		ProductPage pp=new ProductPage(driver);
		AddProductPage apd=new AddProductPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		prodCode = jLib.generateRandomNumber();
		prodName = eLib.getDataFromExcel("product",1,1)+jLib.generateRandomNumber();
		prodDes = eLib.getDataFromExcel("product", 1, 2);
		quantity = eLib.getDataFromExcel("product", 1, 3);
		onHand = eLib.getDataFromExcel("product", 1, 4);
		price = eLib.getDataFromExcel("product", 1, 5);
		category = eLib.getDataFromExcel("product", 1, 6);
		this.supplier = supplier;
		
		dateStockIn = jLib.getSystemDate();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate Product Module");
		hp.getProductLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to add Product Page");
		pp.getAddProductBtn().click();
		
		wLib.waitForElementPresent(driver, apd.getProductCode());
		jsLib.sendNumericDatatoField(driver, apd.getProductCode(), prodCode);
		wLib.waitForElementPresent(driver, apd.getProductName());
		apd.getProductName().sendKeys(prodName);
		wLib.waitForElementPresent(driver, apd.getDescription());
		apd.getDescription().sendKeys(prodDes);
		wLib.waitForElementPresent(driver, apd.getQuantity());
		apd.getQuantity().sendKeys(quantity);
		wLib.waitForElementPresent(driver, apd.getOnhand());
		apd.getOnhand().sendKeys(onHand);
		wLib.waitForElementPresent(driver, apd.getPrice());
		apd.getPrice().sendKeys(price);
		wLib.waitForElementPresent(driver, apd.getCategory());
		apd.getCategory().sendKeys(category);
		wLib.waitForElementPresent(driver, apd.getSupplier());
		apd.getSupplier().sendKeys(supplier);
		Thread.sleep(500);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
//		apd.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "product Named "+prodName+" Created");
		return prodName;
	}
	
	public String createProduct() throws Exception {
		HomePage hp = new HomePage(driver);
		ProductPage pp=new ProductPage(driver);
		AddProductPage apd=new AddProductPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		prodCode = jLib.generateRandomNumber();
		prodName = eLib.getDataFromExcel("product",1,1)+jLib.generateRandomNumber();
		prodDes = eLib.getDataFromExcel("product", 1, 2);
		quantity = eLib.getDataFromExcel("product", 1, 3);
		onHand = eLib.getDataFromExcel("product", 1, 4);
		price = eLib.getDataFromExcel("product", 1, 5);
		category = eLib.getDataFromExcel("product", 1, 6);
		supplier = eLib.getDataFromExcel("product", 1, 7);
		dateStockIn = jLib.getSystemDate();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate Product Module");
		hp.getProductLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to add Product Page");
		pp.getAddProductBtn().click();
		
		wLib.waitForElementPresent(driver, apd.getProductCode());
		jsLib.sendNumericDatatoField(driver, apd.getProductCode(), prodCode);
		wLib.waitForElementPresent(driver, apd.getProductName());
		apd.getProductName().sendKeys(prodName);
		wLib.waitForElementPresent(driver, apd.getDescription());
		apd.getDescription().sendKeys(prodDes);
		wLib.waitForElementPresent(driver, apd.getQuantity());
		apd.getQuantity().sendKeys(quantity);
		wLib.waitForElementPresent(driver, apd.getOnhand());
		apd.getOnhand().sendKeys(onHand);
		wLib.waitForElementPresent(driver, apd.getPrice());
		apd.getPrice().sendKeys(price);
		wLib.waitForElementPresent(driver, apd.getCategory());
		apd.getCategory().sendKeys(category);
		wLib.waitForElementPresent(driver, apd.getSupplier());
		apd.getSupplier().sendKeys(supplier);
		Thread.sleep(500);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		
		UtilityClassObject.getTest().log(Status.INFO, "product Named "+prodName+" Created");
		return prodName;
	}
}
