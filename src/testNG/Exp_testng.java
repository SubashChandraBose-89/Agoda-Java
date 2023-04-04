package testNG;

import com.hrms.lib.Global;
import com.hrms.lib.General;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exp_testng extends Global {
	WebDriver driver;
	General genObj = new General();

	@BeforeMethod
	public void setUp() throws Exception  {
		DOMConfigurator.configure("log4j.xml");
		genObj.openApplications();
		genObj.closePopup1();
	}

	@AfterMethod
	public void tearDown() {
		DOMConfigurator.configure("log4j.xml");
		genObj.closeApplication();
	}

	@Test(priority = 1)
	public void M001() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		genObj.login();
		genObj.closePopup2();
		genObj.hotelSearchDay();	
		genObj.logout();
		
	}
	@Test(priority = 2)
	public void M002() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		genObj.login();
		genObj.closePopup2();
		genObj.searchTest();
		genObj.logout();
	}

	@Test(priority = 3)
	public void M003() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		genObj.login();
		genObj.closePopup2();
		genObj.hotelSearchNight();		
		genObj.selectHotel();
		genObj.logout();
	}
	
	@Test(priority = 4)
	public void M004() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		genObj.login();
		genObj.closePopup2();
		genObj.hotelSearchNight();
		genObj.selectHotel();
		genObj.bookHotelNight();
		genObj.customerInfo();	
	}
	
	@Test(priority = 5)
	public void M005() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		genObj.login();
		genObj.closePopup2();
		genObj.hotelSearchNight();
		genObj.selectHotel();
		genObj.bookHotelNight();
		genObj.customerInfo();
		genObj.paymentInfo();
		
	}
}