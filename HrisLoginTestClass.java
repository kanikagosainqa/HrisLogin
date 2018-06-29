package Hris.HrisLoginUsingJavascriptExecutor;

import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.SucceededChannelFuture;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class HrisLoginTestClass extends HrisLoginMainCLass{
	
	WebDriver driver;
	HrisLoginMainCLass hrisLogin;
		
	public void HrisLoginTest(WebDriver driver) {
		this.driver = driver;
		}
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://hris.qainfotech.com/login.php");
		driver.findElement(By.xpath("//*[@id=\"demo-2\"]/div/div[2]/ul/li[1]/a")).click();
		//hrisLogin=new HrisLoginMainCLass();
		}

	@AfterClass
	public void afterClass() {
		driver.quit();
		}
	  
	  //tc2- when user name field is blank, user name filed's border turns red
	  @Test(priority=1)
	  public void blankUsernameField() {
		  Assert.assertTrue( hrisLogin.blankUsername().contains("red"));
	  }

	  //tc3 - when password field is blank, the password Field's border turns red
	  @Test(priority=3)
	  public void blanckPasswordField() {
		  Assert.assertTrue(hrisLogin.blankPassword().contains("red"));
	  }
	   
	  //tc4 - when user name is incorrect, error message appears
	  @Test(priority=4)
	  public void incorrectUserName() {
		  hrisLogin.incorrectUsername();
		  Assert.assertTrue(driver.findElement(By.cssSelector
				  ("#login > form > div.loginTxt.txtHideDiv.alert.alert-error > div"))
				  .getText().contains("Invalid Login")); 
	  }
	  
	  //tc5 - when password is incorrect, error message appears
	  @Test(priority=5)
	  public void incorrectPassword() {
		  Assert.assertTrue(hrisLogin.incorrectPwd().contains("Invalid Login"));
	  }

	  //tc6 - remember me
	  @Test(priority=6)
	  public void rememberMe() {
		  hrisLogin.remember();
		  Assert.assertEquals("https://hris.qainfotech.com:8086/empFeedback/yourFeedback", driver.getCurrentUrl());
	  } 
	  
	  //tc7 - successful login
	  @Test//(priority=7)
	  public void successfulLogin() {
		  login();
		  Assert.assertEquals("https://hris.qainfotech.com:8086/empFeedback/yourFeedback", driver.getCurrentUrl());
	  }
	  
	  //tc8
	  @Test(priority=8)
	  public void timeSheet_applyLeave() {
		  hrisLogin.applyLeaveInTimeSheet();
		  Assert.assertEquals("https://hris.qainfotech.com:8086/time/timesheet", driver.getCurrentUrl());
	  }
	 
	  //tc9 - after login - logout
	  @Test(priority=9)
	  public void afterLogin_Logout() {
		  hrisLogin.logout();
		  Assert.assertEquals("https://hris.qainfotech.com/login.php",driver.getCurrentUrl());
	  } 
	  
	  //tc10 - forget Password
	  @Test(priority=10)
	  public void forgetPassword() {
		  hrisLogin.forgetPasswordd();
		  Assert.assertEquals("http://115.113.54.29/N9DLRfanX+PP6yPq5SqjXds5NYONBgzS6wV2zbDb8+I=NQGcQZpridnn8H8ErfRa65ReEJ+svJdDc0Y=/?action=sendtoken"
				  , driver.getCurrentUrl());
	  }
	  	  
}