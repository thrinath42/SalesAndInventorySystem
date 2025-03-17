package com.SalesAndInventorySystem.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {
	WebDriver driver;
	
public AddEmployeePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//h5[text()='Add Employee']")
private WebElement headingTxt;



public WebElement getHeadingTxt() {
	return headingTxt;
}







}
