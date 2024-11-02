package staticAndNonStaticMethodsWithWebDriver;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NumberChecking {

	public static void main(String[] args) throws InterruptedException {
		
			
			
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter a number");
		
		int number = Integer.parseInt(sc.nextLine());
		
		//accessing static method
		String range = staticAndNonStaticMethods.numberCheckingRange(number);
		System.out.println("Number is more than 100 : "+range);
		
		//accesing non static methods
		staticAndNonStaticMethods obj=new staticAndNonStaticMethods();
		String postiveOrNeagtiveNumber = obj.postiveNumberCheckingRange(number);
		System.out.println("Number is postive : "+postiveOrNeagtiveNumber);
		
			
			
		
	
	}

}
