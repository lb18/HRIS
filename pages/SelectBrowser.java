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
		//driver.findElement(By.xpath("//*[@a='#panel1']//ancestor::div[2]//ancestor::div[1]//ancestor::div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"demo-2\"]/div/div[2]/ul/li[1]/a")).click();
		return driver;
	}
}
