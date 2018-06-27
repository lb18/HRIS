package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage
{
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"login\"]/form/div[2]/div/input")
	WebElement signIn_Button;
	
	@FindBy(how = How.XPATH, using = "//input[@type, 'checkbox' AND @id, 'txtSsi']")
	WebElement remember_me_checkbox;
	
	@FindBy(how = How.XPATH, using = "*[contains(@href, 'action=sendtoken')")
	WebElement forgot_password_button;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void fill_Fields(String username, String password)
	{
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		signIn_Button.click();
	}
	
}
