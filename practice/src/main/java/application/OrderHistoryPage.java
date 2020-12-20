package application;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.GenericMethods;

public class OrderHistoryPage extends GenericMethods{
	WebDriver driver;
	
	String orderReference = "//table[@id='order-list']/tbody/tr/td[1]";
	
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean orderVerification() {
		List<WebElement> refList = driver.findElements(By.xpath(orderReference));
		int k=0;
		for(int i=0;i<refList.size();i++) {
			if(CheckOutPage.orderSummary.contains(refList.get(i).getText())) {
				System.out.println("Order placed is present in Order History");
				k=1;
				break;
			}
		}
		if(k==0) {
			System.out.println("Order placed is not present in Order History");
			return false;
		}else
			return true;
	}
}
