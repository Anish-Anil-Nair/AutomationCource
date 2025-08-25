package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	private WebElement adminClick;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminUserClick;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") private WebElement manageNews;

	public HomePage clickOnAdminButton() {
		adminClick.click();
		return this;
	}

	public Loginpage clickOnLogoutButton() {

		logout.click();
		return new Loginpage(driver);
	}

	public AdminUserPage clickOnAdminUserButton() {

		adminUserClick.click();
		return new AdminUserPage(driver);
	}
	public ManageNewsPage clickOnManageNewsButton()
	{
		manageNews.click();
		return new ManageNewsPage(driver);
		
		
	}

}
