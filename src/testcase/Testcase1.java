package testcase;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.ForgotPassword;
import pages.LoginPage;
import pages.Logout;
import utility.BaseClass;

public class Testcase1 
{
	@DataProvider
	public Object[][] validLoginData()
	{
		return new Object[][] {{"Admin", "admin123"}};
	}
	
	@DataProvider
	public Object[][] invalidLoginData()
	{
		return new Object[][] {{"Admin", "admin1234"}};
	}
	
	@DataProvider
	public Object[][] searchAdminData()
	{
		return new Object[][] {{"prasad prasad", "Admin", "sasa asa ff", "Enabled"}};
	}
	
	@Test(dataProvider ="validLoginData", priority=-1, enabled=false)
	public static void testcase1(String username, String password) throws AWTException, InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		BaseClass.openBrowserApp();
		LoginPage.loginOrangepage(username, password);
		BaseClass.closeBrowserApp();
	} 
	
	@Test(dataProvider ="validLoginData", priority=0, enabled=false)
	public static void logoutPage(String username, String password)
	{
		BaseClass.openBrowserApp();
		LoginPage.loginOrangepage(username, password);
		Logout.logoutPage();
		BaseClass.closeBrowserApp();
	}
	
	@Test(dataProvider ="invalidLoginData", priority=1, enabled=false)
	public static void verifyInvalidCredentialsOnLoginPage(String username, String password) throws AWTException, InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		BaseClass.openBrowserApp();
		LoginPage.verifyInvalidCredentialsOnLoginPage(username, password);
		BaseClass.closeBrowserApp();
	} 
	
	@Test(priority=2, enabled=false)
	public static void verifyForgotPageMsg()
	{
		BaseClass.openBrowserApp();
		ForgotPassword.verifyForgotPageMsg();
		BaseClass.closeBrowserApp();
	}
	
	@Test(dataProvider = "validLoginData"  ,priority=3)
	public static void verifyAdminPageContent(String username, String password) throws AWTException, InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		BaseClass.openBrowserApp();
		LoginPage.loginOrangepage(username, password);
		AdminPage.verifyAdminPageContent();
		
	} 

	@Test(dataProvider="searchAdminData", priority=4)
	public static void searchAdminData(String us, String us_role, String emp_name , String status )
	{
		AdminPage.searchSystemUser(us, us_role, emp_name, status);
		//BaseClass.closeBrowserApp();
	}
}
