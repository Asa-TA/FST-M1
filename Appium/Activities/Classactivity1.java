package demos;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Classactivity1 {
    AppiumDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException {
    	UiAutomator2Options caps = new UiAutomator2Options().
    			setPlatformName("Android").
    			setAutomationName("UiAutomator2").
    			setAppPackage("com.vivo.calculator").
    			setAppActivity(".Calculator").
    			noReset();
    	
    	URL serverURL = new URI("http://locolhost:4723").toURL();
    	
    	driver= new AndroidDriver(serverURL, caps);
    	
    }
    @Test
    public void add() {
    	driver.findElement(AppiumBy.id("com.vivo.calculator:id/digit_5")).click();
    	driver.findElement(AppiumBy.id("plus")).click();
    	driver.findElement(AppiumBy.id("com.vivo.calculator:id/digit_9")).click();
    	driver.findElement(AppiumBy.id("com.vivo.calculator:id/eq")).click();
    	String result = driver.findElement(AppiumBy.id("com.vivo.calculator:id/formula")).getText();		
		Assert.assertEquals(result, "=14");
        
    }
    
    @AfterClass
    public void teardown() {
    	driver.quit();
    }
}
