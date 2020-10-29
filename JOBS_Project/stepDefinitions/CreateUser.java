package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUser {

	WebDriver driver;
	WebDriverWait wait;
	Double d = (Math.random() + 1) * 1000;
	String userName = "Username_" + Math.round(d);
	String emailId = userName + "@gmail.com";
	@Given("^Open a browser$")
	public void openBrowser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
	}

	@When("^Navigate to Alchemy Jobs and log in$")
	public void logIn() throws Throwable {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
	}

	@Then("^Click the menu item Users$")
	public void clickOnUsers() {
		driver.findElement(By.xpath("//a/div[text()='Users']")).click();
	}

	@And("^Click on Add New Button$")
	public void clickAddNewButton() {
		driver.findElement(By.linkText("Add New")).click();
	}

	@Then("^Fill in the required details$")
	public void fillInUserDetails() {
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys(userName);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(emailId);
	}

	@And("^Click on Add New User button$")
	public void clickAddNewUserButton() {
		driver.findElement(By.id("createusersub")).click();
	}

	@Then("^Verify that the user is created$")
	public void verifyUserCreation() {
		driver.findElement(By.id("user-search-input")).clear();
		driver.findElement(By.id("user-search-input")).sendKeys(userName);
		driver.findElement(By.id("search-submit")).click();
		String actualUserName = driver.findElement(By.linkText(userName)).getText();
		Assert.assertEquals(actualUserName, userName);
	}

	@And("^Close the browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}
}
