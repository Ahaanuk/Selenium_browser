package lancherBrowser;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest5 {

	public static WebDriver driver;
	// public static String configpath="./config.properties";

	public static String configpath = System.getProperty("user.dir") + "//config.properties";

	public static Properties prop;

	public static void init() throws Exception {

		FileInputStream file = new FileInputStream(configpath);
		prop = new Properties();
		prop.load(file);

	}

	public static void launch(String browser) {

		if (prop.getProperty(browser).equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (prop.getProperty(browser).equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

	}

	public static void navigateUrl(String url) {
		driver.get(prop.getProperty(url));
	}

}
