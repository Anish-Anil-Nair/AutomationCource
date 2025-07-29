package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends TestNgBase {
	@Test
	public void verifyUserLoginWithValidCredentials()
	{
		
		WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
		username.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
		password.sendKeys("secret_sauce");
		
		WebElement loginbutton =driver.findElement(By.xpath("//input[@id='login-button']"));
		loginbutton.click();
	}
	
	
	@Test
	public void verifyUserLoginWithValidUserNameAndNonValidPassword()
	{
		WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
		username.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
		password.sendKeys("123");
		
		WebElement loginbutton =driver.findElement(By.xpath("//input[@id='login-button']"));
		loginbutton.click();
		
	}
	
	@Test
	public void verifyUserLoginWithNonValidUserNameAndValidPassword()
	{
		WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
		username.sendKeys("ani");
		
		WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
		password.sendKeys("secret_sauce");
		
		WebElement loginbutton =driver.findElement(By.xpath("//input[@id='login-button']"));
		loginbutton.click();
		

	}
	
	@Test
	public void verifyUserLoginWithNonValidCredentials()
	{
		
		WebElement username = driver.findElement(By.xpath("//input[@data-test='username']"));
		username.sendKeys("ani");
		
		WebElement password = driver.findElement(By.xpath("//input[@data-test='password']"));
		password.sendKeys("123");
		
		WebElement loginbutton =driver.findElement(By.xpath("//input[@id='login-button']"));
		loginbutton.click();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
