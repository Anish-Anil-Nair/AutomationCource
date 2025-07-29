package SeliniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingWebElementsCommands extends Base
{
public void verifyWebElements()
{
	driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
	WebElement messagebox = driver.findElement(By.id("single-input-field"));
	messagebox.sendKeys("Ani");
	
	WebElement showmessagebutton = driver.findElement(By.id("button-one"));
	System.out.println(showmessagebutton.isDisplayed()); // Todays class
	System.out.println(showmessagebutton.isEnabled()); // Todays class
	showmessagebutton.click();
	WebElement showmessage = driver.findElement(By.id("message-one"));
	System.out.println(showmessage.getText());
	messagebox.clear();
	System.out.println(showmessagebutton.getCssValue("border-color"));
	System.out.println(showmessagebutton.getTagName());
}

public static void main(String[] args) { 
		// TODO Auto-generated method stub 

	HandlingWebElementsCommands webelements = new HandlingWebElementsCommands();
		webelements.initialiseBrowser(); 
		webelements.verifyWebElements(); 
	} 
}
