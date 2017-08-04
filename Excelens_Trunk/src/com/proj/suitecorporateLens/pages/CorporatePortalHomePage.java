package com.proj.suitecorporateLens.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.DateUtil;
import com.frw.util.WaitUtil;
import com.frw.util.Xls_Reader;
import com.proj.Constants.Constants;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.library.ElementPresence;
import com.proj.library.KeyMethods;
import com.proj.library.commonMethods;
import com.proj.navigations.Navigations_CorporateLens;
import com.proj.suiteDOCS.pages.Documents_EntryPage;
import com.proj.suiteDOCS.reusables.DocumentRegisterGridUtil;
import com.proj.suitecorporateLens.TestSuiteBase;
import com.proj.util.CustomExceptions;
import com.proj.util.fetchObjectRepository;
import com.report.reporter.Reporting;

public class CorporatePortalHomePage extends TestSuiteBase{
	static String input="";	
	static String res ="";
	static String className=CorporatePortalHomePage.class.getSimpleName();
	private static Xls_Reader xlsReader_objects_cl=new Xls_Reader(Constants.OR_CL_Path);

	private static Hashtable<String,String>objects_step_alerts=null;
	private static Hashtable<String,String>objects_locatorType_alerts=null; 
	private static Hashtable<String,String>objects_objectType_alerts=null;
	private static Hashtable<String,String>objects_objectLocator_alerts=null;
	
	private static Hashtable<String,String>objects_step_NewsCarousel=null;
	private static Hashtable<String,String>objects_locatorType_NewsCarousel=null; 
	private static Hashtable<String,String>objects_objectType_NewsCarousel=null;
	private static Hashtable<String,String>objects_objectLocator_NewsCarousel=null;
	
	private static Hashtable<String,String>objects_step_Blog=null;
	private static Hashtable<String,String>objects_locatorType_Blog=null; 
	private static Hashtable<String,String>objects_objectType_Blog=null;
	private static Hashtable<String,String>objects_objectLocator_Blog=null;
	
