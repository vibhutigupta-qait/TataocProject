package stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;


public class Test_Steps {

public  WebDriver driver;
	
    @Given("^User is on Tatoc Home Page$")
	public void User_is_on_Home_Page() {
	    // Express the Regexp above with the code you wish you had
		System.setProperty("webdriver.firefox.driver","/home/vibhutigupta/Downloads/geckodriver.exe");
		
		 driver = new FirefoxDriver();
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
 
        driver.get("http://10.0.1.86/tatoc/basic");
		
	   
	}
}
