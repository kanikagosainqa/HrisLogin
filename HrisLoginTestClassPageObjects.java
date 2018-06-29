import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HrisLoginTestClassPageObjects extends app {
	WebDriver driver;
	app hrisLogin;

	
	@BeforeClass
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver","/home/qainfotech/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		driver.findElement(By.xpath("//*[@id=\"demo-2\"]/div/div[2]/ul/li[1]/a")).click();
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
	
	
	
	@Test(expectedExceptions = NoSuchElementException.class)
	public void login() {
		hrisLogin.loginForm("kanikagosain","Kanika@321#");
		Assert.assertFalse(hrisLogin.isDisplayed());
	}

}