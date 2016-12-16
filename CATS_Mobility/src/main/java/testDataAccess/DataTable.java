package main.java.testDataAccess;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import main.java.executionSetup.TestParameters;



public interface DataTable {	

	ArrayList<TestParameters> getRunManagerInfo();
	
	String getData(String arg1, String arg2);
	
	String writeData(String arg1, String arg2);
	
	LinkedHashMap<String, String> getRowData(String arg1);
	
	void setCurrentRow(String arg1);

}
