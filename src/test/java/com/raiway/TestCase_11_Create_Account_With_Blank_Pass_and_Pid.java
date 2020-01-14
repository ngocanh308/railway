package com.raiway;

import org.testng.annotations.*;
import junit.framework.Assert;

import common.Constant;
import page.HomePage;
import page.RegisterPage;

public class TestCase_11_Create_Account_With_Blank_Pass_and_Pid extends TestHelper {
	HomePage homePage = new HomePage();
	RegisterPage register = new RegisterPage();
	
	@Test
	public void TC_11_Create_Account_With_Blank_Pass_and_Pid() throws InterruptedException {
		
		homePage.clickTabMenuHomePage(Constant.TAB_REGISTER);		
		//create random String to join into username
		String userNameRegister = Constant.USERNAME_REGISTER + randomNum();
		register.registerAccount(userNameRegister, "", "", "");
		
		Assert.assertEquals(Constant.ERROR_MESSAGE_REGISTER, register.getErrorMessage());		
	}

}
