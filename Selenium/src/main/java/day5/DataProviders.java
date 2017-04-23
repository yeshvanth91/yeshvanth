package day5;
import org.testng.annotations.DataProvider;
public class DataProviders {
	@DataProvider(name="CreateLeadDataSource")
	public static Object[][] createLeadDataStation()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Yeshvanth";
		data[0][1]="Kannan";
		data[1][0]="Hemanth";
		data[1][1]="Vijayaraj";
		return data;
	}
	@DataProvider(name="EditLeadDataSource")
	public static Object[][] editLeadDataStation()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="17";
		data[0][1]="Yesh Solutions";
		return data;
	}
	@DataProvider(name="MergeLeadDataSource")
	public static Object[][] mergeLeadDataStation()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="17";
		data[0][1]="16";
		return data;
	}
	@DataProvider(name="DeactivateLeadDataSource")
	public static Object[][] deactivateLeadDataStation()
	{
		Object[][] data=new Object[1][1];
		data[0][0]="12";
		return data;
	}
	@DataProvider(name="testNG",parallel=true)
	public  Object[][] testNG()
	{
		Object[][] data=new Object[2][1];
		data[0][0]="https://www.irctc.co.in/eticketing/userSignUp.jsf";
		data[1][0]="http://testng.org/doc/documentation-main.html#parallel-running";
		return data;
	}
	@DataProvider(name="browser",parallel=true)
	public Object[][] setBrowserName()
	{
		Object[][] browser=new Object[2][1];
		browser[0][0]="chrome";
		browser[1][0]="firefox";
		return browser;
	}

}
