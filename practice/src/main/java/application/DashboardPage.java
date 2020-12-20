package application;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.DataInitiation;
import utility.GenericMethods;

public class DashboardPage extends GenericMethods{
	WebDriver driver;
	
	String logoImage = "//img[@class='logo img-responsive']";
	String menuList = "//ul[@class='sf-menu clearfix menu-content*']/li";
	String addToCartLink = "//a[@title='Add to cart']";
	String proceedToCheckoutLink = "//a[@title='Proceed to checkout']";
	String personalInformationLink = "//ul[@class='myaccount-link-list']/li//a[@title='Information']";
	String productImage = "//a[@class='product_img_link']";
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void selectMenuOption(String option) {
		String menuLink="//a[@title='"+option+"']";
		List<WebElement> menuElements = driver.findElements(By.xpath(menuLink));
		for(int i=0;i<menuElements.size();i++) {
			if(menuElements.get(i).getText().equalsIgnoreCase(option)) {
				menuElements.get(i).click();
			}
		}
	}
	public void navigateToProductSection() {
		waitForObject(10000, By.xpath(logoImage));
		selectMenuOption(DataInitiation.product);
		captureScreenshot(driver);
	}
	public void addTshirt() {		
		mouseHover(By.xpath(productImage));
		captureScreenshot(driver);
		driver.findElement(By.xpath(addToCartLink)).click();
		waitForObject(5000, By.xpath(proceedToCheckoutLink));
		captureScreenshot(driver);
		driver.findElement(By.xpath(proceedToCheckoutLink)).click();
		captureScreenshot(driver);
	}
	
	public void goToPersonalInfo() {
		waitForObject(10000, By.xpath(personalInformationLink));
		driver.findElement(By.xpath(personalInformationLink)).click();
		captureScreenshot(driver);
	}
	
}
