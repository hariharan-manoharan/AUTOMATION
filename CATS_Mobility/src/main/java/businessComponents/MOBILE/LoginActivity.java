package main.java.businessComponents.MOBILE;

import org.openqa.selenium.By;


import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Utility;

public class LoginActivity extends Utility {

	@SuppressWarnings("rawtypes")
	public LoginActivity(ExtentTest test, AndroidDriver driver) {
		super.test = test;
		super.driver = driver;
	}

	public void addConnection() {
		Click(By.name("Add Connection"), "Click - AddConnection");
		Click(By.id("connections_add"), "Click - AddConnection Symbol");
		EnterText(By.id("connection_edit_name"), "Enter - Connection Name", "AIRTEL QA2");
		EnterText(By.id("connection_edit_host"), "Enter - Host", "services-uswest.skytap.com");
		EnterText(By.id("connection_edit_port"), "Enter - Port", "25582");
		Click(By.id("connection_edit_ssl"), "Click - Enable SSL");
		Click(By.id("connections_save"), "Click - Save Connection");
		Click(By.id("action_bar_title"), "Click - Back button");
	}

	public void login() {
		EnterText(By.id("username"), "Enter - Username", "catsadm");
		EnterText(By.id("password"), "Enter - Password", "catscats11");
		HideKeyboard();
		Click(By.id("btn_connect"), "Click - Connect button");
	}
}
