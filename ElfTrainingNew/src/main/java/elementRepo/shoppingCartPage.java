package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class shoppingCartPage extends BasePage  {
	public shoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "removefromcart")
	private WebElement checkout;
	
	@FindBy(id="termsofservice")
	private WebElement termsOfService;
	
	@FindBy(id="checkout")
	private WebElement orderCheckOut;
	
	public WebElement getOrderCheckOut() {
		return orderCheckOut;
	}
	@FindBy (name = "removefromcart")
	private WebElement removeFromCart;
	
	@FindBy(name = "updatecart")
	private WebElement updateCart;
	
	@FindBy(xpath = "//span[text()='Qty.:']/..//input[@value]")
	private WebElement quantityFeild;

	public WebElement getQuantityFeild() {
		return quantityFeild;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getTermsOfService() {
		return termsOfService;
	}

	public WebElement getRemoveFromCart() {
		return removeFromCart;
	}

	public WebElement getUpdateCart() {
		return updateCart;
	}
}
