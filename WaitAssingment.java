package June26AlertAssign;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
/*
Assignment 3: Dynamic loading	
First scenario
1. http://the-internet.herokuapp.com/dynamic_loading/1
2. Use implicit Wait - 3 sec
3. Click on start button and verify Hello World!

Second scenario
1. http://the-internet.herokuapp.com/dynamic_loading/1
2. Use implicit Wait - 15 sec
3. Click on start button and verify Hello World!

Third scenario
1. http://the-internet.herokuapp.com/dynamic_loading/1
2. No implicit Wait, No Explicit Wait
3. Click on start button and verify Hello World!

Fourth scenario
1. http://the-internet.herokuapp.com/dynamic_loading/1
2. Use Explicit Wait for 10 seconds
3. Click on start button and verify Hello World!

Repeat all the above 4 scenario for the following link:
http://the-internet.herokuapp.com/dynamic_loading/2

*/
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

public class WaitAssingment {

	WebDriver driver;

	@Test
	public void checkimplicitwait() {
		driver.get(" http://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.id("start")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement start1 = driver.findElement(By.xpath("//button[text()='Start']"));
		System.out.println(start1.getText());
		start1.click();
		WebElement finish = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		String actualop = finish.getText();
		String expectop = "Hello World!";
		assertEquals(actualop, expectop);

	}

	//@Test
	public void implicitwaiturl1() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		// Thread.sleep(6000);//Hard wait
		String expectedOutput = "Hello World!";
		WebElement finish = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		String actualOutput = finish.getText();
		assertEquals(actualOutput, expectedOutput, "Verification failed.");
	}

	WebDriverWait wait;

//	@Test
	public void checkExplicitwait() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(250));
		WebElement finish1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		String actualop1 = finish1.getText();
		String expectedop1 = "Hello World!";
		assertEquals(actualop1, expectedop1, "element was not visible");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Levono\\eclipse-workspace\\april22seleniumtraining\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
