package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	// pageObjects implementation here

	public static WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	//having no access modifies also keeps it private
	private By signIn = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
	private By featuredText = By.cssSelector("div[class='text-center'] h2");
	private By Navbar = By.cssSelector(".nav.navbar-nav.navbar-right li");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	
	
	public WebElement login() {

		return driver.findElement(signIn);
	}

	public WebElement getFeaturedText() {

		return driver.findElement(featuredText);
	}
	
	public int getPopUpSize() {

		return driver.findElements(popup).size();
	}
	
	public WebElement clickPopUp() {

		return driver.findElement(popup);
	}

	public List<WebElement> getNavigationBar() {

		return driver.findElements(Navbar);
	}
}