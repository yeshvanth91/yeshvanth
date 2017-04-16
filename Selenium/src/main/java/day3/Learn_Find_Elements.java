package day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Learn_Find_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://legacy.crystalcruises.com/Calendar.aspx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> allquote=driver.findElementsByLinkText("Get-a-Quote");
		System.out.println(allquote.size());
		System.out.println(allquote.get(1).getText());
		allquote.get(1).click();


	}

}
