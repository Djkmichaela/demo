package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
// always run from this class or els you will get an error
// make sure you edit System getproperty to prop.getProperty for it to work in the base class line no 35 and 36
//@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "src/test/java/feature",// point to the path of tht feature file since its one file pointing package is fine
		glue="StepDefinitions")// points to the definition file

public class TestRunner extends AbstractTestNGCucumberTests {  // extent the AbstractTestNGCucumberTests class to run TestNG and comment
																////@RunWith(Cucumber.class) also addt the jar cucumber testNG in the pom
}
