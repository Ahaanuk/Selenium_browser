package gtplBank_SignIn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setup() {

		htmlReporter = new ExtentHtmlReporter("./test-output/MyReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "localHost");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("Author", "Rolia Panna");

		htmlReporter.config().setDocumentTitle("eBanking Report Demo ");
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

	@AfterSuite
	public void tearDown() {
		driver.quit();
		extent.flush();

	}
}
