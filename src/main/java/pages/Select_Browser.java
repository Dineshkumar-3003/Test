package pages;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;



public class Select_Browser {

	public WebDriver driver;

	// method to launch application
	@SuppressWarnings("unused")
	public Login BrowserLaunnch(String sBrowser) {
		if (sBrowser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Dineshkumar.M\\Automation\\eclipse\\Driver\\chromedriver.exe");

			// System.setProperty("webdriver.chrome.driver",sBrowsserDriverPath+"chromedriver.exe");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", "true");
			// chromePrefs.put("download.default_directory",
			// "C://Users//mohammadfaheem.s//Downloads//");
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions"); // to disable browser
															// extension pop up

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}

		else if (sBrowser.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver",
					"D:\\Dineshkumar.M\\Automation\\eclipse\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			InternetExplorerOptions Options = new InternetExplorerOptions();
			Options.disableNativeEvents();
			driver.manage().window().maximize();

		} else if (sBrowser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Dineshkumar.M\\Automation\\eclipse\\Driver\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setLogLevel(FirefoxDriverLogLevel.TRACE);
			options.addArguments("--disable-extensions");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		} else {
			System.out.println("browser not found");
		}
		return new Login(driver);

	}


}
