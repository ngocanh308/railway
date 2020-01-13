package com.raiway;

import org.testng.Assert;
import org.testng.annotations.*;

import common.Constant;
import page.HomePage;
import page.LoginPage;

public class TestCase_04_Redirect_After_Login extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();
	
	@Test
	public void TC_04_Redirect_After_Login() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_BOOK_TICKET);
		homePage.isTabDisplay(Constant.TAB_LOGIN);
		if(login.isFormLoginDisplay())
		{
			login.login(Constant.USERNAME, Constant.PASSWORD);
		}
		else
		{
			System.out.println("Form book ticket no display");
			
		}
		Assert.assertTrue(homePage.isTabDisplay(Constant.TAB_BOOK_TICKET));
	}

}
