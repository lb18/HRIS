package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout
{
	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//a[@href='javascript:void(0);']")
	WebElement user_profile_options_button;
	
	@FindBy(how = How.XPATH, using = "//a[@href='https://hris.qainfotech.com:8086/user/logoff']")
	WebElement logout_button;
	
	public Logout(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void logout_User()
	{
		user_profile_options_button.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(" //*[@id='dv_2018-06-11']/div/div[1]/span"))));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", logout_button);
	}
}