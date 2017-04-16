	package day1;
	
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.chrome.ChromeDriver;
	
	public class FirstClass {	
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementById("username").sendKeys("DemoCSR");
			driver.findElementById("password").sendKeys("crmsfa");
			driver.findElementByClassName("decorativeSubmit").click();
			driver.findElementByLinkText("CRM/SFA").click();
			driver.findElementByLinkText("Create Lead").click();
			driver.findElementById("createLeadForm_companyName").sendKeys("TCS");
			driver.findElementById("createLeadForm_parentPartyId").sendKeys("14798");
			/*driver.findElementByCssSelector("#ext-gen585").click();
			driver.findElementByXPath("//*[@id='ext-gen269']").click();
			driver.findElementByName("phoneAreaCode").sendKeys("81");
			driver.findElementByName("phoneNumber").sendKeys("9952936784");
			driver.findElementByClassName("x-btn-text").click();
			driver.findElementByLinkText("14798");*/
			driver.findElementById("createLeadForm_firstName").sendKeys("Yeshvanth");
			driver.findElementById("createLeadForm_lastName").sendKeys("Kannan");
			driver.findElementById("createLeadForm_dataSourceId").sendKeys("LEAD_COLDCALL");
			driver.findElementById("createLeadForm_marketingCampaignId").sendKeys("CATRQ_AUTOMOBILE");
			driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Yesh");
			driver.findElementById("createLeadForm_lastNameLocal").sendKeys("K");
			driver.findElementById("createLeadForm_personalTitle").sendKeys("K.Y");
			driver.findElementById("createLeadForm_birthDate").sendKeys("12/06/91");
			driver.findElementById("createLeadForm_generalProfTitle").sendKeys("MR");
			driver.findElementById("createLeadForm_departmentName").sendKeys("AIRLINES");
			driver.findElementById("createLeadForm_annualRevenue").sendKeys("360000");
			driver.findElementById("createLeadForm_currencyUomId").sendKeys("AFA - Afghani");
			driver.findElementById("createLeadForm_industryEnumId").sendKeys("IND_AEROSPACE");
			driver.findElementById("createLeadForm_numberEmployees").sendKeys("67");
			driver.findElementById("createLeadForm_ownershipEnumId").sendKeys("OWN_PROPRIETOR");
			driver.findElementById("createLeadForm_sicCode").sendKeys("799GJBJ");
			driver.findElementById("createLeadForm_description").sendKeys("HIGH RATED EMPLOYEE");
			
			driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("7");	
			driver.findElementByName("submitButton").click();
			//driver.close();
	
	
	
	
		}
	
	}
