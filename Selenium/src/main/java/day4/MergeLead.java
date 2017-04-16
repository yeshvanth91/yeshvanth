package day4;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;
import wrappers.LeafTaps_Wrappers;

public class MergeLead extends LeafTaps_Wrappers {
	//@Test(groups={"regression"},dependsOnGroups={"sanity"})
	@Test(groups={"regression"},dependsOnGroups={"smoke"})
	public void  ExecuteMergeLeadTestCase() throws Exception
	{
		//invokeApp("chrome","http://leaftaps.com/control/main");
		//login_Taps();
		clickByLink("CRM/SFA");
		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input","17");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input","17");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		clickByLinkNoSnap("Merge");
		dismissAlert();	
		clickByLink("Find Leads");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input","kkk");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		verifyTextByXpath("//div[contains(text(),'No records to display')]","No records to display");
		//closeAllBrowsers();
	}


}
