package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestWebApp {
	
	
	public static AndroidDriver driver;
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		/*
		 * 
		 * platformName : android
		 * deviceName: Samsung
		 * platformVersion: 6.0.1
		 * browser: Chrome
		 * device: android
		 * 
		 */
		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\rahul\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\src\\test\\resources\\appiumlogs\\logs.txt")));
				
				service.start();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("deviceName", "Android");
		
		
		
		//capabilities.setCapability("device", "Android");
		//capabilities.setCapability("platformVersion", "6.0.1");
		//capabilities.setCapability("platformName", "Android");


		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hello Appium !!!!");
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
