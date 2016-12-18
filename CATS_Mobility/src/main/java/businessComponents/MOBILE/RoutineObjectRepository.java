package main.java.businessComponents.MOBILE;

import org.openqa.selenium.By;

public interface RoutineObjectRepository {


	/*	String TXT_VIEW="%s";
	String BUTTON="%s";
	 */

	//Add Connections
	By TAB_CONNECTIONS= By.name("Add Connection");
	By ICON_ADD=By.id("connections_add");
	By TXT_NAME=By.id("connection_edit_name");
	By TXT_HOST=By.id("connection_edit_host");
	By TXT_PORT=By.id("connection_edit_port");
	By TOGGLE_BTN_SSL =By.id("connection_edit_ssl");
	By ICON_SAVE=By.id("connections_save");
	By IMG_BACK_BTN =By.id("action_bar_title");

	//Login Page
	By TXT_USERNAME=By.id("username");
	By TXT_PASSWORD= By.id("password");
	By BTN_CONNECT= By.id("btn_connect");


}

