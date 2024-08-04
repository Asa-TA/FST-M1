package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClassroomActivity1 {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
 @Given("User is on the DuckDuckGo website")
  public void user_is_on_ddg_website() {
	 driver.get("https://duckduckgo.com");
			 assertEquals("DuckDuckGo — Privacy, simplified.",driver.getTitle());
 }
 
	 
 
 @When("User searches for Cheese")
 public void user_searches_for_cheese() {
	 driver.findElement(By.id("searchbox_input")).sendKeys("Cheese");
	 driver.findElement(By.cssSelector("button.searchbox_searchButton__F5Bwq")).click();
	 //button.searchbox_searchButton__F5Bwq
 }
	 
			 
			 
 @Then("User should see search results")
 public void user_should_see_results() {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-results--main")));
	 WebElement results = driver.findElement(By.cssSelector(".react-results--main"));
	 assertNotNull(results);
 }
	 
@After
public void teardown() {
	driver.quit();
}

	
}

 
