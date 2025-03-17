package com.SalesAndInventorySystem.Admin.Product;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SalesAndInventorySystem.Generic.BaseUtility.BaseClass;
import com.SalesAndInventorySystem.ListenerUtility.ListenerImplementationClass;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.EditProductPage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.HomePage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.ProductPage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.SupplierPage;

@Listeners(ListenerImplementationClass.class)
public class Product extends BaseClass{

	@Test(groups="system")
	public void TC_ST_009() throws Exception {
		SupplierPage sp=new SupplierPage(driver);
		ProductPage pp=new ProductPage(driver);
		
		String supplier=sp.createSupplier();
		String prodName=pp.createProduct(supplier);
		wlib.waitForElementPresent(driver, pp.getSearchBar());
		pp.getSearchBar().sendKeys(prodName);
		
		wlib.validateUsingHardAsset(driver.findElement(By.xpath("//td[text()='"+prodName+"']")).getText(), prodName);
	
	}
	@Test(groups = "smoke")
	public void TC_Smoke_030() throws Exception {
		
		HomePage hp=new HomePage(driver);
		ProductPage pp=new ProductPage(driver);
		EditProductPage epp=new EditProductPage(driver);
		
		String prodName=pp.createProduct();
		hp.getProductLink().click();
		wlib.waitForElementPresent(driver, pp.getSearchBar());
		pp.getSearchBar().sendKeys(prodName);
		driver.findElement(By.xpath("//td[text()='"+prodName+"']/..//a[@data-toggle='dropdown']")).click();
		pp.getEditBtn().click();
		
		wlib.validateUsingHardAsset(epp.getHeading().getText(), "Edit Product");
	}
	
	@Test(groups = "integration")
	public void TC_IT_010() throws Exception {
		HomePage hp=new HomePage(driver);
		ProductPage pp=new ProductPage(driver);
		
		hp.getProductLink().click();
		String prodName=pp.createProduct();
		
		wlib.waitForElementPresent(driver, pp.getSearchBar());
		pp.getSearchBar().sendKeys(prodName);
		pp.getDetailsBtn().click();
		
		wlib.validateUsingHardAsset(pp.getHeading().getText(), "Product's Detail");
	}

}
