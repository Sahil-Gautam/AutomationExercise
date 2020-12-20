package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.DataInitiation;
import utility.GenericMethods;

public class CheckOutPage extends GenericMethods{
	WebDriver driver;
	
	String proceedToCheckoutSummary = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']";
	String proceedToCheckoutAddress = "//button[@name='processAddress']";
	String proceedToCheckoutCarrier = "//button[@name='processCarrier']";
	String tcCheckbox ="//input[@type='checkbox']";
	String bankwireLink = "//a[@class='bankwire']";
	String chequeLink = "//a[@class='cheque']";
	String confirmationPaymentButton = "//p[@id='cart_navigation']//button";
	String messageAlert = "//p[@class='alert alert-success']";
	String backToOrdersLink = "//p[@class='cart_navigation exclusive']//a[@title='Back to orders']";
	String orderSummaryCheque = "//div[@class='box order-confirmation']";
	String orderSummaryBankwire = "//div[@class='box']";
	
	String successMessage = "Your order on My Store is complete.";
	public static String orderSummary;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void checkoutOrder() {
		waitForObject(10000, By.xpath(proceedToCheckoutSummary));
		driver.findElement(By.xpath(proceedToCheckoutSummary)).click();
		driver.findElement(By.xpath(proceedToCheckoutAddress)).click();
		driver.findElement(By.xpath(tcCheckbox)).click();
		driver.findElement(By.xpath(proceedToCheckoutCarrier)).click();
		captureScreenshot(driver);
		
	}
	
	public void makePayment() {
		if(DataInitiation.paymentType.equalsIgnoreCase("bankwire"))
			driver.findElement(By.xpath(bankwireLink)).click();
		else
			driver.findElement(By.xpath(chequeLink)).click();
		waitForObject(10000, By.xpath(confirmationPaymentButton));
		driver.findElement(By.xpath(confirmationPaymentButton)).click();
		//waitForObject(10000, By.xpath(messageAlert));
		if(DataInitiation.paymentType.equalsIgnoreCase("bankwire"))
			orderSummary = driver.findElement(By.xpath(orderSummaryBankwire)).getText();
		else
			orderSummary = driver.findElement(By.xpath(orderSummaryCheque)).getText();		
	}
	
	public void navigateToOrderHistory() {
		driver.findElement(By.xpath(backToOrdersLink)).click();
	}
}
