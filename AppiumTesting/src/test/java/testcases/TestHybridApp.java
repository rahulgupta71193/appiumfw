package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestHybridApp {
	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		/*AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\rahul\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\src\\test\\resources\\appiumlogs\\logs.txt")));
				
				service.start();*/
				//File app = new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\apk\\HTMLWebView.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		/*capabilities.setCapability("app", app.getAbsolutePath());
		Thread.sleep(5000);*/
		capabilities.setCapability("appPackage", "com.html5test.webview");
		capabilities.setCapability("appActivity", "main.java.MainActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.html5test.webview:id/et")).clear();
		
		driver.findElement(By.id("com.html5test.webview:id/et")).sendKeys("http://google.com");
		
		driver.findElement(By.id("com.html5test.webview:id/go")).click();
		
		Thread.sleep(3000);
		Set<String> contextNames = driver.getContextHandles();
		Thread.sleep(3000);
		for(String context: contextNames){
			
			System.out.println(context);
			/*if(context.contains("WEBVIEW")){
				
				driver.context(context);
			}*/
		}
		
		driver.context("WEBVIEW_com.html5test.webview");
		
		driver.findElement(By.id("lst-ib")).sendKeys("Inside webview !!!");
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
