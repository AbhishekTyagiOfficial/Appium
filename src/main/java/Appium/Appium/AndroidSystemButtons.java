package Appium.Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidSystemButtons {
	
	 static AndroidDriver driver;

	 // Constructor
//	public AndroidSystemButtons(AndroidDriver driver) {
//		this.driver = driver;
//	}

	// 🔙 Back Button
	public static void pressBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	// 🏠 Home Button (App minimize ho jayega)
	public static void pressHome() {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

	// 📑 Recent Apps Button
	public static void pressRecentApps() {
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}

	// 🔊 Volume Up
	public static void pressVolumeUp() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
	}

	// 🔉 Volume Down
	public static void pressVolumeDown() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
	}

	// 🔇 Mute
	public static void pressMute() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_MUTE));
	}

	// 🔒 Power Button (Screen lock)
	public static void pressPower() {
		driver.pressKey(new KeyEvent(AndroidKey.POWER));
	}

	// 🔔 Notifications Panel
	public static void openNotifications() {
		driver.openNotifications();
	}
}
