package SeliniumBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HandlingFrames extends Base {
	
	public void frame()
	{
		driver.navigate().to("https://demoqa.com/frames");
		List<WebElement> totalframe = driver.findElements(By.tagName("iframe"));
		System.out.println(totalframe.size());
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		WebElement text1 = driver.findElement(By.id("sampleHeading"));
		System.out.println(text1.getText());
		driver.switchTo().defaultContent(); // to goto default page
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
HandlingFrames frames = new HandlingFrames();
frames.initialiseBrowser();
frames.frame();
	}

}
