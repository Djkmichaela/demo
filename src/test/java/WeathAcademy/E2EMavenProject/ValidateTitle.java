package WeathAcademy.E2EMavenProject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base { 


	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	public  WebDriver driver;
	@BeforeTest
	public void Initialize() throws IOException {
		
	driver =	initializeDriver();
	log.info("Driver Initialized");
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to home page");
	}
	
	@Test
	public void TextValidation(){ 
		LandingPage landpage = new LandingPage(driver);
		
		assertEquals(landpage.getFeaturedText().getText(), "FEATURED COURES");
		System.out.println(landpage.getFeaturedText().getText());
		log.info("Text successfully displayed");
		
	
	}
	
	@AfterTest
	public void TearDown() {
		
		driver.close();
	}

}
