package Appium.Appium;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
	
	// ✅ Sound player method
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
}
