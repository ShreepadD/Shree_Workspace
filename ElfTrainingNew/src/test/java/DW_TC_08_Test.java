import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepo.Excel_Lib;
/***
 * @author admin
 * This test case is used to verify whether user can register with valid details
 */
public class DW_TC_08_Test {
@Test
public void register() throws EncryptedDocumentException, FileNotFoundException, IOException {
	Excel_Lib e= new Excel_Lib();
	ChromeDriver driver= new ChromeDriver();
	SoftAssert softAssert= new SoftAssert();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.linkText("Register")).click();

	
	String gender= e.readStringData("Sheet2", 2, 1);
	String firstName=e.readStringData("Sheet2", 2, 2);
	String lastName= e.readStringData("Sheet2", 2, 3);
	String email= e.readStringData("Sheet2", 2, 4);
	String password=e.readStringData("Sheet2", 2, 5);
	String cnfrmPassword=e.readStringData("Sheet2", 2, 6);

	//Enter gender in Registration
	driver.findElement(By.xpath("//input[@value='"+gender+"']")).click();
	Reporter.log("Gender selected  successfully",true);
	
	//enter first name
	driver.findElement(By.id("FirstName")).sendKeys(firstName);
	Reporter.log("First name entered  successfully",true);
	
	//enter last Name
	driver.findElement(By.id("LastName")).sendKeys(lastName);
	Reporter.log("Last name entered  successfully",true);
	
	//enter email
	driver.findElement(By.id("Email")).sendKeys(email);
	Reporter.log("Email entered  successfully",true);

	//enter password
	driver.findElement(By.id("Password")).sendKeys(password);
	Reporter.log("Password entered  successfully",true);
	
	//confirm password

	driver.findElement(By.id("ConfirmPassword")).sendKeys(cnfrmPassword);
	Reporter.log("Confirm password entered  successfully",true);
	
	//click on register user
	driver.findElement(By.id("register-button")).click();
	Reporter.log("Successfully clicked on Register button",true);
	
	//capture registration successful message
	 WebElement message = driver.findElement(By.xpath("//div[@class='result']"));
	
	//verify if correct message is displayed
	 Assert.assertTrue(message.isDisplayed());
//	if(message.isDisplayed()) {
//		Reporter.log("User registration successfull", true);
//	}
//	else {
//		softAssert.fail("User registration failed");
//	}
	
}
}
