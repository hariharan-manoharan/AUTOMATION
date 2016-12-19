package main.java.businessComponents.MOBILE.XO;



import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import main.java.utils.Utility;

public class RoutinesActivity extends Utility {
	

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
		String text = GetTextWebView(By.xpath("//div[@class='ng-scope']/div[@class='routine-prompt ng-binding']"));
		System.out.println(text); 
		if(text.equals("Enter Location Name (*) :")){
			EnterTextWebView(By.xpath("//div[@class='ng-scope']/div[@class='routine-input ng-binding']"),"Enter Location Name","BAL-MUNDKA-MDEL");
			ClickNext();
		}
		
		
	}

}
