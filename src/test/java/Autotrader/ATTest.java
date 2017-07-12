package Autotrader;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Autotrader.*;

public class ATTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	
	@BeforeTest
	public void setup(){   
	    ChromeDriverManager.getInstance().setup();
	   	driver = new ChromeDriver();
		driver.get("http://www.autotrader.co.uk/");
		
		report = new ExtentReports("..\\seleniumAutotraderTests\\automationreport.html",true);

		homePage = new Home(driver);
	}
	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	@Test(priority = 1, enabled = true)
	public void testTitle() {
		test = report.startTest("Autotrader test title");
		test.log(LogStatus.INFO, "Test started");
		
		String homePageTitle = homePage.getTitle();
		if (homePageTitle.contains("Auto Trader UK | Find New & Used Cars for Sale")) {
			test.log(LogStatus.PASS, "Verify home page title");
		} else {
			test.log(LogStatus.FAIL, "Verify home page title");
		}
		
		test.log(LogStatus.INFO, "Test finished");
		report.endTest(test);
	}
	@Test(priority = 2, enabled = true)
	public void testCarSearchRadius() {
		test = report.startTest("Autotrader test radius");
		test.log(LogStatus.INFO, "Test started");
		
		homePage.selectRadius();
		String radiusText = homePage.getRadius();
		if (radiusText.contains("Within 100 miles")) {
			test.log(LogStatus.PASS, "verify radius input");
		} else {
			test.log(LogStatus.FAIL, "verify radius input");
		}
		
		test.log(LogStatus.INFO, "Test finished");
		report.endTest(test);
	}
	@Test(priority = 3, enabled = true)
	public void testCarSearchMake() {
		test = report.startTest("Autotrader test make");
		test.log(LogStatus.INFO, "Test started");
		
		try{
			homePage.selectMake();
			String makeText = homePage.getMake();
			if (makeText.contains("Tesla")) {
				test.log(LogStatus.PASS, "verify make input");
			} else {
				test.log(LogStatus.FAIL, "verify make input");
			}
		}catch(NoSuchElementException x){
			System.out.println("That make of car might not exist");
		}
		
		test.log(LogStatus.INFO, "Test finished");
		report.endTest(test);
	}
	@Test(priority = 4, enabled = true)
	public void testCarSearchModel() {
		test = report.startTest("Autotrader test model");
		test.log(LogStatus.INFO, "Test started");
		
		try{
			homePage.selectModel();
			String modelText = homePage.getModel();
			if (modelText.contains("Model X")) {
				test.log(LogStatus.PASS, "verify model input");
			} else {
				test.log(LogStatus.FAIL, "verify model input");
			}
		}catch(NoSuchElementException x){
			System.out.println("That model of car might not exist");
		}
		
		test.log(LogStatus.INFO, "Test finished");
		report.endTest(test);
	}
	@Test(priority = 5, enabled = true)
	public void testCarSearchMaxPrice() {
		test = report.startTest("Autotrader test price");
		test.log(LogStatus.INFO, "Test started");
		
		homePage.selectMaxPrice();
		String priceText = homePage.getMaxPrice();
		if (priceText.contains("To £100,000")) {
			test.log(LogStatus.PASS, "verify max price input");
		} else {
			test.log(LogStatus.FAIL, "verify max price input");
		}
		
		test.log(LogStatus.INFO, "Test finished");
		report.endTest(test);
	}
	@Test(priority = 6, enabled = true)
	public void testCarPostcode() {
		test = report.startTest("Autotrader test postcode");
		test.log(LogStatus.INFO, "Test started");
		
		homePage.getPostcodeInput("PO5 4AY");
		String postcodeInputText = homePage.getPostcodeTextBoxText();
		if (postcodeInputText.equals("PO5 4AY")) {
			test.log(LogStatus.PASS, "Verify postcode input");
		} else {
			test.log(LogStatus.FAIL, "Verify postcode input");
		}
		homePage.clickSearch();
			
		test.log(LogStatus.INFO, "Test finished");
		report.endTest(test);
		report.flush();
		teardown();
	}
}
