package tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows_Handling {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Dineshkumar.M\\Automation\\eclipse\\Driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.automationtesting.in/Windows.html");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		
		String Parent_window = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[@id = 'Multiple']//child::button")).click();
		
		Set<String> AllWindows = driver.getWindowHandles();
		for (String Window : AllWindows) {

			
			driver.switchTo().window(Window);

			System.out.println(driver.getTitle());

			if (driver.getTitle().equalsIgnoreCase("index")) {
				driver.findElement(By.id("btn1")).click();
				driver.close();

			} else if (driver.getTitle().equalsIgnoreCase("Sakinalium | Home")) {

				driver.findElement(By.xpath("//*[@id='container']/header/div/div/div[2]/ul/li[3]/a")).click();
				driver.close();

			}
		}

		driver.switchTo().window(Parent_window);
	}

}
