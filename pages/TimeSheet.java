package pages;

import java.util.*;
import javafx.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(" //*[@id='dv_2018-06-11']/div/div[1]/span"))));
		//wait.until(ExpectedConditions.elementToBeClickable((By.xpath(" //*[@id='dv_2018-06-11']/div/div[1]/span"))));
	}
	
	public Pair<Integer, Integer> calculate_time(List<IntegerPair> time)
	{
		int total_hrs = 0, total_mins = 0;
		for (IntegerPair t: time)
		{
			total_hrs += t.get_hrs();
			total_mins += t.get_min();
			if (total_mins >= 60)
			{
				total_hrs++;
				total_mins -=60;
			}
		}
		return new Pair<Integer, Integer>(total_hrs, total_mins);
	}
	
	public String get_Data_From_TimeSheet()
	{
		wait_Until_Timesheet_Loads();
		String starting_day = driver.findElement(By.xpath("//*[@id='dv_2018-06-11']/div/div[1]/span")).getText();
		int st = Integer.parseInt(starting_day);
		String start = "//*[@id='dv_2018-06-";
		String end = "']/div/div[1]/div/div[2]/p/span";
		List<IntegerPair> weekly_working_hrs = new ArrayList<IntegerPair>();
		for (int i = 0; i < 5; i++)
		{
			String working_hrs = driver.findElement(By.xpath(start+st+end)).getText();
			st++;
			int hrs = Integer.parseInt(working_hrs.substring(0, 2));
			int min = Integer.parseInt(working_hrs.substring(3, 5));
			weekly_working_hrs.add(new IntegerPair(hrs, min));
		}
		Pair<Integer, Integer> res = calculate_time(weekly_working_hrs);
		String tot_time = "";
		if (res.getKey() < 10 ) tot_time += "0";
		tot_time = new Integer(res.getKey()).toString() + ":";
		if (res.getValue() < 10) tot_time += "0";
		tot_time += new Integer(res.getValue()).toString();
		return tot_time;
		
		/*for (Iterator<IntegerPair> it = weekly_working_hrs.iterator(); it.hasNext();)
		{
			//Iterator <IntegerPair>iit = it.next();
			//System.out.print(((IntegerPair) it).get_hrs());
			//System.out.print("hrs: " + it.next().get_hrs()+ "   mins: " + it.next().get_min());
			System.out.println("");
			
		}*/
	}
}
