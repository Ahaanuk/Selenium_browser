package gtplBank_SignIn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.silentOutput", "true");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V1/index.php");

	}

	@Test
	public void titleTest() {

		String title = driver.getTitle();
		System.out.println("Gtpl Bank Home page title name is " + title);
		Assert.assertEquals(title, "GTPL Bank Home Page");

	}

	@Test
	public void UrlTest()

	{
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
		Assert.assertEquals(Url, "http://demo.guru99.com/V1/index.php", "Url is true");
	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}
}
