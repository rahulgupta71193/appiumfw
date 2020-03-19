package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestNativeElements {

public static AndroidDriver<MobileElement> driver;


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
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
	
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		if(driver.isLocked()){
			
			driver.unlockDevice();
		}

		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Hello Appium !!!");
		driver.hideKeyboard();
		
		System.out.println(driver.findElements(By.className("android.widget.Button")).size());
		
		List<MobileElement> btn = driver.findElements(By.className("android.widget.Button"));
		
		for(MobileElement button:btn){
			
			if(button.getAttribute("text").contains("Display text view")){
				
				button.click();
				
			}
			
		}
		
		
		
		driver.openNotifications();
		
	
		if(isElementPresent("com.android.systemui:id/clear_button")){
		
		driver.findElement(By.id("com.android.systemui:id/clear_button")).click();
		}
		
		
		Thread.sleep(4000);
		
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
		
		driver.closeApp();
		
		driver.removeApp("io.selendroid.testapp");
		
		Thread.sleep(10000);
		
		System.out.println("Status of App installation : "+driver.isAppInstalled("io.selendroid.testapp"));
		
		
		if(!driver.isAppInstalled("io.selendroid.testapp")){
			
			driver.installApp("C:\\Users\\Selenium\\Downloads\\selendroid-test-app-0.17.0.apk");
			driver.startActivity("io.selendroid.testapp", ".HomeScreenActivity"); //switching the apps - selendroid test app, message app
		
		}
		
		Thread.sleep(5000);
		driver.quit();
		service.stop();
		
		
	}

}
