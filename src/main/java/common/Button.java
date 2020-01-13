package common;
import org.openqa.selenium.By;

import common.PageObject;

public class Button extends PageObject {
	
	public Button(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public void click() {
		this.getRuntimeElement().click();
	}

}
