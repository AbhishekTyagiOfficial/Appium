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

//	public static void PermissionScreen() {
//		try {
//			for (int i = 1; i <= 3; i++) {
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
//				WebElement permissionscreen = wait.until(ExpectedConditions
//						.elementToBeClickable(By.id("filemanager.files.fileexplorer.android.folder:id/nextitem")));
//				permissionscreen.click();
//				System.out.println("Permission Button Clicked !" + i);
//			}
//		} catch (Exception e) {
//			System.out.println("Permission Button Not Clicked !");
//			e.printStackTrace();
//		}
//	}
//
//	public static void Notification() {
//
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
//			WebElement allownotification = wait.until(ExpectedConditions
//					.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
//			allownotification.click();
//			System.out.println("Notification Clicked !");
//
//		} catch (Exception e) {
//			System.out.println("Notification not visible OR not Clicked !");
//			Cleanertab();
//		}
//	}
//
//	public static void Cleanertab() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
//			WebElement cleaner = wait.until(ExpectedConditions.elementToBeClickable(
//					By.id("filemanager.files.fileexplorer.android.folder:id/clean_master_btmnav")));
//			cleaner.click();
//			System.out.println("Cleaner Clicked !");
//		} catch (Exception e) {
//			System.out.println("Cleaner not Clicked !");
//			e.printStackTrace();
//		}
//	}
//
//	public static void CleanupFlow() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//			WebElement cleanup = wait.until(ExpectedConditions
//					.visibilityOfElementLocated(By.id("filemanager.files.fileexplorer.android.folder:id/clean_up")));
//			cleanup.click();
//			System.out.println("CleanUp Clicked !");
//
//			Thread.sleep(10000);
//			
//			// Cleanup1 button (agar visible ho)
//			try {
//				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
//				WebElement cleanup1 = wait1.until(ExpectedConditions
//						.visibilityOfElementLocated(By.id("filemanager.files.fileexplorer.android.folder:id/delete_junk")));
//				cleanup1.click();
//				System.out.println("CleanUp1 Clicked !");
//			} catch (TimeoutException e) {
//				System.out.println("CleanUp1 button not visible after CleanUp.");
//			}
//
//		} catch (Exception e) {
//			System.out.println("Error in Cleanup Flow!");
//			e.printStackTrace();
//		}
//	}
//
//	public static void Duplicatefile() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
//			WebElement duplifile = wait.until(ExpectedConditions.elementToBeClickable(
//					By.id("filemanager.files.fileexplorer.android.folder:id/duplicate_files_2")));
//			duplifile.click();
//			System.out.println("Duplicate Clicked !");
//		} catch (Exception e) {
//			System.out.println("Duplicate not Clicked !");
//			e.printStackTrace();
//		}
//	}
//
//	public static void Photo() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement photos = wait.until(ExpectedConditions
//					.elementToBeClickable(By.id("filemanager.files.fileexplorer.android.folder:id/ll_photos")));
//			photos.click();
//			System.out.println("Photo Section Clicked !");
//		} catch (Exception e) {
//			System.out.println("Photo Section not Clicked !");
//			e.printStackTrace();
//		}
//	}
//
//	public static void Photoviweall() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement viewall = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//					"//android.widget.TextView[@resource-id='filemanager.files.fileexplorer.android.folder:id/viewall'][1]")));
//			viewall.click();
//			System.out.println("View All Clicked !");
//		} catch (Exception e) {
//			System.out.println("View All not Clicked !");
//			e.printStackTrace();
//		}
//	}
//
//	public static void Photoseleteall() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement selectall = wait.until(ExpectedConditions.elementToBeClickable(By.id(
//					"filemanager.files.fileexplorer.android.folder:id/menu_checkbox_select_all")));
//			selectall.click();
//			System.out.println("Select All Clicked !");
//		} catch (Exception e) {
//			System.out.println("Select All not Clicked !");
//			e.printStackTrace();
//		}
//	}
//	public static void Deleteduplicate() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement deletedupli = wait.until(ExpectedConditions.elementToBeClickable(By.id(
//					"filemanager.files.fileexplorer.android.folder:id/delete_duplicate")));
//			deletedupli.click();
//			System.out.println("Delete Duplicate Clicked !");
//		} catch (Exception e) {
//			System.out.println("Delete Duplicate not Clicked !");
//			e.printStackTrace();
//		}
//	}
//	public static void Movetotrash() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement movetotrash = wait.until(ExpectedConditions.elementToBeClickable(By.id(
//					"filemanager.files.fileexplorer.android.folder:id/folder_default")));
//			movetotrash.click();
//			System.out.println("movetotrash Clicked !");
//		} catch (Exception e) {
//			System.out.println("movetotrash not Clicked !");
//			e.printStackTrace();
//		}
//	}
//
//	public static void Afterdelete() {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement afterdelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
//					"filemanager.files.fileexplorer.android.folder:id/ok_filter")));
//			afterdelete.click();
//			System.out.println("Afterdelete Clicked !");
//		} catch (Exception e) {
//			System.out.println("Afterdelete not Clicked !");
//			e.printStackTrace();
//		}
//	}
}
