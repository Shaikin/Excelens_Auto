package com.proj.navigations;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.WaitUtil;
import com.frw.util.Xls_Reader;
import com.proj.Constants.Constants;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.library.ElementPresence;
import com.proj.library.KeyMethods;
import com.proj.library.commonMethods;
import com.proj.objectRepository.ObjRepository;
import com.proj.suiteTRANSMITTALS.TestSuiteBase;
import com.proj.util.CustomExceptions;
import com.proj.util.fetchObjectRepository;
import com.proj.utilApp.ApplicationMethods;
import com.report.reporter.Reporting;


public class Navigations_CorporateLens extends TestSuiteBase{


	static String res="";
	static String input="";	
	static String className=Navigations_CorporateLens.class.getSimpleName();
	private static String locator_menu_pattern=".//*[@class='navigationTop__item navigationTop__item--link']/a[text()='objectlocator']";
//	private static String locator_submenu_pattern=".//*[@class='menu-item-text' and contains(text(),'objectlocator')]";
	private static String locator_submenu_pattern=".//*[contains(@id,'SelectorMenu_Container')]/ul/li/a[text()='objectlocator']";
	

	private static Xls_Reader xlsReader_objects_Navigation=new Xls_Reader(Constants.OR_Nav_Path);

	private static Hashtable<String,String>objects_step_Navigation=null;
	private static Hashtable<String,String>objects_locatorType_Navigation=null; 
	private static Hashtable<String,String>objects_objectType_Navigation=null;
	private static Hashtable<String,String>objects_objectLocator_Navigation=null;

