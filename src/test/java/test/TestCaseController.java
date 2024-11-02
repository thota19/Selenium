package test;
import org.testng.annotations.Test;

import proRunner.RunCucumberTest;
import stepDefinitions.LoginSteps;

public class TestCaseController extends LoginSteps {
    @Test()
    public void OfferShift() throws InterruptedException, ClassNotFoundException {
    	
    	String FeatureFolder="myFeatures";
		String Feature= "login.feature";
		RunCucumberTest.cucumber_Runner(FeatureFolder,Feature);
		
    	
    }
 
}
