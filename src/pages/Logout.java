package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.BaseClass;

public class Logout extends BaseClass
{

	static String user_dropdown = "//p[@class='oxd-userdropdown-name']";
	static String logout_btn="//a[text()='Logout']";
	
	static String login_Title = "//h5[text()='Login']";

	static By btn_userdropdown = By.xpath(user_dropdown);
	static By btn_logout= By.xpath(logout_btn);
	static By loginPageTitle =By.xpath(login_Title);
	
	public static void logoutPage()
	{
	
		driver.findElement(btn_userdropdown).click();
		driver.findElement(btn_logout).click();
		
		WebElement actualTitleElement = driver.findElement(loginPageTitle);
		String actualTitle = actualTitleElement.getText();  // get the text
		String expectedTitle = "Login";

		Assert.assertEquals(actualTitle, expectedTitle, "Login page title does not match");
	}
	
	

}
