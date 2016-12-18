package main.java.businessComponents.MOBILE;

import org.openqa.selenium.By;

public interface RoutineObjectRepository {
	
	
	String TXT_VIEW="//[@id='%s']";
	
	
	
	
	
	//Login Page
	By TXT_USERNAME=By.xpath(String.format(TXT_VIEW,"username"));
	By TXT_PASSWORD= By.xpath(String.format(TXT_VIEW,"password"));
	

}
