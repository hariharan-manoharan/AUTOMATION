package main.java.businessComponents.MOBILE.AIRTEL;



import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Utility;

public class RoutinesActivity extends Utility implements RoutineObjectRepository {
	

	@SuppressWarnings("rawtypes")
	public RoutinesActivity(ExtentTest test, AndroidDriver driver) {
		super(test,driver);
	}	
	
	
	public void selectRoutine(String routineName){		
		ScrolltoText(routineName);		
		Click(By.name(routineName), "Click - Routine - "+routineName+" is selected");
	}
	

	public void locationInquiry(){
		
		selectRoutine("Location Inquiry");	
		String text = GetTextWebView(XPATH_LABEL_WEBVIEW);		
		if(text.equals("Enter Location Name (*) :")){
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Location Name (*)","BAL-MUNDKA-MDEL");
			ClickNext();
		}
				
	}
	
	
	public void pick(){
		
		selectRoutine("Pick");	
		String text = GetTextWebView(XPATH_LABEL_WEBVIEW);		
		if(text.equals("Enter Location (*) :")){
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Location Name","BAL-MUNDKA-MDEL");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Transfer Request (*)","T000000001");
			ClickNext();			
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Line/Item # (*)","185614846");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Asset Code (UIN)/Serial #","TESTASSET01");
			ClickNext();
			EnterTextWebView(XPATH_TXT_WEBVIEW,"Enter Notes","Test Notes");
			ClickNext();
		}
				
	}

}
