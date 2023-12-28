package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BasePage{
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath="//input[@value='Re-order']")
	private WebElement reOrder;
	public WebElement getReOrder() {
		return reOrder;
	}
}
