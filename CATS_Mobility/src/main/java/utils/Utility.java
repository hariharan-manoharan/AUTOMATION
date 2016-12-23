package main.java.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;


import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import main.java.reporting.HtmlReport;
import main.java.testDataAccess.DataTable;

public class Utility {

	@SuppressWarnings("rawtypes")
	protected AndroidDriver driver;
	protected ExtentTest test;
	protected DataTable dataTable;
	public static Properties properties;
	public static Connection connection;
	public static LinkedHashMap<String,String> environmentVariables;

	@SuppressWarnings("rawtypes")
	public Utility(ExtentTest test, AndroidDriver driver, DataTable dataTable) {
		this.test = test;
		this.driver = driver;
		this.dataTable = dataTable;
	}

	
	public Utility() {
		
	}
		

	@SuppressWarnings("static-access")
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	@SuppressWarnings("static-access")
	public void setEnvironmentVariables(LinkedHashMap<String,String> environmentVariables) {
		this.environmentVariables = environmentVariables;
	}

	public void takeScreenshot(String reportName) {

		String screenshotName = getCurrentFormattedTime();

		File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File("./Results/" + HtmlReport.reportFolderName + "/" + screenshotName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, reportName,
				"<b>Screenshot: <b>" + test.addScreenCapture("./" + screenshotName + ".png"));

	}
	
	
	public void takeScreenshotWebView(Set<String> contextHandles, String reportName) {
		
		switchContext(contextHandles,"NATIVE");	
		
		String screenshotName = getCurrentFormattedTime();

		File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File("./Results/" + HtmlReport.reportFolderName + "/" + screenshotName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, reportName,
				"<b>Screenshot: <b>" + test.addScreenCapture("./" + screenshotName + ".png"));

	}


	public void report(String reportName, LogStatus status) {

		test.log(status, reportName);

	}

