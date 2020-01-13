package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import common.Textbox;
import common.Button;
import common.DriverUtils;
import common.Message;
import common.Form;

public class LoginPage {
	Textbox txtUserName = new Textbox(By.id("username"));
	Textbox txtPassWord = new Textbox(By.id("password"));
	Button btnLogin = new Button(By.xpath("//p[@class='form-actions']//input"));
	Message msErrorLogin = new Message(By.xpath("//p[@class='message error LoginForm']"));
	Form fmLogin = new Form (By.xpath("//form[@class='LoginForm']"));
	
	public void login(String username, String password) throws InterruptedException
	{
		txtUserName.type(username);
		txtPassWord.type(password);
		btnLogin.click();
	}
	
	public void loginScroll(String username, String password) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		txtUserName.type(username);
		txtPassWord.type(password);
		btnLogin.click();
	}
	
	public boolean isFormLoginDisplay(){
		return fmLogin.isDisplay();
	}
	
	public String getErrorMessageLogin()
	{
		return msErrorLogin.getTextMessage();
	}
}