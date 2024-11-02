package eightlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Locators {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set up WebDriver 
      
        driver = new ChromeDriver();
        
        driver.get("https://google.com"); 
    }

    @Test
    public void testById() {
    	
        // Locate element by ID
        WebElement elementById = driver.findElement(By.id("hplogo"));
        System.out.println("Found element by ID: " + elementById);
    }

    @Test
    public void testByName() {
        // Locate element by Name
        WebElement elementByName = driver.findElement(By.name("q"));
        System.out.println("Found element by Name: " + elementByName);
    }

    @Test
    public void testByClassName() {
        // Locate element by Class Name
        WebElement elementByClassName = driver.findElement(By.className("csi"));
        System.out.println("Found element by Class Name: " + elementByClassName);
    }

    @Test
    public void testByTagName() {
        // Locate element by Tag Name
        WebElement elementByTagName = driver.findElement(By.tagName("span"));
        System.out.println("Found element by Tag Name: " + elementByTagName);
    }

    @Test
    public void testByLinkText() {
        // Locate element by Link Text
        WebElement elementByLinkText = driver.findElement(By.linkText("Gmail"));
        System.out.println("Found element by Link Text: " + elementByLinkText);
    }

    @Test
    public void testByPartialLinkText() {
        // Locate element by Partial Link Text
        WebElement elementByPartialLinkText = driver.findElement(By.partialLinkText("Ima"));
        System.out.println("Found element by Partial Link Text: " + elementByPartialLinkText);
    }

    @Test
    public void testByCssSelector() {
        // Locate element by CSS Selector
        WebElement elementByCssSelector = driver.findElement(By.cssSelector("svg[class='gb_E']"));
        System.out.println("Found element by CSS Selector: " + elementByCssSelector);
    }

    @Test
    public void testByXPath() {
        // Locate element by XPath
        WebElement elementByXPath = driver.findElement(By.xpath("//input[@value='Google Search']"));
        System.out.println("Found element by XPath: " + elementByXPath);
    }

    @AfterMethod
    public void tearDown() {
        // Close browser after each test
       driver.close();
    }
}