package main.java.businessComponents.MOBILE.AIRTEL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import main.java.testDataAccess.DataTable;
import main.java.utils.Utility;

public class RoutinesActivity extends Utility implements RoutineObjectRepository {

	@SuppressWarnings("rawtypes")
	public RoutinesActivity(ExtentTest test, AndroidDriver driver, DataTable dataTable) {
		super(test, driver, dataTable);
	}

	public void selectRoutine(String routineName) {
		ScrolltoText(routineName);
		Click(By.name(routineName), "Click - Routine - " + routineName + " is selected");
	}

	public void locationInquiry() throws TimeoutException, NoSuchElementException {

		selectRoutine("Location Inquiry");
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");
		if (text.equals("Location Inquiry")) {
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Location Name (*)", "BAL-MUNDKA-MDEL");
			ClickNext();
		}

	}

	public void pick() throws TimeoutException, NoSuchElementException {
		selectRoutine("Pick");
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");
		if (text.equals("Pick")) {
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Location Name", "BAL-MUNDKA-MDEL");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Transfer Request (*)", "T000000003");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Line/Item # (*)", "TESTASSET000001");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Notes", "Pick - Test Notes");
			ClickNext();			
			if (isObjectPresent(ID_MESSAGE, "Transcation completed message")) {
				GetText(ID_MESSAGE, "Transcation completed message");
				Click(ID_MESSAGE_OK, "Click OK");
			}
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}

	}

	public void pack() throws TimeoutException, NoSuchElementException  {
		selectRoutine("Pack");
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");
		if (text.equals("Pack")) {
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Location Name", "BAL-MUNDKA-MDEL");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Transfer Request (*)", "T000000003");
			ClickNext();
			if (GetText(ID_MESSAGE, "Confirm Message").equalsIgnoreCase("Generate new shipment?")) {
				Click(ID_MESSAGE_CONFIRM_YES, "Clicked 'Yes' for 'Generate new shipment?' message");
				// GetTextWebView(XPATH_TXT_WEBVIEW, "Shipment#");
			}
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Barcode (*)", "TESTASSET000001");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Notes", "Pack - Test Notes");
			ClickNext();			
			if (isObjectPresent(ID_MESSAGE, "Transcation completed message")) {
				GetText(ID_MESSAGE, "Transcation completed message");
				Click(ID_MESSAGE_OK, "Click OK");
			}
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}
	}

	public void ship() throws TimeoutException, NoSuchElementException {
		selectRoutine("Ship");
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");
		if (text.equals("Ship")) {
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Location Name", "BAL-MUNDKA-MDEL");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Transfer Request (*)", "T000000003");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Shipment Method (*)", "AIRWAYS");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Tracking Number", "TEST");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Shipment Number (*)", "000000000020161220-6");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW, "Enter Notes", "Ship - Test Notes");
			ClickNext();
			if (isObjectPresent(ID_MESSAGE, "Transcation completed message")) {
				GetText(ID_MESSAGE, "Transcation completed message");
				Click(ID_MESSAGE_OK, "Click OK");
			}
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}
	}

}
