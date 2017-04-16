package TestNG;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkLinks {

	private WebDriver driver;
	private int invalidLinksCount;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.samsung.com/uk/info/contactus/");
	}

	@Test
	public void validateInvalidLinks() {

		try {
			invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By
					.tagName("a"));
			List<String> attributeList=new LinkedList<String>();
			System.out.println("Total no. of links are "
					+ anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					attributeList.add(url);
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(url);
					if (url != null && !url.contains("javascript")) {
						try {
							HttpResponse response = client.execute(request);
							// verifying response code and The HttpStatus should be 200 if not,
							// increment invalid link count
							////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
							if (response.getStatusLine().getStatusCode() != 200)
							{
								System.out.println("Invalid link   "+anchorTagElement.getText()+"   "+response.getStatusLine().getStatusCode()+"  "+anchorTagElement.getAttribute("href"));
								invalidLinksCount++;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Invalid  "+anchorTagElement.getText()+anchorTagElement.getAttribute("href"));
						invalidLinksCount++;
					}
				}
			}

			System.out.println("Total no. of invalid links are "
					+ invalidLinksCount);
			System.out.println(attributeList);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null)
			driver.close();
	}

}
