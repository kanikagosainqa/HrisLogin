package Hris.HrisLoginUsingJavascriptExecutor;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HrisLoginMainCLass {
	
	WebDriver driver;
	WebElement username;
	JavascriptExecutor je;
	
	public void HrisLoginMainCLass(WebDriver driver) {
		this.driver = driver;
	}
		
	private WebElement getUserName() {
		return driver.findElement(By.cssSelector("#txtUserName"));
	}
	
	private WebElement getPassword() {
		return driver.findElement(By.cssSelector("#txtPassword"));
	}
	
	public void loginForm(String username, String pwd){
		getUserName().clear();
		getUserName().sendKeys(username);
		getPassword().clear();
		getPassword().sendKeys(pwd);
		getPassword().submit();
	}
	
	public String blankUsername() {
		loginForm("","Kanika@321#");
		return getUserName().getAttribute("style");
	}
	
	public String blankPassword() {
		loginForm("kanikagosian","Kanika@321#");
		return getPassword().getAttribute("style");
	}
	
	public void applyLeaveInTimeSheet() {
		driver.findElement(By.className("time")).click();
		driver.findElement(By.className("apply_leave")).click();
	}
	
	public void logout() {
		  driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul/li/a/img")).click();
		  WebDriverWait wait=new WebDriverWait(driver,10); 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa")));
		  driver.findElement(By.className("fa-sign-out")).click();	  
	}
	
	public void forgetPasswordd() {
		  driver.findElement(By.xpath("//*[@id=\"demo-2\"]/div/div[2]/ul/li[1]/a")).click();
		  driver.findElement(By.cssSelector("#login > form > div.loginTxtBtn.extraText > div > label:nth-child(2) > a")).click();
		}
	
	public void incorrectUsername() {
		loginForm("kanika","Kanika@321#");
		driver.findElement(By.xpath("//*[@id=\"demo-2\"]/div/div[2]/ul/li[1]/a")).click();
	}
	
	public String incorrectPwd() {
		loginForm("kanikagosain","kanika");
		driver.findElement(By.xpath("//*[@id=\"demo-2\"]/div/div[2]/ul/li[1]/a")).click();
		return driver.findElement(By.cssSelector
				  ("#login > form > div.loginTxt.txtHideDiv.alert.alert-error > div")).getText();
	}
	
	public void login() {
		loginForm("kanikagosain","Kanika@321#");
		 getPassword().submit();
	}
	
	public void remember() {
		loginForm("kanikagosain","Kanika@321#");
		 driver.findElement(By.name("txtSsi")).click();
		  getPassword().submit();
	}
	
}
