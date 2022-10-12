package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToWebThemesAndTempsMenu() {
		waitForElementClickable(driver, HomePageUI.WEB_THEMES_AND_TEMPS_MENU);
		clickToElement(driver, HomePageUI.WEB_THEMES_AND_TEMPS_MENU);
	}

	public void hoverToElementorSubmenu() {
		waitForElementVisible(driver, HomePageUI.ELEMENTOR_SUBMENU);
		hoverMouseToElement(driver, HomePageUI.ELEMENTOR_SUBMENU);
	}

	public CategoryPageObject clickToTemplateKits() {
		waitForElementClickable(driver, HomePageUI.TEMPLATE_KITS_LINK);
		clickToElement(driver, HomePageUI.TEMPLATE_KITS_LINK);
		return PageGeneratorManager.getCategoryPage(driver);
	}

}
