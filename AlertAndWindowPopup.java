package June26AlertAssign;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertAndWindowPopup {

	WebDriver driver;
	  @Test
	  public void handleAlertandswitchWindows() throws InterruptedException {
		
		  driver.get("https://nichethyself.com/tourism/home.html");
			String parentwindow = driver.getWindowHandle();
			WebElement custom = driver.findElement(By.xpath("//a[@href='customised.html']"));
			custom.click();
			Set<String> getAllOpenWindowHandles = driver.getWindowHandles();
			System.out.println("No. of open windows " + getAllOpenWindowHandles.size());

			for (String window : getAllOpenWindowHandles) {
				if (!window.equals(parentwindow)) {
					try {
						driver.switchTo().window(window);
					} catch (NoSuchWindowException e) {
						fail("customized tour window did not exist");
					}

				}
			}
			/*
			 * String customwindow = driver.getWindowHandle();
			 * driver.switchTo().window(customwindow);
			 * System.out.println(customwindow);
			 */
			/*
			 * Actions action = new Actions(driver); //Switch to Second Tab
			 * action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
			 */
			// WebElement stay =driver.findElement(By.id("days"));
			try {
				WebElement stay1 = driver.findElement(By.xpath("//select[@id='days']"));
				System.out.println(stay1);
				Select stayOptions = new Select(stay1);
				Thread.sleep(4000);
				stayOptions.selectByVisibleText("Home Stay");

				List<WebElement> allStayOptions = stayOptions.getOptions();

				for (WebElement oneOption : allStayOptions) {
					System.out.println(oneOption.getText());

				}
			} catch (NoSuchElementException e) {
				fail("Stay drop down not visible");
			}

			driver.findElement(By.xpath("//label[text()='England']/input")).click();

			driver.findElement(By.xpath("//button[text()='Contact us!']")).click();

			// onclick="window.open("contact.html","Contact","width=500,height=500");"
			// which window | name of the window | size od the window

			try {
				driver.switchTo().window("Contact");
				Thread.sleep(4000);
				driver.findElement(By.className("glyphicon-search")).click();
			} catch (NoSuchWindowException e) {
				fail("contact us window was not displayed");
			}

			try {
				Alert location = driver.switchTo().alert();
				location.sendKeys("London");
				location.accept();
			} catch (NoAlertPresentException e) {
				fail("The Location Alert was not displayed");
			}

			// driver.switchTo().window(parentwindow);
			


		
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Levono\\eclipse-workspace\\april22seleniumtraining\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }


}
