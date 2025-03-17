package com.SalesAndInventorySystem.Generic.BaseUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.SalesAndInventorySystem.Generic.DataBaseUtility.DataBaseUtility;
import com.SalesAndInventorySystem.Generic.FileUtility.ExcelUtility;
import com.SalesAndInventorySystem.Generic.FileUtility.FileUtility;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.HomePage;
import com.SalesAndInventorySystem.ObjectRepositoryUtility.LoginPage;
import com.SalesAndInventorySystem.WebDriverUtility.UtilityClassObject;
import com.SalesAndInventorySystem.WebDriverUtility.WebDriverUtility;


public class BaseClass {
	public static DataBaseUtility dlib=new DataBaseUtility();
	public static FileUtility flib=new FileUtility();
	public static WebDriverUtility wlib=new WebDriverUtility();
	public static ExcelUtility elib=new ExcelUtility();
	
	public WebDriver driver;
	public static String url;
	public static String admin_un;
	public static String admin_pwd;
	public static String user_un;
	public static String user_pwd;
	@BeforeSuite(groups= {"smoke","regression","integration","system"})
	public void configBs() throws SQLException {
		System.out.println("================connect to DB================");
	}
	
	@Parameters("Browser")
	@BeforeClass(groups= {"smoke","regression","integration","system"})
	public void configBc(@Optional("chrome") String Browser) {
		System.out.println("=================launch browser=================");
		String browser=Browser;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
			}		
		UtilityClassObject.setDriver(driver);
		}
	
	@BeforeMethod(groups= {"smoke","regression","integration","system"})
	public void configBm() throws IOException, InterruptedException {
		System.out.println("====================Login to Application====================");
		LoginPage lp=new LoginPage(driver);
	
		url = flib.getDatafromPropertyFile("url");
		admin_un = flib.getDatafromPropertyFile("admin_un");
		admin_pwd = flib.getDatafromPropertyFile("admin_pwd");
		user_un = flib.getDatafromPropertyFile("User_un");
		user_pwd=flib.getDatafromPropertyFile("user_pwd");
		
		driver.get(url);
		lp.login(admin_un,admin_pwd);
//		lp.login(user_un,user_pwd);
	}
	
	@AfterMethod(groups= {"smoke","regression","integration","system"})
	public void configAm() throws InterruptedException {
		System.out.println("====================Logout to Application====================");
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.logout();
		Thread.sleep(2000);
	}
	
	@AfterClass(groups= {"smoke","regression","integration","system"})
	public void configAC() {
		System.out.println("===close the browser");
		driver.quit();
	}
	
	@AfterSuite(groups= {"smoke","regression","integration","system"})
	public void configAS() throws SQLException {
		System.out.println("====close DB, Report backup====");
		dlib.closeDbConnection();
	}
	
	}


