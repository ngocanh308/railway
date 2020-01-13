package com.raiway;

import org.testng.annotations.*;
import junit.framework.Assert;

import common.Constant;
import page.HomePage;
import page.LoginPage;

public class TestCase_08_Login_Account_No_Active extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();
	
	@Test
	public void TC_08_Login_Account_No_Active() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME_REGISTER, Constant.PASSWOD_REGISTER);
		Assert.assertEquals(Constant.ERROR_INVALID_PASSWORD, login.getErrorMessageLogin());
		
	}

}
