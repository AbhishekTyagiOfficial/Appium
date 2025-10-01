package com.FileManager;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class openFIleManager {

	static AndroidDriver driver;

	public static void main(String arr[]) throws InterruptedException {
		openFileManager();
		//CleanerModule cm = new CleanerModule(driver);
		CleanerModule.driver = driver;
		AndroidSystemButtons asb = new AndroidSystemButtons(driver);
		CleanerModule.PermissionScreen();
		CleanerModule.Notification();
		CleanerModule.Cleanertab();
		CleanerModule.CleanupFlow();
		CleanerModule.Duplicatefile();
		CleanerModule.Photo();
		CleanerModule.Photoviweall();
		CleanerModule.Photoseleteall();
		CleanerModule.Deleteduplicate();
		CleanerModule.Movetotrash();
		CleanerModule.Afterdelete();
		for (int i=1; i<=6; i++) {			
			asb.pressBack();
			System.out.print(+ i);
			Thread.sleep(1000);
		}

	}

	public static void openFileManager() {

		DesiredCapabilities fm = new DesiredCapabilities();

		fm.setCapability("appium:deviceName", "ffac23575ec0");
		fm.setCapability("appium:platformName", "Android");
		fm.setCapability("appium:platformVersion", "15");
		fm.setCapability("appium:appPackage", "filemanager.files.fileexplorer.android.folder");
		fm.setCapability("appium:appActivity",
				"com.simplemobiletools.filemanager.pro.activities.FileManagerMainActivity");
		fm.setCapability("appium:automationName", "UiAutomator2");
		fm.setCapability("appium:onReset", false);

		try {
			URL url = new URL("http://127.0.0.1:4723");
			driver = new AndroidDriver(url, fm);
			System.out.println("File Manager Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
