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

import org.json.JSONObject;
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

public class VideoPlayerNotification {

	static AndroidDriver driver;
	//static WebDriverWait wait;
	
	@BeforeTest
	public static void setup() {
		DesiredCapabilities vp = new DesiredCapabilities();

		vp.setCapability("platformName", "Android");
		vp.setCapability("appium:deviceName", "ffac23575ec0a");
		vp.setCapability("appium:platformVersion", "15");
		vp.setCapability("appium:appPackage", "com.rocks.music.videoplayer");
		vp.setCapability("appium:appActivity", "com.rocks.music.videoplayer.Splash");
		vp.setCapability("appium:automationName", "UiAutomator2");
//		vp.setCapability("appium:noReset", true);
//		vp.setCapability("appium:newCommandTimeout", 300);

		try {
			URL url = new URL("http://127.0.0.1:4723");
			driver = new AndroidDriver(url, vp);
			System.out.println("Application Invoked...");
			//wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
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
	
	@Test(priority=2)
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

	@Test(priority=3)
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

	@Test(priority=4)
	public static void clickNextButton() {
		try {

			for (int i = 1; i <= 3; i++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement nextbtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.rocks.music.videoplayer:id/btn_next")));

				//driver.findElement(By.id("com.rocks.music.videoplayer:id/btn_next")).click();
				nextbtn.click();
				System.out.println("Next button clicked!" + i);
				Thread.sleep(500);
			}
			
			//Update Bottom Sheet
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement updatesheet = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.rocks.music.videoplayer:id/crossSheet")));
    		
    		if (updatesheet.isDisplayed()) {
    			updatesheet.click();
    			System.out.println("Update Bottom sheet Clicked!");
    		}else {
    			System.out.println("Update Bottom sheet Not & visible Clicked!");
    		}
    		
		} catch (Exception e) {
			System.out.println("Permission not found or already clicked.");
			e.printStackTrace();
		}
	}
	
	@Test(priority=5)
	public static void profile() {
		try {
					
			// Profile Click
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"(//android.widget.ImageView[@resource-id=\"com.rocks.music.videoplayer:id/navigation_bar_item_icon_view\"])[5]")));
			profile.click();
			System.out.println("Profile Clicked");
		} catch (Exception e) {
			System.out.println("Profile Not Clicked");
			e.printStackTrace();
		}
	}

	@Test(priority=6)
	public static void Setting() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
	
	@Test(priority=7)
	public static void NotificationOpen() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement notificationOpen = wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.rocks.music.videoplayer:id/recycler_view\"]/android.view.ViewGroup[5]")));
			notificationOpen.click();
			System.out.println("Notification Open Screen Clicked");
		} catch (Exception e) {
			System.out.println("Notification Open Screen Not Clicked");
			e.printStackTrace();	
		}
	}
	
	@Test(priority=8)
	public static void Notificationtoggel() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement nt = wait.until(ExpectedConditions.elementToBeClickable(By
					.id("com.rocks.music.videoplayer:id/switch1")));
			nt.click();
			System.out.println("Notification toggel Clicked");
		} catch (Exception e) {
			System.out.println("Notification toggel Not Clicked");
			e.printStackTrace();
		}
	}
	
	@Test(priority=9)
	public static void NotificationBototmSheet() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement nbs = wait.until(ExpectedConditions.elementToBeClickable(By
					.id("com.rocks.music.videoplayer:id/allowPermission")));
			if (nbs.isDisplayed()) {
				nbs.click();
				System.out.println("Notification Bototm Sheet Clicked");
			}
			
		} catch (Exception e) {
			System.out.println("Notification Bototm Sheet Not Clicked");
			e.printStackTrace();
		}
	}
	
	@Test(priority=10)
	public static void NotificationGivenPermission() throws InterruptedException  {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ngp = wait.until(ExpectedConditions.elementToBeClickable(By
					.id("com.android.permissioncontroller:id/permission_allow_button")));
				ngp.click();
				System.out.println("Notification Given Clicked");		
		} catch (Exception e) {
			System.out.println("Notification Given Not Clicked");
			e.printStackTrace();
		}
		Thread.sleep(10000);
	}
	
	
	@Test(priority=11)
	public static void invokeNotification() {
	
		driver.openNotifications();
		System.out.println("Notification panel opend.");

		// --- Parse JSON
		String data = "{\"title\":\"Racing fun awaits\", \"body\":\"Let's play and have fun🎮😍\", \"large_icon\":\"https://content.delivery-asset.com/img/default/Notification/41bc53f5-0af8-4d51-8962-e1506ce6cfc2.png\", \"big_image\":\"https://content.delivery-asset.com/img/default/Notification/d746037f-4083-42fa-a030-1a675c4f107d.jpg\",\"landing_type\":\"GAME\", \"landing_value\":\"https://play.amezgame.com/turbotrafficracer/index.html\",\"toolbar_title\":\"Turbo Traffic Racer\", \"app_version\":\"589\"}";

		JSONObject json = new JSONObject(data);

		String titleFromJson = json.getString("title");
		String bodyFromJson = json.getString("body");

		System.out.println("Title from JSON : " + titleFromJson);
		System.out.println("Body from JSON : " + bodyFromJson);

		// Find Notification
		List<WebElement> titles = driver.findElements(AppiumBy.id("android:id/title"));
		List<WebElement> texts = driver.findElements(AppiumBy.id("android:id/text"));

		boolean notificationFound = false;
		for (int i = 0; i < titles.size(); i++) {
			String title = titles.get(i).getText();
			String text = (i < texts.size()) ? texts.get(i).getText() : "";

			if (title.contains(titleFromJson) || text.contains(bodyFromJson)) {
				titles.get(i).click();
				notificationFound = true;
				System.out.println("✅ Clicked on notification: " + titleFromJson);
				break;
			}
		}

		if (!notificationFound) {
			System.out.println("⚠️ Notification not found: " + titleFromJson);
		}
	}
	
	@Test(priority=12)
	// 🔙 Back Button	
			public static void pressBack() {
					driver.pressKey(new KeyEvent(AndroidKey.BACK));
					System.out.println("Back press Clicked");
			}
	
	@Test(priority=13)
	public static void backDialog() {
		WebElement backDialog = driver.findElement(AppiumBy.id("com.rocks.music.videoplayer:id/yesBtn"));
		backDialog.click();
		System.out.println("Back Dialog Clicked");
	}
	
	@Test(priority=14)
	// 🔙 Back Button	
			public static void pressBack1() throws InterruptedException {
		for (int i=1; i<=4; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			System.out.println("Back press Clicked" +i);
			Thread.sleep(9000);
		}		
	}
	public void khtamSound() {
		try {
			File soundFile = new File("src/test/resources/sounds/khatam-tata-bye-bye.wav");

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
	
	@Test(priority=15)
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
	
	@AfterTest
	public static void end() {
		
	}
}
