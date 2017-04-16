package day5;



import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class Learn_Multiple_Window extends GenericWrappers{
	@Test
	public void switchToMultipleWindows()
	{
		invokeApp("chrome","http://www.samsung.com/in/support/");
		System.out.println(verifyTitle("Support | Samsung India"));	
		clickByXpath("//a[@class='ich share']/span");
		clickByXpath("(//ul[@class='share-list']/li/a/span)[1]");
		clickByXpath("(//ul[@class='share-list']/li/a/span)[2]");
		/*switchToLastWindow();
		switchToParentWindow();*/
		clickByXpath("(//ul[@class='share-list']/li/a/span)[3]");
		clickByXpath("(//ul[@class='share-list']/li/a/span)[4]");
		switch_To_NTH_Window(2);
	}

}
