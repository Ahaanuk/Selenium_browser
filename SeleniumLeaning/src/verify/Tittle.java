package verify;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tittle {

	@Test
	public void verifytilleofFB()

	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\SeleniumLeaning\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		String fb_title = driver.getTitle();
		System.out.println(fb_title);
		String my_pagesource = driver.getPageSource();
		Assert.assertTrue(my_pagesource.contains("Facebook - Log In or"));
		System.out.println("test pass");

		// String expected_tile= ("Facebook - Log In or Sign Up");
		// 1 type
		// Assert.assertEquals(fb_title, expected_tile);

		// Type 2
		// Assert.assertTrue(fb_title.contains("Facebook - Log"));
		// System.out.println("Test complited ");
	}

}
