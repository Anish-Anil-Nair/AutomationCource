package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.BaseClass;
import pages.HomePage;
import pages.Loginpage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class ManageNewsTest extends BaseClass {
	HomePage homepage;
	ManageNewsPage managenewspage;

	@Test(description = "Verify whether user is able to navigate to manage news page")

	public void verifyWhetherTheUserIsAbleToNavigateToManageNews() throws IOException {

		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1);

		// loginpage.clickOntoRememberMeCheckbox();
		homepage = loginpage.clinkOnToSigninButton();
		managenewspage = homepage.clickOnManageNewsButton();
		// ManageNewsPage managenewspage = new ManageNewsPage(driver);

	}

	@Test(description = "Verify whether the user is able to add new news")

	public void verifyWhetherTheUserIsAbleToAddNewNews() throws IOException {

		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1);

		// loginpage.clickOntoRememberMeCheckbox();
		homepage = loginpage.clinkOnToSigninButton();
		managenewspage = homepage.clickOnManageNewsButton();
		// ManageNewsPage managenewspage = new ManageNewsPage(driver);

		managenewspage.clickOnNewNewsButton().enterNewNewsOnNewNewsField(ExcelUtilities.getStringData(0, 0, "NewNews"))
				.clickOnSaveNewNews();

		// RandomDataUtility random = new RandomDataUtility();
		// String newNews1 = random.createRandomText();

	}

	@Test(description = "Verify whether the user is able to search the new news")

	public void verifyWhetherTheUserIsAbleToSearchTheNews() throws IOException {
		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1);

		// loginpage.clickOntoRememberMeCheckbox();
		homepage = loginpage.clinkOnToSigninButton();

		// ManageNewsPage managenewspage = new ManageNewsPage(driver);
		homepage.clickOnManageNewsButton().clickOnSearchNewsButton()
				.enterTheNewsInTheTitleBar(ExcelUtilities.getStringData(0, 0, "NewNews")).clickOnSubmitButton();

	}

}
