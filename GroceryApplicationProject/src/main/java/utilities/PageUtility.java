package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		
	}
	
	public void selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		
	}
	
	public void clickOnAlwaysRememberCheckBox(WebElement element) {
		
		element.click();
		
	}
public void clickOnButtons(WebElement element) {
		
		element.click();
		
	}
	

}
