package com.fdmgroup.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreditCardInteractionsStepDef {
	@When("User scrolls down until the {string} section is visible")
	public void user_scrolls_down_until_the_section_is_visible(String string) throws InterruptedException {
	    Hooks.creditCardsPage.scrollToGivenSection(string);
	}

	@Then("The carousel should be visible on the page")
	public void the_carousel_should_be_visible_on_the_page() {
	    assertTrue(Hooks.creditCardsPage.CarouselDivIsDisplayed());
	}

	@When("User drags the carousel to the right")
	public void user_drags_the_carousel_to_the_right() {
	    Hooks.creditCardsPage.grabAndPullCarousel();
	}

	@Then("Additional card offers should be displayed")
	public void additional_card_offers_should_be_displayed() {
	    assertTrue(Hooks.creditCardsPage.additionalCarouselCardIsDisplayed());
	}

	@When("User clicks on compare checkbox")
	public void user_clicks_on_compare_checkbox() throws InterruptedException {
		Hooks.creditCardsPage.compareButtonClick();
	}

	@Then("Compare Tray is visible")
	public void compare_tray_is_visible() {
	    assertTrue(Hooks.creditCardsPage.compareTrayIsDisplayed());
	}

	@Then("{string} rectangle with a plus sign is visible")
	public void rectangle_with_a_plus_sign_is_visible(String string) {
	    assertEquals(Integer.parseInt(string), Hooks.creditCardsPage.numberOfRectangleWithPlusSign());
	}
}
