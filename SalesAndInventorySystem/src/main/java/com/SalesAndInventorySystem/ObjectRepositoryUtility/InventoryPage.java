package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	WebDriver driver;
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath = "//input[@type='search']")
		private WebElement searchBar;
		
		@FindBy(partialLinkText = "View")
		private WebElement viewBtn;
		
		@FindBy(partialLinkText = "Edit")
		private WebElement editBtn;
		
		public WebDriver getDriver() {
			return driver;
		}
		public WebElement getSearchBar() {
			return searchBar;
		}
		public WebElement getViewBtn() {
			return viewBtn;
		}
		public WebElement getEditBtn() {
			return editBtn;
		}
			
}
