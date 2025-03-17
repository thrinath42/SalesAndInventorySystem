package com.SalesAndInventorySystem.Admin.Supplier;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SalesAndInventorySystem.Generic.BaseUtility.BaseClass;
import com.SalesAndInventorySystem.ListenerUtility.ListenerImplementationClass;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.SupplierPage;
import com.SalesAndInventorySystem.WebDriverUtility.UtilityClassObject;
import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;
import com.aventstack.extentreports.Status;

@Listeners(ListenerImplementationClass.class)
public class Supplier extends BaseClass{
	 
	@Test(groups = "integration")
	public void TC_IT_005() throws Exception {
		SupplierPage sp=new SupplierPage(driver);
		String companyName;
		companyName=sp.createSupplier();
		wlib.waitForElementPresent(driver, sp.getSearchBar());
		sp.getSearchBar().sendKeys(companyName);
		
		wlib.validateUsingHardAsset(driver.findElement(By.xpath
				("//td[text()='"+companyName+"']")).getText(),companyName);
	}
	
	@Test(groups = "integration")
	public void TC_IT_006() throws Exception {
		String companyName;
		
		SupplierPage sp=new SupplierPage(driver);
		companyName=sp.createSupplier();
		wlib.waitForElementPresent(driver, sp.getSearchBar());
		sp.getSearchBar().sendKeys(companyName);
		UtilityClassObject.getTest().log(Status.INFO, "Searching "+companyName+"");
		driver.findElement(By.xpath("//td[text()='"+companyName+"']/..//a[contains(text(),'Details')]")).click();
		wlib.validateUsingHardAsset(sp.getHeading().getText(), "Supplier's Detail");
	}

}
