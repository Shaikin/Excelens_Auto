package com.proj.library;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.WaitUtil;
import com.frw.wait.ExplicitWaitUtil;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.base.TestBase;

public class ElementPresence extends TestBase{
	/**
	 * Waits for element to be visible 
	 * @author ShaikK
	 * @param driver
	 * @param locatorType
	 * @param locator
	 * @param timeout
	 * @return boolean
	 */
	public static boolean isElementDisplayed(WebDriver driver,String locatorType,String locator,int timeout){
		boolean flag=Constants_FRMWRK.FalseB;
		WebElement element=null;
		try{
			try{
				element = ExplicitWaitUtil.waitForElement(driver, locatorType, locator, timeout);
			}catch(Throwable t){
				//t.printStackTrace();
			}		
			if(element!=null){
				if(element.isDisplayed()==true){
					WaitUtil.pause(1);
					flag=Constants_FRMWRK.TrueB;
				}			
			}
		}catch(StaleElementReferenceException st){
			isElementDisplayed(driver, locatorType, locator, timeout);
			System.out.println("Stale at is ElementDisplayed ..recovering");
		}
		
		return flag;
	}
	
	public static WebElement elementDisplayed(WebDriver driver,String locatorType,String locator,int timeout){
		WebElement element=null;
		
		try{
			element = ExplicitWaitUtil.waitForElement(driver, locatorType, locator, timeout);
		}catch(Throwable t){
			//t.printStackTrace();
		}		
		
		return element;
	}
	
	public static void waitForElement(WebDriver driver,String locatorType,String locator,int timeout) throws Throwable{
		ExplicitWaitUtil.waitForElement(driver, locatorType, locator, timeout);
		
	}
	
	/**
	 * Waits for element to be visible and then clickable.
	 * Return true for success otherwise false 
	 * @author shaik
	 * @date Aug 17 2016
	 * @param driver
	 * @param locatorType
	 * @param locator
	 * @return
	 */	
	public static boolean isElementDisplayedAndReadyForClickable(WebDriver driver,String locatorType,String locator,int timeout){
		boolean flag=Constants_FRMWRK.FalseB;
		WebElement element=null;
		
		try{
			//element = ExplicitWaitUtil.waitForElement(driver, locatorType, locator, Constants_TimeOuts.Element_TimeOut);
			element =ExplicitWaitUtil.waitForElementTobeActionable(driver, locatorType, locator, Constants_TimeOuts.Element_TimeOut);
		}catch(Throwable t){
			//t.printStackTrace();
			System.out.println("Object :"+locator+" is not displayed/actionable after "+Constants_TimeOuts.Element_TimeOut);
		}		
		if(element!=null){
			if(element.isDisplayed()==true){
				WaitUtil.pause(1);
				flag=Constants_FRMWRK.TrueB;
			}			
		}
		return flag;
	}
	


}
