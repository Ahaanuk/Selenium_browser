package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClipboardDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://clipboardjs.com/");
		driver.manage().window().maximize();
		WebElement button = driver.findElement(By.xpath("//*[@id=\"example-target\"]/div/span/button"));
		String attribute = button.getAttribute("data-clipboard-target");
		System.out.println(attribute);
		WebElement target = driver.findElement(By.cssSelector(attribute));
		String value = target.getAttribute("value");
		System.out.println(value);

	}

}
