package WeathAcademy.E2EMavenProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	public  WebDriver driver;// best practice to declare your own driver in the class to prevent tests from braking when in parallel mode
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void getUrl() throws IOException {
		driver =	initializeDriver();
		
		 
		
	}
	

	@Test(dataProvider="getData")
	public void BasepageNavigation(String email, String Password) throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("URL"));
	
	LandingPage landpage = new LandingPage(driver);
	
	landpage.login().click();
	log.debug("I am the debugger logger");

	LoginPage loginpage = new LoginPage(driver);
	loginpage.getEmail().sendKeys(email);
	loginpage.getPassword().sendKeys(Password);
	
	loginpage.HitLoginbutton().click();
      log.fatal("I am the Fatal Logger");

	}

	
	
	@DataProvider
	public Object[][] getData(){
		 // the index starts at zero to insert data
		// but for the number of parameters and the number of execution starts at 1
		
		Object[][] data = new Object[2][2]; // here it starts at one first [] is how me times it should execute second [] how mani paramiters to use
		
		data[0][0]= "mikekulio@gmail.com";
		data[0][1]= "Verite#2";
		
		data[1][0]="mikekulio@gmail.com";
		data[1][1]="Grouth32";
			
		
		return data;
					
		
	}
	
	@AfterTest
	public void closeTest() {
		
		driver.close();
	}
}


