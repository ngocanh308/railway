package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.DriverUtils;
import common.Form;
import common.ListBox;
import org.openqa.selenium.support.ui.Select;
import common.DriverUtils;

public class BookTicketPage {

	//locator
	Form frTicket = new Form(By.xpath("//span[contains(text(),'Book ticket')]"));
	ListBox lbDate = new ListBox(By.xpath("//select[@name='Date']")); 
	ListBox lbFrom = new ListBox(By.xpath("//select[@name='DepartStation']"));
	ListBox lbArrive = new ListBox(By.xpath("//select[@name='ArriveStation']"));
	ListBox lbSeatType = new ListBox(By.xpath("//select[@name='ArriveStation']"));
	ListBox lbSmount = new ListBox(By.xpath("//select[@name='TicketAmount']"));
	String listSelect = "//select[@name='%s']";
	
	//Method
	public boolean isFormTicketDisplay(){
		return frTicket.isDisplay();
	}
	
	//public void bookTicket(int dpDate, String dpFrom, String arr, String typeSeat, int amount) {
		public void bookTicket(String dpDate, String dpFrom, String arr, String seat, String smount) {
		lbDate.selectVisibleText(dpDate);
		lbFrom.selectVisibleText(dpFrom);
		
	}
	public void selectType(String name, String value)
	{
		//Select listSelect = new Select(DriverUtils.getDriver().findElementBy.xpath(String.format(listSelect,name)));
		Select list = new Select(DriverUtils.getDriver().findElement(By.xpath(String.format(listSelect, name))));
		list.selectByVisibleText(value);
	}

}
