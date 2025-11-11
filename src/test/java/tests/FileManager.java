package tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FileManager {
	static AndroidDriver driver;
	
	@BeforeTest
	public static void setup() {
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
	
	@Test(priority =1)
	public void chaliyeSuruKarteHaiSound() {
		try {
			File soundFile = new File("src/test/resources/sounds/chaliye-shuru-karte-hai.wav");
			if (!soundFile.exists()) {
				System.out.println("⚠️ Sound file not found at: " + soundFile.getAbsolutePath());
				return;
			}
			AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(soundFile);
			Clip clip =  AudioSystem.getClip();
			clip.open(audioStream2);
			clip.start();
			System.out.println("🔊 Sound Played Successfully!");
			
			Thread.sleep(clip.getMicrosecondLength() / 1000);
			
			clip.close();
			audioStream2.close();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println("❌ Unsupported file type! Please use a .wav file.");
		} catch (IOException | LineUnavailableException |InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority =2)
	public static void AllowBtn() {
		try {
			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement AllowBtn = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"filemanager.files.fileexplorer.android.folder:id/allow_tag\"]")));
				AllowBtn.click();
				System.out.println("Permission Button Clicked !");
			
		} catch (Exception e) {
			System.out.println("Permission Button Not Clicked !");
			e.printStackTrace();
		}
	}

	@Test(priority =3)
    public static void AllFileAccess() {
		try {
			//for (int i = 1; i <= 3; i++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement afa = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//android.widget.Switch[@resource-id=\"com.android.settings:id/switchWidget\"]")));
				afa.click();
				System.out.println("Permission Button Clicked !");
			//}
		} catch (Exception e) {
			System.out.println("Permission Button Not Clicked !");
			e.printStackTrace();
		}
	}
    
	@Test(priority =4)
 // 🔙 Back Button	
 	public  void pressBack() {
 		driver.pressKey(new KeyEvent(AndroidKey.BACK));
 		System.out.println("Back Press Clicked!");
 	}
	
	@Test(priority =5)
	public static void PermissionScreen() {
		try {
			for (int i = 1; i <= 3; i++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement permissionscreen = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("filemanager.files.fileexplorer.android.folder:id/nextitem")));
				permissionscreen.click();
				System.out.println("Permission Button Clicked !" + i);
			}
		} catch (Exception e) {
			System.out.println("Permission Button Not Clicked !");
			e.printStackTrace();
		}
	}

	@Test(priority =6)
	public static void Notification() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement allownotification = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
			if (allownotification.isDisplayed()) {
				allownotification.click();
				System.out.println("Notification Clicked !");
			}

		} catch (Exception e) {
			System.out.println("Notification not visible OR not Clicked !");
			Cleanertab();
		}
	}

	@Test(priority =7)
	public static void Cleanertab() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement cleaner = wait.until(ExpectedConditions.elementToBeClickable(
					By.id("filemanager.files.fileexplorer.android.folder:id/clean_master_btmnav")));
			cleaner.click();
			System.out.println("Cleaner Clicked !");
		} catch (Exception e) {
			System.out.println("Cleaner not Clicked !");
			e.printStackTrace();
		}
	}

	@Test(priority =8)
	public static void CleanupFlow() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement cleanup = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("filemanager.files.fileexplorer.android.folder:id/clean_up")));
			cleanup.click();
			System.out.println("CleanUp Clicked !");

			Thread.sleep(10000);
			
			// Cleanup1 button (agar visible ho)
			try {
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
				WebElement cleanup1 = wait1.until(ExpectedConditions
						.visibilityOfElementLocated(By.id("filemanager.files.fileexplorer.android.folder:id/delete_junk")));
				cleanup1.click();
				System.out.println("CleanUp1 Clicked !");
			} catch (TimeoutException e) {
				System.out.println("CleanUp1 button not visible after CleanUp.");
			}

		} catch (Exception e) {
			System.out.println("Error in Cleanup Flow!");
			e.printStackTrace();
		}
	}

	@Test(priority =9)
	public static void Duplicatefile() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement duplifile = wait.until(ExpectedConditions.elementToBeClickable(
					By.id("filemanager.files.fileexplorer.android.folder:id/duplicate_files_2")));
			duplifile.click();
			System.out.println("Duplicate Clicked !");
		} catch (Exception e) {
			System.out.println("Duplicate not Clicked !");
			e.printStackTrace();
		}
	}

	@Test(priority =10)
	public static void Photo() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement photos = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("filemanager.files.fileexplorer.android.folder:id/ll_photos")));
			photos.click();
			System.out.println("Photo Section Clicked !");
		} catch (Exception e) {
			System.out.println("Photo Section not Clicked !");
			e.printStackTrace();
		}
	}

	@Test(priority =11)
	public static void Photoviweall() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement viewall = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@resource-id='filemanager.files.fileexplorer.android.folder:id/viewall'][1]")));
			viewall.click();
			System.out.println("View All Clicked !");
		} catch (Exception e) {
			System.out.println("View All not Clicked !");
			e.printStackTrace();
		}
	}

	@Test(priority =12)
	public static void Photoseleteall() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement selectall = wait.until(ExpectedConditions.elementToBeClickable(By.id(
					"filemanager.files.fileexplorer.android.folder:id/menu_checkbox_select_all")));
			selectall.click();
			System.out.println("Select All Clicked !");
		} catch (Exception e) {
			System.out.println("Select All not Clicked !");
			e.printStackTrace();
		}
	}
	
	@Test(priority =13)
	public static void Deleteduplicate() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement deletedupli = wait.until(ExpectedConditions.elementToBeClickable(By.id(
					"filemanager.files.fileexplorer.android.folder:id/delete_duplicate")));
			deletedupli.click();
			System.out.println("Delete Duplicate Clicked !");
		} catch (Exception e) {
			System.out.println("Delete Duplicate not Clicked !");
			e.printStackTrace();
		}
	}
	
	@Test(priority =14)
	public static void Movetotrash() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement movetotrash = wait.until(ExpectedConditions.elementToBeClickable(By.id(
					"filemanager.files.fileexplorer.android.folder:id/folder_default")));
			movetotrash.click();
			System.out.println("movetotrash Clicked !");
		} catch (Exception e) {
			System.out.println("movetotrash not Clicked !");
			e.printStackTrace();
		}
	}

	@Test(priority =15)
	public static void Afterdelete() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement afterdelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
					"filemanager.files.fileexplorer.android.folder:id/ok_filter")));
			afterdelete.click();
			System.out.println("Afterdelete Clicked !");
		} catch (Exception e) {
			System.out.println("Afterdelete not Clicked !");
			e.printStackTrace();
		}
	}
	
	@Test(priority =16)
	// 🔙 Back Button	
		public  void pressBack1() throws InterruptedException {
			for (int j=1; j<=6; j++) {
				if(j==4) {
					
					driver.pressKey(new KeyEvent(AndroidKey.BACK));
				}
				System.out.println("Back Press Clicked!" + j);
				Thread.sleep(1000);
			}
			
		}
	
	@AfterTest
	public static void teardown() {
		
	}

}
