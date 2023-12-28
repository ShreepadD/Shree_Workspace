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
 * This test case is used to verify whether recently viewed items are present in recent view tab
 */
public class DW_TC_07_Test extends base_Script {
	@Test
	public void recentViews() {
		//click on apparel and shoes
		BasePage bp= new BasePage(driver);
		SoftAssert softAssert= new SoftAssert();
		bp.getApparelAndShoes().click();
		

		Reporter.log("Clicked on Apparel and shoes from Navigation bar",true);
		
		//select blue and green shoes
		WebElement shoes = driver.findElement(By.linkText("Blue and green Sneaker"));
		shoes.click();
		Reporter.log("Clicked on Shoes item",true);
		
		//click on recently viewed products list
		bp.getRecentlyViewedProducts().click();
		Reporter.log("Recently viewed items list opened",true);
		
		//verify if the same item is present in the list
		WebElement shoesInRecentView = driver.findElement(By.linkText("Blue and green Sneaker"));
		Assert.assertTrue(shoesInRecentView.isDisplayed());
		
//		if(shoesInRecentView.isDisplayed()) {
//			Reporter.log("Item is added to recently viewed List",true);
//
//		}
//		else {
			Reporter.log("Item is added to recently viewed List",true);
//			softAssert.fail("Item not added to Compare list");
//
//		}
}
}
