# Author: Jilsa Chandarana
# Date: 23 Oct 2025

@TrayAndModal
Feature: As a user I should be able to compare credit cards with designated tray and modal	

@TrayTest
Scenario: User can open compare modal from compare tray
	Given Compare Tray is visible
	When User clicks on rectangle with a plus sign
	Then Compare modal is visible
	
@ModalTest
Scenario: User can compare credit cards in compare modal
	Given Compare modal is visible
	When User clicks on All cards
	And User checks "Travel Rewards" checkbox
	And User checks "Travel Insurance" checkbox
	And User clicks on "RBC Avion Visa Infinite" card in compare modal
	Then Compare Tray is visible
	And "RBC Avion Visa Infinite" is visible in compare tray