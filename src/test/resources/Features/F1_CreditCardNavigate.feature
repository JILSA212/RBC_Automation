# Author: Jilsa Chandarana
# Date: 23 Oct 2025

@NavigateToCreditCards
Feature: As a user I want to navigate to credit card page from navigation bar

@NavigationTest
Scenario: User should be able to go to credit card page from navigation bar
	Given User launches the application
	And Navigation Bar is visible
	When User hovers over credit cards menu
	Then Extended credit cards menu is displayed
	When User clicks on Credit Cards Overview
	Then User should be able to see title "Credit Cards in Canada"