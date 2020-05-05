package loggDemo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogDemo {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("LogDemo");

		PropertyConfigurator.configure("Log4j.properties");

		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		logger.info("Chrome is opened");

		driver.manage().window().maximize();
		logger.info("Browser is maximaize");

		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		logger.info("App lunched");

		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();

		logger.info("click on search button");

//Alert alt = driver.switchTo().alert();
//alt.accept();
		String actual_msg = driver.switchTo().alert().getText();

		logger.info("capture the text");
		System.out.println("Alert msg is  " + actual_msg);
		String expected_msg = ("Press a button!");

		// Assert.assertEquals(actual_msg, expected_msg);
		// System.out.println("msg is verify");

		driver.switchTo().alert().accept();
		logger.info("Accept alart window");

	}

}
