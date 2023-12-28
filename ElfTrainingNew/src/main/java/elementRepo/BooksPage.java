package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage {
	public BooksPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//a[text()='Computing and Internet']")
	private  WebElement computingAndInternetBook;

	public  WebElement getComputingAndInternetBook() {
		return computingAndInternetBook;
	}

}
