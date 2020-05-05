package lancherBrowser;

public class TC_005 extends BaseTest5 {

	public static void main(String[] args) throws Exception

	{
		init();
		launch("chromebrowser");

		navigateUrl("bestbuyurl");

	}

}
