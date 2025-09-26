package com.FileManager;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class openFIleManager {
	
	static AndroidDriver driver;
	
	public static void main(String arr[]) {
		
		openFileManager();
		
	}
	public static void openFileManager() {

	    DesiredCapabilities fm = new DesiredCapabilities();

	    // ✅ use platformName, not platform
//	    fm.setCapability("appium:deviceName", "ffac23575ec0");
//	    fm.setCapability("platformName", "Android");
//	    fm.setCapability("appium:platformVersion", "15");
////	    fm.setCapability("appium:udid", "192.168.0.21:5555");
//	    fm.setCapability("appium:appPackage", "filemanager.files.fileexplorer.android.folder");
//	    fm.setCapability("appium:appActivity", "filemanager.files.fileexplorer.android.folder.SplashScreen");
//	    fm.setCapability("appium:automationName", "UiAutomator2");

	    
	    fm.setCapability("appium:deviceName", "ffac23575ec0");
	    fm.setCapability("platformName", "Android");
	    fm.setCapability("appium:platformVersion", "15"); // replace with actual version
	    fm.setCapability("appium:udid", "ffac23575ec0"); // USB serial
	    fm.setCapability("appium:appPackage", "filemanager.files.fileexplorer.android.folder");
	    fm.setCapability("appium:appActivity", "filemanager.files.fileexplorer.android.folder.ui.activity.HomeActivity"); // replace with real activity
	    fm.setCapability("appium:automationName", "UiAutomator2"); 
	    
	    try {
	        URL url = new URL("http://127.0.0.21:4723"); 
	        driver = new AndroidDriver(url, fm);
	        System.out.println("File Manager Started...");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	

}
