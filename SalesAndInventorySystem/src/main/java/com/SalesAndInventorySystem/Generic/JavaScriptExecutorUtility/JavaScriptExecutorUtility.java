package com.SalesAndInventorySystem.Generic.JavaScriptExecutorUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtility {
		
	public void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void sendNumericDatatoField(WebDriver driver,WebElement element,int data) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+data+"'", element);
	}
}
