/**
 * 
 */
package config;

/**
 * @author divya
 *
 */
import java.util.concurrent.TimeUnit;

import static executionEngine.TestCaseEngine.OR;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import executionEngine.*;
import utility.*;
 
// TODO: Auto-generated Javadoc
/**
 * The Class ActionKeywords.
 */
public class ActionKeywords {
 
		/** The driver. */
		public static WebDriver driver;
 
	/**
	 * Open browser.
	 *
	 * @param object the object
	 * @param data the data
	 */
	public static void openBrowser(String object,String data){		
		Log.info("Opening Browser");
		try{				
			if(data.equals("Firefox")){
				System.setProperty("webdriver.firefox.marionette", Constants.geckoDriverPath);
				driver=new FirefoxDriver();
				Log.info("Firefox browser started");				
				}
			else if(data.equals("IE")){
				//Dummy Code, Implement you own code
				driver=new InternetExplorerDriver();
				Log.info("IE browser started");
				}
			else if(data.equals("Chrome")){
				//Dummy Code, Implement you own code
				System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
				driver=new ChromeDriver();
				Log.info("Chrome browser started");
				}
 
			int implicitWaitTime=(10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}catch (Exception e){
			Log.info("Not able to open the Browser --- " + e.getMessage());
			TestCaseEngine.bResult = false;
		}
	}
 
	/**
	 * Navigate.
	 *
	 * @param object the object
	 * @param data the data
	 */
	public static void navigate(String object, String data){
		try{
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			TestCaseEngine.bResult = false;
			}
		}
 
	/**
	 * Click.
	 *
	 * @param object the object
	 * @param data the data
	 */
	public static void click(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			TestCaseEngine.bResult = false;
         	}
		}
 
	/**
	 * Input.
	 *
	 * @param object the object
	 * @param data the data
	 */
	public static void input(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to enter Text --- " + e.getMessage());
			 TestCaseEngine.bResult = false;
		 	}
		}
	
	/**
	 * Select.
	 *
	 * @param object the object
	 * @param data the data
	 */
	public static void select(String object, String data){
		try{
			Log.info("Select the value in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to select Value --- " + e.getMessage());
			 TestCaseEngine.bResult = false;
		 	}
		}
	
	public static void copyText(String object, String data) {
		try {
			Log.info("Copy the value in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).getText();
		} catch (Exception e) {
			Log.error("Unable to copy Value --- " + e.getMessage());
			TestCaseEngine.bResult = false;
		}
	}
	
 
	/**
	 * Wait for.
	 *
	 * @param object the object
	 * @param data the data
	 * @throws Exception the exception
	 */
	public static void waitFor(String object, String data) throws Exception{
		try{
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		 }catch(Exception e){
			 Log.error("Not able to Wait --- " + e.getMessage());
			 TestCaseEngine.bResult = false;
         	}
		}
 
	/**
	 * Close browser.
	 *
	 * @param object the object
	 * @param data the data
	 */
	public static void closeBrowser(String object, String data){
		try{
			Log.info("Closing the browser");
			driver.quit();
		 }catch(Exception e){
			 Log.error("Not able to Close the Browser --- " + e.getMessage());
			 TestCaseEngine.bResult = false;
         	}
		}
 
	}