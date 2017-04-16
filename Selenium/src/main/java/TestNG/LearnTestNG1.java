package TestNG;
import org.testng.annotations.Test;


import day5.DataProviders;

import java.io.File;
import java.io.IOException;
import java.rmi.RMISecurityException;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.io.RuntimeIOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeGroups;
public class LearnTestNG1 {
	RemoteWebDriver driver;

	public void method1()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
			driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
			//driver.findElementById("name345");
			
			//driver.close();
	}
	@Test
	public void method3()
	{
		method1();
		System.out.println("m1");
		System.out.println("m4");
	}
	
	public void method4()
	{
		System.out.println("m4");
	}
	public void method5()
	{
		System.out.println("m5");
	}
	public void method6()
	{
		System.out.println("m6");
	}

	public void method2()
	{
		System.out.println("m2");
	}

	public void methodZ()
	{
		System.out.println("mz");
	}
	/*	@BeforeGroups(groups={"smoke","sanity"})
	public void method3()
	{

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Regression Test case executed");
		driver.close();

	}*/
}
