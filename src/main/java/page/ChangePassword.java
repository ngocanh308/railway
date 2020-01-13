package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import common.DriverUtils;

public class ChangePassword {
	private final By currentPass = By.xpath("//input[@id='currentPassword']");
	private final By newPass = By.xpath("//input[@id='newPassword']");
	private final By confirmPass = By.xpath("//input[@id='confirmPassword']");
	private final By btnChangePass = By.xpath("//p[@class='form-actions']//input");
	
	private WebElement getCurrentPass(){
		return DriverUtils.getDriver().findElement(currentPass);
	}
	
	private WebElement getNewPass(){
		return DriverUtils.getDriver().findElement(newPass);
	}
	
	private WebElement getConfirmPass(){
		return DriverUtils.getDriver().findElement(confirmPass);
	}
	
	private WebElement getBtnChangePass(){
		return DriverUtils.getDriver().findElement(btnChangePass);
	}
	
	public void changePass(String curPass, String newPass, String confirmPass)
	{
		this.getCurrentPass().sendKeys(curPass);
		this.getNewPass().sendKeys(newPass);
		this.getConfirmPass().sendKeys(confirmPass);
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		this.getBtnChangePass().click();
		
	}

}
