package utility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	WebDriver driver;
	Actions actions;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForObject(long milliseconds, By by) {
		WebDriverWait wait = new WebDriverWait(driver, milliseconds);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	}

	public void captureScreenshot(WebDriver driver) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenshot, new File(
					System.getProperty("user.dir") + "\\screenshot\\Screenshot" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean doesWebElementExist(long milliseconds, By by) {
		waitForObject(milliseconds, by);
		List<WebElement> dynamicElement = driver.findElements(by);
		if (dynamicElement.size() != 0)
			return true;
		else
			return false;
	}
	
	public void mouseHover(By by) {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(by)).perform();
	}
}
