package pavan.com.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
  public static void main(String[] args) {
	  
    System.out.println("Hello World!");
    System.out.println("pavan kalyan");
 //  WebDriverManager.chromedriver().setup();
   WebDriver wd=new ChromeDriver();
   wd.get("https://www.google.com");
   wd.findElement(By.linkText("About")).click();
   wd.findElement(By.partialLinkText("Gma")).click();
  // System.out.println(wd.getTitle());
   wd.manage().window().maximize();
   wd.manage().window().fullscreen();
  // wd.close();
   }}