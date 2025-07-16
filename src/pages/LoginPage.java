package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utility.BaseClass;

public class LoginPage extends BaseClass
{
	static String user_name = "//input[@placeholder='Username']";
	static String user_pwd = "//input[@placeholder='Password']";
	static String LoginBtn = "//button[@type='submit']";
	static String title ="//h6[text()='Dashboard']";
	static String user_dropdown = "//p[@class='oxd-userdropdown-name']";
	static String error ="//p[text()='Invalid credentials']";
	
	static By txt_username= By.xpath(user_name);
	static By txt_userPassword = By.xpath(user_pwd);
	static By btn_Login = By.xpath(LoginBtn);
	static By after_login = By.xpath(title);
	static By errorMsg =By.xpath(error);
	
	
	public static void loginOrangepage(String username, String password)
	{
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_userPassword).sendKeys(password);
		driver.findElement(btn_Login).click();
		
		WebElement actualTitleElement = driver.findElement(after_login);
	    String actualTitle = actualTitleElement.getText();
	    String expectedTitle = "Dashboard";
		
//		SoftAssert softassert = new SoftAssert();
//		softassert.assertEquals(Actual_title, Expected_title, "Login failed or Dashboard text mismatch");
//		System.out.println("The page is found");
//		softassert.assertAll();
		
		Assert.assertEquals(actualTitle, expectedTitle, "Login failed or Dashboard text mismatch");
		
	}
	
	// Method to test invalid login
	public static void verifyInvalidCredentialsOnLoginPage(String username, String password) {
	    driver.findElement(txt_username).clear();
	    driver.findElement(txt_userPassword).clear();

	    driver.findElement(txt_username).sendKeys(username);
	    driver.findElement(txt_userPassword).sendKeys(password);
	    driver.findElement(btn_Login).click();

	    WebElement error = driver.findElement(errorMsg);
	    Assert.assertTrue(error.isDisplayed(), "Error message not displayed for invalid login");
	    System.out.println("Invalid login test passed: " + error.getText());
	}
}
