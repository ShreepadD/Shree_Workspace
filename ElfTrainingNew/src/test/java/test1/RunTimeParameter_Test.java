package test1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class RunTimeParameter_Test {
@Test
public void launch() {
	WebDriver driver=null;
	String browserName = System.getProperty("bname");
	if(browserName.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("safari")) {
		driver= new SafariDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.coursera.org/");
	driver.quit();
}

}
