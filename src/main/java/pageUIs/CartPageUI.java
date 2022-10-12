package pageUIs;

public class CartPageUI {
	public static final String DYNAMIC_PRODUCT_TITLE_BY_NAME = "xpath=//div[@class='shopping-cart__group']//h5/a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE_BY_NAME = "xpath=//a[text()='%s']//ancestor::div[@class='item-result__details']//following-sibling::div[@class='item-result__price']//b";
	public static final String CART_TOTAL = "xpath=//h3[text()='Your Cart Total']//following-sibling::h4//span";
	public static final String SECURE_CHECKOUT_BUTTON = "xpath=//h3[text()='Your Cart Total']//following-sibling::form//input[@value='Secure Checkout']";
	public static final String EMPTY_CART_BUTTON = "xpath=//button[text()='Empty Cart']";
	public static final String CART_EMPTY_MESSAGE = "xpath=//h2[text()='Your shopping cart is empty.']";
}
