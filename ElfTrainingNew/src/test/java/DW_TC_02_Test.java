import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
 * This test case is to verify whether an user can remove item from the cart
 */
public class DW_TC_02_Test extends base_Script{
@Test
public void removeItemFromCart() {
	BasePage bp= new BasePage(driver);
	BooksPage booksPage= new BooksPage(driver);
	shoppingCartPage cartPage= new shoppingCartPage(driver);
	//SoftAssert softAssert = new SoftAssert();
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
			
			//check item added to cart
			if(driver.findElement(By.xpath("//h1[text()='Shopping cart']/../..//a[text()='Computing and Internet']")).isDisplayed()) {
				Reporter.log("Item is added to cart", true);
			}
			else {
				Reporter.log("Item is not added to cart", true);
			}
			
			//remove shopping cart
			cartPage.getCheckBox().click();
			cartPage.getUpdateCart().click();
			
			//check if cart empty
			
			WebElement emptyCartMessage = driver.findElement(By.cssSelector("div.order-summary-content"));
			String messageText = emptyCartMessage.getText().trim();

//			if ("Your Shopping Cart is empty!".equals(messageText)) {
//			    Reporter.log("Empty cart message found!, cart empty", true);
//			} else {
//				//Reporter.log("Cart is not empty", true);
//				// Use SoftAssert to record the failure
//	            softAssert.fail("Cart is not empty");
//			}
			String messageText1 = "Your Shopping Cart is empty!";
			AssertJUnit.assertEquals(messageText,"Your Shopping Cart is empty!");
			Reporter.log("Cart is now empty");
			

	
}
}
