package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class VerifyLogin {
	
	WebDriver driver;
	HomePage homepage;
	
	@BeforeMethod(alwaysRun = true)
	public void launchApplication()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyLogin()
	{
		homepage= new HomePage(driver);
		homepage.setUserName("Admin");
		homepage.setPassword("Admin");
		homepage.clickOnSumbitBtn();
		String loginmsg=homepage.getLoginSuccesfulMsg();
		Assert.assertEquals(loginmsg, "Login Successfully");
		
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}

}
