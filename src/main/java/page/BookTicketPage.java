package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.DriverUtils;

public class BookTicketPage {

	//locator
	private final By formTicket = By.xpath("//span[contains(text(),'Book ticket')]");	
	//element
	protected WebElement getlblFormTicket(){
		return DriverUtils.getDriver().findElement(formTicket);
	}	
	//Method
	public boolean isFormTicketDisplay(){
		return this.getlblFormTicket().isDisplayed();
	}
	
	

}
