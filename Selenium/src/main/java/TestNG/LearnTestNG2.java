package TestNG;
import org.testng.annotations.Test;


import day5.DataProviders;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeGroups;
public class LearnTestNG2 extends LearnTestNG1 {
	@BeforeSuite
	public void methodA()
	{
		System.out.println("Sub class before suite");
	}
	@BeforeTest
	public void methodB()
	{
		System.out.println("Sub class before test");
	}
	@Test
	public void methodC()
	{
		System.out.println("Sub class test");
	}
	@AfterTest
	public void methodD()
	{
		System.out.println("Sub class  after test");
	}
	@AfterSuite
	public void methodE()
	{
		System.out.println("Sub class after suite");
	}/*
	@Test(groups={"sanity"})
	public void Amethod2(String URL)
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("smoke Test case executed");
		driver.close();
	}*/
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
