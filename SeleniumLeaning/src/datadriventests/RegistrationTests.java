package datadriventests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTests {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\SeleniumLeaning\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		FileInputStream file = new FileInputStream("S:\\Registration.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int noOfrow = sheet.getLastRowNum();
		System.out.println(noOfrow);
		int noOfcol = sheet.getRow(0).getLastCellNum();
		System.out.println(noOfcol);

		for (int row = 1; row < noOfrow; row++) {

			XSSFRow current_row = sheet.getRow(row);

			String First_name = current_row.getCell(0).getStringCellValue();
			String Last_name = current_row.getCell(1).getStringCellValue();
			String Phone = current_row.getCell(2).getStringCellValue();
			String Email = current_row.getCell(3).getStringCellValue();
			String Address = current_row.getCell(4).getStringCellValue();
			String City = current_row.getCell(5).getStringCellValue();
			String State = current_row.getCell(6).getStringCellValue();
			String PinCode = current_row.getCell(7).getStringCellValue();
			String Country = current_row.getCell(8).getStringCellValue();
			String Username = current_row.getCell(9).getStringCellValue();
			String Password = current_row.getCell(10).getStringCellValue();

			// Registration process
			driver.findElement(By.linkText("REGISTER")).click();
			// Entering Contact information
			driver.findElement(By.name("firstName")).sendKeys(First_name);
			driver.findElement(By.name("lastName")).sendKeys(Last_name);
			driver.findElement(By.name("phone")).sendKeys(Phone);
			driver.findElement(By.name("userName")).sendKeys(Email);

			// Mailing Information
			driver.findElement(By.name("address1")).sendKeys(Address);
			driver.findElement(By.name("address2")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(State);
			driver.findElement(By.name("postalCode")).sendKeys(PinCode);

			// Country selection

			Select dropcountry = new Select(driver.findElement(By.name("country")));
			dropcountry.selectByVisibleText(Country);

			// Enter user information
			driver.findElement(By.name("email")).sendKeys(Username);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.name("confirmPassword")).sendKeys(Password);
			driver.findElement(By.name("register")).click();

			if (driver.getPageSource().contains("Thank you for registering")) {

				System.out.println("Test pass " + row + "record");

			} else {
				System.out.println("Test fail " + row + "record");

			}

		}
		System.out.println("Data Driver Test Completed");
		driver.close();
		driver.quit();
		file.close();

	}

}
