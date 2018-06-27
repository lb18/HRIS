package pages;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeSheet
{
	
	WebDriver driver;
	int total_working_hours_of_the_week = 0;
	
	public TimeSheet(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void wait_Until_Timesheet_Loads()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id,'dv_2018-06-11']/div/div[1]/div/div[2]/p[1]/text()"))));
	}
	
	public void get_Data_From_TimeSheet()
	{
		String date = driver.findElement(By.xpath("//div[@id='dv_2018-06-11)']/div/div/div/div[2]/p/span")).getText();
		int st = Integer.parseInt(date);
		System.out.println(date);
		//for (int i = 1; i < 5; i++)
			
	}
}