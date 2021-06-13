package cucumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeInstantiator {
	public static WebDriver driver;	
	public static  List<Object> initiate(WebDriver driver){
		List<Object> results = new ArrayList<Object>();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		chromeOptions.addArguments("--incognito");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		results.add(driver);
		return results;

	}

}
