package SeliniumBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
public WebDriver driver;
public void initialiseBrowser()
{
	driver=new ChromeDriver();
	driver.get("https://selenium.qabible.in/");
	driver.manage().window().maximize();
}
	public void browserClose()//for closing the window
	{
		//driver.close();
		//driver.quit();
		}
	
public static void main(String[] arg) {
	Base base=new Base();
	base.initialiseBrowser();
	base.browserClose();
}
}
