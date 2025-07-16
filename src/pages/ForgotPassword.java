package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utility.BaseClass;

public class ForgotPassword extends BaseClass
{
	static String forgot ="//p[text()='Forgot your password? ']";
	static String title_forgotpwd ="//h6[text()='Reset Password']";
	
	static By link_forgotpwd= By.xpath(forgot);
	static By title_forgotPwdPage= By.xpath(title_forgotpwd);
	
	public static void verifyForgotPageMsg()
	{
		driver.findElement(link_forgotpwd).click();
		WebElement txt_page = driver.findElement(title_forgotPwdPage);
		Assert.assertTrue(txt_page.isDisplayed(), "Reset Password Page is not displayed ");
		System.out.println("Reset Password Text Display: " + txt_page.getText());
	    System.out.println("Forgot Password page verified successfully");
	}
}
