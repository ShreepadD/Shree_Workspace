package test3;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepo.BasePage;
import elementRepo.BooksPage;
import elementRepo.OrderDetailsPage;
import elementRepo.base_Script;
import elementRepo.CheckOutPage;
import elementRepo.shoppingCartPage;
/***
 * @author admin
 * This test case is used to verify if user can ReOrder
 */
public class DW_TC_05_Test extends base_Script {
	@Test
	public void reOrder() {
		BasePage bp = new BasePage(driver);
		BooksPage booksPage= new BooksPage(driver);
		shoppingCartPage cartPage= new shoppingCartPage(driver);
		CheckOutPage details= new CheckOutPage(driver);
		OrderDetailsPage od= new OrderDetailsPage(driver);
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
		
		//check item added to cart
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//h1[text()='Shopping cart']/../..//a[text()='Computing and Internet']")).isDisplayed());

//		if(driver.findElement(By.xpath("//h1[text()='Shopping cart']/../..//a[text()='Computing and Internet']")).isDisplayed()) {
//			Reporter.log("Item is added to cart", true);
//		}
//		else {
//			//Reporter.log("Item is not added to cart", true);
//			softAssert.fail("Item is not added to cart");
//		}
//		
		//agree to terms and conditions
		
		cartPage.getTermsOfService().click();
		Reporter.log("Terms and conditions checkBox selected", true);
		
		//Click on CheckOut page
		
		cartPage.getOrderCheckOut().click();
		Reporter.log("Clicked on CheckOut Button", true);
		
		//confirming Order
		
		details.getBillingAddressContinue().click();
		details.getShippingAddressContinue().click();
		details.getShippingMethodContinue().click();
		details.getPaymentMethodContinue().click();
		details.getPaymentInformationContinue().click();
		details.getConfirm().click();
		
		//confirming if order placed
		
		WebElement orderconfirmation = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
		AssertJUnit.assertTrue(orderconfirmation.isDisplayed());
//		if(orderconfirmation.isDisplayed()) {
//			Reporter.log("Order placed successfully", true);
//		}
//		else {
//			//Reporter.log("Order not placed", true);
//			softAssert.fail("Order not placed");
//		}
		
		//click on Orders
		bp.getOrders().click();
		Reporter.log("Clicked on Orders", true);
		
		////strong[text()='Order Number: 1570015']/../..//input[@value='Details']
		
		//click On details
		
		driver.findElement(By.xpath("//input[@type='button']")).click();
		od.getReOrder().click();
		
		//agree to terms and conditions
		
				cartPage.getTermsOfService().click();
				Reporter.log("Terms and conditions checkBox selected", true);
				
				//Click on CheckOut page
				
				cartPage.getOrderCheckOut().click();
				Reporter.log("Clicked on CheckOut Button", true);
				
				//confirming Order
				
				details.getBillingAddressContinue().click();
				details.getShippingAddressContinue().click();
				details.getShippingMethodContinue().click();
				details.getPaymentMethodContinue().click();
				details.getPaymentInformationContinue().click();
				details.getConfirm().click();
				
				//confirming if order placed
				
				//WebElement orderconfirmation = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
				if(orderconfirmation.isDisplayed()) {
					Reporter.log("ReOrder placed successfully", true);
				}
				else {
					//Reporter.log("ReOrder not placed", true);
					AssertJUnit.fail("ReOrder not placed");
				}

}
}
