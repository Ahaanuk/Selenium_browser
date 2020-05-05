package gtplBank_SignIn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\Downloads\\geckodriver-v0.26.0-win64 (1)\\geckodriver.exe");

		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");

		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V1/index.php");

	}

}
