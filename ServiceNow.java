package assignment.week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//1. Launch URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame1=driver.findElement(By.xpath("//main[@class='navpage-main']//iframe"));
		driver.switchTo().frame(frame1);
		
		//login details
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
	      // js.executeScript("document.querySelector('//div[@id='nav_west_center']').scrollTop=5000");
		Thread.sleep(15000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		//Click New button
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//Select a value for Caller and Enter value for short_description
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		Thread.sleep(2000);
		Set<String>windowHandleset=driver.getWindowHandles();
		List<String>windowHandlelist=new ArrayList<String>(windowHandleset);
		driver.switchTo().window(windowHandlelist.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(windowHandlelist.get(0));
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test");
		
		
		//Read the incident number and save it a variable
		String incidentnumber=driver.findElement(By.xpath("//input[@name='incident.number']")).getAttribute("value");
		System.out.println("incidentnumber"+incidentnumber);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		
		//check the inscident is created
		driver.switchTo().window(windowHandlelist.get(0));
		driver.switchTo().frame("gsft_main");
		WebElement searchBox = driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]"));
		searchBox.sendKeys(incidentnumber);
		searchBox.sendKeys(Keys.ENTER);
		
		String createdId = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(createdId.equals(incidentnumber))
		{
		System.out.println("Incident number is created successfully " +createdId);
		}
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/servicenow.png");
		FileUtils.copyFile(src1, dst);
		
	}

}
