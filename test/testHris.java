package test;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SelectBrowser;
import pages.TimeSheet;

public class testHris
{
	WebDriver driver;
	LoginPage check_credentials_passed_for_login;
	TimeSheet get_total_working_hours;
	
	@BeforeClass
	public void init()
	{
		SelectBrowser select_browser_type = new SelectBrowser();
		driver = select_browser_type.launchBrowser("chrome", "https://hris.qainfotech.com/login.php");
		check_credentials_passed_for_login = PageFactory.initElements(driver, LoginPage.class);
		get_total_working_hours = PageFactory.initElements(driver, TimeSheet.class);
	}
	
	@Test
	public void username_Field_Is_Empty_Should_Load_The_Same_Page_Again()
	{
		check_credentials_passed_for_login.fill_Fields("", "abc");
		//WebElement username_txt_field = driver.findElement(By.id("txtUserName"));
		//System.out.println(username_txt_field.getCssValue("border"));//getAttribute("style")));
		//WebElement username_txt_field = driver.findElement(By.xpath("//*input(@id = 'txtUserName' AND @type = 'text)"));
		//assertEquals(username_txt_field.getAttribute("name"), true);
		assertEquals(driver.getCurrentUrl(),"https://hris.qainfotech.com/login.php");
	}
	
	@Test(dependsOnMethods = {"username_Field_Is_Empty_Should_Load_The_Same_Page_Again"})
	public void logging_In_With_Valid_Credentials_Should_Load_Home_Page()
	{
		check_credentials_passed_for_login.fill_Fields("lokeshbisht", "Lokesh@321#");
		assertEquals(driver.getCurrentUrl(),"https://hris.qainfotech.com:8086/time/timesheet");
		get_total_working_hours.get_Data_From_TimeSheet();
	}
}
