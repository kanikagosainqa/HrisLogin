import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HrisLoginMainClassPageObjects {

	WebDriver driver;
	WebElement username;
	
	private WebElement getUserName(){
		return this.driver.findElement(By.xpath("//[@id=\"txtUserName\"]"));
	}
	
	private WebElement getPassword(){
		return this.driver.findElement(By.xpath("//[@id=\"txtPassword\"]"));
	}
	
	public void loginForm(String username, String pwd){
		getUserName().sendKeys(username);
		getPassword().sendKeys(pwd);
		getPassword().submit();
	}	
	
	public boolean isDisplayed(){
		return getPassword().isDisplayed();
	}
	 
}