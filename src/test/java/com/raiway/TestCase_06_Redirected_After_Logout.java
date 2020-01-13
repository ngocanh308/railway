package com.raiway;

import org.testng.annotations.*;
import junit.framework.Assert;

import common.Constant;
import common.DriverUtils;
import page.HomePage;
import page.LoginPage;

public class TestCase_06_Redirected_After_Logout extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();
	
	@Test
	public void TC_06_Redirected_After_Logout() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.clickTabMenuHomePage(Constant.TAB_CONTACT);
		homePage.clickTabMenuHomePage(Constant.TAB_LOGOUT);
		Assert.assertEquals(Constant.HOMEURL, DriverUtils.getDriver().getCurrentUrl());
		homePage.doesLogoutExits();		
	}

}
