package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcReg {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("userRegistrationForm:userName").sendKeys("yeshvanth");
		driver.findElementById("userRegistrationForm:password").sendKeys("pass");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("pass");
		//select the Security question drop down
		WebElement sq=driver.findElementById("userRegistrationForm:securityQ");
		Select sqDropdown=new Select(sq);
		List<WebElement> sqAllOptions=sqDropdown.getOptions();
		int sqSize=sqAllOptions.size();
		System.out.println(sqSize);
		sqDropdown.selectByIndex(sqSize-1);
		//------
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Chennai");

		//Select the Preferred Language Drop down
		WebElement pl=driver.findElementById("userRegistrationForm:prelan");
		Select plDropdown=new Select(pl);
		List<WebElement> pfAllOptions=plDropdown.getOptions();
		int plSize=pfAllOptions.size();
		System.out.println(plSize);
		plDropdown.selectByIndex(plSize-1);
		//------

		driver.findElementById("userRegistrationForm:firstName").sendKeys("Yeshvanth");
		driver.findElementByName("userRegistrationForm:lastName").sendKeys("Kannan");
		driver.findElementById("userRegistrationForm:gender:1").click();;
		driver.findElementById("userRegistrationForm:maritalStatus:1").click();
		//selecting DOB
		driver.findElementById("userRegistrationForm:dobDay").sendKeys("06");
		driver.findElementById("userRegistrationForm:dobMonth").sendKeys("DEC");
		driver.findElementById("userRegistrationForm:dateOfBirth").sendKeys("1991");


		//Selecting Occupation
		WebElement occ=driver.findElementById("userRegistrationForm:occupation");
		Select occDropdown=new Select(occ);
		occDropdown.selectByValue("1");
		//

		driver.findElementById("userRegistrationForm:email").sendKeys("Yeshchennai@gmail.com");
		driver.findElementByClassName("textfield01").sendKeys("7200502256");
		//Select the Nationality Drop down
		WebElement nl=driver.findElementById("userRegistrationForm:nationalityId");
		Select nlDropdown=new Select(nl);
		nlDropdown.selectByValue("94");
		//------
		driver.findElementByXPath("//*[@id='userRegistrationForm:address']").sendKeys("8/218 THIRUMALAI NAGAR");
		//Select the Country Drop down
		WebElement cont=driver.findElementById("userRegistrationForm:countries");
		Select contDropdown=new Select(cont);
		contDropdown.selectByValue("94");
		//------
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600074");
		Thread.sleep(30000);
		//selecting cityname dropdown
		WebElement city=driver.findElementById("userRegistrationForm:cityName");
		Select cityDropdown=new Select(city);
		List<WebElement> cityAllOptions=cityDropdown.getOptions();
		int citySize=cityAllOptions.size();
		System.out.println(citySize);
		cityDropdown.selectByIndex(citySize-1);
		Thread.sleep(30000);
		//selecting post office dropdown
		WebElement pf=driver.findElementById("userRegistrationForm:postofficeName");
		Select pfDropdown=new Select(pf);
		List<WebElement> postofffAllOptions=pfDropdown.getOptions();
		int pfSize=postofffAllOptions.size();
		System.out.println(citySize);
		pfDropdown.selectByIndex(pfSize-1);
		//
		driver.findElementById("userRegistrationForm:landline").sendKeys("7200502256");
		driver.findElementById("userRegistrationForm:resAndOff").click();
	}
}

