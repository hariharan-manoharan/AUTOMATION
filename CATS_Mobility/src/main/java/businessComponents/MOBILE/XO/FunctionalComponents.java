package main.java.businessComponents.MOBILE;

import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Utility;

public class FunctionalComponents extends Utility {

	@SuppressWarnings("rawtypes")
	public FunctionalComponents(ExtentTest test, AndroidDriver driver) {
		super(test, driver);
	}

	public void createNewConnection() {

		LoginActivity loginActivity = new LoginActivity(test, driver);
		loginActivity.addConnection();

	}

	public void login() {

		LoginActivity loginActivity = new LoginActivity(test, driver);
		loginActivity.login();

	}

	public void selectUserProfile() {
		ProfilesActivity profilesActivity = new ProfilesActivity(test, driver);
		profilesActivity.selectProfile();
	}
	
	public void verifyVersionInfo() {
		ProfilesActivity profilesActivity = new ProfilesActivity(test, driver);
		profilesActivity.verifyInfo();
	}

	
	public void locationInquiryRoutine(){
		RoutinesActivity routinesActivity = new RoutinesActivity(test, driver);
		routinesActivity.locationInquiry();
	}

}