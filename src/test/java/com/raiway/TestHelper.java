package com.raiway;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.Constant;
import common.DriverUtils;

public class TestHelper {

	@BeforeClass
	public void BeforeClass(){
		DriverUtils.setUpDriver();
		DriverUtils.getDriver().get(Constant.RAILWAYURL);
		DriverUtils.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void afterClass() {
		DriverUtils.getDriver().quit();
	}
	
	public int randomNum(){
		Random r = new Random();
		return r.nextInt(100000) + 1;
	}

}
