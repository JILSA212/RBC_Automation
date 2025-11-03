package com.fdmgroup.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreditCardNavigateStepDef {
	@Given("User launches the application")
	public void user_launches_the_application() throws InterruptedException {
	    Hooks.driver.get(DataFile.personalPageURL);
	    Thread.sleep(3000);
		try {
			Hooks.driver.findElement(By.xpath("//button[contains(text(), 'Accept All Cookies')]")).click();
		} catch(Exception e) {
			// Do nothing... Live with it
		}
	}

	@Given("Navigation Bar is visible")
	public void navigation_bar_is_visible() {
		assertTrue(Hooks.navigationBar.navBarIsDisplayed());
	}

	@When("User hovers over credit cards menu")
	public void user_hovers_over_credit_cards_menu() {
	    Hooks.navigationBar.hoverToCreditCardsButton();
	}

	@Then("Extended credit cards menu is displayed")
	public void extended_credit_cards_menu_is_displayed() {
	    assertTrue(Hooks.navigationBar.creditCardsOverviewIsDisplayed());
	}

	@When("User clicks on Credit Cards Overview")
	public void user_clicks_on_credit_cards_overview() throws InterruptedException {
	    Hooks.navigationBar.clickOnCreditCardsOverviewButton();
	    // Take a break to load the page... Have a break, Have a kitkat!
	    Thread.sleep(2000);
	}

	@Then("User should be able to see title {string}")
	public void user_should_be_able_to_see_title(String string) {
	    assertEquals(string, Hooks.creditCardsPage.getPageTitle());
	}
}
