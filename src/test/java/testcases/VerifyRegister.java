package testcases;



import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.Register;
import utility.Utility;

public class VerifyRegister {

	WebDriver driver;
	HomePage homepage;
	Register register;

	@BeforeMethod(alwaysRun = true)
	public void launchApplication()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void verifyRegisstraion() throws IOException
	{   homepage=new HomePage(driver);
	homepage.clickOnRegistrationLink();
	register=new Register(driver);
	ArrayList <String> userData= Utility.readExcel();
	register.putFName(userData.get(0));
	register.putLName(userData.get(1));
	register.putPhoneNumber(userData.get(2));
	register.putEmail(userData.get(3));
	register.putAddress(userData.get(4));
	register.putState(userData.get(5));
	register.putCity(userData.get(6));
	register.putPostalCode(userData.get(7));
	Utility.selectOptionFromDropdown( "ALGERIA",driver.findElement(By.xpath("//select[@name='country']")));
	register.putUserName(userData.get(8));
	register.putPassword(userData.get(8));
	register.putConfirmPassword(userData.get(9));



	register.clickOnSumbitbtn();
    
	Assert.assertEquals(register.getRegisterSuccesfullMsgs(),"","user not registered");

	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}

}



