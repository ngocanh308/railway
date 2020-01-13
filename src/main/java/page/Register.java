package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import common.DriverUtils;

public class Register {	
	private final By email = By.id("email"); 
	private final By pass = By.xpath("//input[@id='password']"); 
	private final By confirmPass = By.xpath("//input[@id='confirmPassword']");
	private final By pid = By.id("pid");
	private final By btnRegister = By.xpath("//p[@class='form-actions']//input");
	private final By messageSucessRegister = By.xpath("//h1[contains(text(),'Thank you for registering your account')]");
	private final By errorMessage = By.xpath("//p[@class='message error']");
	
	private WebElement getEmail(){
		return DriverUtils.getDriver().findElement(email);
	}	
	
	private WebElement getPass(){
		return DriverUtils.getDriver().findElement(pass);
	}
	
	private WebElement getConfirmPass(){
		return DriverUtils.getDriver().findElement(confirmPass);
	}
	
	private WebElement getPid(){
		return DriverUtils.getDriver().findElement(pid);
	}
	
	private WebElement getBtnRegister(){
		return DriverUtils.getDriver().findElement(btnRegister);
	}
	
	private WebElement getMessageSucessRegister(){
		return DriverUtils.getDriver().findElement(messageSucessRegister);
	}
	
	private WebElement getErrorMessage(){
		return DriverUtils.getDriver().findElement(errorMessage);
	}
	
	public String getLblMessageSucessRegister(){
		return this.getMessageSucessRegister().getText();
	}
	
	public String getLblErrorMessage(){
		return this.getErrorMessage().getText();
	}
	
	public void registerAccount(String email, String pass, String pid){
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
		this.getPass().clear();
		this.getPass().sendKeys(pass);
		this.getPass().clear();
		this.getPass().sendKeys(pass);
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		this.getConfirmPass().clear();
		this.getConfirmPass().sendKeys(pass);
		this.getPid().sendKeys(pid);
		this.getBtnRegister().click();
	}
}
