# Author: Jilsa Chandarana
# Date: 23 Oct 2025

@CompareCreditCards
Feature: As a user I want to interact with the credit cards page to know about offers and compare them

Background: 
	Given User launches the application
	And Navigation Bar is visible
	When User hovers over credit cards menu
	Then Extended credit cards menu is displayed
	When User clicks on Credit Cards Overview
	Then User should be able to see title "Credit Cards in Canada"

@Carousel
Scenario: User can scroll and interact with the credit cards carousel
	When User scrolls down until the "Best Current Credit Card Offers" section is visible
	Then The carousel should be visible on the page
	When User drags the carousel to the right
	Then Additional card offers should be displayed
	
@AddingCardToTray
Scenario: User can scroll and compare credit cards
	When User scrolls down until the "Popular Credit Cards" section is visible
	And User clicks on compare checkbox
	Then Compare Tray is visible
	And "2" rectangle with a plus sign is visible
		