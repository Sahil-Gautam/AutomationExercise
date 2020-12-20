package stepDefiniton;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import application.DashboardPage;
import application.PersonalInfoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.DriverSetup;

public class PersonalInfoSteps {
	WebDriver driver;
	DashboardPage dp;
	PersonalInfoPage pi;
	
	public PersonalInfoSteps() {
		driver = DriverSetup.getDriverInstance();
		dp = new DashboardPage(driver);
		pi = new PersonalInfoPage(driver);
	}
	@Given("User navigate to Personal Information page in My Account section")
	public void navigateToPersonalInfoSection() {
	    dp.goToPersonalInfo();
	}
	@When("User update First Name under Personal Information")
	public void updateFirstName() {
	    pi.submitFirstName();	    
	}
	@Then("Successful message is displayed")
	public void successful_message_is_displayed() {
	    Assert.assertEquals(pi.getUpdateMessage(),"Your personal information has been successfully updated.");
	}
}
