package stepDefination;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class FlightBooking {
	static WebDriver driver;
	static String flight_evening_fastest_company;
	static String flight_evening_fastest_no;
	@Given("^user is in home page opened in chrome browser$")
	public void user_is_in_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(6000);
	}
	
	@Given("^user is in home page opened in firefox browser$")
	public void user_is_in_home_page_safari() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(7000);
	}
	
	@When("user enters source (.*)")
	public void user_enters_source_Kolkata(String source) throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(source);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(source);
		Thread.sleep(3000);
		List<WebElement> lst=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lst.get(0));
		Thread.sleep(3000);
		
	}
	
	@When("user enters FromCity in firefox (.*)")
	public void user_enters_source_Kolkata_firefox(String source) throws Throwable {
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(source);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(source);
		Thread.sleep(3000);
		List<WebElement> lst=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lst.get(0));
		Thread.sleep(3000);
		
	}

	@When("user enters destination (.*)")
	public void user_enters_destination_Bangalore(String destination) throws Throwable {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(destination);
		Thread.sleep(3000);
		List<WebElement> lst=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lst.get(0));
		Thread.sleep(3000);
		Robot r=new Robot();

		for(int i=0;i<3;i++)
		{
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		}

				Thread.sleep(3000);
				WebElement button=driver.findElement(By.xpath("//a[text()='Search']"));
				
				//JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", button);
				Thread.sleep(3000);
	}

	@When("user enters ToCity (.*)")
	public void user_enters_destination(String destination) throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(destination);
		Thread.sleep(3000);
		List<WebElement> lst=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lst.get(0));
		Thread.sleep(3000);
		Robot r=new Robot();

		/*
		 * for(int i=0;i<3;i++) { r.keyPress(KeyEvent.VK_TAB);
		 * r.keyRelease(KeyEvent.VK_TAB); }
		 */

				Thread.sleep(3000);
				WebElement button=driver.findElement(By.xpath("//a[text()='Search']"));
				
				//JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", button);
				Thread.sleep(5000);
	}



	@When("^user select the fastest evening flight$")
	public void user_select_the_fastest_evening_flight() throws Throwable {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[text()='Duration']/parent::span")).click();
		Thread.sleep(3000);
		List<WebElement> lst=driver.findElements(By.xpath("//div[@class='dept-time']"));
		List<WebElement> lst1=driver.findElements(By.xpath("//span[@class='airways-name ']"));
		List<WebElement> lst2=driver.findElements(By.xpath("//p[@class='fli-code']"));
		List<WebElement> lst3=driver.findElements(By.xpath("//button[text()='View Fares']"));
		String date_flight=driver.findElement(By.xpath("//input[@id='departure']")).getAttribute("value");
		int temp=0;
		int counter=0;
		String s="";
		for(WebElement wb:lst)
		{
		 s=wb.getText();
			String[] s1=s.split(":");
			int i=Integer.parseInt(s1[0]);
			if(i>18 && i<20)
			{
				flight_evening_fastest_company=lst1.get(counter).getText();
				flight_evening_fastest_no=lst2.get(counter).getText();
				temp++;
				lst3.get(counter).click();
				Thread.sleep(3000);
				List<WebElement> lst4=driver.findElements(By.xpath("//button[text()='Hide Fares']/ancestor::div[@class='fli-list one-way']/div[3]/div/div[2]/div[2]/div[2]/button"));
			lst4.get(0).click();
			break;
			
			}
			
			counter++;
		}
		
		if(temp==0)
		{
			System.out.println("There are no flight in evening from 6:00 P.m to 8:00 P.m for "+date_flight);
		}else
		{
			System.out.println("The fastest evening flight for "+date_flight+" is "+flight_evening_fastest_company+" with flight code "+flight_evening_fastest_no+" at "+s);
		}

	}

	@Then("^user is in flight booking page$")
	public void user_is_in_flight_booking_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Set<String> s=driver.getWindowHandles();
	   if(s.size()>1)
	   {
		   System.out.println("Test case Passed");
	   }else
	   {
		   System.out.println("Test case Failed");
		   Assert.assertEquals(false, true);
	   }
	   driver.quit();
	}


	
}
