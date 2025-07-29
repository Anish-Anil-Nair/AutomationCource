package testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNgBase {
	public WebDriver driver;
	
	@BeforeMethod
	public void initialiseBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
		public void browserClose()//for closing the window
		{
			//driver.close();
			//driver.quit();
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
