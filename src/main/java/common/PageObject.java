package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	
	private WebElement runtimeElement;
	private By locator;
	public PageObject(By locator) {
          this.locator = locator;
    }
	public WebElement getRuntimeElement() {
		waitToElementVisible(this.locator);
		this.runtimeElement = DriverUtils.getDriver().findElement(this.locator);
		return this.runtimeElement;
	}
	
	public boolean isDisplay() {
		return this.getRuntimeElement().isDisplayed();
	}

	public void waitToElementVisible(By locator) {
		WebDriverWait waitExplicit = new WebDriverWait(DriverUtils.getDriver(), 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void scrollVertical() {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
	}

}
