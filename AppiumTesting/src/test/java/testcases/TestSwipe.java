package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestSwipe {
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

		/*capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
*/capabilities.setCapability("appPackage", "com.samsung.android.contacts");
capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		/*driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Shoes");
*/driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'CONTACTS')]")).click();

		//driver.pressKeyCode(AndroidKeyCode.ENTER);

		List<MobileElement> names = driver.findElements(By.id("in.amazon.mShop.android.shopping:id/item_title"));
		//List<MobileElement> names = driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'CONTACTS')]"));
		System.out.println("xolo:"+names.size());			   //com.samsung.android.contacts:id/cliv_name_textview
		try {
			while (true) {

				for (MobileElement name : names) {
					System.out.println(name.getText());
					if (name.getText().contains("Ahana")) {

						name.click();
						break;
					}

				}

				driver.swipe(500, 1900, 500, 200, 5000);
			}
		} catch (Throwable t) {

		}

		Thread.sleep(4000);
		driver.quit();
	}

}
