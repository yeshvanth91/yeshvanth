package day5;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import org.openqa.selenium.chrome.ChromeDriver;
public class Practice extends GenericWrappers {

	WebDriver driver;
	@Test
	public void method1()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/selenium-webdriver/handling-iframes-using-selenium-webdriver/");
		driver.navigate().to("http://www.samsung.com/in/business/");
//		driver.get("http://toolsqa.com/selenium-webdriver/handling-iframes-using-selenium-webdriver/");
		driver.navigate().back();
		Dimension d=new Dimension(420,300);
		driver.manage().window().setSize(d); 
	}
	/*//@Test
	public static void main(String[] args) {
		//invokeApp("chrome","http://toolsqa.com/selenium-webdriver/handling-iframes-using-selenium-webdriver/");
		System.out.println("main method1 invoked");
		}*/

}
