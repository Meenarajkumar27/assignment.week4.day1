package assignment.week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frameexercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Launch URL
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				WebElement frame1=driver.findElement(By.xpath("//iframe[@id='frame1']"));
				driver.switchTo().frame(frame1);
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("12345");
				driver.switchTo().frame("frame3");
				driver.findElement(By.xpath("//input[@id='a']")).click();
				driver.switchTo().defaultContent();
				WebElement frame2=driver.findElement(By.xpath("//iframe[@id='frame2']"));
				driver.switchTo().frame("frame2");
				WebElement animals=driver.findElement(By.xpath("//select[@id='animals']"));
				Select animal=new Select(animals);
				animal.selectByValue("babycat");
	}

}
