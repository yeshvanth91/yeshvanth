package day3;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://legacy.crystalcruises.com/");

		//System.out.println(driver.getTitle());

		driver.findElementByLinkText("GUEST CHECK-IN").click();

		//System.out.println(driver.getTitle());

		//Set<String> allWin = driver.getWindowHandles();//Return a set of window handle
		String parentWindow=driver.getWindowHandle();
		System.out.println("Switched to parent window");
		System.out.println(driver.getTitle());
		System.out.println(parentWindow.length());

		for (String childWindow : driver.getWindowHandles()) {

			driver.switchTo().window(childWindow);
			System.out.println(driver.getTitle());
			System.out.println("Switched to child window");
			System.out.println(childWindow.length());
			Thread.sleep(10000);
			//System.out.println(eachWin);
			//System.out.println(driver.getTitle());

		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		System.out.println("Switched again to parent window");
		//System.out.println(driver.getTitle());
		//driver.quit();//close all instance of browser
	}
}


