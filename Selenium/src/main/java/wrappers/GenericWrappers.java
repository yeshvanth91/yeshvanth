package wrappers;

import java.util.List;
/*import java.util.NoSuchElementException;*/
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeGroups;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
	/*WebDriver driver1=new FirefoxDriver();*/
	WebDriverWait wait;
	static int i=1;
	public void invokeApp(String browser, String url){
		try {
	/*		driver1.findElement(By.id("id")).getClass();*/
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//Implicit Wait
			wait = new WebDriverWait(driver, 30);//Explicit Wait
			System.out.println("The Browser "+ browser +" launched");
		} 
		catch (WebDriverException e) {
			System.err.println("Browser is not launched" + browser);
		}
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		}
		finally{
			takeSnap();
		}

	}

	public void enterById(String idValue, String data){

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue))).clear();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue))).sendKeys(data);
			System.out.println("The Text Field "+ idValue +" is entered with data "+ data );
		} catch (NoSuchElementException e) {
			System.err.println("The value" + idValue + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();

		}
	}

	public void enterByName(String nameValue, String data){
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue))).clear();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue))).sendKeys(data);
			System.out.println("The Text Field "+ nameValue +" is entered with data "+ data );
		} catch (NoSuchElementException e) {
			System.err.println("The value" + nameValue + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();

		}
	}


	public void enterByXpath(String xpathValue, String data) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).clear();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).sendKeys(data);
			System.out.println("The Text Field "+ xpathValue +" is entered with data "+ data );
		} catch (NoSuchElementException e) {
			System.err.println("The value" + xpathValue + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();

		}
	}

	public void enterByCSSSelector(String CssSelectorValue, String data) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CssSelectorValue))).clear();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CssSelectorValue))).sendKeys(data);
			System.out.println("The Text Field "+ CssSelectorValue +" is entered with data "+ data );
		} catch (NoSuchElementException e) {
			System.err.println("The value" + CssSelectorValue + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();

		}
	}
	public void enterByClassName(String classNameValue, String data){
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classNameValue))).clear();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classNameValue))).sendKeys(data);
			System.out.println("The Text Field "+ classNameValue +" is entered with data "+ data );
		} catch (NoSuchElementException e) {
			System.err.println("The value" + classNameValue + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();

		}
	}
	public boolean verifyTitle(String title) {
		boolean flag = false;
		try {
			if(driver.getTitle().equals(title))
				flag=true;
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		return flag;
	}

	public void verifyTextById(String id, String text) {
		try {
			//if(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id))).getText().equals(text))
			if(getTextById(id).equals(text))
				System.out.println(text+" "+ "matches for the id"+" "+id);
			else
				System.out.println(text +" "+"not matched for the id"+" "+id);
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 

	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			//if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText().equals(text))
			if(getTextByXpath(xpath).equals(text))
				System.out.println(text+" "+ "exactly matches for the xpath"+" "+xpath);
			else
				System.out.println(text +" "+"not exactly matched for the xpath"+" "+xpath);
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			//if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText().contains(text))
			if(getTextByXpath(xpath).contains(text))
				System.out.println(text+" partially/fuly matched with the xpath "+xpath);
			else
				System.out.println(text +"partially/fully not matched with the given xpath"+xpath);
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		}

	}

	public void clickById(String id)  {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
			System.out.println("The button "+ id + "is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + id + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();
		}
	}

	public void clickByClassName(String classVal){
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.className(classVal))).click();
			System.out.println("The button "+ classVal + "is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + classVal + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();
		}
	}

	public void clickByName(String name)  {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(name))).click();
			System.out.println("The button "+ name + "is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + name + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();
		}

	}

	public void clickByLink(String LinkText){
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(LinkText))).click();
			System.out.println("The button "+ LinkText + "is clicked");
		} 
		catch (NoSuchElementException e) {
			System.err.println("The value" + LinkText + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}
	}
	public void clickByPartialLinkText(String partialLinkText)  {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(partialLinkText))).click();
			System.out.println("The button "+ partialLinkText + "is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + partialLinkText + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String LinkText)  {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(LinkText))).click();
			System.out.println("The button "+ LinkText + "is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + LinkText + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
	}

	public void clickByXpath(String xpathVal) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal))).click();
			System.out.println("The button "+ xpathVal + "is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + xpathVal + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} finally {
			takeSnap();
		}

	}

	public void clickByXpathNoSnap(String xpathVal)  {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal))).click();
			System.out.println("The button "+ xpathVal + "is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + xpathVal + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
	}


	public String getTextById(String idVal) {
		String text=" ";
		try {
			text=driver.findElementById(idVal).getText();
		} 
		catch (NoSuchElementException e) {
			System.err.println("The value" + idVal + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		return text;
	}

	public String getTextByXpath(String xpathVal) {
		String text=" ";
		try {
			text=driver.findElementByXPath(xpathVal).getText();
		} 
		catch (NoSuchElementException e) {
			System.err.println("The value" + xpathVal + " is not found");
		} 
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		return text;
	}
	public String getTextByLink(String linkVal) {
		String text=" ";
		try {
			text=driver.findElementByLinkText(linkVal).getText();
		}
		catch (NoSuchElementException e) {
			System.err.println("The value" + linkVal + " is not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		return text;
	}

	public void selectVisibileTextById(String id, String value)
	{
		try {
			WebElement sel=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
			Select dropDown=new Select(sel);
			dropDown.selectByVisibleText(value);
			System.out.println("Drop Down by visible text"+value+" "+" selected");
		} 
		catch (NoSuchElementException e) {
			System.err.println("The value" + id + " is not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}

	}
	public void selectTextByValue(String id, String value) {
		try {
			WebElement sel=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
			Select dropDown=new Select(sel);
			dropDown.selectByValue(value);
			System.out.println("Drop Down by value"+value+" selected");
		} 	
		catch (NoSuchElementException e) {
			System.err.println("The value" + id + " is not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}

	}

	public void selectIndexById(String id, int value) throws Exception {
		try {
			WebElement sel=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
			Select dropDown=new Select(sel);
			List<WebElement> allOptions=dropDown.getOptions();
			int size=allOptions.size();
			if(value<size)
			{
				dropDown.selectByIndex(value-1);
				System.out.println("Drop Down by Index value"+value+" selected");
				takeSnap();
			}
		}
		catch (NoSuchElementException e) {
			System.err.println("The value" + id + " is not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}

	}
	public void selectIndexByContainsTextById(String id,String containsText) throws Exception {
		try {
			WebElement sel=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
			Select dropDown=new Select(sel);
			List<WebElement> allOptions=dropDown.getOptions();
			int  size=allOptions.size();
			int count=-1;
			for(WebElement options:allOptions)
			{
				count++;
				if(options.getText().contains(containsText))
				{
					dropDown.selectByIndex(count);
					System.out.println("Drop down that contains text"+containsText+"selected");
					break;
				}
				if((count+1)==size)
					System.out.println("No match found for" +containsText);
			}
		} 
		catch (NoSuchElementException e) {
			System.err.println("The value" + id + " is not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}


	}

	public void switchToParentWindow() {
		try {
			for(String winHandle : driver.getWindowHandles())
			{
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By) (driver.switchTo().window(winHandle))));
				driver.switchTo().window(winHandle);
				System.out.println("Switched back to parent window");
				break;
			}
		} 	
		catch (NoSuchWindowException e) {
			System.err.println("Window not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}

	}
	public void switch_To_NTH_Window(int toWindowN){
		try{

			Set<String> winHandles=driver.getWindowHandles();
			int winSize=winHandles.size();
			System.out.println(winSize);
			int count=0;
			if(toWindowN<=winSize)
			{
				for(String winHandle : driver.getWindowHandles())
				{
					count++;
					if(count==toWindowN)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By) (driver.switchTo().window(winHandle))));
						driver.switchTo().window(winHandle);
						System.out.println("Window switched to"+toWindowN+" nd window"+" "+driver.getTitle());
					}
				}
			}
			else
			{
				System.out.println("No such window exist");
			}
		}
		catch (NoSuchWindowException e) {
			System.err.println("Window not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}
	}



	public void switchToLastWindow() {
		try {
			String parentWindow=driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles()){
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By) (driver.switchTo().window(winHandle))));
				driver.switchTo().window(winHandle);
				System.out.println("Switched back to latest window");
			}
		} 
		catch (NoSuchWindowException e) {
			System.err.println("Window not found");
		} 

		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		} 
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		} 
		finally {
			takeSnap();
		}

	}
	public void switchToFrame()
	{
		
	}

	public void acceptAlert(){
		try {
			if(wait.until(ExpectedConditions.alertIsPresent())!=null);
			{
				Alert alt=driver.switchTo().alert();
				alt.accept();
			}
		} 
		catch (NoAlertPresentException e) {
			System.err.println("No Alert present");
		}
		catch (WebDriverException e) {
			System.err.println("Other web driver exception occured"+e.getMessage());
		}
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		}

	}

	public void dismissAlert() {
		try {
			if(wait.until(ExpectedConditions.alertIsPresent())!=null);
			{
				Alert alt=driver.switchTo().alert();
				alt.dismiss();
			}
		} 
		catch (NoAlertPresentException e) {
			System.err.println("No Alert present");
		}
		catch (WebDriverException e) {
			System.err.println("No Alert present");
		}
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		}

	}

	public String getAlertText() {
		String alertText="";
		try {
			if(wait.until(ExpectedConditions.alertIsPresent())!=null);
			{
			Alert alt=driver.switchTo().alert();
			alertText=alt.getText();
			}
		}
		catch (NoAlertPresentException e) {
			System.err.println("No Alert present");
		}
		catch (WebDriverException e) {
			System.err.println("No Alert present");
		}
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		}
		return alertText;

	}
	public void verifyAlertText(String text) {
		if(getAlertText().equals(text))
			System.out.println("Alert Text exactly matches");
		else
			System.out.println("Alet text not matches");

	}

	public long takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dec = new File("./snaps/snap/"+this.getClass().getName() +i+ ".jpg");
		try {
			FileUtils.copyFile(src, dec);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("Unknown exception occured" + e.getMessage());
		}
		i++;
		return 0;
	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("The Browser Closed");
		} 
		catch(NoSuchWindowException e) {
			System.err.println("window closed" +e.getMessage());
		}
		catch (WebDriverException e) {
			System.err.println("Unknown web driver Exception" +e.getMessage());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Unknown exception occoured" + e.getMessage());
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("The Browser Closed");
		} 
		catch(NoSuchWindowException e) {
			System.err.println("single/multiple window closed" +e.getMessage());
		}
		catch (WebDriverException e) {
			System.err.println("Unknow web driver Exception" +e.getMessage());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Unknown exception occoured" + e.getMessage());
		}
	}

}
