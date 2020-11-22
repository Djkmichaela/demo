package WeathAcademy.E2EMavenProject;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class NavigateBar extends Base{ 
	

	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	public  WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
        
		driver.get(prop.getProperty("URL")); 

	}

	@Test
	public void navBar() {
		LandingPage landpage = new LandingPage(driver);

	List<String> NavigationTexts = landpage.getNavigationBar().stream().map(x -> x.getText()).collect(Collectors.toList());
		
	for(String navText : NavigationTexts)	
		System.out.println(navText);
	
	System.out.println(landpage.getNavigationBar().size());
	Assert.assertEquals(8, landpage.getNavigationBar().size());
	}
	
	
	@AfterTest
	public void TearDown() {
		
		driver.close();
	}

}
