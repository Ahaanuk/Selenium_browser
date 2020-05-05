package browserDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;

	public static void launch(String browser) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromdriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("http://newtours.demoaut.com/");
		}
		// "C:\\Users\\Administrator\\eclipse-workspace\\SeleniumLeaning\\Drivers\\chromdriver\\chromedriver.exe");
		else if (browser.equals("firefox")) {
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\Drivers\\geckodriver\\geckodriver.exe");
			// "C:\\Users\\Administrator\\Downloads\\geckodriver-v0.26.0-win64
			// (1)\\geckodriver.exe");

			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("http://demo.guru99.com/V1/index.php");

		}

	}

}
