package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		//DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		//caps.setCapability("ignoreZoomSetting", true);

		prop = new Properties();
	//	String filePath = System.getProperty("user.dir")+"/data.properties";
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspace\\E2EMavenProject\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
	//String browserName = System.getProperty("browser");// this line enables the maven command to choose the browser system insted of prop

		System.out.println(browserName);
     // running a test headless means that the browser will not open the test is performed below i am addint this option
		ChromeOptions option = new ChromeOptions();
		
		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\user\\eclipse-workspace\\Driver\\chromedriver.exe");
			if(browserName.contains("headless")) {
			option.addArguments("headless");
			}
			
			driver = new ChromeDriver(option);
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\eclipse-workspace\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("InternetExplorer")) {

			System.setProperty("webdriver.ie.driver", "C:\\Users\\user\\eclipse-workspace\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {

		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File src = ts.getScreenshotAs(OutputType.FILE);
	    File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;

	}


}