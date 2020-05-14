package gtplBank_SignIn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginTest {

	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeClass
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("./test-output/MyReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "localHost");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("Author", "Rolia Panna");

		htmlReporter.config().setDocumentTitle("eBanking Report ");
		htmlReporter.config().setReportName("My Own extert Report");
		htmlReporter.config().setTheme(Theme.DARK);

		System.setProperty("webdriver.chrome.silentOutput", "true");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V1/index.php");

	}

	@Test(priority = 3)
	public void login()

	{
		test = extent.createTest("login");
		driver.findElement(By.name("uid")).sendKeys("mngr257777");
		driver.findElement(By.name("password")).sendKeys("gEvetyn");
		driver.findElement(By.name("btnReset")).click();

	}

	@Test(priority = 1)
	public void titleTest() {
		test = extent.createTest("titleTest");
		String title = driver.getTitle();
		System.out.println("Gtpl Bank Home page title name is " + title);
		Assert.assertEquals(title, "GTPL Bank  Page");// Home

	}

	@Test(priority = 2)
	public void UrlTest()

	{
		test = extent.createTest("UrlTest");
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
		Assert.assertEquals(Url, "http://demo.guru99.com/V1/index.php", "Url is true");
	}

	@AfterMethod
	public void getResult(ITestResult result)

	{
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
		} else {
			test.pass(result.getName() + "Test Passed");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		extent.flush();

	}

}
