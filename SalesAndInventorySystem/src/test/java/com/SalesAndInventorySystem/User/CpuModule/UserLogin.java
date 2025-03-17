package com.SalesAndInventorySystem.User.CpuModule;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SalesAndInventorySystem.Generic.BaseUtility.BaseClass;
import com.SalesAndInventorySystem.Generic.JavaScriptExecutorUtility.JavaScriptExecutorUtility;
import com.SalesAndInventorySystem.ListenerUtility.ListenerImplementationClass;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.LoginPage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.UserModule;
import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;

@Listeners(ListenerImplementationClass.class)
public class UserLogin extends BaseClass{
	
	@Test(groups = "system")
	public void TC_ST_02() throws InterruptedException {
		WebDriverUtility wLib=new WebDriverUtility();
		JavaScriptExecutorUtility jsLib=new JavaScriptExecutorUtility();
		
		LoginPage lp=new LoginPage(driver);
		UserModule um=new UserModule(driver);
		
		
		um.getOthersModule().click();
		jsLib.scrollIntoView(driver, um.getAddButton());
		um.getAddButton().click();
		wLib.selectByValue(um.getCustomerDropdown(), "14");
		jsLib.scrollIntoView(driver, um.getSubmitButton());
		um.getSubmitButton().click();
		um.getCashField().sendKeys("250000");
		um.getProceedToPayBtn().click();
		Thread.sleep(500);
		wLib.switchToAlertAndAccept(driver);
				
	}

}
