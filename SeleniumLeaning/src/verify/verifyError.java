package verify;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyError {
	
	@Test
	
	public void handleError_message() throws Exception 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\SeleniumLeaning\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//verify title
		String my_title=driver.getTitle();
		String expected_title=("OrangeHRM");
		Assert.assertEquals(my_title, expected_title);
		
		//Assert.assertTrue(my_title.contains("Oran"));
		System.out.println("Title verify1");
		
		//verify Error Message
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Admin");
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(2000);
	String actual_error_message=driver.findElement(By.id("spanMessage")).getText();
	String expected_error_message=("Invalid credentials");
	
	Assert.assertEquals(actual_error_message, expected_error_message);
	System.out.println("Error is verify");
		
		
		
		
		
		
	}
}
