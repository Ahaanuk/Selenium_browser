package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import library.Utility;

public class Screenshot {
	WebDriver driver;

	@Test
	public void captureshot() throws Exception {

		Utility.lunchbrowser(driver);

		driver.findElement(By.xpath("//*[@name=\"firstname\"]")).sendKeys("Rolia");
		driver.findElement(By.xpath("//*[@name=\"lastname\"]")).sendKeys("panna");

		Utility.captureshot(driver, "Type firstname and lastname");

		System.out.println();

		driver.quit();

	}

}
