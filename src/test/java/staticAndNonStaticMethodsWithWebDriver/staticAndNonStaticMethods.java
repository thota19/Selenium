package staticAndNonStaticMethodsWithWebDriver;


public class staticAndNonStaticMethods {
	
	// Static Method
	public static String numberCheckingRange(int number) {
		if(number>100) {
			return "yes";
		}
		else {
			return "No";
		}
	}
	
	// Non - Static Method
	public String  postiveNumberCheckingRange(int number) {
		if(number>0) {
			return "yes";
		}
		else {
			return "No";
		}
	}
	
	
}
