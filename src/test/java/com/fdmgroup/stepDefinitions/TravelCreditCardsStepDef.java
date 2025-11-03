package com.fdmgroup.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TravelCreditCardsStepDef {
	@When("User clicks on Travel Cards")
	public void user_clicks_on_travel_cards() {
	    Hooks.travelCreditCards.clickOnTravelCreditCardsButton();
	}

	@Given("Sort By Dropdown is visible")
	public void sort_by_dropdown_is_visible() {
	    assertTrue(Hooks.travelCreditCards.sortByDropDownIsDisplayed());
	}

	@When("User click on dropdown")
	public void user_click_on_dropdown() {
	    Hooks.travelCreditCards.clickOnSortByDropDown();
	}

	@Then("multiple dropdown options are displayed")
	public void multiple_dropdown_options_are_displayed() {
	    assertEquals(DataFile.numberOfOptionsInSortByDropDown, Hooks.travelCreditCards.numberOfOptionsInSortByDropDown());
	}

	@When("User selects dropdown option {string}")
	public void user_selects_dropdown_option(String string) {
	    Hooks.travelCreditCards.selectDropDownOption(string);
	}

	@Then("Dropdown option {string} is selected")
	public void dropdown_option_is_selected(String string) {
	    Hooks.travelCreditCards.optionIsSelectedInDropDown(string);
	}
}
