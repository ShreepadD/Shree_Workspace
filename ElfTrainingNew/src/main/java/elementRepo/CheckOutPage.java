package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//label[text()='Select a billing address from your address book or enter a new address.']/../../../../..//input[@value='Continue']")
	private WebElement billingAddressContinue;
	
	@FindBy(xpath="//i[text()='Pick up your items at the store (put your store address here)']/../../../../../..//input[@value='Continue']")
	private WebElement shippingAddressContinue;
	
	@FindBy(xpath="//label[text()='Ground (0.00)']/../../../../../../..//input[@value='Continue']")
	private WebElement shippingMethodContinue;
	
	@FindBy(xpath="//label[text()='Cash On Delivery (COD) (7.00)']/../../../../../../../../..//input[@value='Continue']")
	private WebElement paymentMethodContinue;
	
	@FindBy(xpath="//p[text()='You will pay by COD']/../../../../../../../../../..//input[@value='Continue']")
	private WebElement paymentInformationContinue;
	

	public WebElement getPaymentInformationContinue() {
		return paymentInformationContinue;
	}

	public WebElement getPaymentMethodContinue() {
		return paymentMethodContinue;
	}

	public WebElement getShippingMethodContinue() {
		return shippingMethodContinue;
	}

	public WebElement getBillingAddressContinue() {
		return billingAddressContinue;
	}

	public WebElement getShippingAddressContinue() {
		return shippingAddressContinue;
	}
	@FindBy(xpath="//input[@value='Confirm']")
	private WebElement confirm;

	public WebElement getContinue() {
		return billingAddressContinue;
	}

	public WebElement getConfirm() {
		return confirm;
	}
}
