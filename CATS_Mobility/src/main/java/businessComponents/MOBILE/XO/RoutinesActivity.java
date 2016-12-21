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
	
	public void stockASSET(){
		
		selectRoutine("Stock Equipment");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Stock Equipment")){
			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"To Location : ","SEA-WAREHOUSE");
			ClickNext();		
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter To Status(*):","ON HAND");
			ClickNext();			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter To Bin(*):","ENG");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Item/Mfg.Part #(*):","10001231");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Assetcode(*):","ASSETRAJ1");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Serial#(*):","RAJ1");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Condition(*):","Good");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Notes (*)	","Stock Asset - ASSETRAJ1 ");
			ClickNext();
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}
				
	}	
	public void pick(){
		
		selectRoutine("Pick");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Pick")){
			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Transfer #","MAN0002778");
			ClickNext();		
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Line/Item # ","1");
			ClickNext();			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Asset Code/Serial # ","ASSETRAJ1");
			ClickNext();
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}
				
	}


	public void pack() {		
		selectRoutine("Pack");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Pack")){
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Transfer #","MAN0002778");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Generate Container? (*)","Y");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Barcode (*)","ASSETRAJ1");
			ClickNext();
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}
	}


	public void ship() {		
		selectRoutine("Ship");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Ship")){
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Transfer #","MAN0002778");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Shipment Number (*)","000000020161220-6380");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Shipment Method ","ABF LOGISTICS");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Tracking Number","TEST");
			ClickNext();			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Notes","Ship - Test Notes");
			ClickNext();
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}
	}
	
	public void internalReceive() {		
		selectRoutine("Internal Receive");	
		String text = GetText(ID_ACTION_BAR_SUBTITLE, "Routine name");		
		if(text.equals("Internal Receive")){
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Requisition #","MAN0002778");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Barcode(*)","ASSETRAJ1");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Bin(*)","ENG");
			ClickNext();		
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Notes","Internal Receive- Test Notes");
			ClickNext();
			Click(CONTENT_DESC_ROUITNE_BACK_BTN, "Click Rouitne Back Button");
		}
	}
}
