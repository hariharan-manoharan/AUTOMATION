package main.java.executionSetup;

public class TestParameters {
	
	private String executionMode;
	private String currentTestCase;
	private String executeCurrentTestCase;
	private String port;
	private String bootstrapPort;
	private String deviceName;
	private String udid;
	
	public void setExecutionMode(String executionMode){
		this.executionMode = executionMode;
	}
	
	public String currentTestCase(){
		return this.executionMode;
	}
	
	public void setCurrentTestCase(String currentTestCase){
		this.currentTestCase = currentTestCase;
	}
	
	public String getCurrentTestCase(){
		return this.currentTestCase;
	}
	
	
	public void setExecuteCurrentTestCase(String executeCurrentTestCase){
		this.executeCurrentTestCase = executeCurrentTestCase;
	}
	
	public String getExecuteCurrentTestCase(){
		return this.executeCurrentTestCase;
	}

	public void setPort(String port){
		this.port = port;
	}
	
	public String getPort(){
		return this.port;
	}
	
	
	public void setBootstrapPort(String bootstrapPort){
		this.bootstrapPort = bootstrapPort;
	}
	
	public String getBootstrapPort(){
		return this.bootstrapPort;
	}
	
	
	public void setDeviceName(String deviceName){
		this.deviceName = deviceName;
	}
	
	public String getDeviceName(){
		return this.deviceName;
	}
	
	
	public void setUdid(String udid){
		this.udid = udid;
	}
	
	public String getUdid(){
		return this.udid;
	}
	

}
