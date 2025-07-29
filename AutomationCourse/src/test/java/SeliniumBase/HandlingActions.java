package SeliniumBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandlingActions extends Base {

	
	public void verifyRightClick()
	{
		WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
		Actions a = new Actions(driver);
		a.contextClick(home).build().perform();
		
		
	}
	
	public void verifyMouseHover()
	{
		WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
		Actions a = new Actions(driver);
		a.moveToElement(home).build().perform();
		
	}
	
	public void verifyDragHome()
	{
		driver.navigate().to("https://demoqa.com/droppable");
		WebElement dragme = driver.findElement(By.id("draggable"));
		WebElement dropehere =driver.findElement(By.id("droppable"));
		Actions a =new Actions(driver);
		a.dragAndDrop(dragme, dropehere).build().perform();
		
	}
	
	public void verifyKeyboardAction() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
HandlingActions action = new HandlingActions();
action.initialiseBrowser();
//action.verifyRightClick();
//action.verifyMouseHover();
//action.verifyDragHome();
try {
	action.verifyKeyboardAction();
} catch (AWTException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
