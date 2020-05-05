package browserDemo;

public class TestCase2 extends BaseTest2 {

	public static void main(String[] args) {

		launch2("chrome");
		navigateApp("http://newtours.demoaut.com/");
		driver.close();

	}

}
