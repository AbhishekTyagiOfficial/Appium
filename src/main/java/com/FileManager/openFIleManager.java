package com.FileManager;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class openFIleManager {
	
	static AppiumDriver driver;

	public static void openFIleManager() {

		DesiredCapabilities fm = new DesiredCapabilities();

		fm.setCapability("", "");
		fm.setCapability("", "");
		fm.setCapability("", "");
		fm.setCapability("", "");
		fm.setCapability("", "");
		fm.setCapability("", "");

		try {
			URL url = new URL("");
			driver = new AppiumDriver(url, fm);
			System.out.println("File Manager Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
