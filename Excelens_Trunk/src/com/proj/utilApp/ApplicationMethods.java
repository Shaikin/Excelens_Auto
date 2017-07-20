package com.proj.utilApp;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.PageLoadWaitUtil;
import com.frw.util.PopUpUtil;
import com.frw.util.WaitUtil;
import com.frw.wait.ExplicitWaitUtil;
import com.proj.Constants.Constants;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.base.TestBase;
import com.proj.library.Driver;
import com.proj.library.LocalDriverManager;
import com.proj.library.commonMethods;
import com.proj.objectRepository.ObjRepository;
import com.proj.util.CustomExceptions;
import com.report.reporter.Reporting;



/**
 * 
 * @author shaikka
 *
 */
public class ApplicationMethods extends TestBase{

public static WebDriver launch0365Login(String browser,String url,String userName,String password,String refID) throws Throwable{
	WebDriver driver = null;
	browserName=browser;
	String httpProtocol="https://";
	driver=Driver.launchBrowser(browser);
	LocalDriverManager.setWebDriver(driver);
	driver=LocalDriverManager.getDriver();
	if (browser.equalsIgnoreCase("ie")){
		String title;
		url=httpProtocol+url;
		commonMethods.navigateURL(driver,url);
		//parentwindow = driver.getWindowHandle();
		//driver.switchTo().window(parentwindow);
		O365_loginwithCredentials(driver, userName, password);
		System.out.println("Logged in...");
	}
	
	return driver;
	
}

public static void O365_loginwithCredentials(WebDriver driver,String username,String password) throws Throwable{
	WebElement element=null;
	if(refID.isEmpty()){
		refID="LAT-81";
	}
	try{
		element=ExplicitWaitUtil.waitForElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_login_OtherUserLink, Constants_TimeOuts.Element_optional_TimeOut);
	}catch (Throwable t){
		
	}	
	
	if(element!=null){
		try {
			element.click();
			logsObj.logInfo(" User another account exists and Clicked");
		}catch(Throwable t){
			logsObj.logInfo(" User another account exists and but not Clicked due to"+t);
		}			
	}
	
