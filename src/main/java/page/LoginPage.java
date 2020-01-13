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
//	//Locator
//	private final By formLogin = By.xpath("//form[@class='LoginForm']");
//	private final By userName = By.id("username");
//	private final By passWord = By.id("password");
//	private final By btnLogin = By.xpath("//p[@class='form-actions']//input");
//	private final By errorMessageLogin = By.xpath("//p[@class='message error LoginForm']");
//	
//	//Element
//	private WebElement getFormLogin(){
//		return driver.findElement(formLogin);
//	}
//	private WebElement getTxtUserName(){
//		return driver.findElement(userName);
//	}
//	private WebElement getTxtPassWord(){
//		return driver.findElement(passWord);
//	}
//	private WebElement getBtnLogin(){
//		return driver.findElement(btnLogin);
//	}
//	private WebElement getlblErrorMessageLogin(){
//		return driver.findElement(errorMessageLogin);
//	}
//	
//	public boolean isFormLoginDisplay(){
//		return this.getFormLogin().isDisplayed();
//	}
//	
//	public void login(String name, String pass) 
//	{
//		this.getTxtUserName().clear();
//		this.getTxtUserName().sendKeys(name);
//		this.getTxtPassWord().clear();
//		this.getTxtPassWord().sendKeys(pass);
//		this.getBtnLogin().click();		
//	}
//	
//	public void loginScroll(String name, String pass) 
//	{
//		this.getTxtUserName().clear();
//		this.getTxtUserName().sendKeys(name);
//		this.getTxtPassWord().clear();
//		this.getTxtPassWord().sendKeys(pass);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1000)");
//		this.getBtnLogin().click();		
//	}
//	
//	public String getErrorMessageLogin()
//	{
//		return this.getlblErrorMessageLogin().getText();
//	}
//	
//	public void clickBtnLogin(){
//		this.getBtnLogin().click();
//	}
	
}
