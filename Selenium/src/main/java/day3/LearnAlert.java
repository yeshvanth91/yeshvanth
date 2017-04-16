package day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.findElementByLinkText("Check Availability").click();
		Alert alt=driver.switchTo().alert();
		Thread.sleep(10000);
		System.out.println(alt.getText());
		alt.accept();
		driver.findElementById("userRegistrationForm:userName").sendKeys("TestLeaf");



	}

}
