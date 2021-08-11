package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import pages.Aspiron;;

public class Vefication {

    String chromeDriverPath="\\drivers\\chromedriver.exe";

    
    WebDriver driver;

    Aspiron objLogin;

    @BeforeTest

    public void setup(){

    	
    	String path = System.getProperty("user.dir");
    	System.out.println(path);  

    	System.setProperty("webdriver.chrome.driver",path+chromeDriverPath);
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.aspiration.com/");

    }

	
	  @Test(priority=0)
	  
	  public void testAsprion() throws InterruptedException{
	  
	  //Create Login Page object
	  
	  objLogin = new Aspiron(driver); objLogin.clickspendLink();
	  objLogin.verfyProducts(); objLogin.verfyLinksForAspiron();
	  objLogin.verfyLinksForAspironPlus(); objLogin.closeBrowser();
	  
	  }
	 
    
    @Test(priority=1)

    public void testAsprionAPI() throws InterruptedException{
    	 objLogin = new Aspiron(driver);
    objLogin.verfiyAPI();
    

    }
    

    
    }