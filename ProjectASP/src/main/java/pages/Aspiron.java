package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Aspiron {
	WebDriver driver;

	By spendAndSaveLink = By.xpath("(//a[contains(text(),'Spend & Save')])[1]");

	By boxAspiron = By.xpath("//div[contains(@class,'plan-content')]//child::*[1][text()='Aspiration']");

	By boxAspironPlus = By.xpath("//div[contains(@class,'plan-content')]//child::*[1][text()='Aspiration']");

	By lnkAsprion = By.xpath("//button[contains(text(),'Get Aspiration')]");
	By lnkAsprionPlus = By.xpath("//button[contains(text(),'Get Aspiration Plus')]");
	By inputEmail = By.xpath("//*[@id='join-waitlist-input']");
	
	By insideForm= By.xpath("//*[@class='inside-form']");
	By txtyearlyOption= By.xpath("//*[@class='options']/child::*[1]/h3/following-sibling::*[1]/*[@class='ng-binding']");
	By txtyearlyOptioninsideText= By.xpath("//*[@class='options']/child::*[1]/h3/following-sibling::*[1]");
	By btnClose= By.xpath("//*[@class='close']");
	By txtMonthlyOptioninsideText= By.xpath("//*[@class='options']/child::*[2]/h3/following-sibling::*[1]");



	
	
	public Aspiron(WebDriver driver) {

		this.driver = driver;

	}

	public void clickspendLink() {

		driver.findElement(spendAndSaveLink).click();

	}
	
	public void verfyLinksForAspiron() {

    driver.findElement(lnkAsprion).click();
	int count=	driver.findElements(insideForm).size();
	int count1=	driver.findElements(inputEmail).size();
	
	if(count==1 && count1==1)
	{
		Assert.assertTrue(true);
	}else
	{
		Assert.assertTrue(false);
	}
	
driver.findElement(btnClose).click();
	}
	
	public void verfyProducts () {

	int count=	driver.findElements(boxAspiron).size();

	int count1=	driver.findElements(boxAspironPlus).size();
	
	if(count==1 && count1==1)
	{
		Assert.assertTrue(true);
	}else
	{
		Assert.assertTrue(false);
	}

	}

	public void verfyLinksForAspironPlus() throws InterruptedException {

	    driver.findElement(lnkAsprionPlus).click();
	    Thread.sleep(2000);
		String yealyRadioButtonTextInside=	driver.findElement(txtyearlyOptioninsideText).getText();
		String monthlyRadioButtonTextInside=	driver.findElement(txtMonthlyOptioninsideText).getText();

	System.out.println(yealyRadioButtonTextInside);
	System.out.println(monthlyRadioButtonTextInside);
	assertEquals(yealyRadioButtonTextInside, "$71.88 paid once yearly");
	assertEquals(monthlyRadioButtonTextInside, "$7.99 paid monthly");
	
	
	
	}		
	
	
	  public void verfiyAPI() throws InterruptedException 
	  { 
		  RestAssured.baseURI="https://swapi.dev/api/";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  //Response object
		  Response response=httpRequest.request(Method.GET,"/people/1/");
		  
		  //print response in console window
		
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 200);
		  
	  
	  }
	 
	
	public void  closeBrowser()
	{
		driver.close();
	}
}
