package main.java.businessComponents.MOBILE.AIRTEL;


import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import main.java.testDataAccess.DataTable;
import main.java.utils.Utility;

public class ProfilesActivity extends Utility {	

	@SuppressWarnings("rawtypes")
	public ProfilesActivity(ExtentTest test, AndroidDriver driver, DataTable dataTable) {
		super(test,driver,dataTable);
	}

	public void selectProfile() {		
		
		waitCommand(By.name("ADMIN"));
		driver.scrollTo("ADMIN");		
		Click(By.name("ADMIN"), "Click - ADMIN Profile is selected");

	}
	
	
}
