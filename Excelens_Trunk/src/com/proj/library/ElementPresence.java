package com.proj.library;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.WaitUtil;
import com.frw.wait.ExplicitWaitUtil;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.base.TestBase;
import com.proj.utilApp.KeyMethodsUtil;
import com.report.reporter.Reporting;

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

	public static String isElementDisplayed(WebDriver driver,String refid,String testcasename,String workFlow,String objectType,String locatorType,String locator,int timeout){
		String flag=Constants_FRMWRK.False;
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
					Reporting.logStep(driver, refid, testcasename, workFlow+"Validate Element displayed", locator+" exists and displayed." , Constants_FRMWRK.Pass);
					flag=Constants_FRMWRK.True;
				}	
				else{
					Reporting.logStep(driver, refid, testcasename, workFlow+"Validate Element displayed", locator+" exists but not displayed." , Constants_FRMWRK.Fail);
				}
			}else{
				Reporting.logStep(driver, refid, testcasename, workFlow+"Validate Element displayed", locator+" doesnot exists " , Constants_FRMWRK.Fail);
			}
		}catch(StaleElementReferenceException st){
			isElementDisplayed(driver, locatorType, locator, timeout);
			System.out.println("Stale at is ElementDisplayed ..recovering");
		}

		return flag;
	}

	/**
	 * Method is used to verify the element under test is disabled(with attribute) 
	 * @param driver
	 * @param locatorType
	 * @param locator
	 * @param timeout
	 * @return  True if it is actually disabled else False
	 * @throws Throwable
	 */
	public static String isElementDisabledwithAttribute(WebDriver driver,String locatorType,String locator,int timeout) throws Throwable{
		String flag=Constants_FRMWRK.False;
		WebElement element=null;
		element=elementDisplayed(driver, locatorType, locator, timeout);
		if(element!=null){
			flag=KeyMethodsUtil.isDisabledWithAttr(driver, "refid", "testcasename", "workflow", "Step", locatorType, "objectType", locator, "", element,Constants_FRMWRK.No);
		}
		return flag;
	}
	/**
	 * Check Whether the element under test is not displayed
	 * @param driver
	 * @param refid
	 * @param testcasename
	 * @param workFlow
	 * @param objectType
	 * @param locatorType
	 * @param locator
	 * @param timeout
	 * @return True if actually not displayed else False
	 */
	public static String check_ElementNotDisplayed(WebDriver driver,String refid,String testcasename,String workFlow,String locatorType,String objectType,String locator,int timeout,WebElement fetchedElement){
		String flag=Constants_FRMWRK.False;
		WebElement element=null;
		try{
			try{
				if(fetchedElement==null){
					element = ExplicitWaitUtil.waitForElement(driver, locatorType, locator, timeout);
				}

			}catch(Throwable t){
				//t.printStackTrace();
			}		
			if(element!=null){
				if(element.isDisplayed()==true){
					WaitUtil.pause(1);
					Reporting.logStep(driver, refid, testcasename, workFlow+"Validate Element not displayed",  objectType+": "+locator+" exists and displayed." , Constants_FRMWRK.Fail);
					flag=Constants_FRMWRK.True;
				}	
				else{
					Reporting.logStep(driver, refid, testcasename, workFlow+"Validate Element not displayed",  objectType+": "+locator+" exists but not displayed." , Constants_FRMWRK.Pass);
				}
			}else{
				Reporting.logStep(driver, refid, testcasename, workFlow+"Validate Element not displayed", objectType+": "+locator+" doesnot exists " , Constants_FRMWRK.Pass);
			}
		}catch(StaleElementReferenceException st){
			check_ElementNotDisplayed(driver,refid,testcasename,workFlow,objectType,locatorType,locator,timeout,fetchedElement);
			System.out.println("Stale at is ElementDisplayed ..recovering");
		}

		return flag;
	}

}
