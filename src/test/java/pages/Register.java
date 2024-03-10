package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register {


	WebDriver driver;
	public Register(WebDriver driver)
	{
		this.driver=driver;
	}

	public void putFName(String firstName)
	{
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);

	}
	public void putLName(String lastName)
	{
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
	}
	public void putPhoneNumber(String phone)
	{
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
	}
	public void putEmail(String email)
	{
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(email) ;
	}

	public void putAddress(String Address)
	{
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(Address) ;

	}
	public void putCity(String city)
	{
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);

	}
	public void putState(String state)
	{
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
	}
	public void putPostalCode(String pCode)
	{
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(pCode);
	}

	public void putUserName(String uName)
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(uName);
	}
	public void putPassword(String pwd)
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);

	}
	public void putConfirmPassword(String cPwd)
	{
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(cPwd);	
	}

	public void clickOnSumbitbtn()
	{
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}
	public String getRegisterSuccesfullMsgs()

	{
      return driver.findElement(By.xpath("//font[contains(text(),' Thank you for registering.')]")).getText();
		
	}
}
