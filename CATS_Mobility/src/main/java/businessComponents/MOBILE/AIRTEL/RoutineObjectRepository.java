package main.java.businessComponents.MOBILE.AIRTEL;

import org.openqa.selenium.By;

public interface RoutineObjectRepository {
	

	// ADD CONNECTION
	
	By NAME_ADD_CONNECTION= By.name("Add Connection");
	By ID_ADD_CONNECTIONS=By.id("connections_add");
	By NAME_TXT_CONNECTION_NAME=By.id("connection_edit_name");
	By ID_TXT_CONNECTION_HOST=By.id("connection_edit_host");
	By ID_TXT_CONNECTION_PORT=By.id("connection_edit_port");
	By ID_TOGGLE_BTN_SSL =By.id("connection_edit_ssl");
	By ID_ICON_SAVE=By.id("connections_save");
	By ID_IMG_BACK_BTN =By.id("action_bar_title");
	
	//LOGIN
	
	By ID_TXT_USERNAME = By.id("username");
	By ID_TXT_PASSWORD = By.id("password");
	By ID_BTN_CONNECT = By.id("btn_connect");
	
	// PROFILES
	
	By NAME_LISTTEXT_ADMIN = By.name("ADMIN");
	
	// ID
	
	By ID_ACTION_BAR_SUBTITLE = By.id("action_bar_subtitle");
	By ID_MESSAGE= By.id("message");
	By ID_MESSAGE_CONFIRM_YES = By.id("button1");
	By ID_MESSAGE_CONFIRM_NO = By.id("button2");
	By ID_MESSAGE_OK = By.id("button1");
	
	
	
	// NAME or CONTENT_DESC
	
	By CONTENT_DESC_ROUITNE_BACK_BTN = By.name("Back");
	
	
	//
	
	By XPATH_LABEL_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='routine-prompt ng-binding']");
	By XPATH_TXT_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='routine-input ng-binding']");
	By XPATH_SEARCH_WEBVIEW = By.xpath("//div[@class='ng-scope']/div[@class='btn-group pull-right ng-scope']");
	

}
