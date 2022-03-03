package training.handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class NavigateToGoogle {
	
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private WebDriverWait wait;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(@Optional ("chrome") String browser) {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser(browser);
		driver.get("https://www.google.co.in/");
	}

	@Test
	public void navigateToGooglTest_Parallel_CrossBrowser() throws InterruptedException {
		Reporter.log("Running the test");
		System.out.println("Running the test");
		wait = new WebDriverWait(driver, 120);
		By byLocale = By.cssSelector("div.uU7dJb");
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocale));
		WebElement oLocale = driver.findElement(byLocale);
		String locale = oLocale.getText();
		Reporter.log("Asserting the locale");
		System.out.println("Asserting");
		Assert.assertEquals(locale, "India");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}