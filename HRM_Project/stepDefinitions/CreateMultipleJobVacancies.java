package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateMultipleJobVacancies {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^Open the OrangeHRM​ page and login with given credentials$")
	public void openBrowser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@When("^Navigate to Recruitment page$")
	public void navigateToRecruitmentPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_dashboard_index")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_recruitment_viewRecruitmentModule")));
		WebElement dashboardLink = driver.findElement(By.id("menu_dashboard_index"));
		WebElement recruitmentLink = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));

		if (dashboardLink.isDisplayed()) {

			recruitmentLink.click();

		} else {

			dashboardLink.click();
			recruitmentLink.click();
		}
		
		Thread.sleep(3500);
	}

	@Then("^Click on Vacancies menu item$")
	public void navigateToVacanciesPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_recruitment_viewJobVacancy")));		
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	}

	@And("^Click on Add button$")
	public void navigateToAddVacancyPage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnAdd")));
		driver.findElement(By.id("btnAdd")).click();
	}

	@Then("^Fill out the required details \"(.*)\"$")
	public void fillAddJobVacancyForm(String vacancyName) {
		WebElement addJobVacancy_jobTitle = driver.findElement(By.id("addJobVacancy_jobTitle"));
		Select selectJobTitle = new Select(addJobVacancy_jobTitle);
		selectJobTitle.selectByValue("3");
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Test Employee");
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(Keys.ENTER);
	}

	@And("^Click the Save button to save the vacancy$")
	public void clickOnSaveButton() {
		driver.findElement(By.id("btnSave")).click();
	}

	@And("^Close browser$")
	public void closeTheBrowser() throws Throwable {
		driver.quit();
	}

}
