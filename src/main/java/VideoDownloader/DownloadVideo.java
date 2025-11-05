package VideoDownloader;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

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
		dv.updateBottomSheet();
//		dv.fbWatch();
//		dv.fbWatchbottomSheet();
//		dv.vdownload();
		dv.facebook();
		dv.openBrowser();
		dv.openBrowserbottomsheet();
		dv.fblogin();
		dv.saveInfo();
	}	
	public static void openVD() {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:deviceName", "ffac23575ec0");
		//dc.setCapability("appium:deviceName", "JBDQSOO7FQXWHY7L");
		dc.setCapability("appium:appPackage", "com.rocks.video.downloader");
		dc.setCapability("appium:appActivity", "com.rocks.video.downloader.MainBrowserActivity");
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:noReset", false);
		dc.setCapability("appium:ignoreHiddenApiPolicyError", true);
		dc.setCapability("appium:skipServerInstallation", true);

		
		try {
			URL url = new URL("http://127.0.0.1:4723");
			driver = new AndroidDriver(url,dc);
			System.out.println("Video Donwloader Open");
			Thread.sleep(5000); // Wait 5 seconds for UI to appear

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	public  void permission() {
		try {
			WebElement allowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.rocks.video.downloader:id/allow")));
			if(allowbtn.isDisplayed()) {
				allowbtn.click();
				System.out.println("Permission Clicked!");
			}else {
				facebook();
			}
			
		}catch (Exception e) {
			System.out.println("Permission Not Clicked!");
			e.printStackTrace();
		}
	}
	
	public void permissionAllow() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement clickallowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_all_button")));
			if(clickallowbtn.isDisplayed())
			{
				clickallowbtn.click();
				System.out.println("Permission Allow btn Clicked!");
			}else {
				facebook();
			}
			
		}catch (Exception e) {
			System.out.println("Permission Allow btn Not Clicked!");
			e.printStackTrace();
		}
	}
	
	public void updateBottomSheet() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement ubs = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.rocks.video.downloader:id/crossSheet")));
			if(ubs.isDisplayed()) {
				ubs.click();
				System.out.println("UBS Clicked!");
			}else {
				facebook();
			}
		}catch (Exception e) {
			System.out.println("UBS Not visible & Clicked!");
			e.printStackTrace();
		}
	}
	
	public  void fbWatch() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement fbw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"com.rocks.video.downloader:id/videoSiteIcon\"])[2]")));
			fbw.click();
			System.out.println("facebook btn Clicked!");
		}catch (Exception e) {
			System.out.println("facebook btn Not Clicked!");
			e.printStackTrace();
		}
	}
 
	public  void fbWatchbottomSheet() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement fbwbs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.rocks.video.downloader:id/positive_button")));
			if (fbwbs.isDisplayed()) {
				fbwbs.click();
				System.out.println("facebook bottomSheet Clicked!");
			}else {
				
			}
			WebElement fbwcb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Close\"]")));

			if (fbwcb.isDisplayed()) {
				fbwcb.click();
				System.out.println("fbwcb Clicked!");
			}else {
				
			}
		}catch (Exception e) {
			System.out.println("facebook bottomSheet Not Clicked!");
			e.printStackTrace();
		}
	}
	
	public  void vdownload() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement vd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.Button")));
			if(vd.isDisplayed()) {
				vd.click();
				System.out.println("vdownload btn Clicked!");
			}
			
		}catch (Exception e) {
			System.out.println("vdownload btn Not Clicked!");
			e.printStackTrace();
		}
	}
	
	// FaceBook Clicked
	public  void facebook() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement fb = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.rocks.video.downloader:id/videoSiteIcon\"])[3]")));
			fb.click();
			System.out.println("Fb btn Clicked!");
		}catch (Exception e) {
			System.out.println("fb btn Not Clicked!");
			e.printStackTrace();
		}
	}
	
	// Open Browser
	public  void openBrowser() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement ob = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.rocks.video.downloader:id/browser_app")));
			ob.click();
			System.out.println("openBrowser btn Clicked!");
		}catch (Exception e) {
			System.out.println("openBrowser btn Not Clicked!");
			e.printStackTrace();
		}
	}
	
	// Browser Bottom Sheet
	public  void openBrowserbottomsheet() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement obbs = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.rocks.video.downloader:id/close")));
			if (obbs.isDisplayed()) {
				obbs.click();
				System.out.println("openBrowser btn Clicked!");
			}
			else {
				
			}
			
		}catch (Exception e) {
			System.out.println("openBrowser btn Not Clicked!");
			e.printStackTrace();
		}
	}
	
	// FaceBook login
	public  void fblogin() {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement fbl = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"m_login_email\"]")));
			if (fbl.isDisplayed()) {
				fbl.sendKeys("granthkarta@gmail.com");
				System.out.println("fblogin btn Clicked!");
			}else {
				System.out.println("fblogin btn Not Clicked!");
			}
			
			WebElement fblp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"m_login_password\"]")));
			fblp.sendKeys("Testing@123");
			System.out.println("fblp clicked!");
			
			WebElement fblb = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Log in']")));
			fblb.click();
			System.out.println("fblb clicked!");
			Thread.sleep(1000);
		}catch (Exception e) {
			System.out.println("fblogin btn Not Visible!");
			e.printStackTrace();
		}
	}
	
	// FaceBook login
		public  void saveInfo() {
			try {
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement saveinfo = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Save\"]")));
				if (saveinfo.isDisplayed()) {
					saveinfo.click();
					System.out.println("saveinfo btn Clicked!");
				}else {
					System.out.println("saveinfo btn Not Clicked!");
				}
				
				Thread.sleep(1000);
				WebElement home = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.rocks.video.downloader:id/go_home")));
				if (home.isDisplayed()) {
					home.click();
					System.out.println("home btn Clicked!");
				}else {
					System.out.println("home btn Not Clicked!");
				}
				
				Thread.sleep(1000);
				// Pehle rating dialog check karo
				List<WebElement> ratingDialog = driver.findElements(By.id("com.rocks.video.downloader:id/reallyBtn"));
				if (!ratingDialog.isEmpty() && ratingDialog.get(0).isDisplayed()) {
					ratingDialog.get(0).click();
					System.out.println("Rating dialog clicked!");
				} else {
					// Agar rating dialog nahi mila to Profile flow
					// profile();
				}
				Thread.sleep(1000);
				driver.quit();
				System.out.println("application closed!");
				
			}catch (Exception e) {
				System.out.println("fblogin btn Not Visible!");
				e.printStackTrace();
			}
		}

}
