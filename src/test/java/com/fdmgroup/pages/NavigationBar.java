package com.fdmgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {
	private WebDriver driver;
	private Actions actions;
	
	@FindBy(className = "mega-menu-nav")
	private WebElement navBar;
	
	@FindBy(linkText = "Credit Cards")
	private WebElement creditCardsButton;
	
	@FindBy(linkText = "Credit Cards Overview")
	private WebElement creditCardsOverviewButton;
		
	public NavigationBar(WebDriver driver, Actions actions) {
		this.driver = driver;
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}
	
	public boolean navBarIsDisplayed() {
		return navBar.isDisplayed();
	}
	
	public void hoverToCreditCardsButton() {
		actions.moveToElement(creditCardsButton).perform();
	}
	
	public boolean creditCardsOverviewIsDisplayed() {
		return creditCardsOverviewButton.isDisplayed();
	}
	
	public void clickOnCreditCardsOverviewButton() {
		creditCardsOverviewButton.click();
	}
}