	public static String getCurrentFormattedTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	public void waitCommand(final By by) throws TimeoutException, NoSuchElementException{

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(this.driver);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.withTimeout(100, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(by);
				if (element != null) {
					return true;
				}
				return false;
			}
		};
		wait.until(function);
	
	}
	
	public boolean isObjectPresent(final By by, String objectName) throws TimeoutException, NoSuchElementException{

		
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(this.driver);
			wait.pollingEvery(5, TimeUnit.SECONDS);
			wait.withTimeout(100, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);

			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {

				@Override
				public Boolean apply(WebDriver arg0) {
					WebElement element = arg0.findElement(by);
					if (element != null) {
						return true;
					}
					return false;
				}
			};
			test.log(LogStatus.PASS, "Object - " + objectName + " is present", "");
			return wait.until(function);
		
	}

	public void fluentPredicateWait(final By by) {
		new FluentWait<WebDriver>(driver).withTimeout(100, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new Predicate<WebDriver>() {
					public boolean apply(WebDriver driver) {
						try {
							Boolean booFlag = driver.findElement(by).isDisplayed();
							if (!booFlag) {
								System.out.println("");
								return true;
							} else
								System.out.println("");
							return false;
						} catch (Exception e) {
							return true;
						}
					}
				});
	}

	public static void HardDelay(long delayTime) {
		try {
			Thread.sleep(delayTime);
		} catch (Exception e) {

		}

	}

	public void EnterText(By by, String reportName, String text) {
		try {
			waitCommand(by);
			WebElement element = this.driver.findElement(by);			
			this.driver.pressKeyCode(112); // DELETE Key event	 - https://developer.android.com/reference/android/view/KeyEvent.html#KEYCODE_FORWARD_DEL		
			element.sendKeys(text);
			takeScreenshot(reportName);
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);

		}
	}

	public void Click(By by, String reportName) {
		try {
			waitCommand(by);
			this.driver.findElement(by).click();
			HardDelay(5000L);
			takeScreenshot(reportName);
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
		}
	}

	public void Click(WebElement element, String reportName) {
		try {
			element.click();
			HardDelay(2000L);
			takeScreenshot(reportName);
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
		}
	}

	public String GetText(By by, String FieldName) {
		String text = null;
		
		try {
			waitCommand(by);
			text = this.driver.findElement(by).getText();
			
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
			test.log(LogStatus.INFO, FieldName + ": Not Returned - " + text);
		}
		test.log(LogStatus.INFO, FieldName + ":  Returned - " + text);
		return text.trim();

	}
	

	@SuppressWarnings("unchecked")
	public String GetTextWebView(By by, String fieldname) {
		String text = null;				
				
		try {
			Set<String> contextHandles = driver.getContextHandles();	
			switchContext(contextHandles,"fulcrum");
			waitCommand(by);
			text = driver.findElement(by).getText();
			switchContext(contextHandles,"NATIVE");			
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
		}
		test.log(LogStatus.INFO, fieldname + ":  Returned - " + text);
		return text.trim();

	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public void EnterTextWebView(By by, String reportName, String text) throws TimeoutException, NoSuchElementException  {
		
			Set<String> contextHandles = driver.getContextHandles();	
			switchContext(contextHandles,"fulcrum");
			waitCommand(by);
			WebElement element = driver.findElement(by);			
			focusEnterText(element,text);
			takeScreenshotWebView(contextHandles , reportName);	
					
	}
	
	public void focusEnterText(WebElement element, String textToEnter){
		Actions actions = new Actions(this.driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		actions.sendKeys(textToEnter);
		actions.build().perform();
	}


	@SuppressWarnings("unchecked")
	public List<WebElement> GetWebElements(By by) {
		List<WebElement> webElements = null;
		try {
			waitCommand(by);
			webElements = this.driver.findElements(by);
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
		}
		return webElements;
	}

	public void HideKeyboard() {
		this.driver.hideKeyboard();

	}

	public void ClickNext() {
		try {
			waitCommand(By.id("next"));
			this.driver.findElement(By.id("next")).click();
			HardDelay(2000L);
			takeScreenshot("Click Next Button");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
		}
	}

	public void ClickPrevious() {
		try {
			waitCommand(By.id("previous"));
			this.driver.findElement(By.id("previous")).click();
			takeScreenshot("Click Previous Button");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
		}
	}

	public boolean CompareText(String expected, By by) {

		String actual = this.driver.findElement(by).getText().trim();
	
		if (expected.equals(actual)) {
			test.log(LogStatus.PASS,"Compare Text() - Expected - "+ expected + ", Actual - "+actual);
			return true;
		} else {
			test.log(LogStatus.FAIL,"Compare Text() - Expected - "+ expected + ", Actual - "+actual);
			return false;
		}

	}
	
	public void EnterTextCmd(By by, String reportName, String text) {
		try {
			waitCommand(by);
			WebElement element = this.driver.findElement(by);
			element.click();
			element.clear();
			Runtime.getRuntime().exec("adb -s emulator-5554 shell input text "+text);
			takeScreenshot(reportName);
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);

		}
	}
	
	@SuppressWarnings("unchecked")
	public void switchContext(Set<String> contextHandles, String contextName){			
		for(String s: contextHandles){
			System.out.println("Context - "+s);			
			if(s.contains(contextName)){
				driver.context(s);
				break;
			}
		}
	}
	
	
	public boolean verifyTransactionCreation(By by, String loopingField){

		if (GetTextWebView(by, "Looping field").equalsIgnoreCase(loopingField)) {
			test.log(LogStatus.PASS, "Transaction created successfully");
			return true;
		}
		test.log(LogStatus.FAIL, "Transaction created not successfully");
		return false;

	}
	
	/************************************************************************************************
	 * Function   :ScrolltoText()
	 * Decsription:Function to Scroll to give text.
	 * Date		  :14-12-2016	
	 * Author	  :Saran	
	 *************************************************************************************************/		
	public void ScrolltoText(String Text){
		try {
			this.driver.scrollToExact(Text);
			takeScreenshot("Scrolled to : "+Text);
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, ex);
		}

	}
	/************************************************************************************************
	 * Function   :Getconnections()
	 * Decsription:Function to connect Database
	 * Date		  :14-12-2016	
	 * Author	  :Saran	
	 *************************************************************************************************/		
	public void Getconnections() throws Exception {

		try {
			String driver = "oracle.jdbc.driver.OracleDriver";

			String url = "jdbc:oracle:thin:@"+environmentVariables.get("DataBaseURL");
			String username = "CATS"; String password = "CATS";

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "DB Connection not established");

		}

	}

	/************************************************************************************************
	 * Function   :Closeconnections()
	 * Decsription:Function to connect Database
	 * Date		  :14-12-2016	
	 * Author	  :Saran	
	 *************************************************************************************************/		
	public void Closeconnections() throws Exception {
		try{
			connection.close();
			if (connection.isClosed()) 
				System.out.println("Connection closed.");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, e);
		}

	}
	/************************************************************************************************
	 * Function   :Design in progress
	 * Decsription:Function to connect Database
	 * Date		  :14-12-2016	
	 * Author	  :Saran	
	 *************************************************************************************************/	
	public void SqlQuery(String Text , String Text1) {
		Statement stmt;
		ResultSet rs;
		try {
			stmt = connection.createStatement();			
			rs = stmt.executeQuery(Text);			
			while (rs.next()) {

				String [] Key = Text1.split("#");
				int key1=Key.length;
				for(int i=0;i<key1;i++){
					String txt = rs.getString(Key[i]);
					HashMap<String,String> map=new HashMap<String,String>(); 
					map.put(Key[i],txt);  
					System.out.println(Key[i] + txt);
				}

			}
		} catch (SQLException e) {			
			test.log(LogStatus.FAIL, e);
		}
	}

	/************************************************************************************************
	 * Function   :GetNonSerializedPart
	 * Decsription:Function to get Nonserialized part from DB
	 * Date		  :16-12-2016	
	 * Author	  :Saran	
	 *************************************************************************************************/	
	public String GetNonSerializedPart(){
		String partcode = null;
		Statement stmt;
		ResultSet rs;
		try {
			stmt = connection.createStatement();			
			rs = stmt.executeQuery("select * from cats_part p left join cats_partdetail pd on p.partid = pd.partid where p.Active = 'Y' and p.Trackable = 'Y'and p.ORDERABLE = 'Y'and p.ORDERABLE = 'Y'and p.PURCHASABLE = 'Y'and p.INSTALLABLE = 'Y'and p.SERIALIZED = 'N'and p.KIT = 'N'and p.ASSEMBLY = 'N'and pd.partid is null");			
			while (rs.next()){
				Object firstrow =rs.getObject(1);
				partcode = rs.getString("PARTCODE");
				System.out.println(partcode);
				if(!partcode.equals(null)){
					break;
				}
				return partcode;

			} 
		}catch (SQLException e) {			
			test.log(LogStatus.FAIL, e);
		}

		return partcode;


	}
	/************************************************************************************************
	 * Function   :GetSerializedPart
	 * Decsription:Function to get serialized part from DB
	 * Date		  :16-12-2016	
	 * Author	  :Saran	
	 *************************************************************************************************/	

	public String GetSerializedPart(){
		String partcode = null;
		Statement stmt;
		ResultSet rs;
		try {
			stmt = connection.createStatement();			
			rs = stmt.executeQuery("select * from cats_part p left join cats_partdetail pd on p.partid = pd.partid where p.Active = 'Y' and p.Trackable = 'Y'and p.ORDERABLE = 'Y'and p.ORDERABLE = 'Y'and p.PURCHASABLE = 'Y'and p.INSTALLABLE = 'Y'and p.SERIALIZED = 'Y'and p.KIT = 'N'and p.ASSEMBLY = 'N'and pd.partid is null");			
			while (rs.next()){
				Object firstrow =rs.getObject(1);
				partcode = rs.getString("PARTCODE");
				System.out.println(partcode);
				if(!partcode.equals(null)){
					break;
				}
				return partcode;

			} 
		}catch (SQLException e) {			
			e.printStackTrace();
		}

		return partcode;		

	}


}
