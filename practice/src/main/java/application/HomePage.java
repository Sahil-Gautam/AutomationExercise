package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.DataInitiation;
import utility.GenericMethods;

public class HomePage extends GenericMethods{
	WebDriver driver;
	
	String signInLink = "a.login";
	String emailSignInTxtBox ="input#email";
	String passwordSignInTxtBx ="input#passwd";
	String signInButton ="button#SubmitLogin";
	String logoutLink ="a.logout";
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void signIn() {
		captureScreenshot(driver);
		driver.findElement(By.cssSelector(signInLink)).click();
		waitForObject(10000, By.cssSelector(emailSignInTxtBox));
		driver.findElement(By.cssSelector(emailSignInTxtBox)).sendKeys(DataInitiation.email);
		driver.findElement(By.cssSelector(passwordSignInTxtBx)).sendKeys(DataInitiation.password);
		captureScreenshot(driver);
		driver.findElement(By.cssSelector(signInButton)).click();
		captureScreenshot(driver);
	}
	
	public boolean loginSuccessValidation() {
		return driver.findElement(By.cssSelector(logoutLink)).isDisplayed();
	}
}
