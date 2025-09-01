package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'
	// and @class='small-box-footer']") private WebElement manageNews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement newNewsButton;

	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement addNewNews;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveNewNews;

	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	private WebElement searchNewsButton;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement enterSearchNews;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement clickSearchNews;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement newsSuccessfullySavedMsg;
	
	@FindBy(xpath = "//h4[text()='Manage News']")
	private WebElement manageNewsText;
	
	@FindBy(xpath="//h4[text()='Search Manage News']")
	private WebElement searchNewsText;

	public ManageNewsPage clickOnNewNewsButton()

	{
		newNewsButton.click();
		return new ManageNewsPage(driver);

	}

	public ManageNewsPage enterNewNewsOnNewNewsField(String newNews1) {
		addNewNews.sendKeys(newNews1);
		return new ManageNewsPage(driver);
	}

	public ManageNewsPage clickOnSaveNewNews() {

		saveNewNews.click();
		return new ManageNewsPage(driver);
	}

	public ManageNewsPage clickOnSearchNewsButton() {
		searchNewsButton.click();
		return new ManageNewsPage(driver);

	}

	public ManageNewsPage enterTheNewsInTheTitleBar(String enterSearchNews1) {
		enterSearchNews.sendKeys(enterSearchNews1);
		return new ManageNewsPage(driver);

	}

	public ManageNewsPage clickOnSubmitButton() {

		clickSearchNews.click();
		return new ManageNewsPage(driver);
	}
	public Boolean isDisplayedNewsSavedAlertMsg()
	{
		return newsSuccessfullySavedMsg.isDisplayed();
	}
	
	public String resetPageHeading()
	{
		return manageNewsText.getText();
	}
	
	public String searchPageHeading()
	{
		return searchNewsText.getText();
	}

}
