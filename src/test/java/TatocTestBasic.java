import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class TatocTestBasic {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette","/home/vibhutigupta/Downloads/geckodriver.exe");
		//System.setProperty("webdriver.firefox.driver", "/home/vibhutigupta/Desktop/firefoxdriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://10.0.1.86/tatoc/basic");
		driver.findElement(By.className("greenbox")).click();
		
		//String text = driver.findElement(By.linkText("Box 2");
		driver.switchTo().frame("main");
		String box1color= driver.findElement(By.id("answer")).getAttribute("class")	;
		System.out.println(box1color);
		while(true){
			driver.switchTo().frame("child");
			String box2color = driver.findElement(By.id("answer")).getAttribute("class");
			System.out.println(box2color);
			
        if(box1color.equals(box2color)){
	     driver.switchTo().parentFrame();
	     driver.findElement(By.linkText("Proceed")).click();
	     break;
	     
		}
       else{
       driver.switchTo().parentFrame();
       driver.findElement(By.linkText("Repaint Box 2")).click();
       }
       
       
		} 
		
		//WebElement from = driver.findElement(By.id("dragbox"));
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(from, to).perform();
	    driver.findElement(By.linkText("Proceed")).click();
	    String oldtab = driver.getWindowHandle();
	    driver.findElement(By.linkText("Launch Popup Window")).click();
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldtab);
	    driver.switchTo().window(newTab.get(0));
	   // assertAdvertisingBlog();
	    //String handle1 = driver.getWindowHandle();
	    //System.out.println(handle);
	    //driver.switchTo().window(handle1);
	    WebElement name= driver.findElement(By.id("name"));;
	    name.click();
	    name.sendKeys("vibhutigupta");
	    driver.findElement(By.id("submit")).click();
	    driver.switchTo().window(oldtab);
	    
	    driver.findElement(By.linkText("Proceed")).click();
	    driver.findElement(By.linkText("Generate Token")).click();
        String token = driver.findElement (By.id("token")).getText();
        System.out.println(token);
        String tokenvalue = token.substring(7);
        
        
        driver.manage().addCookie(new Cookie("Token", tokenvalue));
        driver.findElement(By.linkText("Proceed")).click();;
		  
		  
		
		}
		
	
 
	}


