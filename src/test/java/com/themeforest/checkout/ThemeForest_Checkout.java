package com.themeforest.checkout;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.CartPageObject;
import pageObjects.CategoryPageObject;
import pageObjects.CheckoutPageObject;
import pageObjects.HomePageObject;

public class ThemeForest_Checkout extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private CategoryPageObject categoryPage;
	private CartPageObject cartPage;
	private CheckoutPageObject checkoutPage;

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-Condition: Open browser and navigate to Homepage");
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test(dataProvider = "fname_lname_email_user_pass_cap_extInfo")
	public void Checkout(String firstName, String lastName, String email, String userName, String password, String captcha, String extraInfo) throws Exception {
		log.info("Checkout - Step 01: Click to 'Web Themes & Templates' menu");
		homePage.clickToWebThemesAndTempsMenu();

		log.info("Checkout - Step 02: Click to 'Template Kits' link from 'Elementor' submenu");
		homePage.hoverToElementorSubmenu();
		categoryPage = homePage.clickToTemplateKits();

		log.info("Checkout - Step 03: Choose Grid View mode");
		categoryPage.chooseGridViewMode();

		log.info("Checkout - Step 04: Add product 'Cabel - Electricity Services Elementor Template Kit' to Cart");
		categoryPage.addProductToCartByName("Cabel - Electricity Services Elementor Template Kit");

		log.info("Checkout - Step 05: Click to 'Keep Browsing' button to continue choosing next product");
		categoryPage.clickToKeepBrowsing();

		log.info("Checkout - Step 06: Add product 'Maldives - Business & Agency Elementor Template Kit' to Cart");
		categoryPage.addProductToCartByName("Maldives - Business & Agency Elementor Template Kit");

		log.info("Checkout - Step 07: Click to 'Go to Checkout' button");
		cartPage = categoryPage.clickToGoToCheckout();

		log.info("Checkout - Step 08: Verify product 'Cabel - Electricity Services Elementor Template Kit' name is correctly displayed");
		verifyTrue(cartPage.isProductDisplayedByName("Cabel - Electricity Services Elementor Template Kit"));

		log.info("Checkout - Step 09: Verify product 'Cabel - Electricity Services Elementor Template Kit' price is correctly displayed");
		verifyEquals(cartPage.getProductPriceByProductName("Cabel - Electricity Services Elementor Template Kit"), 22);

		log.info("Checkout - Step 10: Verify product 'Maldives - Business & Agency Elementor Template Kit' name is correctly displayed");
		verifyTrue(cartPage.isProductDisplayedByName("Maldives - Business & Agency Elementor Template Kit"));

		log.info("Checkout - Step 11: Verify product 'Maldives - Business & Agency Elementor Template Kit' price is correctly displayed");
		verifyEquals(cartPage.getProductPriceByProductName("Maldives - Business & Agency Elementor Template Kit"), 24);

		log.info("Checkout - Step 12: Verify cart total is correctly displayed");
		verifyEquals(cartPage.getCartTotal(), 46);

		log.info("Checkout - Step 13: Click to 'Secure Checkout' button");
		checkoutPage = cartPage.clickToSecureCheckout();

		log.info("Checkout - Step 14: Input to Firstname textbox with value: " + firstName);
		checkoutPage.inputToFirstNameTextbox(firstName);

		log.info("Checkout - Step 15: Input to Lastname textbox with value: " + lastName);
		checkoutPage.inputToLastNameTextbox(lastName);

		log.info("Checkout - Step 16: Input to Email textbox with value: " + email);
		checkoutPage.inputToEmailTextbox(email);

		log.info("Checkout - Step 17: Input to Username textbox with value: " + userName);
		checkoutPage.inputToUserNameTextbox(userName);

		log.info("Checkout - Step 18: Input to Password textbox with value: " + password);
		checkoutPage.inputToPasswordTextbox(password);

		log.info("Checkout - Step 19: " + captcha + " to captcha checkbox");
		if (captcha.equals("Tick")) {
			checkoutPage.tickToCaptchaCheckbox();
		} else if (captcha.equals("Untick")) {
			checkoutPage.unTickToCaptchaCheckbox();
		} else {
			throw new Exception("The data is invalid error");
		}

		log.info("Checkout - Step 20: " + extraInfo + " to send me tips checkbox");
		if (extraInfo.equals("Tick")) {
			checkoutPage.tickToSendMeTipsCheckbox();
		} else if (extraInfo.equals("Untick")) {
			checkoutPage.unTickToSendMeTipsCheckbox();
		} else {
			throw new Exception("The data is invalid error");
		}

		log.info("Checkout - Step 21: Back to Cart Page");
		cartPage = checkoutPage.clickToCartIcon();

		log.info("Checkout - Step 22: Click to 'Empty Cart' button");
		cartPage.clickToEmptyCartButton();

		log.info("Checkout - Step 23: Accept alert to remove all item from cart");
		cartPage.acceptAlertEmptyCart();

		log.info("Checkout - Step 24: Verify cart is empty");
		verifyTrue(cartPage.isCartEmptyMessageDisplayed());

	}

	@DataProvider(name = "fname_lname_email_user_pass_cap_extInfo")
	public Object[][] UserInfo() {
		return new Object[][] { { "Vincent", "VSM", "vincent@gmail.com", "vincen218", "Vincen@218", "Tick", "Tick" }, { "Leo", "VSM", "leo@gmail.com", "leo123", "Leo@5421", "Untick", "Untick" },
				{ "Thao", "Le", "thaole@gmail.com", "thaole123", "Thao@!#$", "Untick", "Tick" }, };
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
