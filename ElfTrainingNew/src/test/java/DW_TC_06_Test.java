import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepo.BasePage;
import elementRepo.base_Script;
/***
 * @author admin
 * This test case is used to verify whether user can add items to compare list 
 */
public class DW_TC_06_Test extends base_Script{
	@Test
	public void compareList() {
		//click on apparel and shoes
		BasePage bp= new BasePage(driver);
		SoftAssert softAssert = new SoftAssert();
		bp.getApparelAndShoes().click();
		Reporter.log("Clicked on Apparel and shoes from Navigation bar",true);
		
		//select blue and green shoes
		WebElement shoes = driver.findElement(By.linkText("Blue and green Sneaker"));
		shoes.click();
		Reporter.log("Clicked on Shoes item",true);
		
		//add to compare list
		bp.getAddToCompareList().click();
		Reporter.log("Clicked on Add to Compare list",true);
		
		//Click on Compare list
		
		bp.getCompareProductsList().click();
		Reporter.log("Compare list opened",true);
		
		//Verify if item is added
		WebElement shoesCompareList = driver.findElement(By.linkText("Blue and green Sneaker"));
		AssertJUnit.assertTrue(shoesCompareList.isDisplayed());
//		if(shoesCompareList.isDisplayed()) {
//			Reporter.log("Item successfully added to Compare list",true);
//		}
//		else {
//			//Reporter.log("Item not added to Compare list",true);
//			softAssert.fail("Item not added to Compare list");
//		}
}
}