	static {		
		System.out.println("Static ...............Initializeeeeeeeeeee");
		logsObj.log("fetchExcelobjects method triggred for Navigation Class");
		try {
			fetchObjectRepository.getObjects(Navigations_CorporateLens.class,xlsReader_objects_Navigation, "Objects_Navigation", "Navigation");
		} catch (Throwable e) {
			e.printStackTrace();
			Reporting.logStep("Excel Object Initialization - "+className, "Required Objects for "+className+" are not  initialized due to error-"+e.getStackTrace(), Constants_FRMWRK.Fail);

		}
	}
	/**
	 * Navigates to Transmittals Menu
	 * @author shaikka
	 * @param driver
	 * @throws Throwable 
	 */
	public static void navigateToTramsmittals(WebDriver driver) throws Throwable{
		commonMethods.switchToDefaultPage(driver);
		commonMethods.pageLoadWait(driver);
		String key_step="Menu - Transmittals";
		String locator=locator_menu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(key_step));
		res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , input);
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
		}
		ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_transmittals_inbox,Constants_TimeOuts.Element_TimeOut);
		ApplicationMethods.isSyncElementDisplayed(driver, Constants_TimeOuts.Page_TimeOut);
	}

	public static void navigateToDocumentRegister(WebDriver driver) throws Throwable{
		String Step="Menu - Document Register";
		commonMethods.switchToDefaultPage(driver);
		commonMethods.pageLoadWait(driver);
		String locator=locator_menu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(Step));
		res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(Step), objects_locatorType_Navigation.get(Step), objects_objectType_Navigation.get(Step),locator , input);
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(locator, " Navigate Failure - "+Step, "Please refer above details for more details");
		}
		
		ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_DocumentRegister,Constants_TimeOuts.Element_TimeOut);
		ApplicationMethods.isSyncElementDisplayed(driver, Constants_TimeOuts.Page_TimeOut);
	}
	/**
	 * Navigates to Documents
	 * @param driver
	 * @throws Throwable 
	 */
	public static void navigateToDocuments(WebDriver driver) throws Throwable{
		String Step="Usersite Menu - Documents";
		WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
		commonMethods.switchToDefaultPage(driver);
		commonMethods.pageLoadWait(driver);
		String locator=locator_menu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(Step));
		res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(Step), objects_locatorType_Navigation.get(Step), objects_objectType_Navigation.get(Step),locator , input);
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(locator, " Navigate Failure - "+Step, "Please refer above details for more details");
		}
	}
	
	public static void navigateToHome(WebDriver driver) throws Throwable{
		commonMethods.switchToDefaultPage(driver);
		commonMethods.pageLoadWait(driver);
		String key_step="Menu - Home";
		String locator=locator_menu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(key_step));
		res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , input);
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
		}
		ApplicationMethods.validate_homePageLogo(driver, Constants_TimeOuts.sync_homepageelement_load);
	}
	
	public static class Transmittals{
		/**
		 * Navigates to New Transmittals sub menu
		 * @author shaikka
		 * @param driver
		 * @throws Throwable 
		 */
		public static void navigateToNewTransmittal(WebDriver driver) throws Throwable{
			boolean titleDisplayed=false;
			int recoveryCounter=0;
			String Step="Page Option - new transmittal";
			while (recoveryCounter<=0 && titleDisplayed==false){
				navigateToTramsmittals(driver);
				WaitUtil.pause(1);			
				titleDisplayed=ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_transmittals_inbox,Constants_TimeOuts.sync_element_load);
				recoveryCounter=recoveryCounter+1;
			}			
			res=KeyMethods.f_performAction(driver, refID, testcaseName, "", Step, objects_locatorType_Navigation, objects_objectType_Navigation,objects_objectLocator_Navigation , input);
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(Step, " Navigate Failure - "+Step, "Please refer above details for more details");
			}
			//ApplicationMethods_Falcrum.getApplicationFrameCount(driver);
		}

		/**
		 * Navigates to My Sent Sub menu
		 * @param driver
		 * @throws Throwable 
		 */
		public static void navigateToMysent(WebDriver driver) throws Throwable{
			navigateToTramsmittals(driver);
		//commonMethods.switchToDefaultPage(driver);
		//commonMethods.pageLoadWait(driver);
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			String key_step="SubMenu - My Sent";
			String locator=locator_submenu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(key_step));
			//ApplicationMethods.waitForElementToDisappear(driver,".//*[text()='Transmittals - My Inbox']");
			
			boolean titleDisplayed=false;
			int recoveryCounter=1;
			while (recoveryCounter<3 && titleDisplayed==false){
				res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , "");
				titleDisplayed=ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_transmittals_mysent,Constants_TimeOuts.sync_element_load);
				recoveryCounter=recoveryCounter+1;
			}
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
			}			
			commonMethods.switchToDefaultPage(driver);
			commonMethods.pageLoadWait(driver);
			ApplicationMethods.isSyncElementDisplayed(driver, Constants_TimeOuts.Page_TimeOut);
		}
		/**
		 * Navigates to My Inbox
		 * @param driver
		 * @throws Throwable 
		 */
		public static void navigateToMyinbox(WebDriver driver) throws Throwable{
			navigateToTramsmittals(driver);
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			String key_step="SubMenu - My Inbox";
			String locator=locator_submenu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(key_step));

		/*	res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , "");
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
			}
			ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.search_inlineSearch,Constants_TimeOuts.Element_TimeOut);*/
			
			boolean titleDisplayed=false;
			int recoveryCounter=1;
			while (recoveryCounter<3 && titleDisplayed==false){
				res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , "");
				titleDisplayed=ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_transmittals_inbox,Constants_TimeOuts.sync_element_load);
				recoveryCounter=recoveryCounter+1;
			}
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
			}			
			commonMethods.switchToDefaultPage(driver);
			commonMethods.pageLoadWait(driver);
			ApplicationMethods.isSyncElementDisplayed(driver, Constants_TimeOuts.Page_TimeOut);
		}

		/**
		 * Navigates to Actions Required
		 * @param driver
		 * @throws Throwable 
		 */
		public static void navigateToActionRequired(WebDriver driver) throws Throwable{
			navigateToTramsmittals(driver);
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			String key_step="Menu - Action Required";
			String locator=locator_submenu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(key_step));
			
			/*res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , "");
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
			}*/
			
			boolean titleDisplayed=false;
			int recoveryCounter=1;
			while (recoveryCounter<3 && titleDisplayed==false){
				res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , "");
				titleDisplayed=ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_transmittals_actionRequired,Constants_TimeOuts.sync_element_load);
				recoveryCounter=recoveryCounter+1;
			}
			
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
			}			
			commonMethods.switchToDefaultPage(driver);
			commonMethods.pageLoadWait(driver);
			ApplicationMethods.isSyncElementDisplayed(driver, Constants_TimeOuts.Page_TimeOut);
		}

		/**
		 * Navigates to Actions Overdue
		 * @param driver
		 * @throws Throwable 
		 */

		/*public static void navigateToActionsOverdue(WebDriver driver) throws Throwable{
			navigateToTramsmittals(driver);
			String key_step="Menu - Actions Overdue";
			String locator=locator_submenu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(key_step));

			res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , input);
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
			}
		}*/
		
		public static void navigateToActionsOverdue(WebDriver driver) throws Throwable{
			navigateToTramsmittals(driver);
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			String key_step="Menu - Actions Overdue";
			String locator=locator_submenu_pattern.replaceAll("objectlocator", objects_objectLocator_Navigation.get(key_step));

			boolean titleDisplayed=false;
			int recoveryCounter=1;
			while (recoveryCounter<3 && titleDisplayed==false){
				res=KeyMethods.f_performAction(driver, refID, testcaseName, "", objects_step_Navigation.get(key_step), objects_locatorType_Navigation.get(key_step), objects_objectType_Navigation.get(key_step),locator , "");
				titleDisplayed=ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_transmittals_overdue,Constants_TimeOuts.sync_element_load);
				recoveryCounter=recoveryCounter+1;
			}
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(locator, " Navigate Failure - "+key_step, "Please refer above details for more details");
			}			
			commonMethods.switchToDefaultPage(driver);
			commonMethods.pageLoadWait(driver);
			ApplicationMethods.isSyncElementDisplayed(driver, Constants_TimeOuts.Page_TimeOut);
		}
	}
		
		
		
	public static void verify_menu(WebDriver driver,String ApplicationName, Hashtable<String,String>data){

		int j = Integer.valueOf(data.get(ApplicationName+"_MenuCount"));		
		for(int i=1;i<=j; i++){
			String MenuName = ApplicationName+"_Menu"+String.valueOf(i);				
			commonMethods.switchToDefaultPage(driver);				
			res=KeyMethods.f_performAction(driver, refID, testcaseName, "","Fluid Menu List",objects_locatorType_Navigation ,objects_objectType_Navigation,objects_objectLocator_Navigation, data.get(MenuName));
		}		
	}
	
	
	public static class Settings{

		public static void navigateToSettingsWheel(WebDriver driver,String workFlow) throws Exception{
			res=KeyMethods.f_performAction(driver, refID, testcaseName, workFlow, "Settings Wheel", objects_locatorType_Navigation, objects_objectType_Navigation, objects_objectLocator_Navigation, input);
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(objects_objectLocator_Navigation.get("Settings Wheel"), " Navigate Failure - My Sent", "Please refer above details for more details");
			}			
		}

		public static void navigateToSiteContents(WebDriver driver,String workFlow) throws Throwable{
			navigateToSettingsWheel(driver,workFlow);
			/*res=KeyMethods.f_performAction(driver, refID, testcaseName, workFlow, "Site contents", objects_locatorType_Navigation, objects_objectType_Navigation, objects_objectLocator_Navigation, input);
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(objects_objectLocator_Navigation.get("Site contents"), " Navigate Failure - My Sent", "Please refer above details for more details");
			}*/
			
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			
			boolean titleDisplayed=false;
			int recoveryCounter=1;
			while (recoveryCounter<3 && titleDisplayed==false){
				res=KeyMethods.f_performAction(driver, refID, testcaseName, workFlow, "Site contents", objects_locatorType_Navigation, objects_objectType_Navigation, objects_objectLocator_Navigation, input);
				titleDisplayed=ElementPresence.isElementDisplayed(driver, Constants_FRMWRK.FindElementByXPATH, ObjRepository.pageTile_siteContents,Constants_TimeOuts.sync_element_load);
				recoveryCounter=recoveryCounter+1;
			}
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(objects_objectLocator_Navigation.get("Site contents"), " Navigate Failure - "+objects_step_Navigation.get("Site contents"), "Please refer above details for more details");
			}			
			commonMethods.switchToDefaultPage(driver);
			commonMethods.pageLoadWait(driver);			
		}
	}
}




