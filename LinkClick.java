package day5;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wrappers.GenericWrappers;
public class LinkClick extends GenericWrappers {
	public static void main(String[] args) throws AWTException{
		RemoteWebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 30);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_W);
		driver.get("http://www.samsung.com/us/common/sitemap.html");
		driver.manage().window().maximize();
		Dimension parentWindowSize=driver.manage().window().getSize();
		System.out.println("Parent win size"+parentWindowSize);
		List<WebElement> prodLinks=driver.findElementsByXPath("//div[@class='columns_left']//div[@class='column1']//ul[1]//li//a");
		int i=1;
		try {
			for(WebElement clickAllProdLinks:prodLinks)
			{
				String getLinkText=wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("((//div[@class='columns_left']//div[@class='column1']//ul[1]//a)["+i+"])"))).getText();
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("((//div[@class='columns_left']//div[@class='column1']//ul[1]//a)["+i+"])"))).click();
				i++;
				Set<String> winHandles=driver.getWindowHandles();
				int winSize=driver.getWindowHandles().size();
				if(winSize>1)
				{
					for(String winHandle:winHandles)
					{
						driver.switchTo().window(winHandle);
					}
					if(parentWindowSize.equals(driver.manage().window().getSize()))
					{
						driver.close();
						System.out.println("Link opens in a new tab");
					}
					else
					{
						System.out.println("Opened Window size"+driver.manage().window().getSize());
						driver.close();
						System.out.println("Link opens in a new window");
					}
				}
				else
				{
					System.out.println(getLinkText+"   opened in a same tab");
					driver.navigate().back();

				}
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}