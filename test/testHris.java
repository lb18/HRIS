package test;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Logout;
import pages.SelectBrowser;
import pages.TimeSheet;

public class testHris
{
	WebDriver driver;
	LoginPage check_credentials_passed_for_login;
	TimeSheet get_total_working_hours;
	Logout logout;
	
	@BeforeClass
	public void init()
	{
		SelectBrowser select_browser_type = new SelectBrowser();
		driver = select_browser_type.launchBrowser("chrome", "https://hris.qainfotech.com/login.php");
		check_credentials_passed_for_login = PageFactory.initElements(driver, LoginPage.class);
		get_total_working_hours = PageFactory.initElements(driver, TimeSheet.class);
		logout = PageFactory.initElements(driver, Logout.class);
	}
	
	@Test
	public void username_Field_Is_Empty_Should_Load_The_Same_Page_Again()
	{
		check_credentials_passed_for_login.fill_Fields("", "abc");
		assertEquals(driver.getCurrentUrl(),"https://hris.qainfotech.com/login.php");
	}
	
	@Test(dependsOnMethods = {"username_Field_Is_Empty_Should_Load_The_Same_Page_Again"})
	public void logging_In_With_Valid_Credentials_Should_Load_Home_Page()
	{
		check_credentials_passed_for_login.fill_Fields("", "");     //login credentials
		assertEquals(driver.getCurrentUrl(),"https://hris.qainfotech.com:8086/time/timesheet");
	}
	
	@Test(dependsOnMethods = {"logging_In_With_Valid_Credentials_Should_Load_Home_Page"})
	public void Total_Time_Shown_In_HRIS_Timesheet_Should_Be_Correct()
	{
		get_total_working_hours.get_Data_From_TimeSheet();
		WebElement total_working_hrs = driver.findElement(By.xpath("//tr[3]/td[8]/employee-timesheet/div/div/span"));
		String tot_time = total_working_hrs.getText();
		Assert.assertTrue(get_total_working_hours.get_Data_From_TimeSheet().equals(tot_time));
	}
	
	@Test(dependsOnMethods = {"Total_Time_Shown_In_HRIS_Timesheet_Should_Be_Correct"})
	public void after_Clicking_On_Logout_Button_User_Should_Be_Able_To_See_Copyright_Text()
	{
		logout.logout_User();
		WebElement logout_check = driver.findElement(By.xpath("//footer/div/div[2]/p"));
		Assert.assertTrue(logout_check.getText().contains("QAITHRIS Copyright QA InfoTech Pvt. Ltd. 2018 rights reserved."));
	}
	
	@Test(dependsOnMethods = {"after_Clicking_On_Logout_Button_User_Should_Be_Able_To_See_Copyright_Text"})
	public void after_Clicking_On_Logout_Button_User_Should_Redirect_To_Login_Page()
	{
		assertEquals(driver.getCurrentUrl(),"https://hris.qainfotech.com/login.php");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
