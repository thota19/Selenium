package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {
	
	private String username;
	private String password;
	private boolean isRedirectedTodashboard;
	private String errorMessage;
	private boolean onLoginPage;
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		onLoginPage = true;
		System.out.println("Iam on the login page\n");
	}
	@Given("I have a valid account")
	public void i_have_a_valid_account() {
		System.out.println("I have a valid account\n");
		
	}
	@Given("I have an account")
	public void i_have_a_account() {
		System.out.println("I have an account\n");
		
	}
		
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		username="validUser";
		password="validPassword";
		isRedirectedTodashboard = true; 
	
	}
	
	@When("I enter invalid credentials")
	public void i_enter_invalid_credentials() {
		username="invalidUser";
		password="wrongPassword";
		errorMessage = "invalid credentials";
	}
	
	@When ("I enter the {string} and {string}")
	public void I_enter_the_username_and_password(String usernameInput,String passwordInput) {
		username= usernameInput;
		password=passwordInput;
		
		if(username.equalsIgnoreCase("invalidUser") || password.equalsIgnoreCase("wrongPass")) {
			errorMessage="Invalid credentials";
		}else {
			isRedirectedTodashboard=true;
		}	
	}
	
	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
		//assertTrue(isRedirectedTodashboard);
		
	}
	
	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		//assertNotNull(errorMessage);
		//assertEquals("invalid credentials", errorMessage.toLowerCase());
		
	}
	@Then("I should remain on the login page")
	public void i_should_remain_on_the_login_page() {
		//assertTrue(onLoginPage);
		//assertNull(isRedirectedTodashboard);
	}
	@Then("I should not see any error message")
	public void i_should_not_see_any_error_message() {
		//assertNull("Error message should not be present", errorMessage);
	}
	
	
			
}
