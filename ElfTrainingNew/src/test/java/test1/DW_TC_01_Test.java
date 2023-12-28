package test1;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepo.BasePage;
import elementRepo.BooksPage;
import elementRepo.base_Script;
import elementRepo.shoppingCartPage;
/***
 * @author admin
 * This test case is to check if an user can add item to the cart
 */
public class DW_TC_01_Test extends base_Script {
	@Test
	public void checkItemAddToCart() {
		BasePage bp = new BasePage(driver);
		BooksPage booksPage= new BooksPage(driver);
		SoftAssert softAssert = new SoftAssert();
		bp.emptyCart();
		//click on Books
		bp.getBooks().click();
		Reporter.log("Clicked on Books", true);
		
		//click on "Computing and Internet
		booksPage.getComputingAndInternetBook().click();
		Reporter.log("Clicked on 'Computing and Internet' ", true);
		
		//click on add to cart button
		bp.getAddToCartButton().click();
		Reporter.log("Clicked on 'Add to cart' ", true);
		
		//click on add to cart LINK
		bp.getShoppingCart().click();
		Reporter.log("Clicked on 'Add to cart Link' ", true);
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//h1[text()='Shopping cart']/../..//a[text()='Computing and Internet']")).isDisplayed());
		//check item added to cart
//		if(driver.findElement(By.xpath("//h1[text()='Shopping cart']/../..//a[text()='Computing and Internet']")).isDisplayed()) {
//			Reporter.log("Item is added to cart", true);
//		}
//		else {
//			//Reporter.log("Item is not added to cart", true);
//			 // Use SoftAssert to record the failure
//            softAssert.fail("Item is not added to cart");
//		}
		
		// selecting item from cart
		//driver.findElement(By.xpath("//input[@type='checkbox']/../..//a[text()='Computing and Internet']")).click();
		
	}
}
