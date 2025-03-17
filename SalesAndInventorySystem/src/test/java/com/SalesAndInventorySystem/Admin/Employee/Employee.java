package com.SalesAndInventorySystem.Admin.Employee;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SalesAndInventorySystem.Generic.BaseUtility.BaseClass;
import com.SalesAndInventorySystem.Generic.FileUtility.ExcelUtility;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.AddEmployeePage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.EmployeeDetailsPage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.EmployeePage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.HomePage;
import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;

public class Employee extends BaseClass {
	
	@Test(groups = "smoke")
	public void addEmployeeButton() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		EmployeePage ep = new EmployeePage(driver);
		AddEmployeePage aep = new AddEmployeePage(driver);
		
		hp.getEmployeeLink().click();
		ep.getAddEmployeeBtn().click();
		
		wlib.waitForElementPresent(driver, aep.getHeadingTxt());
		aep.getHeadingTxt().click();
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.click().perform();

		String heading = aep.getHeadingTxt().getText();
		wlib.validateUsingHardAsset(heading, "Add Employee");
	}

	@Test(groups="smoke")
	public void EmployeePageSearchPage() throws Exception {
		HomePage hp = new HomePage(driver);
		EmployeePage ep = new EmployeePage(driver);
		AddEmployeePage aep = new AddEmployeePage(driver);
		

		String empName = elib.getDataFromExcel("Employee", 1, 1);
	
		hp.getEmployeeLink().click();
		ep.getSearchBar().sendKeys(empName);
		Thread.sleep(1000);
		WebElement result = driver.findElement(By.xpath("//td[text()='" + empName + "']"));
		wlib.waitForElementPresent(driver, result);
		boolean value = result.isDisplayed();

		Assert.assertEquals(value, true);

	}

	@Test(groups = "smoke")
	public void EmployeePageDetailsButton() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		EmployeePage ep = new EmployeePage(driver);
		AddEmployeePage aep = new AddEmployeePage(driver);
		EmployeeDetailsPage edp = new EmployeeDetailsPage(driver);
		

		hp.getEmployeeLink().click();
		ep.getDetailsBtn().click();
		String actualHeading = edp.getHeading().getText();
		wlib.validateUsingHardAsset(actualHeading, "Employees' Detail");
	}
	
	

}
