package Activities;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.mms");
        options.setAppActivity(".ui.ComposeMessageActivity");
        options.noReset();

       
        URL serverURL = new URI("http://localhost:4723").toURL();
 
        
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    @Test
    public void smsTest() {
        driver.findElement(AppiumBy.id("Messages")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("New message")
        ));

        driver.findElement(AppiumBy.id("To")).sendKeys("8870004500");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("embedded_text_editor")));

        driver.findElement(AppiumBy.id("embedded_text_editor")).sendKeys("Hello from Appium");
        // Press Send
        driver.findElement(AppiumBy.accessibilityId("Send")).click();

        // Assertion
        String messageTextSent = driver.findElement(AppiumBy.id("Messages")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
