package com.raiway;

import org.testng.annotations.*;
import junit.framework.Assert;

import common.Constant;
import page.HomePage;
import page.RegisterPage;

public class TestCase_07_Create_New_Account extends TestHelper {
	HomePage homePage = new HomePage();
	RegisterPage register = new RegisterPage();
	
	@Test
	public void TC_07_Create_New_Account() throws InterruptedException {
		
		homePage.clickTabMenuHomePage(Constant.TAB_REGISTER);	
		//create random String to join into username
		String usrNameRegister = Constant.USERNAME_REGISTER + randomNum();
		register.registerAccount(usrNameRegister, Constant.PASSWOD_REGISTER,Constant.PASSWOD_REGISTER, Constant.PID);
		
		Assert.assertEquals(Constant.MESSAGE_REGISTER_SUCESS, register.getMessageSucess());		
	}

}
