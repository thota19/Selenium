package pavan.com.second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
  public static void main(String[] args) {
    
	 // WebDriverManager.chromedriver().setup();
	  
	  WebDriver wd=new ChromeDriver();
	  wd.get("https://www.youtube.com");
	  wd.findElement(By.linkText("Shorts")).click();

	  wd.manage().window().fullscreen();
	  wd.close();
	  
  }
}
