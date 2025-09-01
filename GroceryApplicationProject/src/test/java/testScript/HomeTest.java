package testScript;

import java.io.IOException;
import java.security.MessageDigest;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Messages;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtilities;

public class HomeTest extends BaseClass {
	HomePage homepage;

	@Test(description = "Verify whether the user is able to logout sucessfully")

	public void verifyWhetherTheUserIsAbleSucessfullyLogout() throws IOException {
		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1);

//loginpage.clickOntoRememberMeCheckbox();
		homepage = loginpage.clinkOnToSigninButton().clickOnAdminButton();

		loginpage = homepage.clickOnLogoutButton();
		
		//Assertion
				String actual=homepage.loginpageHeading();
				String expected="7rmart supermarkete";
				Assert.assertEquals(actual, expected,Messages.LOGOUTERROR);

	}

}
