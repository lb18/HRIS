package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SelectBrowser
{
	static WebDriver driver;
	
	public static WebDriver launchBrowser(String browserType, String url)
	{
		if (browserType.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browserType.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "/home/loki/Downloads/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("IE"))
			driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//a[@href='#panel1']")).click();
		return driver;
	}
}
