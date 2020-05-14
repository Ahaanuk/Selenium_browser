package lancherBrowser;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class guruBank extends BaseTest5 {
	@Parameters("pro")
	@BeforeClass
	public void setup() throws Exception {
		init();
		launch("firefoxbrowser");
		launch("chrome");
		navigateUrl("guru99");

	}

	@Test
	public void titleTest() {

		String title = driver.getTitle();
		System.out.println("Gtpl Bank Home page title name is " + title);
		Assert.assertEquals(title, "GTPL Bank Home Page");

	}

	@AfterClass
	public void teardown() {

		driver.close();
	}
}
