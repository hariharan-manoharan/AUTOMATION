package main.java.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import main.java.executionSetup.ExecutionMode;
import main.java.executionSetup.TestParameters;
import main.java.testDataAccess.DataTable;
import main.java.utils.AppiumServerHandler;
import main.java.utils.AppiumServerHandlerCmd;

public class Executor implements Runnable {

	private ExtentReports report;
	private ExtentTest test;
	private TestParameters testParameters;
	private ExecutionMode execMode;
	private DataTable dataTable;
	private AppiumServerHandler appiumServerHandler;
	private AppiumServerHandlerCmd appiumServerHandlerCmd;
	@SuppressWarnings("rawtypes")
	private AndroidDriver driver;

	public Executor(TestParameters testParameters, ExtentReports report, ExecutionMode execMode, DataTable dataTable) {
		this.testParameters = testParameters;
		this.report = report;
		this.execMode = execMode;
		this.dataTable = dataTable;

	}

	@Override
	public void run() {
		if (testParameters.getExecuteCurrentTestCase().equalsIgnoreCase("Yes")) {
			test = report.startTest(testParameters.getCurrentTestCase());
			dataTable.setCurrentRow(testParameters.getCurrentTestCase());
			test.log(LogStatus.INFO, testParameters.getCurrentTestCase() + " execution started", "");
			executeKeywords(getKeywords());
			test.log(LogStatus.INFO, testParameters.getCurrentTestCase() + " execution completed", "");
			report.endTest(test);
			report.flush();
		}
	}

	public void executeKeywords(LinkedHashMap<String, String> keywords) {

		try {

			driverSetUp();

			Class<?> className = Class.forName("main.java.businessComponents." + execMode + ".FunctionalComponents");
			Constructor<?> constructor = className.getDeclaredConstructors()[0];
			Object classInstance = constructor.newInstance(test, driver);

			for (Entry<String, String> map : keywords.entrySet()) {
				if (!map.getKey().equals("TC_ID")) {
					String currentKeyword = map.getValue().substring(0, 1).toLowerCase() + map.getValue().substring(1);
					Method method = className.getMethod(currentKeyword);
					method.invoke(classInstance);
				}
			}

			end();

		} catch (ClassNotFoundException e) {
			test.log(LogStatus.FAIL, e);
			end();
		} catch (NoSuchMethodException e) {
			test.log(LogStatus.FAIL, e);
			end();
		} catch (SecurityException e) {
			test.log(LogStatus.FAIL, e);
			end();
		} catch (IllegalAccessException e) {
			test.log(LogStatus.FAIL, e);
			end();
		} catch (IllegalArgumentException e) {
			test.log(LogStatus.FAIL, e);
			end();
		} catch (InvocationTargetException e) {
			test.log(LogStatus.FAIL, e);
			end();
		} catch (InstantiationException e) {
			test.log(LogStatus.FAIL, e);
			end();
		} catch (IOException | InterruptedException e) {
			test.log(LogStatus.FAIL, e);
			end();
		}

	}

	public LinkedHashMap<String, String> getKeywords() {

		LinkedHashMap<String, String> keywordMap = new LinkedHashMap<String, String>();
		keywordMap = dataTable.getRowData("Keywords");
		return keywordMap;

	}

	@SuppressWarnings("rawtypes")
	public void driverSetUp() throws ExecuteException, IOException, InterruptedException {

		try {

			appiumServerHandler = new AppiumServerHandler(Integer.parseInt(testParameters.getPort()),
					testParameters.getBootstrapPort());
			appiumServerHandler.appiumServerStart();

			String absolutePath = new File(System.getProperty("user.dir")).getAbsolutePath();

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", testParameters.getDeviceName());
			capabilities.setCapability("udid", testParameters.getUdid());
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
			capabilities.setCapability("app", absolutePath + "\\src\\main\\resources\\Libs\\CATS-Mobility.apk");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "net.fulcrum.mobility");
			capabilities.setCapability("appActivity", "net.fulcrum.mobility.activities.LoginActivity");

			driver = new AndroidDriver(new URL("http://127.0.0.1:" + testParameters.getPort() + "/wd/hub"),
					capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			test.log(LogStatus.INFO, "Android Driver and Appium server setup done Successfully", "");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Android Driver and Appium server setup not done Successfully", "");
		}

	}

	public void end() {

		if (driver != null) {
			driver.quit();
		}

		if (appiumServerHandler != null) {
			appiumServerHandler.appiumServerStop();
		}

	}

}
