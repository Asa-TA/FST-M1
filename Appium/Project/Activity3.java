package Projectappium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity3 {
	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {

		// Desired Capabilities
		UiAutomator2Options caps = new UiAutomator2Options().setPlatformName("andriod")
				.setAutomationName("UiAutomator2").
				setAppPackage("com.google.android.keep").
				setAppActivity("com.google.android.apps.keep.ui.activities.BrowseActivity").
				noReset();
		
		
		//Set the Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
		
		//Initializing driver
		driver = new AndroidDriver(serverURL,caps);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
		
	
	@Test
	public void KeepAppTest() {
		
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("editable_title")));
		driver.findElement(AppiumBy.id("editable_title")).sendKeys("Test");
		driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Testnote_Asa");
		driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]")));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button\"]")));
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button\"]")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("save")));
		//driver.findElement(AppiumBy.id("save")).click();	
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\"])[1]")).click();
		driver.findElement(AppiumBy.id("(com.google.android.keep:id/reminder_chip_text")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Open navigation drawer")));
		//driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
		//driver.findElement(AppiumBy.id("com.google.android.keep:id/reminder_chip")).click();
		
		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
