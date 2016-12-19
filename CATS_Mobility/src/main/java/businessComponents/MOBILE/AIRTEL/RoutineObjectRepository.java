package main.java.businessComponents.MOBILE.AIRTEL;

import org.openqa.selenium.By;

public interface RoutineObjectRepository {
	
	String EDIT_TXT = "";
	String BUTTON = "";		
	
	By XPATH_LABEL_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='routine-prompt ng-binding']");
	By XPATH_TXT_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='routine-input ng-binding']");
	By XPATH_SEARCH_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='btn-group pull-right ng-scope']");
	

}
