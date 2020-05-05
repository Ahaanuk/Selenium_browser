package dropdown;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Intitate driver
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\SeleniumLeaning\\Drivers\\chromdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize Page
		driver.manage().window().maximize();

		// Implicit wait Time for 10 sec

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Open the URL

		driver.get("http://newtours.demoaut.com/");

		// wait
		Thread.sleep(5000);

		// Capture links from webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// size of links
		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++)

		{
			WebElement element = links.get(i);

			String url = element.getAttribute("href");// using href we will get url of link

			// Use special URL class for creat url link

			URL link = new URL(url);

			// Create connection with special class HttpUrlConnect /this connection will
			// check the likes are connect or not

			HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();

			// wait 2 sce
			Thread.sleep(2000);
			httpconn.connect();

			int rescode = httpconn.getResponseCode();// return respose code.if response code is more them 400 then its
														// broken link

			if (rescode >= 400) {

				System.out.println(url + " - " + "is broken link");
			} else {
				System.out.println(url + " - " + "is valid link");
			}
		}

	}

}
