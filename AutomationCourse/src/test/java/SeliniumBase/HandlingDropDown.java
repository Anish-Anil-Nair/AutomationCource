package SeliniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown extends Base {

	
	public void verifyDropDown()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
		Select select = new Select(dropdown);
		//select.selectByIndex(2);
		//select.selectByValue("python");
		select.selectByVisibleText("SQL");
		
		}
	
	public void verifyCheckbox() // Todays class
	{
		WebElement checkbox = driver.findElement(By.xpath("//input[@value='option-2']"));
		checkbox.click();
		System.out.println(checkbox.isSelected());
		
	}
	
	public void verifyRadiobutton()
	{
	WebElement radiobutton =driver.findElement(By.xpath("//input[@value='orange']"));
	radiobutton.click();
	
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
HandlingDropDown drop = new HandlingDropDown();
drop.initialiseBrowser();
drop.verifyDropDown();
drop.verifyCheckbox();
drop.verifyRadiobutton();
	}

}
