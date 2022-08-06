package June26AlertAssign;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitAssingment2 {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void implicitwaiturl2() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		String expectedOutput2 = "Hello World!";
		WebElement finish2 = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		System.out.println("finish->> " + finish2.getText());
		String actualOutput2 = finish2.getText();
		assertEquals(actualOutput2, expectedOutput2, "Verification failed.");

	}

	@Test
	public void explicitwaiturl2() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(250));
		WebElement finish2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		String actualop2 = finish2.getText();
		String expectedop2 = "Hello World!";
		assertEquals(actualop2, expectedop2, "Hello world! was not visible");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Levono\\eclipse-workspace\\april22seleniumtraining\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
