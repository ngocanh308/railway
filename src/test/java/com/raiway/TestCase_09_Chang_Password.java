package com.raiway;

import org.testng.annotations.*;

import common.Constant;
import page.HomePage;
import page.LoginPage;
import page.ChangePasswordPage;

public class TestCase_09_Chang_Password extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();
	ChangePasswordPage changePass = new ChangePasswordPage();
	
	@Test
	public void TC_09_Chang_Password() throws InterruptedException {
		
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.clickTabMenuHomePage(Constant.TAB_CHANGE_PASSWORD);
		changePass.changePass(Constant.PASSWORD, Constant.NEW_PASSWORD, Constant.CONFIRM_PASSWORD);
		
	}

}
