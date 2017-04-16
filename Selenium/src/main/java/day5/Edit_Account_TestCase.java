package day5;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import wrappers.LeafTaps_Wrappers;
public class Edit_Account_TestCase extends LeafTaps_Wrappers {
	@Test(groups={"sanity"},dataProvider="EditLeadDataSource",dataProviderClass=DataProviders.class,priority=1)
	public void verify_EditAccountName(String empId,String editCmpName)
	{
		//login_Taps();
		clickByLink("CRM/SFA");
		clickByLink("Accounts");
		clickByXpath("//a[@href='/crmsfa/control/findAccounts' and text()='Find Accounts']");
		enterByName("id",empId);
		enterByXpath("//div[@class='x-form-item x-tab-item']//child::div[1]//following::input[@name='accountName']","ra");
		clickByXpath("//button[@class='x-btn-text' and text()='Find Accounts']");
		String id=getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		clickByXpathNoSnap("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		verifyTitle("Account Details | opentaps CRM");
		clickByLink("Edit");
		String cmpNameSent="Saina nehwal";
		String cmpName=cmpNameSent+" "+"("+id+")";
		System.out.println(cmpName);
		enterByXpath("(//input[@name='accountName'])[2]",cmpNameSent);
		clickByXpathNoSnap("(//input[@class='smallSubmit'])[1]");
		String viewCompanyName=getTextByXpath("(//table[@class='fourColumnForm']//following::span)[2]");
		System.out.println(viewCompanyName);
		if(cmpName.equals(viewCompanyName))
			System.out.println("Edited company name appears at the view");
		else
			System.out.println("Edited company name wrongly appears at the view");
		//closeBrowser();

	}
}
