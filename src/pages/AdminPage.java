package pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utility.BaseClass;

public class AdminPage extends BaseClass
{
	static String admin ="//span[text()='Admin']";
	static String adminPage="//h5[text()='System Users']";
	
	static String username ="//label[text()='Username']/following::input[1]";
	static String user_role ="//label[text()='User Role']/following::div[contains(@class, 'oxd-select-text')][1]";
	static String select_user ="(//div[text()='Admin'])[1]";
	static String txt_empName="//input[@placeholder='Type for hints...']";
	static String dropDown_status ="//label[text()='Status']/following::div[contains(@class, 'oxd-select-text')][1]";
	static String input_status = "(//div[text()='Enabled'])[1]";
	
	static String btn_search="//button[text()=' Search ']";
	
	static By txt_admin = By.xpath(admin);
	static By adminPagecontent =By.xpath(adminPage);
	
	static By txt_username =By.xpath(username);
	static By dropdown_admin =By.xpath(user_role);
	static By txt_select_user = By.xpath(select_user);
	static By  txt_empNameField = By.xpath(txt_empName);
	static By select_dropDownStatus = By.xpath(dropDown_status);
	static By input_statusSelect = By.xpath(input_status);
	static By btn_searchclk = By.xpath(btn_search);
	
	public static void verifyAdminPageContent()
	{
		driver.findElement(txt_admin).click();
		WebElement adminPageTxt = driver.findElement(adminPagecontent);
		Assert.assertTrue(adminPageTxt.isDisplayed(), "System User text is not Displayed");
		 System.out.println("System User text displayed: " + adminPageTxt.getText());
		
	}
	
	public static void searchSystemUser(String us, String us_role, String emp_name , String status)
	{
		driver.findElement(txt_username).sendKeys(us);

	    driver.findElement(dropdown_admin).click();
	    WebElement userRoleOption = driver.findElement(txt_select_user);
	    Actions act = new Actions(driver);
	    act.moveToElement(userRoleOption).click().build().perform();

	    driver.findElement(txt_empNameField).sendKeys(emp_name);

	    driver.findElement(select_dropDownStatus).click();
	    WebElement statusOption = driver.findElement(input_statusSelect);
	    act.moveToElement(statusOption).click().build().perform();
		
	    driver.findElement(btn_searchclk).click();

	}
}