	element=ExplicitWaitUtil.waitForElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.textbox_login_UserName, Constants_TimeOuts.Element_TimeOut);

	if(element!=null){
		try {
			element.sendKeys(username);
			logsObj.logInfo(" User Name exists and Entered "+username);
			
			Reporting.logStep(driver, refID, "Log In- User Name", "UserName exists and Entered "+username, Constants_FRMWRK.Pass);
		}catch(Throwable t){
			logsObj.logInfo(" User Name exists and but not entered "+username+" due to error-"+t);
			Reporting.logStep(driver, refID, "Log In- User Name", "UserName exists and but could not Entered "+username+"due to "+t, Constants_FRMWRK.Fail);
		}			
	}
	
	element=ExplicitWaitUtil.waitForElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.textbox_login_Password, Constants_TimeOuts.Element_TimeOut);

	if(element!=null){
		try {
			element.sendKeys(password);
			logsObj.logInfo(" User Name exists and Entered "+password);
			Reporting.logStep(driver, refID, "Log In- Password", "Password exists and Entered "+password, Constants_FRMWRK.Pass);
		}catch(Throwable t){
			logsObj.logInfo(" Password exists and but not entered "+password+" due to error-"+t);
			Reporting.logStep(driver, refID, "Log In-Password", "Password exists and but could not Entered "+password+"due to "+t, Constants_FRMWRK.Fail);
		}			
	}
	commonMethods.switchToDefaultPage(driver);
	commonMethods.pageLoadWait(driver);
	WaitUtil.pause(Constants_TimeOuts.sync_element_load);
	element=ExplicitWaitUtil.waitForElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_login_Signin, Constants_TimeOuts.Element_TimeOut);

	if(element!=null){
		try {
			//commonMethods.actionsdoubleClick(driver, element);
			commonMethods.actionsClick2(driver, element);
			logsObj.logInfo(" Sign In  exists and Clicked ");
			Reporting.logStep(driver, refID, "Log In- Sign In", "Sign In exists and Clicked ", Constants_FRMWRK.Pass);
		}catch(Throwable t){
			logsObj.logInfo(" Sign In exists and but not clicked  due to error-"+t);
			Reporting.logStep(driver, refID, "Log In-Sign In", "Sign in exists and but could not clicked due to "+t, Constants_FRMWRK.Fail);
		}			
	}
	
	try{
		element=ExplicitWaitUtil.waitForElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.logo_homepage_exelens, Constants_TimeOuts.Page_TimeOut);	
		Reporting.logStep(driver, refID,"Login into application", "IE-Log into the application -0365 User Authenication", "Successfully able to log into the application with user credentials "+username+"--"+password, Constants_FRMWRK.Pass);
	}catch(Throwable t){
		Reporting.logStep(driver, refID,"Login into application", "IE-Log into the application -0365 User Authenication", "Not able to log into the application with user credentials "+username+"--"+password+"due to error-"+t, Constants_FRMWRK.Fail);
	}
	
}

	/**
	 * Launches required browser and logs into the application with given credentails
	 * @param browserType
	 * @param browser
	 * @param url
	 * @param userName
	 * @param password
	 * @return
	 * @throws Throwable
	 */
	public static WebDriver launchBrowserAndlogIntoApplication(String browser,String url,String userName,String password,String refID) throws Throwable{
		WebDriver driver = null;
		browserName=browser;
		String httpProtocol="https://";
		driver=Driver.launchBrowser(browser);
		LocalDriverManager.setWebDriver(driver);
		driver=LocalDriverManager.getDriver();
		if(browser.equalsIgnoreCase("Chrome")||browser.equalsIgnoreCase("firefox") ){
			url=httpProtocol+userName+":"+password+"@"+url;			
			PopUpUtil.checkDefaultPopup(driver, "Login User Authentication popup-Confirmation", "ok");			
			commonMethods.navigateURL(driver,url);
			Reporting.logStep("Launch and Log into the application", "Launched & logged into the application "+url, Constants_FRMWRK.Pass);

		}else if (browser.equalsIgnoreCase("ie")){
			String title;
			url=httpProtocol+url;
			commonMethods.navigateURL(driver,url);
			/*boolean isDisplayed=com.proj.util.PopupUtil.isDialogPresent(driver);
			if(isDisplayed==false){
				title=driver.getTitle();
				commonMethods.ie_Certification(driver);
			}else{
				title="WebDriver";
			}	*/
			//Dialogs.userAuthentication(driver,browser,url,title, CONFIG.getProperty("userDomain")+"\\"+userName, password);
			
			O365_loginwithCredentials(driver, userName, password);
			
			
			waitforHomePage();			
		}
		try{
			PageLoadWaitUtil.waitForPageToLoad(driver);
		}catch (Exception ex){

		}

		return driver;
	}
	/**
	 * Logs out of the application
	 * @author shaikka	
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	public static String o365_logOutFromApplication(WebDriver driver) throws Throwable{

		String flag=Constants_FRMWRK.True;		
		WebElement element;
		if(isTestPass==false){
			//closeAllDialogs(driver, refID, testcaseName);
			ApplicationMethods.closeAllDialogswithCancelAndClose(driver, refID, testcaseName);
		}
		
		commonMethods.switchToDefaultPage(driver);
		element=ExplicitWaitUtil.waitForElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.link_user, Constants_TimeOuts.Element_TimeOut);

		if(element!=null){
			try{
				WaitUtil.pause(1);
				commonMethods.actionsClick(driver, element);
				//element.click();
				
				Reporting.logStep(driver, refID, "Logout- Click on Open Menu in the Home Page", "Open Menu exists and Clicked", Constants_FRMWRK.Pass);
			}catch(Throwable t){
				isTestPass=false;
				flag=Constants_FRMWRK.False;
				Reporting.logStep(driver, refID, "Logout-Click on Open Menu in the Home Page", "Open Menu exists and but not Clicked"+" due to error-"+t, Constants_FRMWRK.Fail);
			}

		}else{
			isTestPass=false;
			flag=Constants_FRMWRK.False;
			Reporting.logStep(driver, refID, "Logout- Click on Open Menu in the Home Page", "Open Menu doesnot exists ", Constants_FRMWRK.Fail);
		}


		element=ExplicitWaitUtil.waitForElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.link_signOut, Constants_TimeOuts.Element_TimeOut);

		if(element!=null){
			try{
				WaitUtil.pause(1);
				element.click();
				Reporting.logStep(driver, refID, "Logout- Click on Sign Out", "Sign Out exists and Clicked", Constants_FRMWRK.Pass);
			}catch(Throwable t){
				isTestPass=false;
				flag=Constants_FRMWRK.False;
				Reporting.logStep(driver, refID, "Logout- Click on Sign Out", "Sign Out exists and but not Clicked"+" due to error-"+t, Constants_FRMWRK.Fail);
			}

		}else{
			isTestPass=false;
			flag=Constants_FRMWRK.False;
			Reporting.logStep(driver, refID, "Logout- Click on Sign Out", "Sign Out doesnot exists ", Constants_FRMWRK.Fail);
		}

		//PageLoadWaitUtil.waitForPageToLoad(driver);
		return flag;
	}

	/**
	 * Logs out from the application , closes the driver instance & kills the processes
	 * @author shaikk
	 * @param driver
	 * @param refid
	 * @param testcasename
	 * @return
	 * @throws Throwable
	 */
	public static String logOutFromApplicationAndcloseBrowser(WebDriver driver,String refid,String testcasename) throws Throwable{
		WaitUtil.pause(2);
		String flag=Constants_FRMWRK.True;	
		if(isTestPass==Constants_FRMWRK.FalseB){
			//ApplicationMethods.closeAllDialogs(driver, refid, testcasename);
			ApplicationMethods.closeAllDialogswithCancelAndClose(driver, refID, testcasename);
		}
		flag=o365_logOutFromApplication(driver);
		PopUpUtil.checkDefaultPopup(driver, Constants.ok);
		Driver.close(driver,browserName);
		return flag;
	}
	/**
	 * closes all pop-up windows displayed
	 * @author shaikk
	 * @param driver
	 * @param refID
	 * @param testcaseName
	 */
	public static void closeAllDialogs(WebDriver driver,String refID,String testcaseName){
		int counter=1;
		commonMethods.switchToDefaultPage(driver);
		int frameCount=getApplicationFrameCount(driver);
		Boolean isView=false;
		System.out.println("Number of Frame before Close icons are "+frameCount);
		logsObj.log("Number of Frame before Close icons are "+frameCount);
		int closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.icon_close, Constants_TimeOuts.Save_TimeOut);
		if(frameCount!=0 && closeIcons==0){
			WorkArounds.getViewPortOfPage(driver,browserName);
			isView=true;
		}
		if(frameCount!=0){			
			closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.icon_close, Constants_TimeOuts.Save_TimeOut);
			WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);		
			System.out.println("Number of Close icons displayed are "+closeIcons);
			logsObj.log("Number of Close icons displayed are "+closeIcons);
			if(closeIcons!=0 && counter <10){				
				List <WebElement> elements=ExplicitWaitUtil.waitForVisibilityOfElements(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.icon_close,Constants_TimeOuts.Element_TimeOut);
				System.out.println("Number of Close icons elements are "+elements.size());
				logsObj.log("Number of Close icons elements are "+elements.size());
				for (WebElement element :elements){
					WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
					try{
						if(element!=null && element.isDisplayed()==true){
							commonMethods.getViewOfElement(driver, element,browserName);					
							//element.click();
							commonMethods.actionsClick(driver, element);
							if(isView==true){
								Reporting.logStep(driver, "Close popup windows", "Closed all Popup Windows with view port recovery", Constants_FRMWRK.Warning);
							}							
						}
					}catch(StaleElementReferenceException st){
						System.out.println("closeAllDialogs :- stale..");
					}
					//WaitUtil.pause(3);		
					WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
				}
				closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.icon_close,Constants_TimeOuts.Save_TimeOut);	
				WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
				if(closeIcons!=0 && counter <10){
					counter=counter+1;
					System.out.println("Number of Close icons are still "+elements.size());
					closeAllDialogs(driver, refID, testcaseName);
				}else if (elements.size()==0 && counter <10){
					//Reporting.logStep(driver, "Closing the popup dialogs", "All Opened dialogs are closed", Constants_FRMWRK.Pass);
				}else if (elements.size()!=0 && counter >=10){
					isTestPass=Constants_FRMWRK.FalseB;
					Reporting.logStep(driver, "Closing the popup windows", "Unable to close all opened dialogs after 10 attempts", Constants_FRMWRK.Fail);
				}
			}
		}

	}
	/**
	 * fetches the frame count from the page displayed
	 * @author shaikk
	 * @param driver
	 * @return
	 */
	public static int getApplicationFrameCount(WebDriver driver){
		int flag=0;
		commonMethods.switchToDefaultPage(driver);
		flag=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.frame_single,Constants_TimeOuts.Save_TimeOut);
		return flag;
	}
	/**
	 * Switches to latest frame displayed
	 * @author shaikk
	 * @param driver
	 * @param testcasename
	 * @throws Throwable
	 */
	public static void switchToLatestDLGframe(WebDriver driver,String testcasename) throws Throwable{
		String frameName;
		WaitUtil.pause(Constants_TimeOuts.sync_frame_load);
		try{
			int frames=getApplicationFrameCount(driver);
			if(frames==0){				
			}
			else if(frames!=0){
				frameName=ObjRepository.frame_list_pattern;
				frameName=frameName.replaceAll("framelist", String.valueOf(frames));
				commonMethods.switchToFrameFromDefault(driver, testcasename, Constants_FRMWRK.FindElementByXPATH, frameName);
			}
		}catch (Throwable t ){
			CustomExceptions.Exit(testcasename, "Switch to latest frame -Failure", "Unable to switch the latest frame expected due to error-"+commonMethods.getStackTrace(t));
		}


	}
	/**
	 * Fetches the site name
	 * @author shaikk
	 * @param url
	 * @return
	 */
	public static String getSiteName(String url){
		String flag;
		if(url.contains(Constants.App_Fluid)){
			flag=Constants.App_Fluid;
		}else{
			flag=Constants.App_Fulcrum;
		}
		return flag;	
	}
	/**
	 * Waits for Overlay to disappear
	 * @author shaikk
	 * @param driver
	 */
	public static void waitForOverlayToDisappear(WebDriver driver){
		commonMethods.switchToDefaultPage(driver);
		boolean tt=ExplicitWaitUtil.waitUntilInvisibilityOfElement(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.overlay_working, Constants_TimeOuts.Overlay_disappear);
		System.out.println("Overlay Working on it.. invisibility.."+tt);
	}
	/**
	 * fetches subsite from the url
	 * @author shaikk
	 * @param mainSite
	 * @param subsiteName
	 * @return
	 */
	public static String getSubsite(String mainSite,String subsiteName){
		String patternSubsite="/SitePages";
		return mainSite.replaceAll(patternSubsite, "/"+subsiteName+patternSubsite);

	}

	private static void waitforHomePage() throws Throwable{
		ExplicitWaitUtil.waitForElementTobeActionable(LocalDriverManager.getDriver(), Constants_FRMWRK.FindElementByXPATH, ObjRepository.homePage_element, Constants_TimeOuts.Page_TimeOut);
	}
	
	/**
	 * Waits for Overlay to disappear
	 * @author shaikk
	 * @param driver
	 */
	public static void waitForElementToDisappear(WebDriver driver,String objectLocator){
		commonMethods.switchToDefaultPage(driver);
		boolean tt=ExplicitWaitUtil.waitUntilInvisibilityOfElement(driver, Constants_FRMWRK.FindElementByXPATH, objectLocator, Constants_TimeOuts.Overlay_disappear);
		System.out.println("Overlay Working on it.. invisibility.."+tt);
	}
	
	/**
	 * Waits for Overlay to disappear
	 * @author shaikk
	 * @param driver
	 */
	public static void waitForSpinnerToDisappear(WebDriver driver,String objectLocator){
		commonMethods.switchToDefaultPage(driver);
		boolean isSpinnerDisplayed=false;
		int counter=1;
		if(isSpinnerDisplayed==false && counter<=3){
			isSpinnerDisplayed=ExplicitWaitUtil.waitUntilInvisibilityOfElement(driver, Constants_FRMWRK.FindElementByXPATH, objectLocator, Constants_TimeOuts.Overlay_disappear);
			counter=counter+1;
		}
	
		System.out.println("Waiting for Spinner Please Wait... invisibility.."+isSpinnerDisplayed);
	}
	
	/**
	 * closes all pop-up windows displayed with cancel button
	 *  @author shaikk
	 *  @date May 18 2017
	 * @param driver
	 * @param refID
	 * @param testcaseName
	 * @throws Throwable 
	 */
	public static void closeAllDialogswithCancel(WebDriver driver,String refID,String testcasename) throws Throwable{
		int counter=1;
		commonMethods.switchToDefaultPage(driver);
		int frameCount=getApplicationFrameCount(driver);
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
		//Boolean isView=false;
		System.out.println("Number of Frame before Cancel are "+frameCount);
		logsObj.log("Number of Frame before Cancel are "+frameCount);
		int closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_cancel, Constants_TimeOuts.Save_TimeOut);
		/*if(frameCount!=0 && closeIcons==0){
			WorkArounds.getViewPortOfPage(driver,browserName);
			isView=true;
		}*/
		if(frameCount!=0){	
			ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
			closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_cancel, Constants_TimeOuts.Save_TimeOut);
			WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);		
			System.out.println("Number of Cancel buttons displayed are "+closeIcons);
			logsObj.log("Number of Cancel buttons displayed are "+closeIcons);
			if(closeIcons!=0 && counter <10){	
				ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
				List <WebElement> elements=ExplicitWaitUtil.waitForVisibilityOfElements(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_cancel,Constants_TimeOuts.Element_TimeOut);
				System.out.println("Number of Cancel button elements are "+elements.size());
				logsObj.log("Number of Cancel elements are "+elements.size());
				for (WebElement element :elements){
					WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
					try{
						if(element!=null && element.isDisplayed()==true){
							//commonMethods.getViewOfElement(driver, element,browserName);					
							//element.click();
							commonMethods.actionsClick(driver, element);
							/*if(isView==true){
								Reporting.logStep(driver, "Close popup windows", "Closed all Popup Windows with view port recovery", Constants_FRMWRK.Warning);
							}*/							
						}
					}catch(StaleElementReferenceException st){
						System.out.println("closeAllDialogs :- stale..");
					}
					//WaitUtil.pause(3);		
					WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
				}
				ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
				closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_cancel,Constants_TimeOuts.Save_TimeOut);	
				WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
				if(closeIcons!=0 && counter <10){
					counter=counter+1;
					System.out.println("Number of Cancel buttons are still "+elements.size());
					closeAllDialogswithCancel(driver, refID, testcaseName);
				}else if (elements.size()==0 && counter <10){
					//Reporting.logStep(driver, "Closing the popup dialogs", "All Opened dialogs are closed", Constants_FRMWRK.Pass);
				}else if (elements.size()!=0 && counter >=10){
					isTestPass=Constants_FRMWRK.FalseB;
					Reporting.logStep(driver, "Closing the popup windows", "Unable to close all opened dialogs with cancel after 10 attempts", Constants_FRMWRK.Fail);
				}
			}
		}

	}
	/**
	 * closes all pop-up windows displayed with cancel button
	 *  @author shaikk
	 *  @date May 18 2017
	 * @param driver
	 * @param refID
	 * @param testcaseName
	 * @throws Throwable 
	 */
	public static void closeAllDialogswithClose(WebDriver driver,String refID,String testcasename) throws Throwable{
		int counter=1;
		commonMethods.switchToDefaultPage(driver);
		int frameCount=getApplicationFrameCount(driver);
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
		//Boolean isView=false;
		System.out.println("Number of Frame before Close are "+frameCount);
		logsObj.log("Number of Frame before Close are "+frameCount);
		int closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_close, Constants_TimeOuts.Save_TimeOut);
		/*if(frameCount!=0 && closeIcons==0){
			WorkArounds.getViewPortOfPage(driver,browserName);
			isView=true;
		}*/
		if(frameCount!=0){			
			ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
			closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_close, Constants_TimeOuts.Save_TimeOut);
			WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);		
			System.out.println("Number of Close buttons displayed are "+closeIcons);
			logsObj.log("Number of Close buttons displayed are "+closeIcons);
			if(closeIcons!=0 && counter <10){	
				ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
				List <WebElement> elements=ExplicitWaitUtil.waitForVisibilityOfElements(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_close,Constants_TimeOuts.Element_TimeOut);
				System.out.println("Number of Close button elements are "+elements.size());
				logsObj.log("Number of Close elements are "+elements.size());
				for (WebElement element :elements){
					WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
					try{
						if(element!=null && element.isDisplayed()==true){
							//commonMethods.getViewOfElement(driver, element,browserName);					
							//element.click();
							commonMethods.actionsClick(driver, element);
							/*if(isView==true){
								Reporting.logStep(driver, "Close popup windows", "Closed all Popup Windows with view port recovery", Constants_FRMWRK.Warning);
							}*/							
						}
					}catch(StaleElementReferenceException st){
						System.out.println("closeAllDialogs :- stale..");
					}
					//WaitUtil.pause(3);		
					WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
				}
				ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
				closeIcons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_close,Constants_TimeOuts.Save_TimeOut);	
				WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);	
				if(closeIcons!=0 && counter <10){
					counter=counter+1;
					System.out.println("Number of Close buttons are still "+elements.size());
					closeAllDialogswithClose(driver, refID, testcaseName);
				}else if (elements.size()==0 && counter <10){
					//Reporting.logStep(driver, "Closing the popup dialogs", "All Opened dialogs are closed", Constants_FRMWRK.Pass);
				}else if (elements.size()!=0 && counter >=10){
					isTestPass=Constants_FRMWRK.FalseB;
					Reporting.logStep(driver, "Closing the popup windows", "Unable to close all opened dialogs with cancel after 10 attempts", Constants_FRMWRK.Fail);
				}
			}
		}

	}
/**
 * Close all dialogs with Cancel and Close buttons.
 * @author ShaikK
 * @date May 18 2017
 * @param driver
 * @param refID
 * @param testcaseName
 * @throws Throwable 
 */
	public static void closeAllDialogswithCancelAndClose(WebDriver driver,String refID,String testcasename) throws Throwable{
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
	//	System.out.println("ook");
		int cancelButtons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_cancel, Constants_TimeOuts.Save_TimeOut);
		if (cancelButtons!=0){
			closeAllDialogswithCancel(driver, refID, testcaseName);
		}
		int closebuttons=ExplicitWaitUtil.getVisibleElementsSize(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.button_close, Constants_TimeOuts.Save_TimeOut);
		if (closebuttons!=0){
			closeAllDialogswithClose(driver, refID, testcaseName);
		}
	}
	
	public static void isSyncElementDisplayed(WebDriver driver,int timeout){
		ExplicitWaitUtil.waitForVisibilityOfElements(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.search_inlineSearch, timeout);
		
	}
}
