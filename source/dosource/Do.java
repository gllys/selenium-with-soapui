package dosource;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import readproperties.parseproperties;
import waitsource.wait;;

public class Do {

	private WebDriver driver;
	private parseproperties locator = new parseproperties(System.getProperty("user.dir")+"tools\\locators.properties"); 
	private wait waiter;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public parseproperties getLocator() {
		return locator;
	}

	public void setLocator(parseproperties locator) {
		this.locator = locator;
	}

	public wait getWaiter() {
		return waiter;
	}

	public void setWaiter(wait waiter) {
		this.waiter = waiter;
	}

	public Do(WebDriver driver){
		this.driver = driver;	
		waiter = new wait(driver);
	}
	
	public WebElement what(String locatorname){
		return driver.findElement(By.xpath(locator.getValue(locatorname)));
	}
	
	public List<WebElement> whats(String locatorname){
		return driver.findElements(By.xpath(locator.getValue(locatorname)));
	}
	
	public void waitForElementPresent(String locatorname){
		waiter.waitForElementPresent(locator.getValue(locatorname));
	}
	
	public void waitForElementIsEnable(String locatorname){
		waiter.waitForElementIsEnable(locator.getValue(locatorname));
	}
	

	
	public void waitFor(long timeout){
		waiter.waitFor(timeout);
	}

}