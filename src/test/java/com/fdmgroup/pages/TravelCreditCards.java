package com.fdmgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TravelCreditCards {
	private WebDriver driver;
	private Actions actions;
	
	@FindBy(linkText = "Travel Cards")
	private WebElement travelCardsButton;
	
	@FindBy(tagName = "select")
	private WebElement sortByDropDown;
	
	public TravelCreditCards(WebDriver driver, Actions actions)
	{
		this.driver = driver;
		this.actions = actions;
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTravelCreditCardsButton() {
		travelCardsButton.click();
	}
	
	public boolean sortByDropDownIsDisplayed() {
		return sortByDropDown.isDisplayed();
	}
	
	public void clickOnSortByDropDown() {
		sortByDropDown.click();
	}
	
	public int numberOfOptionsInSortByDropDown() {
		return new Select(sortByDropDown).getOptions().size();
	}
	
	public void selectDropDownOption(String string)
	{
		Select select = new Select(sortByDropDown);
		select.selectByContainsVisibleText(string);
	}
	
	public boolean optionIsSelectedInDropDown(String string)
	{
		Select select = new Select(sortByDropDown);
		if(select.getAllSelectedOptions().size() > 1)
		{
			for(WebElement e : select.getAllSelectedOptions())
			{
				if(e.getText().contains(string))
					return true;
			}
		}
		return false;
	}
}
