package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContacts_LeafTaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/control/main");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoCSR");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByXPath("//*[@id='login']/p[3]/input").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys("Yeshvanth");
		driver.findElementById("lastNameField").sendKeys("Kannan");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("Yesh");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("Kann");
		driver.findElementById("createContactForm_personalTitle").sendKeys("MR");
		driver.findElementById("createContactForm_departmentName").sendKeys("Technology,R&D");

		//Selecting Preferred currency
		WebElement pc=driver.findElementById("createContactForm_preferredCurrencyUomId");
		Select pcSel=new Select(pc);
		pcSel.selectByValue("INR");
		//
		driver.findElementById("createContactForm_accountPartyId").sendKeys("14798");
		driver.findElementById("createContactForm_importantNote").sendKeys("Preferred Contact-Email");
		driver.findElementById("createContactForm_primaryPhoneNumber").sendKeys("7200502256");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("yeshchennai@gmail.com");
		driver.findElementById("createContactForm_generalAddress1").sendKeys("8/218");
		//Selecting country
		WebElement con=driver.findElementById("createContactForm_generalCountryGeoId");
		Select conSel=new Select(con);
		conSel.selectByValue("IND");
		//
		//Selecting State
		WebElement state=driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select stateSel=new Select(state);
		stateSel.selectByValue("IN-TN");
		//
		driver.findElementById("createContactForm_generalPostalCodeExt").sendKeys("60074");
		driver.findElementById("createContactForm_generalCity").sendKeys("Chennai");
		driver.findElementById("createContactForm_generalPostalCode").sendKeys("600074");
		driver.findElementByName("submitButton").click();
		
		











	}

}
