package StepDefinitions;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.Portalpage;
import resources.Base;

import static org.testng.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {


@Given("^Initialize the browser with chrome$")
public void initialize_the_browser_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver = initializeDriver();
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   driver.get(arg1);
}

@Given("^Click on login link in home page to land on Secure sign in page$")
public void click_on_login_link_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
LandingPage landpage = new LandingPage(driver);
	
	landpage.login().click();
}



@When("^User enters (.+) and (.+) and logs in$")
public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.getEmail().sendKeys(username);
	loginpage.getPassword().sendKeys(password);	
	loginpage.HitLoginbutton().click();
}

@And("^close browser$")
public void close_browser() throws Throwable {
	LandingPage landpage = new LandingPage(driver);
	if(landpage.getPopUpSize()>0)
		landpage.clickPopUp().click();
   driver.close();
}
}