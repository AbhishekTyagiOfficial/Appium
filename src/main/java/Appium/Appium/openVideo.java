package Appium.Appium;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class openVideo {

	static AndroidDriver driver;

	public static void main(String[] args) {
		videoplayer();

		AppiumTest.driver = driver; // isse AppiumTest ke static methods same driver use karenge.
		//AndroidSystemButtons.driver = driver;
		AndroidSystemButtons asb = new AndroidSystemButtons(driver); // Create
		// instance
		AppiumTest.clickAllowButton();
		AppiumTest.clickAllowButtongiven();
		AppiumTest.clickNextButton();
		AppiumTest.clickDocumentHome();
		openvideo();
		clicktutorial();
		controllerEnable();
		playandpausevideo();
		takescreenShot();
		controllerEnable();
		videoplayerscreenbaackbtn();
		AppiumTest.clickDocumentBackbtn();
		AppiumTest.handleRatingOrNotification();
		profile();
		Setting();
		asb.pressBack();
		asb.pressBack();
		AppiumTest.Exitbtn();

	}

	public static void videoplayer() {
		DesiredCapabilities dc = new DesiredCapabilities();

		// If Device connected through the Wifi.
		/*
		 * dc.setCapability("appium:deviceName", "POCO M6 Pro 5G");
		 * dc.setCapability("appium:udid", "192.168.0.62:5555"); // adb devices
		 */
		dc.setCapability("appium:deviceName", "ffac23575ec0");
		dc.setCapability("platformName", "Android"); // W3C standard capability
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:appPackage", "com.rocks.music.videoplayer");
		dc.setCapability("appium:appActivity", "com.rocks.music.videoplayer.Splash");
		dc.setCapability("appium:automationName", "UiAutomator2");

		try {
//			URL url = new URL("http://127.0.0.81:4723");  
			URL url = new URL("http://127.0.0.1:4723");	// If we connected device from USB. 
			driver = new AndroidDriver(url, dc);
			System.out.println("Application Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void openvideo() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement openvideo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"(//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/thumbnailimageView1\"])[1]")));
			openvideo.click();
			System.out.println("Video Clicked!");
		} catch (Exception e) {
			System.out.println("Video Not Clicked!");
			e.printStackTrace();
		}
	}

	public static void clicktutorial() {
		try {
			for (int i = 1; i <= 2; i++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement tutorial = wait.until(
						ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/tv_got_it")));
				tutorial.click();
				System.out.println("Tutorial Clicked!" + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("Tutorial Not Clicked!");
			e.printStackTrace();
		}
	}

	public static void controllerEnable() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement controllerenable = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/media_controller_gestures_area")));
			controllerenable.click();
			System.out.println("Controller Enable Clicked!");
		} catch (Exception e) {
			System.out.println("Controller Enable Not Clicked!");
			e.printStackTrace();
		}
	}

	public static void playandpausevideo() {
		for (int i = 1; i <= 2; i++) {
			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement playandpause = wait.until(ExpectedConditions
						.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/media_controller_pause")));
				playandpause.click();
				System.out.println("Play/Pause Clicked!" + i);
			}

			catch (Exception e) {
				System.out.println("Play/Pause Not Clicked!");
				e.printStackTrace();
			}
		}
	}

	public static void takescreenShot() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement playandpause = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.RelativeLayout[@resource-id=\"com.rocks.music.videoplayer:id/media_controller_root\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.ImageButton")));
			playandpause.click();
			System.out.println("TakeScreenShoot Clicked!");
		} catch (Exception e) {
			System.out.println("TakeScreenShoot Not Clicked!");
			e.printStackTrace();
		}
	}

	public static void videoplayerscreenbaackbtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement videoplayerscreenbaackbtn = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
			videoplayerscreenbaackbtn.click();
			System.out.println("Video Player Screen Back Press Clicked!");
		} catch (Exception e) {
			System.out.println("Video Player Screen Back Press Not Clicked!");
			e.printStackTrace();
		}
	}

	public static void profile() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"(//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/navigation_bar_item_icon_view\"])[5]\r\n"
							+ "")));
			profile.click();
			System.out.println("Profile Clicked");
		} catch (Exception e) {
			System.out.println("Profile Not Clicked");
			e.printStackTrace();
		}
	}

	public static void Setting() {
		try {
			WebElement element = driver
					.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
							+ ".scrollIntoView(new UiSelector().resourceId(\"com.rocks.music.videoplayer:id/setting_text\"))"));
			element.click();
			System.out.println("Settings Clicked");
		} catch (Exception e) {
			System.out.println("Settings Not Clicked");
			e.printStackTrace();
		}
	}

}
