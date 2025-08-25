package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newUserClick;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newUserName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement newUserType;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement newUserSave;

	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(2)']")
	private WebElement searchUser;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement entersearchusername;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchUsername;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']")
	private WebElement reset;

	public AdminUserPage clickOnNewUserButton() {

		newUserClick.click();
		return new AdminUserPage(driver);
	}

	public AdminUserPage enterNewUserName(String newUsername1) {

		newUserName.sendKeys(newUsername1);
		return new AdminUserPage(driver);
	}

	public AdminUserPage enterNewPassword(String newPassword1) {
		newPassword.sendKeys(newPassword1);
		return new AdminUserPage(driver);

	}

	public AdminUserPage selectTheNewUserType(String newUserType1) {

		PageUtility page = new PageUtility();
		page.selectDropdownWithVisibleText(entersearchusername, newUserType1);
		return new AdminUserPage(driver);

	}

	public AdminUserPage clickOnNewUserSaveButton() {

		newUserSave.click();
		return new AdminUserPage(driver);
	}

	public AdminUserPage clickOnSearchUser() {
		searchUser.click();
		return new AdminUserPage(driver);

	}

	public AdminUserPage enterSearchUserNameOnUserField(String entersearchname1) {
		entersearchusername.sendKeys(entersearchname1);
		return new AdminUserPage(driver);
	}

	public AdminUserPage selectSearchUserType(String searchUserType1) {
		// Select select= new Select(searchUserType);
		// select.selectByVisibleText(searchUserType1);
		PageUtility page = new PageUtility();
		page.selectDropdownWithVisibleText(entersearchusername, searchUserType1);
		return new AdminUserPage(driver);

	}

	public AdminUserPage clickOnSearchButtonToSearchUser() {

		searchUsername.click();
		return new AdminUserPage(driver);
	}

	public AdminUserPage clickOnToResetButton() {
		reset.click();
		return new AdminUserPage(driver);

	}

}