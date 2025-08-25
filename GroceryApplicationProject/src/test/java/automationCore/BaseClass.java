package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenShotUtility;

public class BaseClass {
	Properties prop;
	FileInputStream fs;

public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initialiseBrowser(String browsers) throws Exception
	{
		prop= new Properties();
		fs= new FileInputStream(Constant.CONFIGFILE);
		prop.load(fs);
	if(browsers.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	
	else if(browsers.equalsIgnoreCase("edge"))
	{
		driver= new EdgeDriver();
	}

	
	else
	{
		throw new Exception("Invalid browser");
	}
	
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod(alwaysRun=true)
	
	//public void browserClose()//for closing the window
	//{
		//driver.close();
		//driver.quit();
		//}
		
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)
	{
	ScreenShotUtility screenShot=new ScreenShotUtility();
	screenShot.getScreenshot(driver, iTestResult.getName());
	}
	driver.quit();

	}
}
