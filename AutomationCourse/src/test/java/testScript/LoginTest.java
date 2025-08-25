package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends TestNgBase {
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String username1 = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterPasswordOnPasswordField(password1);
		loginpage.clickOnSignInButton();
		
		//WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		//username.sendKeys("standard_user");
		
		//WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		//password.sendKeys("secret_sauce");
		
		//WebElement loginbutton =driver.findElement(By.xpath("//input[@id='login-button']"));
		//loginbutton.click();
	}
	
	
	@Test
	public void verifyUserLoginWithValidUserNameAndNonValidPassword() throws IOException
	{
		String username1 = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterPasswordOnPasswordField(password1);
		loginpage.clickOnSignInButton();
		
	}
	
	@Test
	public void verifyUserLoginWithNonValidUserNameAndValidPassword() throws IOException
	{
		String username1 = ExcelUtilities.readStringData(2, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterPasswordOnPasswordField(password1);
		loginpage.clickOnSignInButton();
		

	}
	
	@Test
	public void verifyUserLoginWithNonValidCredentials() throws IOException
	{
		String username1 = ExcelUtilities.readStringData(3, 0, "LoginPage");
		String password1 = ExcelUtilities.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username1);
		loginpage.enterPasswordOnPasswordField(password1);
		loginpage.clickOnSignInButton();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
