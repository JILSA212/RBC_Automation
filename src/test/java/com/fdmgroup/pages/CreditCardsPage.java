package com.fdmgroup.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.data.DataFile;

public class CreditCardsPage {
	private WebDriver driver;
	private Actions actions;
	
	@FindBy(tagName = "h1")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//div[@class='carousel']")
	private WebElement carouselDiv;
	
//	@FindBy(xpath = "//a[contains(@class,'btn-compare-added')][text()='Compare']")
	@FindBy(xpath = "(//div[@class='compare-card-button'])[2]")
	private WebElement compareButton;
	
	@FindBy(className = "compare-tray-content")
	private WebElement compareTrayContent;
	
	@FindBy(className = "compare-tray-add-btn")
	private List<WebElement> compareCardAddButtonList;
	
	@FindBy(className = "carousel-item")
	private List<WebElement> carouselCards; 
	
	@FindBy(id = "compareToolModal")
	private WebElement compareModal;
	
	@FindBy(id = "all-cards")
	private WebElement allCardsButton;
	
	@FindBy(xpath = "//div[contains(@class,'checkbox-wpr')]")
	private List<WebElement> checkBoxList;
	
	@FindBy(xpath = "//div[contains(@class,'card-result')]")
	private List<WebElement> creditCardsCardsList;
	
	public CreditCardsPage(WebDriver driver, Actions actions)
	{
		this.driver = driver;
		this.actions = actions;
		
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		return pageTitle.getText();
	}
	
	public void scrollToGivenSection(String section) throws InterruptedException
	{
		System.out.println("//*[contains(text(),'" + section + "')]");
		WebElement givenSection = driver.findElement(By.xpath("//*[contains(text(),'" + section + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", givenSection);

		if(section.contains("Popular Credit Cards"))
		{
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)", "");
			// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", compareButton);
			Thread.sleep(2000);
		}
	}
	
	public boolean CarouselDivIsDisplayed() {
		return carouselDiv.isDisplayed();
	}
	
	public void grabAndPullCarousel() {
		try {
	        Actions actions = new Actions(driver);
	        actions.clickAndHold(carouselDiv)
	               .moveByOffset(DataFile.carouselOffsetX, 0)
	               .pause(Duration.ofMillis(5000))
	               .release()
	               .perform();	        
		} catch (Exception e) {
	        // Fallback to JavaScript scroll if drag doesn't work
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollLeft += arguments[1];", carouselDiv, DataFile.carouselOffsetX);
	    }
	}
	
	public boolean additionalCarouselCardIsDisplayed() {
		System.out.println(carouselCards.size());
		return carouselCards.get(3).isDisplayed();
//		WebElement expectedCarouselCardDiv = driver.findElement(By.xpath("//div[contains(text(), '" + DataFile.carouselExpectedCardTitle + "')]"));
//		return expectedCarouselCardDiv.isDisplayed();
	}
	
//	public boolean compareButtonIsDisplayed() {
//		return compareButton.isDisplayed();
//	}
	
	public void compareButtonClick() throws InterruptedException {
			compareButton.click();
			
			// Wait for the tray to open
			Thread.sleep(2000);
	}
	
	public boolean compareTrayIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DataFile.explicitWaitInSeconds));
		wait.until(ExpectedConditions.visibilityOf(compareTrayContent));
		return compareTrayContent.isDisplayed();
	}
	
	public int numberOfRectangleWithPlusSign()
	{
		int count = 0;
		for(WebElement e : compareCardAddButtonList)
		{
			if(e.getText().contains("+"))
				count++;
		}
		return count;
	}
	
	public boolean compareModalIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.visibilityOf(compareModal));
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    }
	}
	
	public void allCardsButtonClick() throws InterruptedException {
		allCardsButton.click();
		Thread.sleep(500);
	}
	
	public void clickCheckbox(String string)
	{
		System.out.println("Checkbox list size: " + checkBoxList.size());
		if(checkBoxList.size() > 1)
		{
			for(WebElement e : checkBoxList)
			{
				WebElement label = e.findElement(By.tagName("label"));
				System.out.println(label.getText());
				if(label.getText().contains(string))
				{
					// e.findElement(By.tagName("input")).click();
					e.click();
					break;
				}
			}
		}
	}
	
	public void chooseCreditCard(String string)
	{
		if(creditCardsCardsList.size() > 1)
		{
			for(WebElement e : creditCardsCardsList)
			{
				WebElement internalList = e.findElement(By.tagName("a"));
				if(internalList.getAttribute("title").contains(string))
				{
					WebElement finalElement = internalList.findElement(By.tagName("img"));
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DataFile.explicitWaitInSeconds));
					wait.until(ExpectedConditions.elementToBeClickable(finalElement));
//					internalList.findElement(By.tagName("img")).click();
					finalElement.click();
				}
			}
		}
	}
	
	public boolean compareTrayHasString(String string)
	{
		List<WebElement> compareCardsInContent = compareTrayContent.findElements(By.className("compare-tray-card"));
		System.out.println(compareCardsInContent.size());
		if(compareCardsInContent.size() > 1)
		{
			for(WebElement e : compareCardsInContent)
			{
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				    By.cssSelector("p[class^='card-name-']")
//				));
				WebElement card = e.findElement(By.cssSelector("div.compare-tray-card p:first-of-type"));
				System.out.println(card.getText());
				if(card.getText().contains(string))
					return true;
			}
		}
		return false;
	}
	
	public void clickOnRectangleWithPlusSign() 
	{
		for(WebElement e : compareCardAddButtonList)
		{
			if(e.getText().contains("+"))
			{
				// e.findElement(By.xpath("..")).click();
				// System.out.println("Clicked +");
				e.click();
				break;
			}
		}
	}
}
