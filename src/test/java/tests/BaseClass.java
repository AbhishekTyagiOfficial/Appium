package tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
			URL url = new URL("http://127.0.0.1:4723"); // If we connected device from USB.
			driver = new AndroidDriver(url, dc);
			System.out.println("Application TestNG Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1)
	public void chaloBhaiSound() {
		try {
			File soundFile = new File("src/test/resources/sounds/chalo-bhai.wav");
			if (!soundFile.exists()) {
				System.out.println("⚠️ Sound file not found at: " + soundFile.getAbsolutePath());
				return;
			}
			AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(soundFile);
			Clip clip =  AudioSystem.getClip();
			clip.open(audioStream1);
			clip.start();
			System.out.println("🔊 Sound Played Successfully!");
			
			Thread.sleep(clip.getMicrosecondLength() / 1000);
			
			clip.close();
			audioStream1.close();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println("❌ Unsupported file type! Please use a .wav file.");
		} catch (IOException | LineUnavailableException |InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
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

	@Test(priority = 3)
	public void clickAllowButtongiven() {
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

	@Test(priority = 4)
	public void clickNextButton() {
		try {

			for (int i = 1; i <= 3; i++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/btn_next")));

				driver.findElement(By.id("com.rocks.music.videoplayer:id/btn_next")).click();
				System.out.println("Next button clicked!" + i);
				Thread.sleep(500);
			}

			// Update Bottom Sheet
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement updatesheet = wait.until(
					ExpectedConditions.elementToBeClickable(AppiumBy.id("com.rocks.music.videoplayer:id/crossSheet")));
			if (updatesheet.isDisplayed()) {
				updatesheet.click();
				System.out.println("Update Bottom sheet Clicked!");
			} else {
				System.out.println("Update Bottom sheet Not & visible Clicked!");
			}

		} catch (Exception e) {
			System.out.println("Allow button not found or already clicked.");
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void clickDocumentHome() {
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

	@Test(priority = 6)
	public void openvideo() {
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

	@Test(priority = 7)
	public void clicktutorial() {
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

	@Test(priority = 8)
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

	@Test(priority = 9)
	public void playandpausevideo() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement playandpause = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.id("com.rocks.music.videoplayer:id/media_controller_pause")));
			playandpause.click();
			System.out.println("Play/Pause Clicked!");

			// Rptate Screen
			WebElement rotate = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
					"//android.widget.LinearLayout[@resource-id=\"com.rocks.music.videoplayer:id/top_button_holder\"]/android.widget.LinearLayout[1]/android.widget.ImageButton")));
			for (int i = 1; i <= 2; i++) {
				rotate.click();
				Thread.sleep(2000);
			}

			// More Option
			WebElement morebtn = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@content-desc=\"More Options\"]")));
			morebtn.click();
			System.out.println("More Clicked");
			Thread.sleep(2000);

			// Equalizer
			WebElement equalizer = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
					"//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/optionEqualizer\"]")));
			equalizer.click();
			System.out.println("Equalizer Clicked");
			Thread.sleep(2000);

			// Equalizer Enable
			WebElement equalizerEnable = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
					"//android.widget.Switch[@resource-id=\"com.rocks.music.videoplayer:id/checkBoxCustomized\"]")));
			equalizerEnable.click();
			System.out.println("Equalizer Enable Clicked");
			Thread.sleep(2000);

			// Equalizer Cancel
			WebElement equalizerCancel = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
					.xpath("//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/cancel\"]")));
			equalizerCancel.click();
			System.out.println("Equalizer Cancel Clicked");
			Thread.sleep(2000);

			// Controller Invoke
			controllerEnable();

			// Loop < Repeat Enable
			try {
				WebElement morebtn1 = wait.until(ExpectedConditions.elementToBeClickable(
						AppiumBy.xpath("//android.widget.Button[@content-desc=\"More Options\"]")));
				morebtn1.click();
				System.out.println("More Clicked");
				Thread.sleep(2000);

				WebElement repeat = driver
						.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
								+ ".scrollIntoView(new UiSelector().resourceId(\"com.rocks.music.videoplayer:id/optionRepeatOneIcon\"))"));
				repeat.click();
				System.out.println("Repeat Clicked");
			} catch (Exception e) {
				System.out.println("Repeat Not Clicked");
				e.printStackTrace();
			}

			// More Cancel
			WebElement moreCancel = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
					.xpath("//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/cancel\"]")));
			moreCancel.click();
			System.out.println("More Button Cancel Clicked");
			Thread.sleep(2000);

			// Controller Invoke
			controllerEnable();

			WebElement speed = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"1.0X\"]")));
			speed.click();

			WebElement speedIncrease = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.id("com.rocks.music.videoplayer:id/increase_speed")));
			for (int i = 1; i <= 5; i++) {
				speedIncrease.click();
				System.out.println("Speed Increase Clicked" + i);
			}

			driver.pressKey(new KeyEvent(AndroidKey.BACK));

			// Controller Invoke
			controllerEnable();

			// Fit Videos
			WebElement Fit = wait.until(ExpectedConditions
					.elementToBeClickable(AppiumBy.id("com.rocks.music.videoplayer:id/media_controller_crop")));
			for (int i = 1; i <= 3; i++) {
				Fit.click();
				System.out.println("Speed Increase Clicked" + i);
				Thread.sleep(200);
			}

			WebElement playandpause1 = wait.until(ExpectedConditions
					.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/media_controller_pause")));
			playandpause1.click();
			System.out.println("Play Button Clicked");

		} catch (Exception e) {
			System.out.println("Play/Pause Not Clicked!");
			e.printStackTrace();
		}
	}

	@Test(priority = 10)
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

	@Test(priority = 11)
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

	@Test(priority = 12)
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

	@Test(priority = 13)
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

	@Test(priority = 14)
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

	@Test(priority = 15)
	public void clickDocumentHome1() {
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

	@Test(priority = 16)
	public void clickDocumentBackbtn1() {
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

	@Test(priority = 17)
	public void clicknotificationPermission() {
		try {

			List<WebElement> notification = driver
					.findElements(By.id("com.rocks.music.videoplayer:id/allowPermission"));

			if (!notification.isEmpty() && notification.get(0).isDisplayed()) {
				notification.get(0).click();
				System.out.println("Notification permission Bottom sheet Clicked");
			} else {
//				profile();
			}
		} catch (Exception e) {
			System.out.println("Notification permission Bottom sheet Not visible and Not Clicked");
			e.printStackTrace();
		}
	}

	@Test(priority = 18)
	public void allowNotificationPermission() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement allownotification = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
			if (allownotification.isDisplayed()) {
				allownotification.click();
				System.out.println("Allow Notification Permission Clicked");
			}

		} catch (Exception e) {
			System.out.println("Allow Notification Permission Not visible or Clicked");
			e.printStackTrace();
		}
	}

	@Test(priority = 19)
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

	@Test(priority = 20)
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

	@Test(priority = 21)
	public void pressBack() throws InterruptedException {
		for (int i = 1; i <= 2; i++) {

			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
		}
	}

	// ✅ Sound player method
	@Test(priority = 22)
	public void sound() {
		try {
			File soundFile = new File("src/test/resources/sounds/shabash-beta.wav");

			if (!soundFile.exists()) {
				System.out.println("⚠️ Sound file not found at: " + soundFile.getAbsolutePath());
				return;
			}

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
			System.out.println("🔊 Sound Played Successfully!");

			// Wait for sound to complete
			Thread.sleep(clip.getMicrosecondLength() / 1000);

			// Close everything
			clip.close();
			audioStream.close();

		} catch (UnsupportedAudioFileException e) {
			System.out.println("❌ Unsupported file type! Please use a .wav file.");
		} catch (IOException | LineUnavailableException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 23)
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
