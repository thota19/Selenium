package parallellevelexecutions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class ClasssA {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void loadBrowser() {
		
		//chrome launch 
		driver=new ChromeDriver();
		
		//navigate to google
		driver.get("https://www.google.com");
	}
	
	
	@Test
	
	public void github() {
		
		//Navigate to Github
		
		driver.get("https://www.github.com");
	}
	@Test
	public void youtube() {
	
		//Navigate to Youtube
		
		driver.get("https://www.youtube.com");
	}
	
	//chrome driver closed
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
}
