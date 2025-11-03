# Author: Jilsa Chandarana
# Date: 24 Oct 2025

@TravelCardFeatures
Feature: As a User I should be able to select sorting options from Drop down menu

Background:
	Given User launches the application
	And Navigation Bar is visible
	When User hovers over credit cards menu
	Then Extended credit cards menu is displayed
	When User clicks on Travel Cards
	Then User should be able to see title "Travel Credit Cards In Canada"

Scenario: User should be able to select different options from drop down
	Given Sort By Dropdown is visible
	When User click on dropdown
	Then multiple dropdown options are displayed
	When User selects dropdown option "Popular"
	Then Dropdown option "Popular" is selected