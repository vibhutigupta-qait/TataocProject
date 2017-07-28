import java.awt.Desktop.Action;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TatocTestAdvance {
	  private static String display;
	
	

	public static String getDisplay() {
		return display;
	}



	public static void setDisplay(String display) {
		TatocTestAdvance.display = display;
	}



	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette","/home/vibhutigupta/Downloads/geckodriver.exe");
		//System.setProperty("webdriver.firefox.driver", "/home/vibhutigupta/Desktop/firefoxdriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://10.0.1.86/tatoc/advanced");
		Actions action = new Actions(driver);
		WebElement menu2 = driver.findElement(By.cssSelector(".menutitle"));
		action.moveToElement(menu2).moveToElement(driver.findElement(By.xpath("//span[text()='Go Next']"))).click().build().perform();
		
		
		display = driver.findElement(By.id("symboldisplay")).getText();
		System.out.println(display);
		WebElement ele1=driver.findElement(By.id("name"));
		ele1.click();
		JdbcConnectivity object = new JdbcConnectivity();
		object.setup();
		object.querystatements();
		
		
		System.out.println("name :"+JdbcConnectivity.getName());
		ele1.sendKeys(JdbcConnectivity.getName());
		WebElement ele2=driver.findElement(By.id("passkey"));
		ele2.click();
		System.out.println("passkey :"+JdbcConnectivity .getPasskey());
		ele2.sendKeys(JdbcConnectivity.getPasskey());
		driver.findElement(By.id("submit")).click();
	    object.close();
	    
	    
		

	}

}
