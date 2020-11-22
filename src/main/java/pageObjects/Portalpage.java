package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Portalpage  {

	public  WebDriver driver;
	
	public Portalpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By searchcourse = By.name("query");
	
	
	public WebElement getSearch() {
		return driver.findElement(searchcourse);
	}
	
}
