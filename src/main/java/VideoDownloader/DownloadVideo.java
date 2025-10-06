package VideoDownloader;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DownloadVideo {
	
	static AndroidDriver driver;
	public static void main(String[] args) {
		openVD();
		DownloadVideo dv = new DownloadVideo();
		dv.permission();
		dv.permissionAllow();
		dv.fbWatch();
	}
	public static void openVD() {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:deviceName", "ffac23575ec0");
		dc.setCapability("appium:appPackage", "com.rocks.video.downloader");
		dc.setCapability("appium:appActivity", "com.rocks.video.downloader.MainBrowserActivity");
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:onReset", true);
		dc.setCapability("appium:ignoreHiddenApiPolicyError", true);
		dc.setCapability("appium:skipServerInstallation", true);

		
		try {
			URL url = new URL("http://127.0.0.1:4723");
			driver = new AndroidDriver(url,dc);
			System.out.println("Video Donwloader Open");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	public  void permission() {
		try {
			
			WebElement allowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.rocks.video.downloader:id/allow")));
			allowbtn.click();
			System.out.println("Permission Clicked!");
		}catch (Exception e) {
			System.out.println("Permission Not Clicked!");
			e.printStackTrace();
		}
	}
	
	public void permissionAllow() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement clickallowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_all_button")));
			clickallowbtn.click();
			System.out.println("Permission Allow btn Clicked!");
		}catch (Exception e) {
			System.out.println("Permission Allow btn Not Clicked!");
			e.printStackTrace();
		}
	}
	
	public  void fbWatch() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.rocks.video.downloader:id/videoSiteIcon\"])[2]")));
			facebook.click();
			System.out.println("facebook btn Clicked!");
		}catch (Exception e) {
			System.out.println("facebook btn Not Clicked!");
			e.printStackTrace();
		}
	} 
}
