package com.githubAutomation.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.githubAutomation.Base.TestBase;
import com.githubAutomation.PageObjects.LandingPage;

public class LandingPageTest extends TestBase {

	public LandingPage landingPage;

    @BeforeMethod
    
	public void setup() {

		landingPage = new LandingPage();

	}

	@Test(priority = 1, description = "Verifying whether Landing page is loaded or not")

	public void verifyingLandingPage() {

		String welcomePageText = landingPage.landingPageText();

		Assert.assertEquals("Where the world builds software", welcomePageText);

	}

	@Test(priority = 2, description = "Verfiying whether we get the results or not with given keyword")

	public void verifyingRepoResults() {

		boolean results_Found = landingPage.searchingRepo();

		Assert.assertEquals(true, results_Found);
	}

	@Test(priority = 3, description = "Opening the Repository and validating whether repo is opened or not")

	public void validatingRepository() {

		boolean is_repoOpened = landingPage.selectingRepo();

		Assert.assertEquals(true, is_repoOpened);
	}

	@Test(priority = 4, description = "Selecting the star by signing and verfiying the start is selected")

	public void verifyingStar() {

		String starStatus = landingPage.selectingStar();

		Assert.assertEquals("Unstar", starStatus);
	}

	@Test(priority = 5, description = "validing whether star is unselected or not")

	public void verifyingUnstar() {

		String unstarStatus = landingPage.unSelectingStar();

		Assert.assertEquals("Star", unstarStatus);
	}

	@Test(priority = 6, description = "Validating whether searched file  is opened or not")

	public void verifyingFileSearchField() {

		String fileOpened = landingPage.searchingAndOpeningFile();

		Assert.assertEquals(prop.getProperty("fileOpenedOrNOt"), fileOpened, "File opened Successfully");

	}

}
