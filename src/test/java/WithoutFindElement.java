import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WithoutFindElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.marionette","/home/vibhutigupta/Downloads/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://10.0.1.86/tatoc/basic");
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
        js.executeScript(" document.getElementsByClassName('greenbox')[0].click();");
        driver.switchTo().frame("main");
        String boxcolo =  (String)((WebElement) js.executeScript("return document.evaluate( \"//div[@id='answer']\" ,"
        		+ "document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;")).getAttribute("class");
       // String boxcolo = (String) js.executeScript(" return document.getElementById('answer')[0].className");
        System.out.println(boxcolo);
        while(true){
			driver.switchTo().frame("child");
			String box2color=(String)((WebElement) js.executeScript("return document.evaluate( \"//div[@id='answer']\" ,"
	        		+ "document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;")).getAttribute("class");
			
			System.out.println(box2color);
			
        if(boxcolo.equals(box2color)){
	     driver.switchTo().parentFrame();
	     js.executeScript("document.getElementsByTagName('a')[1].click()");
	 
	     break;
	     
		}
       else{
       driver.switchTo().parentFrame();
      // driver.findElement(By.linkText("Repaint Box 2")).click();
       js.executeScript("document.getElementsByTagName('a')[0].click()");
       
       }
       
       
		} 
		
		//WebElement from = driver.findElement(By.id("dragbox"));
		WebElement from = driver.findElement(By.id("dragbox"));
		WebElement to = driver.findElement(By.id("dropbox"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(from, to).perform();
		 js.executeScript("document.getElementsByTagName('a')[1].click()");
	   // driver.findElement(By.linkText("Proceed")).click();
	    /*String oldtab = driver.getWindowHandle();
	    
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
        driver.findElement(By.linkText("Proceed")).click();;*/
		  
		  
		
		}
        
        

	}


