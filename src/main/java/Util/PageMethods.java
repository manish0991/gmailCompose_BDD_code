package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class PageMethods {
	
	WebDriver driver;
	Properties prop; 
	
	// initiallize browser and return driver 
	
	public WebDriver init_driver(String browserName ){
		
		if (browserName.equals("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
          else if (browserName.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
          else {
  			
  			System.out.println("Browser name " + browserName +"  is not found");
  			
  		}
  		
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  
		  return driver;
		
	}
	
	// Creating Method to read property file 
	
	public Properties init_properties(){
		
		   prop = new Properties();
		  
		   String path ="./src/main/java/Util/config.properties";
		   
		   try {
			FileInputStream ip = new FileInputStream(path); 
			prop.load(ip);                                                
		} catch (FileNotFoundException e) {
			System.out.println("Some issue with config fie");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				   
		return prop;
			
	}
	
	
	
	 public void  doLogin(String username, String password){
		    driver.findElement(By.id("identifierId")).sendKeys(username);
			driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		    driver.findElement(By.name("password")).sendKeys(password);
	}
	
}
	
	
	
	
	


