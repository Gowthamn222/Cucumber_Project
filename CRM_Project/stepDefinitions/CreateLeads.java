package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateLeads {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open the browser with ​Alchemy CRM​ site and login$")
	public void loginCRM() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).clear();
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
	}
	
	@Then("^Navigate to Sales -> Leads -> Create Lead$")
	public void navigateToCreateLead() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".dashlet-title")));
		WebElement salesLink = driver.findElement(By.id("grouptab_0"));
		Actions action = new Actions(driver);
		action.moveToElement(salesLink).build().perform();
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Create Lead']")));
		driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
	}

	@And("^Fill in \"(.*)\", \"(.*)\" details to create lead accounts$")
	public void updateCreateLead(String fName, String lName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys(fName);
		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys(lName);
 	}
	
	@Then("^Click Save Leads$")
	public void clickOnSave() {
		driver.findElement(By.id("SAVE")).click();
	}
	
	@And("^Navigate to the View Leads page for results$")
	public void navigateToViewLeads() throws InterruptedException {
		Thread.sleep(3500);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='View Leads']")));
		driver.findElement(By.xpath("//div[text()='View Leads']")).click();
		Thread.sleep(3000);

	}
	
	@And("^Close Browser$")
	public void closeBrowser() throws Throwable {
		driver.quit();
	}
}
