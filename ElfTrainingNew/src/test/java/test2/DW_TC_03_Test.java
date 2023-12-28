package test2;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
 * This test case is to verify whether user can edit the quantity of items added to cart
 */
public class DW_TC_03_Test extends base_Script{
@Test
public void quantityOfItems() {
	//click on apparel and shoes
	BasePage bp= new BasePage(driver);
	SoftAssert softAssert = new SoftAssert();
	
	bp.emptyCart();

	bp.getApparelAndShoes().click();
	Reporter.log("Clicked on Apparel and shoes from Navigation bar",true);
	
	//select blue and green shoes
	WebElement shoes = driver.findElement(By.linkText("Blue and green Sneaker"));
	shoes.click();
	Reporter.log("Clicked on Shoes item",true);
	
	//update quantity field and add to cart
	bp.getQuantityFeildBox().clear();
	int numberOfShoes=3;
	bp.getQuantityFeildBox().sendKeys("3");
	bp.getAddToCartButton().click();
	Reporter.log("Quantity updated and added to cart",true);
	
	//check the quantity added to cart
	bp.getShoppingCart().click();
	String qunatityTakenIntoCart = bp.getQuantityFeildBox().getAttribute("value");
	int q= Integer.parseInt(qunatityTakenIntoCart);
	AssertJUnit.assertEquals(q, numberOfShoes);
//	if(q==numberOfShoes) {
//		Reporter.log("Correct quantity is taken into Cart", true);
//	}
//	else {
//		//Reporter.log("Incorrect quantity is taken into cart", true);
//		 // Use SoftAssert to record the failure
//        softAssert.fail("Incorrect quantity is taken into cart");
//	}
}
}
