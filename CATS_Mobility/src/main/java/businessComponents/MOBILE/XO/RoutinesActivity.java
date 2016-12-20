package main.java.businessComponents.MOBILE.XO;



import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import main.java.testDataAccess.DataTable;
import main.java.utils.Utility;

public class RoutinesActivity extends Utility  implements RoutineObjectRepository {
	

	@SuppressWarnings("rawtypes")
	public RoutinesActivity(ExtentTest test, AndroidDriver driver, DataTable dataTable) {
		super(test,driver,dataTable);
	}	
	
	
	public void selectRoutine(String routineName){		
		ScrolltoText(routineName);		
		Click(By.name(routineName), "Click - Routine - "+routineName+" is selected");
	}
	



	public void locationInquiry(){
		
		selectRoutine("Location Inquiry");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Location Inquiry")){		
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Location Name (*)","BAL-MUNDKA-MDEL");
			ClickNext();
		}
				
	}
	
	
	public void pick(){
		
		selectRoutine("Pick");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Pick")){
			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Transfer #","MAN0002777");
			ClickNext();		
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Line/Item # ","1");
			ClickNext();			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Asset Code/Serial # ","ASSET105");
			ClickNext();			
		}
				
	}


	public void pack() {		
		selectRoutine("Pack");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Pack")){
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Location Name","BAL-MUNDKA-MDEL");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Transfer Request (*)","T000000003");
			ClickNext();
			if(GetText(ID_MESSAGE_CONFIRM, "Confirm Message").equalsIgnoreCase("Generate new shipment?")){
				Click(ID_MESSAGE_CONFIRM_YES, "Clicked 'Yes' for 'Generate new shipment?' message");
				//GetTextWebView(XPATH_TXT_WEBVIEW, "Shipment#");
			}
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Barcode (*)","TESTASSET000001");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Notes","Pack - Test Notes");
			ClickNext();
			//verifyTransactionCreation(XPATH_TXT_WEBVIEW, "Enter Transfer Request (*) :");
		}
	}


	public void ship() {		
		selectRoutine("Ship");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Ship")){
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Location Name","BAL-MUNDKA-MDEL");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Transfer Request (*)","T000000003");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Shipment Method (*)","AIRWAYS");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Tracking Number","TEST");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Shipment Number (*)","000000000020161219-5");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Notes","Ship - Test Notes");
			ClickNext();
		}
	}

}
