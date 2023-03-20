package org.project;

public class Browser_Launch extends BaseClass {

	public static void main(String[] args) throws InterruptedException  {
		
		setUp("webdriver.chrome.driver",
				"C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\driver\\chromedriver.exe");
		
		link("https://www.amazon.in/ref=nav_bb_logo");
		max();
		screenShot("./ss/", "3", "png");
		//select("text", "//select[@class='col-lg-3']", 0, null, "Yahoo");
		geturl();
		gettitle();
	//	scroll("//*[.='Bonda']");
		
	mouse("rightClick", "//*[.='Customer Service']");
	Thread.sleep(5000);
	mouse("rightClick", "//*[.='Amazon Pay']");
	}

}














//public static void dummy() throws IOException {
//System.setProperty("webdriver.chrome.driver",
//		"C:\\Users\\skal\\eclipse-workspace\\Demo_MarchProject\\driver\\chromedriver.exe");
//
//WebDriver driver = new ChromeDriver();
//
//driver.manage().window().maximize();
//driver.get("https://www.youtube.com/");
//
//	TakesScreenshot ss = (TakesScreenshot) driver;
//	File from = ss.getScreenshotAs(OutputType.FILE);
//	File to = new File("./ss/youtube.png");
//	FileUtils.copyFile(from, to);
//}