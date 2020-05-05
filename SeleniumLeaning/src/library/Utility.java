package library;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {

	public static void captureshot(WebDriver driver, String screenshotname)

	{

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sr = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sr, new File("./screenshot/" + screenshotname + ".png"));
		}

		catch (Exception e) {

			System.out.println("Expection while taking screenshot" + e.getMessage());

		}

	}

	public static void lunchbrowser(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\SeleniumLeaning\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
}
