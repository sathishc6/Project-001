package org.project;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {


	public static WebDriver driver;
	public static Actions mouse;
	public static Robot bot;
	public static Select slc;

	public static void setUp(String webdriver,String path) {

		System.setProperty(webdriver, path);
		driver = new ChromeDriver();
	}


	public static void link(String url) {

		driver.get(url);
	}

	public static void max() {

		driver.manage().window().maximize();
	}

	//SCREENSHOT
	public static void screenShot(String loc,String name,String format) {

		TakesScreenshot ss = (TakesScreenshot)driver;
		File from = ss.getScreenshotAs(OutputType.FILE);
		File to = new File(""+loc+""+name+""+"."+format+"");
		try {
			FileUtils.copyFile(from, to);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	//SCREENSHOT


	//ELEMENT CLICK
	public static void elementClick(String elements,String locator) {

		switch (elements) {
		case "id":
			driver.findElement(By.id(locator)).click();
			break;
		case "name":
			driver.findElement(By.name(locator)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(locator)).click();
			break;

		default:
			break;
		}
	}
	//ELEMENT CLICK

	//ELEMENT SENDKEYS
	public static void elementSend(String tag,String locator,String value) {

		switch (tag) {
		case "id":
			driver.findElement(By.id(locator)).sendKeys(value);
			break;
		case "name":
			driver.findElement(By.name(locator)).sendKeys(value);
			break;
		case "xpath":
			driver.findElement(By.xpath(locator)).sendKeys(value);
			break;

		default:
			break;
		}
	}
	//ELEMENT SENDKEYS

	//CLOSE
	public static void close() {

		driver.close();
	}
	//CLOSE

	//QUIT
	public static void quit() {

		driver.quit();
	}
	//QUIT

	//wait
	public static void Wait(int sec) {

		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}
	//wait

	//GET TITLE
	public static void gettitle() {
		String title = driver.getTitle();
		System.out.println("Current page title==> "+title+'\n');
	}
	//GET TITLE

	//GET URL
	public static void geturl() {

		String url = driver.getCurrentUrl();
		System.out.println("Current page url==> "+url+'\n');
	}

	//NAVIGATE To
	public static void To(String naviagteTo) {

		driver.navigate().to(naviagteTo);
	}
	//NAVIGATE To

	//NAVIGATE back
	public static void back() {

		driver.navigate().back();
	}
	//NAVIGATE back

	//NAVIGATE forward
	public static void forward() {

		driver.navigate().forward();
	}
	//NAVIGATE forward

	//SELECT(DROPDOWN)
	public static void select(String type,String element,int number,String value,String text) {

		WebElement ele = driver.findElement(By.xpath(element));
		slc = new Select(ele);
		switch (type)  {

		case "index":
			slc.selectByIndex(number);
			break;
		case "value":
			slc.selectByValue(value);
			break;
		case "text":
			slc.selectByVisibleText(text);
			break;

		default:
			break;
		}
	}
	//SELECT(DROPDOWN)
	
	//SCROLL
	public static void scroll(String scrollElement) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement element = driver.findElement(By.xpath(scrollElement));
		js.executeScript("arguments[0].scrollIntoView();",element );
	}
	//SCROLL
	
	//MOUSE ACTIONS
	public static void mouse(String typeOfClick,String elementToClick) {
		
		mouse = new Actions(driver);
	WebElement loc = driver.findElement(By.xpath(elementToClick));
	
	switch (typeOfClick) {
	
	case "click":
		mouse.click(loc).build().perform();
		break;
	case "rightClick":
		mouse.contextClick(loc).build().perform();
		break;
	case "doubleClick":
		mouse.doubleClick(loc).build().perform();
		break;
	case "hover":
		mouse.moveToElement(loc).build().perform();
		break;
		
	default:
		break;
	}	
}
	//MOUSE ACTIONS
	
}
