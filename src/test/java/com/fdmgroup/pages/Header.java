package com.fdmgroup.pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fdmgroup.data.DataFile;

public class Header {
	private WebDriver driver;
	private Actions actions;
	
	@FindBy(id = "header")
	private WebElement header;
	
	@FindBy(id = "header-search-btn")
	private WebElement headerSearchTrigger;
	
	@FindBy(id = "header-search")
	private WebElement headerSearch;
	
	@FindBy(tagName = "h1")
	private WebElement pageHeading;
	
	@FindBy(xpath = "//span[contains(@class, 'result_count')]")
	private WebElement resultCountSpan;
	
	@FindBy(xpath = "//div[contains(@class, 'show-no-results')]")
	private WebElement noResultDiv;
	
	
	public Header(WebDriver driver, Actions actions) {
		this.driver = driver;
		this.actions = actions;
		PageFactory.initElements(driver, this);
	}
	
	public boolean headerIsDisplayed() {
		return header.isDisplayed();
	}
	
	public void searchBarUtility(String string)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DataFile.explicitWaitInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(headerSearchTrigger));
		headerSearchTrigger.click();
		wait.until(ExpectedConditions.visibilityOf(headerSearch));
		headerSearch.click();
		headerSearch.sendKeys(string + Keys.ENTER);
	}
	
	public String getPageHeading()
	{
		return pageHeading.getText();
	}
	
	public boolean isThereSearchResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DataFile.explicitWaitForSearch));
		wait.until(ExpectedConditions.visibilityOf(noResultDiv));
		return ! noResultDiv.isDisplayed();
	}
	
	
	public boolean multipleResultDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DataFile.explicitWaitForSearch));
		wait.until(ExpectedConditions.visibilityOf(resultCountSpan));
		if(resultCountSpan.isDisplayed())
			return true;
		return false;
	}
	
	public String noSearchHeader() {
		if(! isThereSearchResult())
		{
			return noResultDiv.findElement(By.tagName("h4")).getText();
		}
		return "";
	}
	
	public void takeScreenShot() throws IOException {
		File source = header.getScreenshotAs(OutputType.FILE);
		File destination = new File(DataFile.pathForScreenShot + "header_screenshot.png");
		FileHandler.copy(source, destination);
		System.out.println("Screenshot saved");
	}
	
	public boolean colorOfHeader() throws InterruptedException {
		try {
			takeScreenShot();
			Thread.sleep(1000);
			
	        File file = new File(DataFile.pathForScreenShot + "header_screenshot.png"); // Replace with your image path
	        BufferedImage image = ImageIO.read(file);
	        int x = DataFile.pixelX;
	        int y = DataFile.pixelY;
	        
	        if (image != null && x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
	            int pixelValue = image.getRGB(x, y);
	            System.out.println("Pixel value at (" + x + ", " + y + "): " + pixelValue);
	            
	         // Extracting individual components using bitwise operations
	            int alpha = (pixelValue >> 24) & 0xFF;
	            int red = (pixelValue >> 16) & 0xFF;
	            int green = (pixelValue >> 8) & 0xFF;
	            int blue = (pixelValue >> 0) & 0xFF; // or simply (pixelValue & 0xFF)
	            System.out.println("Colors: Red: " + red + "\tGreen: " + green + "\tblue: " + blue);
	            
	            if(blue >= red && blue >= green)
	            {
	            	return true;
	            }
	        } else {
	            System.out.println("Invalid image or coordinates.");
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return false;
	}
}
