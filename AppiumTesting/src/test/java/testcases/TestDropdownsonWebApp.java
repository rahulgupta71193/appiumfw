package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestDropdownsonWebApp {

	//IOSElement, AndroidElement, MobileElement, WebElement
	public static AndroidDriver<WebElement> driver;
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\rahul\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\src\\test\\resources\\appiumlogs\\logs.txt")));
				
				service.start();
				
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("deviceName", "Android");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.get("http://wikipedia.org");
		
		//driver.manage().deleteAllCookies();
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		select.selectByValue("hi");
		//select.getOptions();

		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		
		System.out.println(values.size());
		
		for(WebElement value: values){
			
			System.out.println(value.getAttribute("lang"));
			
		}
		
		System.out.println("----Printing links-------");
		
		WebElement block = driver.findElement(By.cssSelector(".other-projects"));
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(WebElement link: links){
			
			System.out.println(link.getAttribute("href")+"----"+link.getText());
			
		}
	
		
		
		
		Thread.sleep(2000);
		
		driver.quit();
		
		service.stop();
	
	}

}
