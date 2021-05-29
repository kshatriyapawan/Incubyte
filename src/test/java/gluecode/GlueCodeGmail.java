package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlueCodeGmail {
	public static WebDriver driver;	
	String chromeDriverPath="/home/pawan/Desktop/chromedriver"; // PLZ SPECIFY YOUR DRIVER PATH
	WebDriverWait wait=null;
	static String email="YOUR_EMAIL_ID";
	static String pswd="YOUR_PASSWORD";



	@Given("^User logged on to Gmail home page$")
	public void user_logged_on_to_Gmail_home_page() throws Throwable {		
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30L);
		driver.manage().window().maximize();
		String url="https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		driver.get(url);
	}

	@When("^User navigates to Login Page and User enetrs credentials$")
	public void user_navigates_to_Login_Page_and_User_enetrs_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='identifierId']")));
		driver.findElement(By.xpath("//*[@id='identifierId']")).click();
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
		driver.findElement(By.xpath("//span[text()='Next']")).sendKeys(pswd);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwordNext']/div/button/div[2]")));
		driver.findElement(By.xpath("//*[@id='passwordNext']/div/button/div[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit_approve_access']/span")));
		driver.findElement(By.xpath("//*[@id='submit_approve_access']/span")).click();
	    
	}

	@When("^User lands on Mailbox page$")
	public void user_lands_on_Mailbox_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@gh='cm']")));
		driver.findElement(By.xpath("//*[@gh='cm']")).click();
	}

	@Then("^Compose an email and send it$")
	public void compose_an_email_and_send_it() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='to']")));
		driver.findElement(By.xpath("//*[@name='to']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@name='subjectbox']")).sendKeys("Test Automation Craftsperson Open House");
		driver.findElement(By.xpath("//*[@class='gmail_default']")).click();
		driver.findElement(By.xpath("//*[@class='gmail_default']")).sendKeys("Hi Incubyte");
		driver.findElement(By.xpath("//*[@id=':pg']")).click();
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}
}
