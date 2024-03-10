package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setUserName(String userName) {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);
	}
   public void setPassword(String passWord) {
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
	   
   }
   public void clickOnSumbitBtn()
   {
	   driver.findElement(By.xpath("//input[@name='submit']")).click();
   }
   public String getLoginSuccesfulMsg()
   {
	   return driver.findElement(By.xpath("//h3")).getText();
   }
   public void clickOnRegistrationLink()
	{
		driver.findElement(By.xpath("//img[@src='images/mast_register.gif']")).click();
	}
}
