package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPageObject;
import pageObjects.CategoryPageObject;
import pageObjects.CheckoutPageObject;
import pageObjects.HomePageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static CategoryPageObject getCategoryPage(WebDriver driver) {
		return new CategoryPageObject(driver);
	}

	public static CartPageObject getCartPage(WebDriver driver) {
		return new CartPageObject(driver);
	}

	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

}
