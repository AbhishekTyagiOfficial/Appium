package Appium.Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;

public class AppiumTest {

	static AndroidDriver driver;

	public static void main(String[] args) {
		openVideoplayer();
		clickAllowButton();
		clickAllowButtongiven();
		clickNextButton();
		clickDocumentHome();
		clickDocumentBackbtn();
		handleRatingOrNotification();
		clickDocumentHome();
		clickDocumentBackbtn();
		clicknotificationPermission();
		allowNotificationPermission();
//		profile();
		threedotbtn();
		clicksetting();
		notificationScreenOpen();
		notificationScreenbackbtn();
		settingbackbtn();
		HomeBackbtn();
		Exitbtn();
		// Homebackbtn();
	}

	public static void openVideoplayer() {
		DesiredCapabilities dc = new DesiredCapabilities();

		// Appium 3.x compatible capabilities
		// If Device connected through the Wifi.
		/*	
			dc.setCapability("appium:deviceName", "POCO M6 Pro 5G");
			dc.setCapability("appium:udid", "192.168.0.62:5555"); // adb devices
		*/
		dc.setCapability("appium:deviceName", "ffac23575ec0");
		dc.setCapability("platformName", "Android"); // W3C standard capability
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:appPackage", "com.rocks.music.videoplayer");
		dc.setCapability("appium:appActivity", "com.rocks.music.videoplayer.Splash");
		dc.setCapability("appium:automationName", "UiAutomator2");

		try {
			// Appium 3.x URL (no /wd/hub)
			URL url = new URL("http://127.0.0.81:4723");
			driver = new AndroidDriver(url, dc);
			System.out.println("Application Started...");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public static void clickAllowButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/allow")));

			driver.findElement(By.id("com.rocks.music.videoplayer:id/allow")).click();
			System.out.println("Allow button clicked!");
		} catch (Exception e) {
			System.out.println("Allow button not found or already clicked.");
		}
	}

	public static void clickAllowButtongiven() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_all_button")));

			driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_all_button")).click();
			System.out.println("Allow Permission clicked!");
		} catch (Exception e) {
			System.out.println("Allow Pemmission not found or already clicked.");
		}
	}

	public static void clickNextButton() {
		try {

			for (int i = 1; i <= 3; i++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/btn_next")));

				driver.findElement(By.id("com.rocks.music.videoplayer:id/btn_next")).click();
				System.out.println("Next button clicked!" + i);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("Allow button not found or already clicked.");
			e.printStackTrace();
		}
	}

	public static void clickDocumentHome() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"(//android.view.ViewGroup[@resource-id='com.rocks.music.videoplayer:id/relativeLayout3'])[1] ")));
			element.click();
			System.out.println("Document clicked!");
		} catch (Exception e) {
			System.out.println("Document not clicked!");
			e.printStackTrace();
		}
	}

	public static void clickDocumentBackbtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement documentbackbtn = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
			documentbackbtn.click();
			System.out.println("DocumentBack clicked!");
		} catch (Exception e) {
			System.out.println("DocumentBack Not Clicked");
			e.printStackTrace();
		}

	}

	public static void handleRatingOrNotification() {
		try {
			// Pehle rating dialog check karo
			List<WebElement> ratingDialog = driver.findElements(By.id("com.rocks.music.videoplayer:id/reallyBtn"));
			if (!ratingDialog.isEmpty() && ratingDialog.get(0).isDisplayed()) {
				ratingDialog.get(0).click();
				System.out.println("Rating dialog clicked!");
			} else {
				// Agar rating dialog nahi mila to Profile flow
				// profile();
			}
		} catch (Exception e) {
			System.out.println("Neither rating dialog nor Profile flow executed.");
			e.printStackTrace();
		}
	}

	public static void clicknotificationPermission() {
		try {

			List<WebElement> notification = driver
					.findElements(By.id("com.rocks.music.videoplayer:id/allowPermission"));

			if (!notification.isEmpty() && notification.get(0).isDisplayed()) {
				notification.get(0).click();
				System.out.println("Notification permission Bottom sheet Clicked");
			} else {
				threedotbtn();
			}
		} catch (Exception e) {
			System.out.println("Notification permission Bottom sheet Not visible and Not Clicked");
			e.printStackTrace();
		}
	}

	public static void allowNotificationPermission() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement allownotification = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
			allownotification.click();
			System.out.println("Allow Notification Permission Clicked");
		} catch (Exception e) {
			System.out.println("Allow Notification Permission Not visible or Clicked");
			e.printStackTrace();
		}
	}

	/*
	 * CLICK ON PROFILE public static void profile() { try { WebDriverWait wait =
	 * new WebDriverWait(driver, Duration.ofSeconds(10)); WebElement profile =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "(//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/navigation_bar_item_icon_view\"])[5]"
	 * ))); profile.click(); System.out.println("Profile Clicked"); } catch
	 * (Exception e) { System.out.println("Profile Not Clicked");
	 * e.printStackTrace(); } }
	 */

	public static void threedotbtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement threedot = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/three_dot")));
			threedot.click();
			System.out.println("Three Dot clicked!");

		} catch (Exception e) {
			System.out.println("Three Dot Not clicked!");
			e.printStackTrace();
		}
	}

	public static void clicksetting() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement setting = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//android.view.View[@resource-id=\"com.rocks.music.videoplayer:id/action_settings\"]")));
			setting.click();
			System.out.println("Setting Clicked");

		} catch (Exception e) {
			System.out.println("Setting Not Clicked");
			e.printStackTrace();
		}
	}

	public static void notificationScreenOpen() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement notificationOpen = wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Notification\"]")));
			notificationOpen.click();
			System.out.println("Notification Screen Clicked");
		} catch (Exception e) {
			System.out.println("Notification Screen Not Clicked");
			e.printStackTrace();
		}
	}

	public static void notificationScreenbackbtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement notificationScreenback = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/q3icon\"]\r\n" + "")));
			notificationScreenback.click();
			System.out.println("Notification Back Clicked");
		} catch (Exception e) {
			System.out.println("Notification Back Not Clicked");

			e.printStackTrace();
		}
	}

	public static void settingbackbtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement settingback = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));
			settingback.click();
			System.out.println("Setting Back Clicked");
		} catch (Exception e) {
			System.out.println("Setting Back Not Clicked");
			e.printStackTrace();
		}
	}

	public static void HomeBackbtn() {
		try {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			System.out.println("Home Back Button Clicked");
		} catch (Exception e) {
			System.out.println("Home Not Clicked");
			e.printStackTrace();
		}
	}

	public static void Exitbtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement exit = wait.until(
					ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/view_exit_app")));
			if (exit.isDisplayed()) {
				exit.click();
				System.out.println("Exit button Clicked!");
			} else {
				System.out.println("Exit button Not Clicked!");
			}

		} catch (Exception e) {
			System.out.println("Exit button Not Clicked!");
			e.printStackTrace();
		}
	}

}
