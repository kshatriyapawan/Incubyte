package gluecode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.ChromeInstantiator;

public class GlueCodeGmail {
	WebDriver driver;
	WebDriverWait wait;
	
	String email="YOUR_EMAIL_ID";
	String pswd="YOUR_PASSWORD";
	String rec_email="RECP_EMAIL_ID";
	
	List<Object> result = ChromeInstantiator.initiate(driver);

	@Given("^navigate to Gmail page$")
	public void navigate_to_Gmail_page() throws Throwable {
		String chromeDriverPath = "YOUR_CHROME_DRIVER_PATH";
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		
		driver = (WebDriver)result.get(0);
		wait = new WebDriverWait(driver, 30L);
		String url="https://mail.yahoo.com/";
		driver.get(url);
	}

	@Given("^user logged in using username and password$")
	public void user_logged_in_using_username_and_password() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sign in']")));
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-username']")));		
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='signin']")));
		driver.findElement(By.xpath("//*[@name='signin']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-passwd']")));
		driver.findElement(By.xpath("//*[@id='login-passwd']")).sendKeys(pswd);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-signin']")));
		driver.findElement(By.xpath("//*[@id='login-signin']")).click();
		Thread.sleep(3000L);
		
	}
	@Given("^gmail mailbox page should be displayed$")
	public void gmail_mailbox_page_should_be_displayed() throws Throwable {
		String exp_mail_title="Yahoo Mail";
		String actual_mail_title=driver.findElement(By.xpath("//*[@id='ybar-logo']")).getText();
		Assert.assertEquals(exp_mail_title,actual_mail_title);		
	}

	@Given("^User clicks on compose email$")
	public void user_clicks_on_compose_email() throws Throwable {
		Thread.sleep(3000L);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Compose']")));
		driver.findElement(By.xpath("//a[text()='Compose']")).click();

	}

	@When("^Compose an email and send it$")
	public void compose_an_email_and_send_it() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message-to-field']")));
		driver.findElement(By.xpath("//*[@id='message-to-field']")).sendKeys(rec_email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Subject']")));
		driver.findElement(By.xpath("//*[@placeholder='Subject']")).sendKeys("Incubyte-Pawan Singh");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Message body']")));
		driver.findElement(By.xpath("//*[@aria-label='Message body']")).sendKeys("Incubyte Evaluation Test Passed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Compose']")));
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		Thread.sleep(3000L);
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test-id='displayed-count']")));
		driver.close();
	}

}