	@SuppressWarnings("unused")
	private static Hashtable<String,String>objects_step_MyDocs=null;
	private static Hashtable<String,String>objects_locatorType_MyDocs=null; 
	private static Hashtable<String,String>objects_objectType_MyDocs=null;
	private static Hashtable<String,String>objects_objectLocator_MyDocs=null;
	
	
	static {		
		logsObj.log("fetchExcelobjects method triggred for Class "+className);
		try {
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Alerts", "alerts");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_NewsCarousel", "NewsCarousel");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Blog", "Blog");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_MyDocuments", "MyDocs");
			
		} catch (Throwable e) {
			e.printStackTrace();
			Reporting.logStep("Excel Object Initialization - "+className, "Required Objects for "+className+" are not  initialized due to error-"+e.getStackTrace(), Constants_FRMWRK.Fail);
          //Reporting.logStep(driver, workflow+" "+page+" - Transmittal ID", "Transmittal ID :-"+res+" is displayed for the record "+subject, Constants_FRMWRK.Pass);    
		}
	}

	
	
	
	//===============================================================================================================
	// 							                            ALERTS 
	//===============================================================================================================
	
	public static class Alerts{
		
		private static Hashtable<String,String> createAlert(WebDriver driver,String testcasename,String refid,String workFlow,Hashtable<String,String>data) throws Throwable{
			Hashtable<String,String> alertdata=new Hashtable<String,String>();
			res=KeyMethods.f_performAction(driver, refid, testcasename, workFlow, "Alerts-Title", objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, data.get("Title")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("dd/MM/yyyy hh:mm:ss"));
			alertdata.put("Alerts-Title", res);
			
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcaseName, objects_step_alerts.get("Alerts-Title")+"-Failure", "Please refer above details for more details");
			}
			
			res=KeyMethods.f_performAction(driver, refid, testcasename, workFlow, "Alerts-Description", objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, data.get("Description"));
			alertdata.put("Alerts-Description", res);
			
			res=KeyMethods.f_performAction(driver, refid, testcasename, workFlow, "Alerts-Status", objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, data.get("Status"));
			alertdata.put("Alerts-Status", res);
			
			res=KeyMethods.f_performAction(driver, refid, testcasename, workFlow, "Alerts-Active", objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, data.get("Active"));
			alertdata.put("Alerts-Active", res);
			
			Documents_EntryPage.clickSave(driver, refid, testcasename, workFlow);
			return alertdata;

		}
		
		private static void validate_alert(WebDriver driver,String refid,String testcasename,String workflow,Hashtable<String,String>alertDetails) throws Throwable{
			
			String locator_alert_notification_default=objects_objectLocator_alerts.get("Alerts-Notification");
			String locator_alert_notification=objects_objectLocator_alerts.get("Alerts-Notification");
			locator_alert_notification=commonMethods.replaceString("status", locator_alert_notification, alertDetails.get("Alerts-Status").toLowerCase());
			locator_alert_notification=commonMethods.replaceString("alertName", locator_alert_notification, alertDetails.get("Alerts-Title"));
			
			objects_objectLocator_alerts.put("Alerts-Notification", locator_alert_notification);
			objects_objectLocator_alerts.put("Alerts-Notification-displayed", locator_alert_notification);
			
			res=KeyMethods.f_fetchElementDetails(driver, refid, testcasename, workflow, objects_step_alerts.get("Alerts-Notification"), objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, alertDetails.get("Alerts-Title"));
			objects_objectLocator_alerts.put("Alerts-Notification", locator_alert_notification_default);
			
		}
		
		private static void validate_alert_color(WebDriver driver,String refid,String testcasename,String workflow,Hashtable<String,String>alertData) throws Throwable{
			String locator_alert_notification_tag_default=objects_objectLocator_alerts.get("Alerts-Notification-Tag");
			
			String locator_alert_notification_tag=objects_objectLocator_alerts.get("Alerts-Notification-displayed")+objects_objectLocator_alerts.get("Alerts-Notification-Tag");
					
			objects_objectLocator_alerts.put("Alerts-Notification-Tag", locator_alert_notification_tag);
					
			//Include key as WebElement_Background color in f_fetchelements
			res=KeyMethods.f_fetchElementDetails(driver, refid, testcasename, workflow, objects_step_alerts.get("Alerts-Notification-Tag"), objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, alertData.get("Color"));
			
			objects_objectLocator_alerts.put("Alerts-Notification-Tag", locator_alert_notification_tag_default);
		}
		
		public static Hashtable<String,String> AsContributor_CreateAlert(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			Navigations_CorporateLens.Settings.navigateToSiteContents(driver, workflow);
			SiteContents.clickAlertsLibrary(driver, workflow);
			SiteContents.clicknewItem(driver, workflow);
			Hashtable <String,String> alertdata=createAlert(driver, testcasename, refId, workflow, data);
			WaitUtil.pause(Constants_TimeOuts.processToAlert);
			return alertdata;
		}
		
		public static void vaidate_AlertInHomePage(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>alertData,Hashtable<String,String>alerttestData) throws Throwable{
			Navigations_CorporateLens.navigateToHome(driver);
			validate_alert(driver, refId, testcasename, workflow, alertData);
			WaitUtil.pause(Constants_TimeOuts.processToAlert);
			validate_alert_color(driver, refId, testcasename, workflow, alerttestData);
		}
		
	}
	
	
	//===============================================================================================================
	// 							                          NewsCarousel
	//===============================================================================================================
	
	public static class NewsCarousel{
		
		
		public static Hashtable<String,String> AsContributor_CreatePage(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			Hashtable<String,String> pagedata=new Hashtable<String,String>();
			
			Navigations_CorporateLens.Newsroom.Articles(driver);
			WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
			Navigations_CorporateLens.Settings.navigateToAddaPage(driver, workflow);
			WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
			res=Page.enterPageName(driver, refId, testcasename, workflow, data.get("Page Name")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("ddMMyyyy hhmmss"));
			pagedata.put("Page Name", res);
			Page.clickCreate(driver, refId, testcasename, workflow);
			commonMethods.switchToDefaultPage(driver);
			WaitUtil.pause(5);
			Page.PageDetails(driver, refId, testcasename, workflow, data,res);				
			//Page.check_PageTile(driver, refId, testcasename, workflow, returndata.get("Title")); commented this as crawl will take 15 mins.
			return pagedata;
		}
		
		public static void check_newsCarouselinHomePage(WebDriver driver,String refId,String testcasename,String workflow,String newsCarouselTitle) throws Throwable{
			
			String locator=objects_objectLocator_NewsCarousel.get("Home Page -NewsCarousel Article");
			locator=commonMethods.replaceString("tile", locator, newsCarouselTitle);
			objects_objectLocator_NewsCarousel.put("Home Page -NewsCarousel Article", locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Home Page -NewsCarousel Article", objects_locatorType_NewsCarousel, objects_objectType_NewsCarousel, objects_objectLocator_NewsCarousel, newsCarouselTitle);
					if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_NewsCarousel.get("Home Page -NewsCarousel Article")+"- Failure", "Please refer above details for more details");
			}
		}
		
		public static void AsContributor_Validate_NewsCarousel(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			//Navigations_CorporateLens.navigateToBreadCrumPage(driver, testcasename, workflow, "Excelens Portal");
			check_newsCarouselinHomePage(driver, refId, testcasename, workflow, data.get("Page Name"));
			
		}
		
	}
	
	//===============================================================================================================
	// 							                         Blogs
	//===============================================================================================================
	
	public static class Blogs{		

		public static Hashtable<String,String> AsContributor_CreatePage(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			Hashtable<String,String> pagedata=new Hashtable<String,String>();
			Navigations_CorporateLens.Settings.navigateToSiteContents(driver, workflow);
			Navigations_CorporateLens.Settings.navigateToSubsite(driver, workflow, "Blogs");
			WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
			Navigations_CorporateLens.Settings.navigateToAddaPage(driver, workflow);
			WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
			res=Page.enterPageName(driver, refId, testcasename, workflow, data.get("Page Name")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("ddMMyyyy hhmmss"));
			pagedata.put("Page Name", res);
			Page.clickCreate(driver, refId, testcasename, workflow);
			commonMethods.switchToDefaultPage(driver);
			WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
			Page.PageDetails(driver, refId, testcasename, workflow, data,res);

			return pagedata;
		}
		
		public static void check_bloginHomePage(WebDriver driver,String refId,String testcasename,String workflow,String blogTitle) throws Throwable{

			String locator=objects_objectLocator_Blog.get("Home Page -Blog Article");
			locator=commonMethods.replaceString("tile", locator, blogTitle);
			objects_objectLocator_Blog.put("Home Page -Blog Article", locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Home Page -Blog Article", objects_locatorType_Blog, objects_objectType_Blog, objects_objectLocator_Blog, blogTitle);
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_Blog.get("Home Page -Blog Article")+"- Failure", "Please refer above details for more details");
			}
		}
		
		public static void AsContributor_Validate_Blog(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			//Navigations_CorporateLens.navigateToBreadCrumPage(driver, testcasename, workflow, "Excelens Portal");
			check_bloginHomePage(driver, refId, testcasename, workflow, data.get("Page Name"));
			
		}

	}
	

	//===============================================================================================================
	// 							                       My Documents
	//===============================================================================================================
	
	public static class My_Documents{	
		
		
		public static Hashtable<String,String> AsContributor_UploadADocument(String site,WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			Hashtable<String,String> docdata=new Hashtable<String,String>();
			Navigations_CorporateLens.Settings.navigateToSiteContents(driver, workflow);
			SiteContents.clickDocumentsLibrary(driver, workflow);
			res=Documents_EntryPage.uploadADocumentIntoApplication(driver, refId, testcasename, workflow, data);
			docdata.put("Document Name", res);

			String[] filename=docdata.get("Document Name").split("\\.");
			driver_CORP.navigate().refresh();
			DocumentRegisterGridUtil.validateUploadedDocument(driver_CORP, refID, workflow, testcaseName,filename[0] );
			if(site.contains("CorporateSite")){
				Documents_EntryPage.publishMajorVersion(driver_CORP, refID, local_testcaseName, workflow, data, filename[0], data.get("Major version"));
			}
			

			return docdata;			
		}
		
		

		public static void AsContributor_check_documentinMyDocumentsWebPart(WebDriver driver,String refId,String testcasename,String workflow,String docName) throws Throwable{

			String locator=objects_objectLocator_MyDocs.get("Home Page -My Document");
			locator=commonMethods.replaceString("documentName", locator, docName);
			objects_objectLocator_MyDocs.put("Home Page -My Document", locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Home Page -My Document", objects_locatorType_MyDocs, objects_objectType_MyDocs, objects_objectLocator_MyDocs, docName);
		/*	if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_MyDocs.get("Home Page -My Document")+"- Failure", "Please refer above details for more details");
			}*/
		}
		
		public static void AsNotOwner_check_documentinMyDocumentsWebPart(WebDriver driver,String refId,String testcasename,String workflow,String docName) throws Throwable{
			String key="Home Page -My Document-Visitor/Other Contributor";
			String locator=objects_objectLocator_MyDocs.get(key);
			locator=commonMethods.replaceString("documentName", locator, docName);
			objects_objectLocator_MyDocs.put(key, locator);
			WebElement fetchedElement=null;
			ElementPresence.check_ElementNotDisplayed(driver, refId, testcasename, workflow, objects_locatorType_MyDocs.get(key), objects_objectType_MyDocs.get(key), objects_objectLocator_MyDocs.get(key), Constants_TimeOuts.Element_optional_TimeOut, fetchedElement);
			//res=KeyMethods.f_fetchElementDetails(driver, refId, testcasename, workflow, key, objects_locatorType_MyDocs, objects_objectType_MyDocs, objects_objectLocator_MyDocs, docName);
			/*if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_MyDocs.get(key)+"- Failure", "Please refer above details for more details");
			}*/
		}
	}
}
