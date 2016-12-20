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
	

}
