package com.fdmgroup.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.fdmgroup.pages.CreditCardsPage;
import com.fdmgroup.pages.Header;
import com.fdmgroup.pages.NavigationBar;
import com.fdmgroup.pages.TravelCreditCards;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends DriverUtilities {
//	public static DriverUtilities driverUtilities;
//	public static WebDriver driver;
	public static Actions actions;
	public static NavigationBar navigationBar;
	public static CreditCardsPage creditCardsPage;
	public static Header header;
	public static TravelCreditCards travelCreditCards;
	
	public Hooks() {
		super();
	}
	
	@BeforeAll
	public static void setUp() throws InterruptedException {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		actions = new Actions(driver);
		
		navigationBar = new NavigationBar(driver, actions);
		creditCardsPage = new CreditCardsPage(driver, actions);
		header = new Header(driver, actions);
		travelCreditCards = new TravelCreditCards(driver, actions);
		
		// Maximize window before working
		driver.manage().window().maximize();
	}
	
	@AfterAll
	public static void tearDown() {
		if(driver != null)
		{
			driver.quit();
			driver = null;
			driverUtilities = null;			
		}
	}
}
