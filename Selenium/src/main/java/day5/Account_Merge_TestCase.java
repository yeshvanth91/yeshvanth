package day5;
import wrappers.LeafTaps_Wrappers;
import org.testng.annotations.Test;
public class Account_Merge_TestCase extends LeafTaps_Wrappers{
	@Test(timeOut=60000,dataProvider="MergeLeadDataSource",dataProviderClass=DataProviders.class)
	public void mergeAccount(String fromId,String toId)
	{
		//login_Taps();
		clickByLink("CRM/SFA");
		clickByLink("Accounts");
		clickByLink("Merge Accounts");
		clickByXpathNoSnap("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		enterByName("id",fromId);
		clickByXpath("//button[@class='x-btn-text' and contains(text(),'Find Accounts')]");
		String account_ID_To_Merge=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		System.out.println(account_ID_To_Merge);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		switchToParentWindow();
		clickByXpathNoSnap("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		enterByName("id",toId);
		clickByXpath("//button[@class='x-btn-text' and contains(text(),'Find Accounts')]");
		String account_ID_To_Get_Merge=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		System.out.println(account_ID_To_Get_Merge);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		switchToParentWindow();
		clickByLinkNoSnap("Merge");
		acceptAlert();
		clickByLink("Find Accounts");
		enterByName("id",account_ID_To_Merge);
		clickByXpath("//button[@class='x-btn-text' and contains(text(),'Find Accounts')]");
		if(getTextByXpath("//div[@class='x-paging-info']").equals("No records to display"))
			System.out.println("Account succesfully merged- from account not present at search");
		else
			System.out.println("Account not succesfully merged- from account present at search");
		//verifyTextByXpath("//div[@class='x-paging-info']","No records to display");
		closeBrowser();
	}

}
