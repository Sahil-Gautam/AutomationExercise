package stepDefiniton;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import application.CheckOutPage;
import application.DashboardPage;
import application.OrderHistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.DriverSetup;

public class OrderSteps {
	WebDriver driver;
	DashboardPage dp;
	CheckOutPage co;
	OrderHistoryPage oh;
	
	public OrderSteps() {
		driver = DriverSetup.getDriverInstance();
		dp = new DashboardPage(driver);
		co = new CheckOutPage(driver);
		oh = new OrderHistoryPage(driver);
	}
	@Given("User navigate to T-Shirt section")
	public void goToTShirtSection() {
	    dp.navigateToProductSection();
	}
	@Given("Add T-shirt in the cart")
	public void checkoutTshirtOrder() {
	   dp.addTshirt();
	   co.checkoutOrder();
	}
	@When("User make payment for selected T-shirt")
	public void makePaymentForOrder() {
	    co.makePayment();	    
	}
	@When("Navigate to order history page")
	public void navigate_to_order_history_page() {
	    co.navigateToOrderHistory();
	}
	@Then("Placed order is visible in order history")
	public void placed_order_is_visible_in_order_history() {
		Assert.assertTrue(oh.orderVerification());
		driver.close();
	}
}
