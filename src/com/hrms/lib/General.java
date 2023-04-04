package com.hrms.lib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.hrms.utilities.Log;

import org.apache.commons.io.FileUtils;

public class General extends Global {
	
	static JavascriptExecutor js;

	public void openApplications() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(url);
		driver.manage().window().maximize();
		System.out.println("Application Opened");
		Reporter.log("Application Opened");
		Log.info("Application Opened");
		System.out.println(driver.getTitle());
	}

	public void closePopup1() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popup_close1)));
		Thread.sleep(1000);
		popUp.click();
		System.out.println("POPup Closed");
		Reporter.log("POPup Closed");
		Log.info("POPup Closed");
	}

	public void signINCheck() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='Box-sc-kv6pi1-0 bTkTcE']")).click();
		driver.switchTo().frame(0);
		WebElement loginbtn = driver.findElement(By.xpath(btn_login));
		js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		js.executeScript("arguments[0].click()", loginbtn);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Agoda Screenshots\\"+sdf.format(date)+".png");
		FileUtils.copyFile(source, destination);
		System.out.println("Login Button Clicked");
		driver.switchTo().defaultContent();	
	}

	public void closePopup2() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		try {
			WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(popup_close2)));
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(popup_close2))).isDisplayed()) {
				popUp.click();
			} else {
				Thread.sleep(1000);
				System.out.println("POPup Closed");
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Popup Alert elements not found");
		}
	}

	public void closeApplication() {
		driver.quit();
		System.out.println("Application Closed");
		Reporter.log("Application Closed");
		Log.info("Application Closed");
	}
	
	public void blankLogin() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='Box-sc-kv6pi1-0 bTkTcE']")).click();
		driver.switchTo().frame(0);
		WebElement loginbtn = driver.findElement(By.xpath(btn_login));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginbtn);
		WebElement invalid = driver.findElement(By.xpath("//span[@class='sc-fznZeY PbGWn']"));
		String text = invalid.getText();
		if (text.contains("Email address format is not valid.")) {
			System.out.println("Error Statement = " + text);
		} else {
			System.out.println("Error Statement not displayed");
		}
		driver.switchTo().defaultContent();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Agoda Screenshots\\"+sdf.format(date)+".png");
		FileUtils.copyFile(source, destination);
	}

	public void login() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='Box-sc-kv6pi1-0 bTkTcE']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.name(txt_loginname)).sendKeys(validUserName);
		driver.findElement(By.name(txt_password)).sendKeys(validPassWord);
		WebElement loginbtn = driver.findElement(By.xpath(btn_login));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginbtn);
		driver.switchTo().defaultContent();	
		System.out.println("Login Completed");
		Reporter.log("Login Completed");
		Log.info("Login Completed");
		WebElement search = driver.findElement(By.xpath(hotelsearch_button));
		wait.until(ExpectedConditions.visibilityOf(search));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Agoda Screenshots\\"+sdf.format(date)+".png");
		FileUtils.copyFile(source, destination);
		
	}


	public void searchTest() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement search = driver.findElement(By.xpath(hotelsearch_button));
		search.click();
		WebElement errAlert = driver.findElement(By.xpath("//div[@class='ModalMessage ModalMessage--center']"));
		String erralert = errAlert.getText();
		System.out.println("Error Statement = "+erralert);
		wait.until(ExpectedConditions.visibilityOf(errAlert));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Agoda Screenshots\\"+sdf.format(date)+".png");
		FileUtils.copyFile(source, destination);
		driver.findElement(By.xpath("//i[@class='ficon ficon-20 ficon-x-icon ReactModal__close-button']")).click();
		Reporter.log("Search Done");
	}

	public void logout() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath(logoutmain)).click();
		driver.findElement(By.xpath(logoutBtn)).click();
		System.out.println("Logout Done");
		Reporter.log("Logout Done");
		Log.info("Login Done");
	}

	public void hotelSearchDay() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath(dayusestay)).click();
		WebElement daykey = driver.findElement(By.id(city_search));
		daykey.sendKeys(chennai);
		System.out.println("City Printed");
		driver.findElement(By.xpath(select_chennai)).click();
		WebElement datefrom = driver.findElement(By.xpath(day_book));
		wait.until(ExpectedConditions.elementToBeClickable(datefrom));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", datefrom);
		System.out.println("Dates Selected");
		try {
			if (driver.findElement(By.xpath(adultroom_select)).isDisplayed()) {
				driver.findElement(By.xpath(adultroom_select)).click();
				driver.findElement(By.xpath(hotelsearch_button)).click();
				System.out.println("adult Booked");
			}
			else {
				System.out.println("Element not found");
			}
		} 
		catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("adult room elements not found");
		}
		try {
			if (driver.findElement(By.xpath(noofroom_select)).isDisplayed()) {
				driver.findElement(By.xpath(noofroom_select)).click();
				driver.findElement(By.xpath(confirmroom_click)).click();
				driver.findElement(By.xpath(hotelsearch_button)).click();		
			}
			else {
				System.out.println("no of room Booked");
			}
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("no of rooms elements not found");
		}	
		System.out.println("Day Booking Sucessful");
		Reporter.log("Day Room Booked");
	}

	public void hotelSearchNight() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement nightkey = driver.findElement(By.id(city_search));
		nightkey.sendKeys(chennai);
		System.out.println("City Printed");
		driver.findElement(By.xpath(select_chennai)).click();
		WebElement datefrom = driver.findElement(By.xpath(book_from));
		WebElement from = wait.until(ExpectedConditions.elementToBeClickable(datefrom));
		from.click();
		WebElement dateto = driver.findElement(By.xpath(book_to));
		WebElement to = wait.until(ExpectedConditions.elementToBeClickable(dateto));
		to.click();
		System.out.println("Dates Selected");
		try {
			if (driver.findElement(By.xpath(adultroom_select)).isDisplayed()) {
				driver.findElement(By.xpath(adultroom_select)).click();
				driver.findElement(By.xpath(confirmroom_click)).click();
				WebElement searchButton = driver.findElement(By.xpath(hotelsearch_button));
				js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", searchButton);			
				System.out.println("adult Booked");
				Reporter.log("Night Booking Done");
			}
			else {
				System.out.println("Element not found");
			}
		} 
		catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("adult room elements not found");
		}
		try {
			if (driver.findElement(By.xpath(noofroom_select)).isDisplayed()) {
				driver.findElement(By.xpath(noofroom_select)).click();
				driver.findElement(By.xpath(confirmroom_click)).click();
				WebElement searchButton1 = driver.findElement(By.xpath(hotelsearch_button));
				js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", searchButton1);	
//				driver.findElement(By.xpath(hotelsearch_button)).click();	
				System.out.println("Night Booking Successful");
			}
			else {
				System.out.println("no of room Booked");
				Reporter.log("Night Booking Done");
			}
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("no of rooms elements not found");
		}			
	}
	
	public void selectHotel() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		By hotelName = By.xpath(select_hotel);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hotelName));	
		driver.findElement(hotelName).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Iterator<String> itr = windows.iterator();
		String parentid = itr.next();
		System.out.println(parentid);
		String childid = itr.next();
		driver.switchTo().window(childid);
		System.out.println(childid);   
		System.out.println(driver.getTitle());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Agoda Screenshots\\"+sdf.format(date)+".png");
		FileUtils.copyFile(source, destination);	
	}

	public void bookHotelNight() throws Exception {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		By locator = By.xpath(booknowBtn);
		By locator1 = By.xpath(registerBtn);

		WebElement viewDealBtn = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
		if (viewDealBtn.isDisplayed()) {
			try {			
				viewDealBtn.click();
				System.out.println("Booknow button found");
			}
			catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("Booknow button not found");
			} 
		}else {
			try {
				WebElement viewDealBtn1 = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator1));
				viewDealBtn1.click();
				System.out.println("Register button found");
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("Register button not found");
			}
		}
		WebElement element = driver.findElement(By.xpath(nosmoking));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Agoda Screenshots\\"+sdf.format(date)+".png");
		FileUtils.copyFile(source, destination);	
	}

	public void bookHotelDay() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By locator = By.xpath(select_Day);
		WebElement viewDealBtn = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
		if (viewDealBtn.isDisplayed()) {
			try {			
				viewDealBtn.click();
				System.out.println("Select time button button found");
			}
			catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("Select time button not found");
			} 
		}else {
			System.out.println("Select time button not found");
		}

		WebElement locator2 = driver.findElement(By.xpath("//button[@class='ChildRoomsList-bookButtonInput']"));
		wait.until(ExpectedConditions.elementToBeClickable(locator2));
		locator2.click();			
	}

	public void customerInfo() throws Exception {	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath(nosmoking));
		jse.executeScript("arguments[0].scrollIntoView();", element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);	
		System.out.println("No Smoking Selected");
		WebElement element1 = driver.findElement(By.xpath(nextfinalstep));
		executor.executeScript("arguments[0].click();", element1);
		System.out.println("Final Button Clicked");
		Reporter.log("Customer Info successfully updated");
	}

	public void paymentInfo() throws Exception {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		WebElement dropdown = driver.findElement(By.xpath(carddrpdwn));
		wait1.until(ExpectedConditions.visibilityOfAllElements(dropdown));
		dropdown.click();
		dropdown.click();
		driver.findElement(By.id("cardNumber")).sendKeys("2435263748595674");
		driver.findElement(By.id("expiryDate")).sendKeys("1225");
		driver.findElement(By.id("cvv")).sendKeys("177");
		System.out.println("Card Details Entered");
		driver.findElement(By.id("issuingBank")).sendKeys("SBI");
		WebElement key1 = driver.findElement(By.xpath(selectRS));
		key1.click();
		key1.sendKeys(Keys.ENTER);
		System.out.println("Booking not cofirmed because of wrong debit number");
		Reporter.log("Customer Info successfully updated");
	}
}
