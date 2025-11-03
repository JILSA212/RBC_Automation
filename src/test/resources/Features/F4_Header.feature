# Author: Jilsa Chandarana
# Date: 24 Oct 2025

Feature: As a User I should be able to use searchbar and language dropdown in Header

@HeaderScreenShot
Scenario: Header should appear in blue color
	Given Header is displayed
	Then Header is of blue color
	
@HeaderSearch
Scenario Outline: User can search for a string in searchbar
	Given Header is displayed
	When User clicks on searchbar and writes "<search query>"
	Then Search page is displayed
	And multiple results for search are displayed
	
	Examples:
	| search query |
	| banking 	   |
	| cards		   |
	
@HeaderSearch
Scenario Outline: User should get error message if searchbar can not fetch any result
	Given Header is displayed
	When User clicks on searchbar and writes "<search query>"
	Then Search page is displayed
	And Message is displayed "Sorry, we couldn't find any results" on search page
	
	Examples:
	| search query |
	| asdjsakse    |
	| $%^@!$	   |
