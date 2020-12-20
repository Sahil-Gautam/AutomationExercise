package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.DataInitiation;
import utility.GenericMethods;

public class PersonalInfoPage extends GenericMethods{
	WebDriver driver;
	
	String firstNameTextBox = "//input[@name='firstname']";
	String currentPwdTextBox = "//input[@name='old_passwd']";
	String saveButton= "//button[@name='submitIdentity']";
	String messageAlert = "//p[@class='alert alert-success']";
	
	String successMessage = "Your personal information has been successfully updated.";
	
	public PersonalInfoPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void submitFirstName() {
		waitForObject(10000, By.xpath(firstNameTextBox));
		driver.findElement(By.xpath(firstNameTextBox)).clear();
		driver.findElement(By.xpath(firstNameTextBox)).sendKeys(DataInitiation.firstName);
		driver.findElement(By.xpath(currentPwdTextBox)).sendKeys(DataInitiation.password);
		captureScreenshot(driver);
		driver.findElement(By.xpath(saveButton)).click();
		captureScreenshot(driver);
	}
	
	public String getUpdateMessage() {
		waitForObject(10000, By.xpath(messageAlert));
		return driver.findElement(By.xpath(messageAlert)).getText();
	}
}
