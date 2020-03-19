package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestDeployApp {

public static AndroidDriver<WebElement> driver;
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\rahul\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\src\\test\\resources\\appiumlogs\\logs.txt")));
				
				service.start();
			
		//File app = new File("C:\\Users\\Selenium\\Downloads\\selendroid-test-app-0.17.0.apk");		
		DesiredCapabilities capabilities = new DesiredCapabilities();
	
		capabilities.setCapability("deviceName", "Android");
	//	capabilities.setCapability("app", app.getAbsolutePath());
		
	//	sCDCsrvRFRRR
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


		
		Thread.sleep(3000);
		driver.quit();
		service.stop();
		
		
	}

}
