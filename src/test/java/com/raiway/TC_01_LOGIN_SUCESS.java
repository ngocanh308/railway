package com.raiway;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.Constant;
import common.DriverUtils;
import junit.framework.Assert;
import page.BookTicket;
import page.ChangePassword;
import page.HomePage;
import page.Login;
import page.Register;

public class TC_01_LOGIN_SUCESS {
	HomePage homePage;
	Login login; 
	BookTicket bookTicket;
	Register register;
	ChangePassword changPass;
	
	@BeforeClass
	public void BeforeTest(){
		DriverUtils.setUpDriver();
		DriverUtils.getDriver().get(Constant.RAILWAYURL);
		DriverUtils.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage();
		login = new Login();
		bookTicket = new BookTicket();
		register = new Register();
		changPass = new ChangePassword();
	}

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException{
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.loginScroll(Constant.USERNAME,Constant.PASSWORD);
		
		Assert.assertEquals(Constant.HOMEURL, DriverUtils.getDriver().getCurrentUrl());
		Assert.assertEquals(Constant.WELCOM_MESSAGE, homePage.getWelcomeMessage());
		
		homePage.clickTabMenuHomePage(Constant.TAB_LOGOUT);
	}
}
