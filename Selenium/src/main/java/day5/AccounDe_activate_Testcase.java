package day5;
import wrappers.LeafTaps_Wrappers;
import org.testng.annotations.Test;
public class AccounDe_activate_Testcase extends LeafTaps_Wrappers {

	//@Test(enabled=false)
	@Test(dataProvider="DeactivateLeadDataSource",dataProviderClass=DataProviders.class)
	public void de_activateAccount(String phNo)
	{
		
		//login_Taps();
		clickByLink("CRM/SFA");
		clickByLink("Accounts");
		clickByXpath("//a[@href='/crmsfa/control/findAccounts' and contains(text(),'Find Accounts')]");
		clickByXpath("//span[contains(text(),'Phone')]");
		enterByName("phoneNumber",phNo);
		clickByXpath("//button[@class='x-btn-text' and contains(text(),'Find Accounts')]");
		String firstResultingId=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		System.out.println(firstResultingId);
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		verifyTextById("sectionHeaderTitle_accounts","Account Details");
		clickByLinkNoSnap("Deactivate Account");
		acceptAlert();
		verifyTextContainsByXpath("(//div[@class='x-panel-header']/span)[1]","This account was deactivated");
		clickByXpath("//a[@href='/crmsfa/control/findAccounts' and contains(text(),'Find Accounts')]");
		enterByName("id",firstResultingId);
		clickByXpath("//button[@class='x-btn-text' and contains(text(),'Find Accounts')]");
		if(getTextByXpath("//div[@class='x-paging-info']").equals("No records to display"))
			System.out.println("Account  succesfully deactivated- De-activated ID account not present at search");
		else
			System.out.println("Account not succesfully deactivated- De-activated ID account  present at search");

		//verifyTextByXpath("//div[@class='x-paging-info']","No records to display");
		//closeBrowser();
	}
}
