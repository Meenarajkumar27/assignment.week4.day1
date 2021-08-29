package assignment.week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunwithFrame {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1. Launch URL
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("http://leafground.com/pages/frame.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//1.Take the the screenshot of the click me button of first frame
				WebElement frame1=driver.findElement(By.xpath("(//div[@id='wrapframe']//iframe)[1]"));
				driver.switchTo().frame(frame1);
				WebElement clickMe=driver.findElement(By.xpath("//button[@id='Click']"));
				File src1 = clickMe.getScreenshotAs(OutputType.FILE);
				File dst = new File("./snaps/clickme.png");
				FileUtils.copyFile(src1, dst);
				driver.switchTo().defaultContent();
				List<WebElement>noofFrame=driver.findElements(By.tagName("iframe"));
				System.out.println("No of Frame in the Screen:"+noofFrame.size());
				
				
	}

}
