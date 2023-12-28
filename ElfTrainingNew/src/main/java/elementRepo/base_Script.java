package elementRepo;
/***
 * @author admin
 * This class will launch the browser and Login the user before every Test case execution
 * Once test case is completed it will logout the user and close the browser
 */
import java.time.Duration;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class base_Script{
	public static WebDriver driver;

@BeforeClass

public void launchBrowser() {
	//launch browser in Chrome
	 driver= new ChromeDriver();
	Reporter.log("Browser Launched", true);
	//maximize windiow
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	//enter URL and launch
	driver.get("https://demowebshop.tricentis.com/login");
	Reporter.log("URL entered", true);
	
	//enter login details and login
	driver.findElement(By.id("Email")).sendKeys("shreepaddaundkar@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Asdfghjkl@123");
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	Reporter.log("Logged In", true);
	
	
	
}
@AfterMethod
public void logout() {
	
	
	//logout from the account
	driver.findElement(By.xpath("//a[text()='Log out']")).click();
	
	//close the browser
	driver.quit();
}
}
