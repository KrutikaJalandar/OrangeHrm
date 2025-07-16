package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass 
{
	public static WebDriver driver;
	@BeforeTest
	public static void openBrowserApp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Browser1\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public static void closeBrowserApp()
	{
		driver.quit();
		System.out.println("Application Closed Successfully");
		System.out.println("Browser closed ");
		
	}

}
