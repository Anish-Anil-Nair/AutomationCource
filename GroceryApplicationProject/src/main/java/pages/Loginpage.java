package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class Loginpage {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement username;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signin;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement remember;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement supermarketname;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	
	

	public Loginpage enterUserNameOnUserNameField(String username1) {

		username.sendKeys(username1);
		return this;
	}

	public Loginpage enterUserPasswordOnPassWordField(String password1) {

		password.sendKeys(password1);
		return this;
	}

	public Loginpage clickOntoRememberMeCheckbox() {

		remember.click();
		return this;

	}

	public HomePage clinkOnToSigninButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitForWebElementClickable(driver, signin);
		signin.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {

		return dashboard.isDisplayed();
	}

	public String pageHeading() {

		return supermarketname.getText();
	}
}
