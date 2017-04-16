
package day4;
import org.testng.annotations.Test;

import day5.DataProviders;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;
import wrappers.LeafTaps_Wrappers;
public class CreateTestLead extends LeafTaps_Wrappers{
	//@Test(invocationCount=2,invocationTimeOut=30000)
	//@Test(groups={"smoke"})
	@Test(groups={"smoke"},dataProvider="CreateLeadDataSource",dataProviderClass=DataProviders.class,priority=0)
	public void createTestLead(String fName,String LName) throws Exception{

		/*invokeApp("chrome", "http://leaftaps.com");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");*/
		clickByLink("CRM/SFA");
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName","Yesh Solutions");
		enterById("createLeadForm_firstName",fName);
		enterById("createLeadForm_lastName",LName);
		/*		selectVisibileTextById("createLeadForm_dataSourceId","Conference");
		selectIndexById("createLeadForm_marketingCampaignId",3);
		enterById("createLeadForm_firstNameLocal","Yesh");
		enterById("createLeadForm_lastNameLocal","K");
		enterById("createLeadForm_personalTitle","MR");
		enterById("createLeadForm_generalProfTitle","K.Y");
		enterById("createLeadForm_departmentName","Digital Marketing");
		enterById("createLeadForm_annualRevenue","360000");
		selectIndexByContainsTextById("createLeadForm_currencyUomId","India");
		selectIndexById("createLeadForm_industryEnumId",7);
		enterById("createLeadForm_numberEmployees","100");
		selectVisibileTextById("createLeadForm_ownershipEnumId","Sole Proprietorship");
		enterById("createLeadForm_sicCode", "67880");
		enterById("createLeadForm_importantNote", "This lead is expertise in HTML5,CSSS,JAva");
		enterById("createLeadForm_primaryPhoneCountryCode", "91");
		enterById("createLeadForm_primaryPhoneAreaCode", "44");
		enterById("createLeadForm_primaryPhoneNumber", "7200502256");
		enterById("createLeadForm_primaryEmail", "yeshchennai@gmail.com");
		enterById("createLeadForm_generalToName", "yeshvanth");
		enterById("createLeadForm_generalAddress1", "8/218 Thirumalai Nagar Pozhichlur Chennai-74");
		selectTextByValue("createLeadForm_generalCountryGeoId", "IND");
		selectTextByValue("createLeadForm_generalStateProvinceGeoId", "IN-TN");
		enterById("createLeadForm_generalPostalCode", "600074");*/
		clickByName("submitButton");
		//closeBrowser();
	}
	/*@Test
	public void verify_EditAccountName()
	{
		//login_Taps();
		clickByLink("CRM/SFA");
		clickByLink("Accounts");
		clickByXpath("//a[@href='/crmsfa/control/findAccounts' and text()='Find Accounts']");
		enterByName("id","17");
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

	}*/
	/*@BeforeMethod
	public
	void login_Taps1()
	{
		System.out.println("before method-create lead");

	}
	@AfterMethod
	public
	void CloseBrowser1()
	{
		System.out.println("after method-create lead");

	}*/

}
