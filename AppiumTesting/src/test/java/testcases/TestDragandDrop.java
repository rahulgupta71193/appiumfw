package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.condition.Presence;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestDragandDrop {

	public static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		/*AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\rahul\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("C:\\Users\\rahul\\Desktop\\Appium note\\AppiumTesting\\AppiumTesting\\src\\test\\resources\\appiumlogs\\logs.txt")));
				
				service.start();*/

		//File app = new File(System.getProperty("user.dir") + "//apk//drag.apk");
		File app=new File(System.getProperty("user.dir") + "//apk//drag.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");

		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		//driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		//driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		//System.out.println(driver.getPageSource());
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Basic')]")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Basic')])")).click();
		//System.out.println(driver.getPageSource());
		// driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		String text="Basic";
		driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")").click();
		Thread.sleep(3000);
		//System.out.println(driver.getPageSource());
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.mobeta.android.demodslv:id/text")));
		MobileElement draggable = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Brad')]/preceding-sibling::android.widget.ImageView"));
		MobileElement droppable = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Kurt')]/preceding-sibling::android.widget.ImageView"));
		
		
		TouchAction action = new TouchAction(driver);
		action.longPress(draggable).moveTo(droppable).release().perform();
		
		
		

		// xml code
		//driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Basic')]")).click();
		
		/*String text = "Basic";
		//driver.fin
		//driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+text+"\")").click();
		//Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.mobeta.android.demodslv:id/text")));
		
		
		System.out.println(driver.getPageSource());
		
		MobileElement draggable = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Brad')]/preceding-sibling::android.widget.ImageView"));
		MobileElement droppable = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Kurt')]/preceding-sibling::android.widget.ImageView"));
		
		
		TouchAction action = new TouchAction(driver);
		action.longPress(draggable).moveTo(droppable).release().perform();*/
		
		
		
		Thread.sleep(4000);
		driver.quit();
		// service.stop();
	}

}
