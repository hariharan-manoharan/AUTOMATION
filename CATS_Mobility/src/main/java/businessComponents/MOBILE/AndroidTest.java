/*package main.java.businessComponents.MOBILE;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import main.java.utils.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AndroidTest extends Utility {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Test");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "net.fulcrum.mobility");
		capabilities.setCapability("appActivity", "net.fulcrum.mobility.activities.LoginActivity");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	
	 * @Test public void Sum() {
	 * 
	 * // Click on DELETE/CLR button to clear result text box before running
	 * test.
	 * driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
	 * // Click on number 2 button. driver.findElement(By.name("2")).click();
	 * takeScreenshot(driver,"1"); // Click on + button.
	 * driver.findElement(By.name("+")).click(); takeScreenshot(driver,"2"); //
	 * Click on number 5 button. driver.findElement(By.name("5")).click();
	 * takeScreenshot(driver,"3"); // Click on = button.
	 * driver.findElement(By.name("=")).click(); takeScreenshot(driver,"4"); //
	 * Get result from result text box. String result =
	 * driver.findElement(By.className("android.widget.EditText")).getText();
	 * takeScreenshot(driver,"5"); System.out.println("Number sum result is : "
	 * + result);
	 * 
	 * }
	 

	public void waitCommand() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Test
	public void addConnection() {
		waitCommand();
		driver.findElement(By.name("Add Connection")).click();		
		waitCommand();
		takeScreenshot(driver, "Click - AddConnection");
		driver.findElement(By.id("connections_add")).click();
		waitCommand();
		takeScreenshot(driver, "Click - AddConnection Symbol");
		
		
		driver.findElement(By.id("connection_edit_name")).sendKeys("XO QA inv 1.1 pln 1.1");
		waitCommand();
		takeScreenshot(driver, "Enter Connection Name");
		driver.findElement(By.id("connection_edit_host")).sendKeys("services-uswest.skytap.com");
		waitCommand();
		takeScreenshot(driver, "Enter Host");
		driver.findElement(By.id("connection_edit_port")).sendKeys("23843");
		waitCommand();
		takeScreenshot(driver, "Enter Port");
		driver.findElement(By.id("connection_edit_ssl")).click();
		waitCommand();
		takeScreenshot(driver, "Enable SSL");
		driver.findElement(By.id("connections_save")).click();
		waitCommand();
		takeScreenshot(driver, "Save Connection");
		driver.findElement(By.id("action_bar_title")).click();			
		takeScreenshot(driver, "Click back button");
		
	}

		
	 @Test
	public void login() {
		waitCommand();
		driver.findElement(By.id("username")).sendKeys("catsadm");
		waitCommand();
		takeScreenshot(driver, "Enter - Username");
		driver.findElement(By.id("password")).sendKeys("catscats11");
		waitCommand();
		takeScreenshot(driver, "Enter - Password");
		driver.findElement(By.id("btn_connect")).click();
		waitCommand();
		takeScreenshot(driver, "Click Connect button");
		
	}
	 

	@AfterTest
	public void End() {
		driver.quit();
	}
}
*/