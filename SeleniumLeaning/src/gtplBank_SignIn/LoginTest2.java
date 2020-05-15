package gtplBank_SignIn;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import library.GetScreenShot;

public class LoginTest2 extends BaseClass {

	@Test(priority = 3)
	public void login2()

	{
		test.log(Status.INFO, "Login Excuttion Started");
		test = extent.createTest("login");
		driver.findElement(By.name("uid")).sendKeys("mngr257777");
		driver.findElement(By.name("password")).sendKeys("gEvetyn");
		driver.findElement(By.name("btnReset")).click();
		test.log(Status.INFO, "Login Excuttion Ended");
	}

	@Test(priority = 1)
	public void titleTest2() {
		test = extent.createTest("titleTest");
		test.log(Status.INFO, "tileTest2 Excuttion Started");
		String title = driver.getTitle();
		test.log(Status.INFO, "tile of the Website is" + title);
		System.out.println("Gtpl Bank Home page title name is :" + title);
		Assert.assertEquals(title, "GTPL Bank  Page");// Home
		test.log(Status.INFO, "tileTest2 Excuttion Ended");
	}

	@Test(priority = 2)
	public void UrlTest2()

	{
		test.log(Status.INFO, "UrlTest2 Excuttion Started");
		test = extent.createTest("UrlTest");
		String Url = driver.getCurrentUrl();
		test.log(Status.INFO, "Url name is : " + Url);
		System.out.println(Url);
		Assert.assertEquals(Url, "http://demo.guru99.com/V1/index.php", "Url is true");
		test.log(Status.INFO, "UrlTest2 Excuttion Ended");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException

	{
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotpath = GetScreenShot.capture(driver, "SampleScreenshot");// if you take screenshot
			test.fail(result.getThrowable());
			test.fail("Screenshot below" + test.addScreenCaptureFromPath(screenshotpath));// if you take screenshot
		} else {
			test.pass(result.getName() + "Test Passed");
		}
	}

}
