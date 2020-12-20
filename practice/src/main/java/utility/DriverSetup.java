package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {
	private static WebDriver driver;

	public static WebDriver getDriverInstance() {
		return driver;
	}

	public void initializeDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else
			driver = new FirefoxDriver();		
	}
}
