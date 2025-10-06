package tests;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BaseClass {
	
	 AndroidDriver driver;

	@BeforeTest
	public void setup() {
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
			System.out.println("Application TestNG Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1)
	public void clickAllowButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/allow")));

			driver.findElement(By.id("com.rocks.music.videoplayer:id/allow")).click();
			System.out.println("Allow button clicked!");
		} catch (Exception e) {
			System.out.println("Allow button not found or already clicked.");
		}
	}

	@Test(priority = 2)
	public  void clickAllowButtongiven() {
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

	@Test(priority = 3)
	public  void clickNextButton() {
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
	
	@Test(priority =4)
	public  void clickDocumentHome() {
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
	
	@Test(priority = 5)
	public  void openvideo() {
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
	
	@Test(priority = 6)
	public  void clicktutorial() {
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
	
	@Test(priority = 7)
	public void controllerEnable() {
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
	
	@Test(priority = 8)
	public void playandpausevideo() {
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

	@Test(priority = 9)
	public void takescreenShot() {
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
	
	@Test(priority = 10)
	public void controllerEnable1() {
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

	@Test(priority = 11)
	public void videoplayerscreenbaackbtn() {
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
	@Test(priority = 12)
	public void clickDocumentBackbtn() {
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
	@Test(priority = 13)
	public void handleRatingOrNotification() {
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

	@Test(priority = 14)
	public void clicknotificationPermission() {
		try {

			List<WebElement> notification = driver
					.findElements(By.id("com.rocks.music.videoplayer:id/allowPermission"));

			if (!notification.isEmpty() && notification.get(0).isDisplayed()) {
				notification.get(0).click();
				System.out.println("Notification permission Bottom sheet Clicked");
			} else {
				profile();
			}
		} catch (Exception e) {
			System.out.println("Notification permission Bottom sheet Not visible and Not Clicked");
			e.printStackTrace();
		}
	}

	@Test(priority = 15)
	public void allowNotificationPermission() {
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
	
	
	@Test(priority = 16)
	public void profile() {
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

	
	@Test(priority = 17)
	public void Setting() {
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
	@Test(priority = 18)
	public void pressBack() throws InterruptedException {
		for(int i=1; i<=2; i++) {
			
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
		}
	}
	
	
	@Test(priority = 19)
	public void Exitbtn() {
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
	
	
	@AfterTest
	public void teardown() {
		
	}
}
