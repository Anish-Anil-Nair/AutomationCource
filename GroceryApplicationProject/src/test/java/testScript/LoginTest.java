package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverFinder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Messages;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtilities;

public class LoginTest extends BaseClass {

	HomePage homepage;

	@Test(priority = 1, description = "Verify whether the user is able to login with the valid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidCridentials() throws IOException {
		String username1 = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1)
				.clickOntoRememberMeCheckbox();

		homepage = loginpage.clinkOnToSigninButton();

		boolean dashboarddisplay = loginpage.isDashboardDisplayed();// Assertion
		Assert.assertTrue(dashboarddisplay, Messages.VALIDCRIDENTIALEROOR);

		// WebElement
		// username=driver.findElement(By.xpath("//input[@name='username']"));
		// username.sendKeys("admin");

		// WebElement password=
		// driver.findElement(By.xpath("//input[@name='password']"));
		// password.sendKeys("admin");

		// WebElement submit = driver.findElement(By.xpath("//button[@class='btn
		// btn-dark btn-block']"));
		// submit.click();

		// WebElement remember = driver.findElement(By.name("remember_me"));
		// remember.click();

	}

	@Test(priority = 2, description = "Verify whether the user is able to login with the valid username and invalid password", groups = {
			"smoke" })
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() throws IOException {
		String username1 = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(1, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1)
				.clinkOnToSigninButton();

		String actual = loginpage.pageHeading();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Messages.INVALIDUSERNAMEERROR);

	}

	@Test(priority = 3, description = "Verify whether the user is able to login with the invalid username and valid password", groups = {
			"smoke" })
	public void verifyUserLoginWithInValidUserNameAndValidPassword() throws IOException {
		String username1 = ExcelUtilities.getStringData(2, 0, "LoginPage");
		String password1 = ExcelUtilities.getStringData(2, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1).enterUserPasswordOnPassWordField(password1)
				.clinkOnToSigninButton();

//loginpage.clickOnRememberButton();

		String actual = loginpage.pageHeading();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Messages.INVALIPASSWORDERROR);
	}

	@Test(priority = 4, description = "Verify whether the user is able to login with the invalid credentials", dataProvider = "loginProvider")
	public void verifyUserLoginWithInValidUserNameAndInValidPassword(String username1, String password1)
			throws IOException {
		// String username1 = ExcelUtilities.getStringData(3, 0, "LoginPage");
		// String password1 = ExcelUtilities.getStringData(3, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterUserPasswordOnPassWordField(password1).clinkOnToSigninButton();
//loginpage.clickOnRememberButton();

		String actual = loginpage.pageHeading();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Messages.INVALICRIDENTIALERROR);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "admin123", "admin1234" }, new Object[] { "123", "123" },
//new Object[] {ExcelUtilities.getStringData(3, 0,"Login"),ExcelUtilities.getStringData(3,1 ,"Login")}
		};
	}

}
