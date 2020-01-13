package com.raiway;

import org.testng.annotations.Test;

import common.Constant;
import common.DriverUtils;
import junit.framework.Assert;
import page.HomePage;
import page.LoginPage;

public class TestCase_01_Login_Sucess extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException{
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.loginScroll(Constant.USERNAME, Constant.PASSWORD);
		
		Assert.assertEquals(Constant.HOMEURL, DriverUtils.getDriver().getCurrentUrl());
		Assert.assertEquals(Constant.WELCOM_MESSAGE, homePage.getWelcomeMessage());
	}
}
