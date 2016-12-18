package main.java.businessComponents.MOBILE;

import org.openqa.selenium.By;


import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Utility;

public class LoginActivity extends Utility implements RoutineObjectRepository {

	@SuppressWarnings("rawtypes")
	public LoginActivity(ExtentTest test, AndroidDriver driver) {
		super.test = test;
		super.driver = driver;
	}

	public void addConnection() {
		Click(TAB_CONNECTIONS, "Click - AddConnection");
		Click(ICON_ADD, "Click - AddConnection Symbol");
		EnterText(TXT_NAME, "Enter - Connection Name", "AIRTEL QA2");
		EnterText(TXT_HOST, "Enter - Host", "services-uswest.skytap.com");
		EnterText(TXT_PORT, "Enter - Port", "25582");
		Click(TOGGLE_BTN_SSL , "Click - Enable SSL");
		Click(ICON_SAVE, "Click - Save Connection");
		Click(IMG_BACK_BTN , "Click - Back button");
	}

	public void login() {
		EnterText(TXT_USERNAME, "Enter - Username", "catsadm");
		EnterText(TXT_PASSWORD, "Enter - Password", "catscats11");
		HideKeyboard();
		Click(BTN_CONNECT, "Click - Connect button");
	}
}
