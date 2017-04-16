package day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import wrappers.GenericWrappers;
public class SelectDropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://output.jsbin.com/osebed/2");
		WebElement ele=driver.findElementById("fruits");
		//System.out.println(ele);
		Select sel=new Select(ele);
		if(sel.isMultiple()){
			sel.selectByVisibleText("Orange");
			sel.selectByVisibleText("Grape");
			//System.out.println(ele.getText());
			System.out.println(sel.getFirstSelectedOption().getAttribute("option"));
			List<WebElement> allSelectedOptions=sel.getAllSelectedOptions();
			int i=0;
			for(WebElement options:allSelectedOptions)
			{
				
				String value=allSelectedOptions.get(i).getText();
				System.out.println(value);
				i++;
			}
			sel.deselectAll();
		}
	}

}

