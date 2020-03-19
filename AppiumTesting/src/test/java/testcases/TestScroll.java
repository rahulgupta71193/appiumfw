package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestScroll {

	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

	
		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\rahul\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\src\\test\\resources\\appiumlogs\\logs.txt")));
				
				service.start();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");

		capabilities.setCapability("appPackage", "com.samsung.android.contacts");
		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'CONTACTS')]")).click();
		//driver.scrollTo("");
		
		String text = "Abhinav";
		MobileElement ele=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/list\")).scrollIntoView(new UiSelector().textContains(\""+text+"\"))");
		//left to rght
		//driver.swipe(ele.getLocation().x+0, ele.getLocation().y, ele.getLocation().x+800, ele.getLocation().y, 5000);
		//rght to left
		driver.swipe(ele.getLocation().x+600, ele.getLocation().y, ele.getLocation().x+0, ele.getLocation().y, 5000);
		
		Thread.sleep(4000);
		driver.quit();

	}

}
