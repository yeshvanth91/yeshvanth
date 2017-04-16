package day4;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class DuplicateLead extends GenericWrappers {
	@Test(dependsOnMethods={"day4.CreateTestLead.createTestLead"})
	public void executeDuplicateLeadTestCAse() throws Exception
	{
		invokeApp("chrome","http://leaftaps.com/control/main");
		enterById("username","DemoSalesManager");
		enterById("password","crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
		clickByLink("Leads");
		clickByLink("Find Leads");
		clickByXpath("//span[contains(text(),'Email')]");
		enterByName("emailAddress","tkgkamal@gmail.com");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(10000);
		String firstName=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a");
		System.out.println(firstName);
		String lastName=getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName'])[1]/a");
		System.out.println(lastName);
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a");
		clickByLink("Duplicate Lead");
		verifyTextContainsByXpath("//div[contains(text(),'Duplicate Lead')]","Duplicate Lead");
		clickByName("submitButton");
		String dupFirstName=getTextById("viewLead_firstName_sp");
		String dupLastName=getTextById("viewLead_lastName_sp");
		System.out.println(dupFirstName);
		System.out.println(dupLastName);
		if(firstName.equals(dupFirstName)&&lastName.equals(dupLastName))
			System.out.println("Duplicate Lead created");
		else
			System.out.println("Created lead is not duplicate");

		closeBrowser();



	}



}
