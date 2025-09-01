package testScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import automationCore.BaseClass;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtilities;
import utilities.RandomDataUtility;

public class AdminUsersTest extends BaseClass {
	HomePage homepage;
	AdminUserPage adminuserpage;

	@Test(description = "Verify whether the admin is able to create new user")
	public void verifyWhetherTheAdminIsAbleToAddUser() throws IOException {

		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1);
		// loginpage.clickOntoRememberMeCheckbox();
		homepage = loginpage.clinkOnToSigninButton();

//AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage = homepage.clickOnAdminUserButton().clickOnNewUserButton();

		RandomDataUtility random = new RandomDataUtility();
		String newUsername1 = random.createRandomUserName();
		String newPassword1 = random.createRandomPassword();

//String newUsername1 = ExcelUtilities.getStringData(0, 0, "NewUser");
//String newPassword1 = ExcelUtilities.getStringData(0, 1, "NewUser");
		String newUserType1 = ExcelUtilities.getStringData(0, 2, "NewUser");
		adminuserpage.enterNewUserName(newUsername1).enterNewPassword(newPassword1).selectTheNewUserType(newUserType1)
				.clickOnNewUserSaveButton();
		//Assert
				boolean Actual = adminuserpage.isDisplayedUserSavedAlertMsg();
				assertEquals(Actual, "Alert!",Messages.UNSUCCESSFULLUSERCREATION);
	}

	@Test(description = "Verify whether the user is able to search the new user")
	public void verifyWhetherTheUserIsAbleToSearchTheUser() throws IOException {
		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1);

		// loginpage.clickOntoRememberMeCheckbox();
		homepage = loginpage.clinkOnToSigninButton();

		// AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage = homepage.clickOnAdminUserButton().clickOnSearchUser();

		String entersearchname1 = ExcelUtilities.getStringData(0, 0, "NewUser");
		String searchUserType1 = ExcelUtilities.getStringData(0, 2, "NewUser");

		adminuserpage.enterSearchUserNameOnUserField(entersearchname1).selectSearchUserType(searchUserType1)
				.clickOnSearchButtonToSearchUser();
		
		boolean searchAdminUserstext=adminuserpage.isDisplayedSearchAdminUsersText();
		assertTrue(searchAdminUserstext,Messages.UNSUCCESSFULLUSERSEARCH);

	}

	@Test(description = "Verify whether the user is able to click on reset button")
	public void verifyWhetherTheUserIsAbleToClickOnResetButton() throws IOException {

		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1);

		// loginpage.clickOntoRememberMeCheckbox();
		homepage = loginpage.clinkOnToSigninButton();

		// AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage = homepage.clickOnAdminUserButton().clickOnToResetButton();
		
		//Assertion
		boolean resetAdminUserstext=adminuserpage.isDisplayedResetAdminUsersText();
		assertEquals(resetAdminUserstext,Messages.RESETUSERERROR);

	}

}
