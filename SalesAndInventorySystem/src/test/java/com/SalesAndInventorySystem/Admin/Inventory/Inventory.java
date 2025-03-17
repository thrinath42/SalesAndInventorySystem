package com.SalesAndInventorySystem.Admin.Inventory;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SalesAndInventorySystem.Generic.BaseUtility.BaseClass;
import com.SalesAndInventorySystem.Generic.FileUtility.ExcelUtility;
import com.SalesAndInventorySystem.ListenerUtility.ListenerImplementationClass;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.EditInventoryPage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.HomePage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.InventoryPage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.ProductPage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.SupplierPage;
import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;


@Listeners(ListenerImplementationClass.class)
public class Inventory extends BaseClass{
	
	@Test(groups = "system")
	public void TC_ST_015() throws Exception {
		HomePage hp=new HomePage(driver);
		InventoryPage ip=new InventoryPage(driver);
		EditInventoryPage eip=new EditInventoryPage(driver);
		
		
		String prodName=  elib.getDataFromExcel("product", 2, 1);
		hp.getInventoryLink().click();
		ip.getSearchBar().sendKeys(prodName);
		ip.getViewBtn().click();
		ip.getEditBtn().click();
		eip.getQuantity().sendKeys("5");
		eip.getOnHand().sendKeys("2");
		eip.getUpdateBtn().click();
		Thread.sleep(500);
		
		wlib.switchToAlertAndAccept(driver);
		wlib.validateUsingHardAsset(driver.findElement(By.xpath("//h4[text()='Inventory']")).getText(), "Inventory");
	}
	
	@Test(groups = "system")
	public void TC_ST_017() throws Exception {
		SupplierPage sp=new SupplierPage(driver);
		ProductPage pp=new ProductPage(driver);
		HomePage hp=new HomePage(driver);
		InventoryPage ip=new InventoryPage(driver);
		EditInventoryPage eip=new EditInventoryPage(driver);
		
		
		String supplier;
		String prodName;
		supplier=sp.createSupplier();
		prodName=pp.createProduct(supplier);
		hp.getInventoryLink().click();
		ip.getSearchBar().sendKeys(prodName);
		ip.getViewBtn().click();
		ip.getEditBtn().click();
		eip.getQuantity().sendKeys("5");
		eip.getOnHand().sendKeys("2");
		eip.getUpdateBtn().click();
		Thread.sleep(500);
		wlib.switchToAlertAndAccept(driver);
		
		wlib.validateUsingHardAsset(driver.findElement(By.xpath("//h4[text()='Inventory']")).getText(), "Inventory");
	}
	
	
}
