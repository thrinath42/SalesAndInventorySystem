package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {
	WebDriver driver;
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "prodcode")
	private WebElement productCode;
	
	@FindBy(name = "name")
	private WebElement ProductName;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;
	
	@FindBy(name = "quantity")
	private WebElement quantity;

	@FindBy(name = "onhand")
	private WebElement onhand;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(xpath = "//select[@name='category']")
	private WebElement category;
	
	@FindBy(xpath = "//select[@name='supplier']")
	private WebElement supplier;
	
	@FindBy(name = "datestock")
	private WebElement datestock;
	
	@FindBy(xpath = "(//button[text()='Save'])[5]")
	private WebElement saveBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductCode() {
		return productCode;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getOnhand() {
		return onhand;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getSupplier() {
		return supplier;
	}

	public WebElement getDatestock() {
		return datestock;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
		
}
