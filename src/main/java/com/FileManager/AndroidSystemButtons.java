package com.FileManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidSystemButtons {
	
	 private AndroidDriver driver;

	 // Constructor
	public AndroidSystemButtons(AndroidDriver driver) {
		this.driver = driver;
	}

	// 🔙 Back Button	
	public  void pressBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		System.out.println("Back Press Clicked!");
	}

	// 🏠 Home Button (App minimize ho jayega)
	public  void pressHome() {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

	// 📑 Recent Apps Button
	public void pressRecentApps() {
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}

	// 🔊 Volume Up
	public void pressVolumeUp() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
	}

	// 🔉 Volume Down
	public void pressVolumeDown() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
	}

	// 🔇 Mute
	public void pressMute() {
		driver.pressKey(new KeyEvent(AndroidKey.VOLUME_MUTE));
	}

	// 🔒 Power Button (Screen lock)
	public void pressPower() {
		driver.pressKey(new KeyEvent(AndroidKey.POWER));
	}

	// 🔔 Notifications Panel
	public void openNotifications() {
		driver.openNotifications();
	}
}
