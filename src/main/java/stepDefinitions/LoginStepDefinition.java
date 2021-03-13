package stepDefinitions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.PageMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginStepDefinition{

WebDriver driver;
WebDriverWait wait;
PageMethods pmethods;
Properties prop;


@Given("user is already on Login Page")
public void user_is_already_on_login_page() {
	 pmethods = new PageMethods();
	 prop = pmethods.init_properties();
	 String browserName=  prop.getProperty("browser"); 
	 driver = pmethods.init_driver(browserName);
	 driver.get(prop.getProperty("url"));
    
}

@When("user enters {string} and {string}")
public void user_enters_and(String username, String password) {
   
	pmethods.doLogin(prop.getProperty("username"), prop.getProperty("password"));
  
	
}

@When("user clicks on next button")
public void user_clicks_on_next_button() {
	  
	  driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
}

@When("user click on compose button")
public void user_click_on_compose_button() {
	
	  driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
}

@Then("user Attached file and enter email in To filed")
public void user_attached_file_and_enter_email_in_to_filed() throws InterruptedException, IOException {
	
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//textarea[contains(@aria-label, 'To')]")));
	driver.findElement(By.xpath(".//textarea[contains(@aria-label, 'To')]")).click();
	driver.findElement(By.xpath(".//textarea[contains(@aria-label, 'To')]")).sendKeys("manishkr5555@gmail.com");
	driver.findElement(By.xpath("(.//*[@aria-label='Message Body'])[2]")).sendKeys("This is an auto-generated mail");
	
	//clicking on attachment icon 
	driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
	
   // using AutoIt to browse file here
	Runtime.getRuntime().exec("D:\\Selenium Workspace\\UploadFile.exe");
	Thread.sleep(2000);
}

@Then("user clicks on send button")
public void user_clicks_on_send_button() {
	
	 driver.findElement(By.className("aoO")).click();
	
}

@Then("Close the browser")
public void close_the_browser() {
    
	driver.quit();
}

}
