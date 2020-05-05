package datadriventests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\SeleniumLeaning\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

		FileInputStream file = new FileInputStream("S:\\calculator.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int noOfrow = sheet.getLastRowNum();
		System.out.println(noOfrow);
		int noOfcal = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= noOfrow; i++) {

			XSSFRow row = sheet.getRow(i);

			XSSFCell principlecell = row.getCell(0);
			int princ = (int) principlecell.getNumericCellValue();// type casting

			XSSFCell rateOfInterest = row.getCell(1);
			int rate_interest = (int) rateOfInterest.getNumericCellValue();

			XSSFCell priod = row.getCell(2);
			int priod_years = (int) priod.getNumericCellValue();

			XSSFCell Freqency = row.getCell(3);
			String Freq = Freqency.getStringCellValue();

			XSSFCell maturityValue = row.getCell(4);
			double Exp_value = (double) maturityValue.getNumericCellValue();

			driver.findElement(By.name("principal")).sendKeys(String.valueOf(princ));
			driver.findElement(By.name("interest")).sendKeys(String.valueOf(rate_interest));
			driver.findElement(By.name("tenure")).sendKeys(String.valueOf(priod_years));

			Select days_dropdown = new Select(driver.findElement(By.id("tenurePeriod")));
			days_dropdown.selectByVisibleText("year(s)");

			Select frequencycombo = new Select(driver.findElement(By.xpath("//*[@id=\"frequency\"]")));
			frequencycombo.selectByVisibleText(Freq);

			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
			Thread.sleep(2000);

			String Actual_Mvalue = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
			System.out.println(Actual_Mvalue);

			if ((Double.parseDouble(Actual_Mvalue)) == Exp_value) {

				System.out.println("Test Passed");

			} else {
				System.out.println("Test failed");
			}

			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();

		}
		driver.close();
		driver.quit();
		// file.close();

	}

}
