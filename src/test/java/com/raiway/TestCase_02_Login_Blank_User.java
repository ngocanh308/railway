package com.raiway;

import org.testng.annotations.*;
import junit.framework.Assert;

import common.Constant;
import common.DriverUtils;
import page.HomePage;
import page.LoginPage;

public class TestCase_02_Login_Blank_User extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();
	
	@Test
	public void TC_02_Login_Blank_User() throws InterruptedException{
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.loginScroll(Constant.USERNAME, "");
		
		Assert.assertEquals(Constant.LOGINURL, DriverUtils.getDriver().getCurrentUrl());
		Assert.assertEquals(Constant.ERROR_BLANK_PASSWORD, login.getErrorMessageLogin());		
	}
}
