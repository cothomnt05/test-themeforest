package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.CartPageUI;

public class CartPageObject extends BasePage {
	WebDriver driver;

	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDisplayedByName(String productName) {
		waitForElementVisible(driver, CartPageUI.DYNAMIC_PRODUCT_TITLE_BY_NAME, productName);
		return isElementDisplayed(driver, CartPageUI.DYNAMIC_PRODUCT_TITLE_BY_NAME, productName);

	}

	public int getProductPriceByProductName(String productName) {
		waitForElementVisible(driver, CartPageUI.DYNAMIC_PRODUCT_PRICE_BY_NAME, productName);
		String price = getElementText(driver, CartPageUI.DYNAMIC_PRODUCT_PRICE_BY_NAME, productName).trim().replace("$", "");
		return Integer.parseInt(price);
	}

	public int getCartTotal() {
		waitForElementVisible(driver, CartPageUI.CART_TOTAL);
		String cartTotal = getElementText(driver, CartPageUI.CART_TOTAL);
		return Integer.parseInt(cartTotal);
	}

	public CheckoutPageObject clickToSecureCheckout() {
		waitForElementClickable(driver, CartPageUI.SECURE_CHECKOUT_BUTTON);
		clickToElement(driver, CartPageUI.SECURE_CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPage(driver);
	}

	public void clickToEmptyCartButton() {
		waitForElementClickable(driver, CartPageUI.EMPTY_CART_BUTTON);
		clickToElement(driver, CartPageUI.EMPTY_CART_BUTTON);
	}

	public void acceptAlertEmptyCart() {
		acceptAlert(driver);
	}

	public boolean isCartEmptyMessageDisplayed() {
		waitForElementVisible(driver, CartPageUI.CART_EMPTY_MESSAGE);
		return isElementDisplayed(driver, CartPageUI.CART_EMPTY_MESSAGE);
	}

}
