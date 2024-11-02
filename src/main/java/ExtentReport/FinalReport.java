package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class FinalReport {
	private static ExtentReports extent;
	private static ExtentTest test;
	
	public static void main(String[] args) throws ClassNotFoundException {
		String ExtentReportPath= System.getProperty("user.dir")+"/src/test/resources/extentreports/";
	String reportName = "ExtentReport.html";
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(ExtentReportPath+reportName);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest feature = extent.createTest(Feature.class, "Setting the chrome");
		ExtentTest scenario = feature.createNode(Scenario.class, "Launching the chrome");
		scenario.createNode(new GherkinKeyword("Given"), "Launch chrome").pass("User has successfully Launched");
		scenario.createNode(new GherkinKeyword("When"), "Entered credentials").pass("I enter valid credentials");
		scenario.createNode(new GherkinKeyword("Then"), "Redirect to dashboard").pass("I should be redirected to the dashboard");
		
		
		feature = extent.createTest(Feature.class, "Unsuccessful login attempts");
		ExtentTest outline = feature.createNode(Scenario.class, "Login attempts");
		scenario.createNode(new GherkinKeyword("Given"), "I am on the login page").pass("User has successfully Launched");
		scenario.createNode(new GherkinKeyword("When"), "Entered credentials").pass("I entered valid credentials");
		scenario.createNode(new GherkinKeyword("Then"), "error message").pass("I should see an error message");
		
		
		extent.flush();
	}
}
