package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestDialingNumbers {
	public static AndroidDriver<MobileElement> driver;
	public static Logger log=Logger.getLogger("devpinoyLogger");


	public static boolean isElementPresent(String id){
		
		try{
		driver.findElement(By.id(id));
		return true;
		}catch(Throwable t){
			
			return false;
		}
	}
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
			AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\rahul\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\src\\test\\resources\\appiumlogs\\logs.txt")));
				
				service.start();
			//System.out.println("hh");
		DesiredCapabilities capabilities = new DesiredCapabilities();
	
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("appPackage", "com.samsung.android.contacts");
		capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug("Applcation Launched");
		/*driver.findElement(By.id("com.samsung.android.contacts:id/floating_action_button")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/two")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/three")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/five")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/two")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/four")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/seven")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/dialButtonImage1")).click();*/
		
		
		Thread.sleep(5000);
		driver.quit();
		log.debug("Applcation stopped");
		service.stop();
		
	}

}
