package main.java.businessComponents.MOBILE.XO;

import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import main.java.testDataAccess.DataTable;
import main.java.utils.Utility;

public class FunctionalComponents extends Utility {

	@SuppressWarnings("rawtypes")
	public FunctionalComponents(ExtentTest test, AndroidDriver driver, DataTable dataTable) {
		super(test,driver,dataTable);
	}

	public void createNewConnection() {

		LoginActivity loginActivity = new LoginActivity(test, driver,dataTable);
		loginActivity.addConnection();

	}

	public void login() {

		LoginActivity loginActivity = new LoginActivity(test, driver,dataTable);
		loginActivity.login();

	}

	public void selectUserProfile() {
		ProfilesActivity profilesActivity = new ProfilesActivity(test, driver,dataTable);
		profilesActivity.selectProfile();
	}
	
	public void verifyVersionInfo() {
		ProfilesActivity profilesActivity = new ProfilesActivity(test, driver,dataTable);
		profilesActivity.verifyInfo();
	}

	
	public void locationInquiryRoutine(){
		RoutinesActivity routinesActivity = new RoutinesActivity(test, driver,dataTable);
		routinesActivity.locationInquiry();
	}

}