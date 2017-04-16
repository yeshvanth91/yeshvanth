package day3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		driver.manage().window().maximize();
		int noOfIframes=driver.findElementsByTagName("iframe").size();
		System.out.println(noOfIframes);
		/*driver.switchTo().frame(0);
		driver.findElementByName("firstname").sendKeys("yeshvanth");
		driver.switchTo().defaultContent();*/
		for(int i=0;i<2;i++)
		{
		driver.switchTo().frame(i);
		System.out.println(driver.findElementsByLinkText("Tab 3").size());
		driver.switchTo().defaultContent();
		}
		/*driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElementByName("firstname").clear();*/
		/*driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_youtubeiframe");
		Thread.sleep(4000);
		WebElement frameXpath=driver.findElementByXPath("//iframe[@src='https://www.youtube.com/embed/XGSy3_Czz8k?controls=0']");
		driver.switchTo().frame(frameXpath);
		driver.findElementByClassName("ytp-large-play-button ytp-button").click();*/
	}

}
