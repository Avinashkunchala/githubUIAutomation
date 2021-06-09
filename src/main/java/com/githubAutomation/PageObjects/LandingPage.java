package com.githubAutomation.PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.githubAutomation.Base.TestBase;

public class LandingPage extends TestBase {

	@FindBy(xpath = "//h1[text()=' Where the world builds software ']")
	WebElement landingPageText;

	@FindBy(xpath = "//input[@type='text' and @placeholder='Search GitHub']")
	WebElement searchbox;

	@FindBy(xpath = "//h3[contains (text(),'repository results')]")
	WebElement searchResults;

	@FindBy(xpath = "//a[@class='v-align-middle']")
	List<WebElement> projectLinks;

	@FindBy(xpath = "//span[@data-content='Code']")
	WebElement repoCode;

	@FindBy(xpath = "//span[normalize-space()='Star']")
	WebElement starButton;

	@FindBy(id = "login_field")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement signIn;

	@FindBy(xpath = "//span[normalize-space()='Unstar']")
	WebElement unstar;

	@FindBy(xpath = "//a[normalize-space()='Go to file']")
	WebElement searchingFileLink;
	
	@FindBy(xpath = "//div[@class='flash']")
    WebElement pathFinder;

	@FindBy(xpath = "//input[@id='tree-finder-field']")
	WebElement FileSearchField;

	@FindBy(xpath = "//a[@role='option']//span[contains(@class,'js-tree-browser-result-path')]")
	WebElement fileLink;
	
	@FindBy(xpath = "//strong[normalize-space()='History']")
	WebElement fileHistory;

	public LandingPage() {

		PageFactory.initElements(driver, this);

	}

	// This method define to fetch the text form the github landing page

	public String landingPageText() {

		return landingPageText.getText();

	}

	// This method define to search the reops and give the results

	public Boolean searchingRepo() {

		searchbox.sendKeys(prop.getProperty("repoName"));

		searchbox.sendKeys(Keys.ENTER);

		boolean resultsFound = searchResults.isDisplayed();

		return resultsFound;
	}

	// Selecting the 1st repo from the search results

	public boolean selectingRepo() {

		projectLinks.get(0).click();

		boolean openRepository = repoCode.isDisplayed();

		return openRepository;
	}

	// Selecting the star by signing with username and password

	public String selectingStar() {

		starButton.click();

		userName.sendKeys(prop.getProperty("userName"));

		password.sendKeys(prop.getProperty("password"));

		signIn.click();

		starButton.click();

		return unstar.getText();

	}

	// Unselecting the star

	public String unSelectingStar() {

		unstar.click();

		return starButton.getText();
	}
	
	// Searching and opening the file from the existing repo

	public String searchingAndOpeningFile() {

		searchingFileLink.click();
		
		Actions action=new Actions(driver);
		
		action.moveToElement(FileSearchField).build().perform();
		
		action.sendKeys(prop.getProperty("FileName")).build().perform();
		
		fileLink.click();
		
		return fileHistory.getText();
	}

}
