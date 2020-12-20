package stepDefiniton;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import application.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.ConfigFileReader;
import utility.DataInitiation;
import utility.DriverSetup;

public class LoginSteps {
	WebDriver driver;
	HomePage hp;
	ConfigFileReader cfr;
	DriverSetup ds;
	
	public LoginSteps() {
		cfr=new ConfigFileReader();
		try {
			DataInitiation.initializeTestData(cfr.getUser());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ds=new DriverSetup();
		ds.initializeDriver(cfr.getBrowser());
		driver=DriverSetup.getDriverInstance();
		hp = new HomePage(driver);
	}
	@Given("User is on Shopping website homepage")
	public void user_is_on_shopping_website_homepage() {
		driver.get(cfr.getAppURL());
		driver.manage().window().maximize();		
	}

	@When("User sign in by submitting valid email and password")
	public void loginToApplication() {
		hp.signIn();
	}
	@Then("User dashboard is displayed")
	public void loginVerification() {
		Assert.assertTrue(hp.loginSuccessValidation());
	}
}
