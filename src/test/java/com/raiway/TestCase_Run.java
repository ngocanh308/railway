package com.raiway;

import org.testng.annotations.*;
import junit.framework.Assert;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import common.Constant;
import common.DriverUtils;
import page.HomePage;
import page.Login;
import page.BookTicket;
import page.Register;
import page.ChangePassword;

public class TestCase_Run {
	HomePage homePage;
	Login login; 
	BookTicket bookTicket;
	Register register;
	ChangePassword changPass;
	
	@BeforeClass
	public void BeforeClass(){
		DriverUtils.setUpDriver();
		DriverUtils.getDriver().get(Constant.RAILWAYURL);
		DriverUtils.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage();
		login = new Login();
		bookTicket = new BookTicket();
		register = new Register();
		changPass = new ChangePassword();
	}
	
	@BeforeMethod
	public void BeforeMethod(){
		homePage.clickTabMenuHomePage(Constant.TAB_LOGOUT);
	}

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException{
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.loginScroll(Constant.USERNAME,Constant.PASSWORD);
		
		Assert.assertEquals(Constant.HOMEURL, DriverUtils.getDriver().getCurrentUrl());
		Assert.assertEquals(Constant.WELCOM_MESSAGE, homePage.getWelcomeMessage());
	}
	
	@Test
	public void TC_02_Login_Blank_User() throws InterruptedException{
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.loginScroll(Constant.USERNAME, "");
		
		Assert.assertEquals(Constant.LOGINURL, DriverUtils.getDriver().getCurrentUrl());
		Assert.assertEquals(Constant.ERROR_BLANK_PASSWORD, login.getErrorMessageLogin());		
	}
	
	@Test
	public void TC_03_Login_Invalid_Pasword() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME, Constant.ARRAY_INVALID_PASSWORD[1]);
		
		Assert.assertEquals(Constant.ERROR_INVALID_PASSWORD, login.getErrorMessageLogin());		
	}
	
	@Test
	public void TC_04_Redirect_After_Login() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_BOOK_TICKET);
		login.isFormLoginDisplay();
		if(login.isFormLoginDisplay())
		{
			login.login(Constant.USERNAME, Constant.PASSWORD);
		}
		else
		{
			System.out.println("Form book ticket no display");
			
		}
		bookTicket.isFormTicketDisplay();
	}
	
	@Test
	public void TC_05_Enter_Wrong_Password_Serveral_Times() throws InterruptedException {
		homePage.isTabDisplay(Constant.TAB_LOGIN);
		homePage.clickTabMenuHomePage(Constant.TAB_LOGOUT);
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		
		int len = Constant.ARRAY_INVALID_PASSWORD.length;
		for(int i=0; i < len; i++)
		{
			login.loginScroll(Constant.USERNAME, Constant.ARRAY_INVALID_PASSWORD[i]);			
		}		
	}
	
	@Test
	public void TC_06_Redirected_After_Logout() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.clickTabMenuHomePage(Constant.TAB_CONTACT);
		homePage.clickTabMenuHomePage(Constant.TAB_LOGOUT);
		Assert.assertEquals(Constant.HOMEURL, DriverUtils.getDriver().getCurrentUrl());
		homePage.doesLogoutExits();		
	}
	
	@Test
	public void TC_07_Create_New_Account() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_REGISTER);
	
		//create random String to join into username
		String usrNameRegister = Constant.USERNAME_REGISTER + randomNum();
		register.registerAccount(usrNameRegister, Constant.USERNAME_REGISTER, Constant.PID);
		Assert.assertEquals(Constant.messageSucessRegister, register.getLblMessageSucessRegister());		
	}
	
	@Test
	public void TC_08_Login_Account_No_Active() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME_REGISTER, Constant.PASSWOD_REGISTER);
		Assert.assertEquals(Constant.ERROR_INVALID_PASSWORD, login.getErrorMessageLogin());
		
	}
	
	@Test
	public void TC_09_Chang_Password() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.clickTabMenuHomePage(Constant.TAB_CHANGE_PASSWORD);
		changPass.changePass(Constant.PASSWORD, Constant.newPassword, Constant.confirmPass);
		
	}
	
	@Test
	public void TC_10_Create_Acount_In_Use_Email() throws InterruptedException {
		if(homePage.doesLogoutExits())
		{
			homePage.clickTabMenuHomePage(Constant.TAB_LOGOUT);
		}
		homePage.clickTabMenuHomePage(Constant.TAB_REGISTER);
		
		register.registerAccount(Constant.USERNAME, Constant.newPassword, Constant.PID);
		Assert.assertEquals(Constant.errorEmailInUse, register.getLblErrorMessage());
	}
	
	@Test
	public void TC_11_Create_Account_With_Blank_Pass_and_Pid() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_REGISTER);
		//create random String to join into username
		String usrNameRegister = Constant.USERNAME_REGISTER + randomNum();
		register.registerAccount(usrNameRegister,"" ,"" );
		Assert.assertEquals(Constant.messageFailsRegister, register.getLblErrorMessage());		
	}
	
	public int randomNum(){
		Random rn = new Random();
		int answer = rn.nextInt(10) + 1;
		return answer;
	}
	
	@AfterClass
	public void AfterClass(){
		DriverUtils.getDriver().quit();
	}
	
}
