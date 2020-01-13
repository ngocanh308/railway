package com.raiway;

import org.testng.annotations.*;
import junit.framework.Assert;

import common.Constant;
import page.HomePage;
import page.RegisterPage;

public class TestCase_10_Create_Acount_In_Use_Email extends TestHelper {
	HomePage homePage = new HomePage();
	RegisterPage register = new RegisterPage();
	
	@Test
	public void TC_10_Create_Acount_In_Use_Email() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_REGISTER);
		register.registerAccount(Constant.USERNAME, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD, Constant.PID);
		Assert.assertEquals(Constant.ERROR_EMAIL_IN_USE, register.getErrorMessage());
	}

}
