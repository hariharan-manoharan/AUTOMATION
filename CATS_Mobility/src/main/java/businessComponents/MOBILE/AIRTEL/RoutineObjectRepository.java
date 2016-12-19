package main.java.businessComponents.MOBILE.AIRTEL;

import org.openqa.selenium.By;

public interface RoutineObjectRepository {
	
	String EDIT_TXT = "";
	String BUTTON = "";		
	
	
	By ID_ACTION_BAR_SUBTITLE = By.id("action_bar_subtitle");
	By ID_MESSAGE_CONFIRM = By.id("message");
	By ID_MESSAGE_CONFIRM_YES = By.id("button1");
	By ID_MESSAGE_CONFIRM_NO = By.id("button2");
	
	By XPATH_LABEL_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='routine-prompt ng-binding']");
	By XPATH_TXT_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='routine-input ng-binding']");
	By XPATH_SEARCH_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='btn-group pull-right ng-scope']");
	

}
