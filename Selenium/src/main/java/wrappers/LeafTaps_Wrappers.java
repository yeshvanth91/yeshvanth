package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class LeafTaps_Wrappers extends GenericWrappers 
{

	//@BeforeMethod
	@BeforeMethod(groups={"common"})
	@Parameters({"url","username","password"})
	public void login_Taps(String url,String uname,String password)
	{
		invokeApp("chrome",url);
		enterById("username",uname);
		enterById("password",password);
		clickByClassName("decorativeSubmit");
	}
	//@AfterMethod
	@AfterMethod(groups={"common"})
	public void closeOneBrowser()
	{
		closeBrowser();
	}

}
