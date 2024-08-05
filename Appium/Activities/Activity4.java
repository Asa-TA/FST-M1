package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

   
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.ContactEditorActivity");
        options.noReset();

     
        URL serverURL = new URI("http://localhost:4723").toURL();

       
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   
    @Test
    public void contactsTest() {
      
        driver.findElement(AppiumBy.accessibilityId("create_contacts")).click();

     
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text=\"Name\"]")
        ));

       
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text=\\\"Name\\\"]")).sendKeys("Testcontact");
       
        //no last name field in phone
        /* driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text='Last name']"
        )).sendKeys("Varma");*/
        
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text=\"Phone\"]")).sendKeys("9154012001");
       
        driver.findElement(AppiumBy.id("com.android.contacts:id/menu_save")).click();

        
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.contacts:id/contact_name")));

        
        String contactName = driver.findElement(AppiumBy.id("com.android.contacts:id/contact_name")).getText();
        Assert.assertEquals(contactName, "Testcontact");
    }

   
    @AfterClass
    public void tearDown() {
      
        driver.quit();
    }
}
