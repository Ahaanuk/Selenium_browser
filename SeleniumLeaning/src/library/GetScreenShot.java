package library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class GetScreenShot {

	public static String capture(WebDriver driver, String screenshotname) throws IOException

	{

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/ErrorScreenshot/" + screenshotname + ".png";
		File destination = new File(dest);
		FileHandler.copy(src, destination);
		return dest;
	}
}
