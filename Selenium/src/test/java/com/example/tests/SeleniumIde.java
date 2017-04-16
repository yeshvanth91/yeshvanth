package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIde {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://testleaf.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFirstTestcase() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("h5.wp-categories-title")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("yeshvanth@gmail.com");
    driver.findElement(By.xpath("//input[@value='Append ']")).clear();
    driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Appended text");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("values");
    driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("");
    String emailobj = driver.findElement(By.id("email")).getAttribute("value");
    String appendobj = driver.findElement(By.xpath("//input[@value='Append ']")).getAttribute("value");
    System.out.println(emailobj);
    try {
      assertEquals(emailobj, driver.findElement(By.id("email")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertEquals(appendobj, driver.findElement(By.id("email")).getAttribute("value"));
    try {
      assertEquals(emailobj, driver.findElement(By.id("email")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
