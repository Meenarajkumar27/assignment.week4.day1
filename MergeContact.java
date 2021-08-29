package assignment.week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//1. Launch URL
		
		
		try
		{
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//login
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.partialLinkText("CRM/SFA")).click();
			
			Thread.sleep(2000);
			//home page
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
			Thread.sleep(2000);
			//from contact
			driver.findElement(By.xpath("//span[text()='From Contact']/following::a[1]")).click();
			Set<String>windowhandleset=driver.getWindowHandles();
			List<String>windowHandleList=new ArrayList<String>(windowhandleset);
			
			driver.switchTo().window(windowHandleList.get(1));
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
			Thread.sleep(2000);
			//driver.quit();
			driver.switchTo().window(windowHandleList.get(0));
			
			//to contact
			System.out.println(driver.findElement(By.xpath("//div[text()='Merge Contacts']")).getText());
			driver.findElement(By.xpath("//span[text()='To Contact']/following::a[1]")).click();
			Thread.sleep(2000);
			Set<String>windowhandleset1=driver.getWindowHandles();
			List<String>windowHandleList1=new ArrayList<String>(windowhandleset1);
			
			driver.switchTo().window(windowHandleList1.get(1));
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
			Thread.sleep(2000);
			driver.switchTo().window(windowHandleList.get(0));
			//clicking Merge button
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			//Accept the alert
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			//Verfiy the title of the page
			System.out.println(" Verify the title of the page"+driver.getTitle());
			driver.close();
		}
		catch(Exception e)
		{
			System.out.println("Error Found :" + e.getMessage());
		}
		
	}

}
