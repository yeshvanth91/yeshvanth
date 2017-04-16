package day5;

import wrappers.GenericWrappers;
public class Test extends GenericWrappers {
	@org.testng.annotations.Test
	public void methodA()
	{
		invokeApp("chrome","http://www.samsung.com/in/smartphones/galaxy-s7/more/");
		closeBrowser();
	}
	@org.testng.annotations.Test
	public void methodB()
	{
		invokeApp("chrome","http://www.samsung.com/in/");
		closeBrowser();
	}
	@org.testng.annotations.Test
	public void methodC()
	{
		invokeApp("chrome","http://www.samsung.com/in/");
		closeBrowser();
	}
	@org.testng.annotations.Test
	public void methodD()
	{
		invokeApp("chrome","http://www.samsung.com/in/");
		closeBrowser();
	}
	@org.testng.annotations.Test
	public void methodE()
	{
		invokeApp("chrome","http://www.samsung.com/in/");
		closeBrowser();
	}
	@org.testng.annotations.Test
	public void methodF()
	{
		invokeApp("chrome","http://www.samsung.com/in/");
		closeBrowser();
	}
}
