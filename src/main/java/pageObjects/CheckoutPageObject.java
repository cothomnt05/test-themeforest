package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {
	WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CheckoutPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CheckoutPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, CheckoutPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToUserNameTextbox(String userName) {
		waitForElementVisible(driver, CheckoutPageUI.USERNAME_TEXTBOX);
		clearValueInElementByPressKey(driver, CheckoutPageUI.USERNAME_TEXTBOX);
		sleepInSecond(1);
		clearValueInElementByPressKey(driver, CheckoutPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.USERNAME_TEXTBOX, userName);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, CheckoutPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CheckoutPageUI.PASSWORD_TEXTBOX, password);
	}

	public void tickToCaptchaCheckbox() {
		switchToFrameIframe(driver, CheckoutPageUI.IFRAME_CAPTCHA);
		waitForElementClickable(driver, CheckoutPageUI.CAPTCHA_CHECKBOX);
		if (!isElementSelected(driver, CheckoutPageUI.CAPTCHA_CHECKBOX)) {
			clickToElementByJS(driver, CheckoutPageUI.CAPTCHA_CHECKBOX);
		}
		switchToDefaultContent(driver);
	}

	public void tickToSendMeTipsCheckbox() {
		waitForElementClickable(driver, CheckoutPageUI.EXTRA_INFO_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, CheckoutPageUI.EXTRA_INFO_CHECKBOX);
	}

	public void unTickToSendMeTipsCheckbox() {
		waitForElementClickable(driver, CheckoutPageUI.EXTRA_INFO_CHECKBOX);
		uncheckToDefaultCheckbox(driver, CheckoutPageUI.EXTRA_INFO_CHECKBOX);
	}

	public CartPageObject clickToCartIcon() {
		waitForElementClickable(driver, CheckoutPageUI.CART_ICON);
		clickToElementByJS(driver, CheckoutPageUI.CART_ICON);
		return PageGeneratorManager.getCartPage(driver);
	}

	public void unTickToCaptchaCheckbox() {
		switchToFrameIframe(driver, CheckoutPageUI.IFRAME_CAPTCHA);
		waitForElementClickable(driver, CheckoutPageUI.CAPTCHA_CHECKBOX);
		if (isElementSelected(driver, CheckoutPageUI.CAPTCHA_CHECKBOX)) {
			clickToElementByJS(driver, CheckoutPageUI.CAPTCHA_CHECKBOX);
		}
		switchToDefaultContent(driver);

	}

}
