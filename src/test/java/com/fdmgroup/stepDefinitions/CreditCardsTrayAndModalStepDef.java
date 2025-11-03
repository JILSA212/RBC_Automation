package com.fdmgroup.stepDefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreditCardsTrayAndModalStepDef {
	@When("User clicks on rectangle with a plus sign")
	public void user_clicks_on_rectangle_with_a_plus_sign() {
	    Hooks.creditCardsPage.clickOnRectangleWithPlusSign();
	}
	
	@Given("Compare modal is visible")
	public void compare_modal_is_visible() {
	    assertTrue(Hooks.creditCardsPage.compareModalIsDisplayed());
	}
	
	@When("User clicks on All cards")
	public void user_clicks_on_all_cards() throws InterruptedException {
	    Hooks.creditCardsPage.allCardsButtonClick();
	}

	@When("User checks {string} checkbox")
	public void user_checks_checkbox(String string) {
	    Hooks.creditCardsPage.clickCheckbox(string);
	}

	@When("User clicks on {string} card in compare modal")
	public void user_clicks_on_card_in_compare_modal(String string) {
		Hooks.creditCardsPage.chooseCreditCard(string);
	}

	@Then("{string} is visible in compare tray")
	public void is_visible_in_compare_tray(String string) {
		Hooks.creditCardsPage.compareTrayHasString(string);
	}
}
