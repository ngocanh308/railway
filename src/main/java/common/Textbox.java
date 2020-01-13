package common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.PageObject;

public class Textbox extends PageObject{
	
	public Textbox(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public void type(String content) throws InterruptedException {
		this.getRuntimeElement().sendKeys(content);
	}
	public void click() {
		this.getRuntimeElement().click();
	}

}
