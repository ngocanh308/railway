package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.DriverUtils;
import common.Form;

public class BookTicketPage {

	//locator
	Form frTicket = new Form(By.xpath("//span[contains(text(),'Book ticket')]"));
	
	//Method
	public boolean isFormTicketDisplay(){
		return frTicket.isDisplay();
	}
	
	

}
