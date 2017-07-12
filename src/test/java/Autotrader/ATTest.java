package Autotrader;
import org.junit.Before;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ATTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	
	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
	}

//	@After
//	public void teardown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
	@Test
	public void setup(){   
		report = new ExtentReports("..\\autotrader\\automationreport.html",true);
		test = report.startTest("Autotrader tests");

		driver.get("http://www.autotrader.co.uk/");

		test.log(LogStatus.INFO, "Browser started");

	}
//	@Test(priority = 1, enabled = true)
//	public void testTitle() {
//		String homePageTitle = homePage.getTitle();
//		if (homePageTitle.contains("Auto Trader UK | Find New & Used Cars for Sale")) {
//			test.log(LogStatus.PASS, "Verify home page title");
//		} else {
//			test.log(LogStatus.FAIL, "Verify home page title");
//		}
//	}
//	@Test(priority = 2, enabled = true)
//	public void testCarSearchRadius() {
//		homePage.selectRadius();
//		String radiusText = homePage.getRadius();
//		if (radiusText.contains("Within 100 miles")) {
//			test.log(LogStatus.PASS, "verify radius input");
//		} else {
//			test.log(LogStatus.FAIL, "verify radius input");
//		}
//	}
//	@Test(priority = 3, enabled = true)
//	public void testCarSearchMake() {
//		try{
//			homePage.selectMake();
//			String makeText = homePage.getMake();
//			if (makeText.contains("Tesla")) {
//				test.log(LogStatus.PASS, "verify make input");
//			} else {
//				test.log(LogStatus.FAIL, "verify make input");
//			}
//		}catch(NoSuchElementException x){
//			System.out.println("That make of car might not exist");
//		}
//	}
//	@Test(priority = 4, enabled = true)
//	public void testCarSearchModel() {
//		try{
//			homePage.selectModel();
//			String modelText = homePage.getModel();
//			if (modelText.contains("Model X")) {
//				test.log(LogStatus.PASS, "verify model input");
//			} else {
//				test.log(LogStatus.FAIL, "verify model input");
//			}
//		}catch(NoSuchElementException x){
//			System.out.println("That model of car might not exist");
//		}
//	}
//	@Test(priority = 5, enabled = true)
//	public void testCarSearchMaxPrice() {
//		homePage.selectMaxPrice();
//		String priceText = homePage.getMaxPrice();
//		if (priceText.contains("To �100,000")) {
//			test.log(LogStatus.PASS, "verify max price input");
//		} else {
//			test.log(LogStatus.FAIL, "verify max price input");
//		}
//	}
//	@Test(priority = 6, enabled = true)
//	public void testCarPostcode() {
//		homePage.getPostcodeInput("PO5 4AY");
//		String postcodeInputText = homePage.getPostcodeTextBoxText();
//		if (postcodeInputText.equals("PO5 4AY")) {
//			test.log(LogStatus.PASS, "Verify postcode input");
//		} else {
//			test.log(LogStatus.FAIL, "Verify postcode input");
//		}
//		homePage.clickSearch();
//		
//		test.log(LogStatus.INFO, "Browser closed");
//		report.endTest(test);
//		report.flush();
//		teardown();
//
//	}

}
