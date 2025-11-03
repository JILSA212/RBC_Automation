package com.fdmgroup.data;

public class DataFile {
	// Browser name
	public static String browser = "chrome";
	
	// Path to save screenshot
	public static String pathForScreenShot = "src/test/resources/Images/";
	
	// URL of Personal Page which is also Home Page of RBC Website
	public static String personalPageURL = "https://www.rbcroyalbank.com/personal.html";
	
	// URL of Credit Cards Page
	public static String creditCardsPageURL = "https://www.rbcroyalbank.com/credit-cards/index.html";
	
	// Amount to pull Carousel
	public static int carouselOffsetX = -100;
	
	// Title of expected Carousel card
	public static String carouselExpectedCardTitle = "Get up to 11,000 Avion Points";
	
	// Explicit wait for webdrivers in seconds
	public static int explicitWaitInSeconds = 2;
	
	// Explicit wait in case of search
	public static int explicitWaitForSearch = 7;
	
	// Expected Page Heading for Search Page
	public static String expectedHeadingOfSearchPage = "Let Us Help You Find the Answers You're Looking for...";
	
	// Number of options in Sort By Drop Down
	public static int numberOfOptionsInSortByDropDown = 4;
	
	// Pixel values to read color String
	public static int pixelX = 5;
	public static int pixelY = 5;
}
