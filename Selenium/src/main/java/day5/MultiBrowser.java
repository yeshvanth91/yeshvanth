package day5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;
public class MultiBrowser extends GenericWrappers {
	RemoteWebDriver driver;
	@BeforeTest
	@Parameters({"browserName"})
	public void invokeBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_64 bit.exe");
			driver=new FirefoxDriver();
		}
	}
	@Test
	public void demoMethod()
	{
		driver.get("http://www.samsung.com/in/support/");
		String cookieText=driver.findElementByXPath("//div[@class='cookie-notice js-cookie']").getText();
		if(cookieText.equals("This site uses cookies. By continuing to browse the site you are agreeing to our use of cookies.Find out more here"));
		{
			System.out.println("Cookie message displayed and matches");
			driver.findElementByXPath("//div[@class='cookie-notice js-cookie']//following-sibling::button").click();

		}

	}
}