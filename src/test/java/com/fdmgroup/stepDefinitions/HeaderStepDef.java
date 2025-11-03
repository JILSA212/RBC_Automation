package com.fdmgroup.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderStepDef {
	@Given("Header is displayed")
	public void header_is_displayed() {
	    assertTrue(Hooks.header.headerIsDisplayed());
	}

	@Then("Header is of blue color")
	public void header_is_of_blue_color() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		// ------------------------------------------------------
		// IMPLEMENT IT -----------------------------------------
		// ------------------------------------------------------
		assertTrue(Hooks.header.colorOfHeader());
//		assertTrue(true);
	}

	@When("User clicks on searchbar and writes {string}")
	public void user_clicks_on_searchbar_and_writes(String string) {
	    Hooks.header.searchBarUtility(string);
	}

	@Then("Search page is displayed")
	public void search_page_is_displayed() {
	    assertEquals(DataFile.expectedHeadingOfSearchPage, Hooks.header.getPageHeading());
	}

	@Then("multiple results for search are displayed")
	public void multiple_results_for_search_are_displayed() {
	    assertTrue(Hooks.header.multipleResultDisplayed());
	}

	@Then("Message is displayed {string} on search page")
	public void message_is_displayed_on_search_page(String string) {
	    assertEquals(string, Hooks.header.noSearchHeader());
	}
}
