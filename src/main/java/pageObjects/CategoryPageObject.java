package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.CategoryPageUI;

public class CategoryPageObject extends BasePage {
	WebDriver driver;

	public CategoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseGridViewMode() {
		waitForElementClickable(driver, CategoryPageUI.GRID_VIEW_MODE_ICON);
		clickToElementByJS(driver, CategoryPageUI.GRID_VIEW_MODE_ICON);

	}

	public void addProductToCartByName(String productName) {
		waitForElementClickable(driver, CategoryPageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT_NAME, productName);
		clickToElement(driver, CategoryPageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT_NAME, productName);
	}

	public void clickToKeepBrowsing() {
		waitForElementClickable(driver, CategoryPageUI.KEEP_BROWSING_BUTTON);
		clickToElement(driver, CategoryPageUI.KEEP_BROWSING_BUTTON);

	}

	public CartPageObject clickToGoToCheckout() {
		waitForElementClickable(driver, CategoryPageUI.GO_TO_CHECKOUT_BUTTON);
		clickToElement(driver, CategoryPageUI.GO_TO_CHECKOUT_BUTTON);
		return PageGeneratorManager.getCartPage(driver);
	}

}
