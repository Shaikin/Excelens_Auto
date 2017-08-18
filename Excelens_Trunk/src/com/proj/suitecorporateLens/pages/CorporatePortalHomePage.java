package com.proj.suitecorporateLens.pages;

import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.DateUtil;
import com.frw.util.NumberConversionUtil;
import com.frw.util.WaitUtil;
import com.frw.util.Xls_Reader;
import com.frw.wait.ExplicitWaitUtil;
import com.proj.Constants.Constants;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.library.ElementPresence;
import com.proj.library.KeyMethods;
import com.proj.library.commonMethods;
import com.proj.navigations.Navigations_CorporateLens;
import com.proj.objectRepository.ObjRepository;
import com.proj.suiteDOCS.pages.Documents_EntryPage;
import com.proj.suiteDOCS.reusables.DocumentRegisterGridUtil;
import com.proj.suitecorporateLens.TestSuiteBase;
import com.proj.util.CustomExceptions;
import com.proj.util.Dialogs;
import com.proj.util.fetchObjectRepository;
import com.proj.utilApp.ApplicationMethods;
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

	private static Hashtable<String,String>objects_step_fav=null;
	private static Hashtable<String,String>objects_locatorType_fav=null; 
	private static Hashtable<String,String>objects_objectType_fav=null;
	private static Hashtable<String,String>objects_objectLocator_fav=null;

	@SuppressWarnings("unused")
	private static Hashtable<String,String>objects_step_announcement=null;
	private static Hashtable<String,String>objects_locatorType_announcement=null; 
	private static Hashtable<String,String>objects_objectType_announcement=null;
	private static Hashtable<String,String>objects_objectLocator_announcement=null;


	private static Hashtable<String,String>objects_step_calendar=null;
	private static Hashtable<String,String>objects_locatorType_calendar=null; 
	private static Hashtable<String,String>objects_objectType_calendar=null;
	private static Hashtable<String,String>objects_objectLocator_calendar=null;
	
	private static Hashtable<String,String>objects_step_marketplace=null;
	private static Hashtable<String,String>objects_locatorType_marketplace=null; 
	private static Hashtable<String,String>objects_objectType_marketplace=null;
	private static Hashtable<String,String>objects_objectLocator_marketplace=null;
	


	static {		
		logsObj.log("fetchExcelobjects method triggred for Class "+className);
		try {
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Alerts", "alerts");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_NewsCarousel", "marketplace");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Blog", "Blog");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_MyDocuments", "MyDocs");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Favourites", "fav");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Announcements", "announcement");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Calendar", "calendar");
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Marketplace", "marketplace");

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
			SiteContents.clickAlertsLibrary(driver, workflow,testcasename);
			SiteContents.clicknewItem(driver, workflow,testcasename,refId);
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
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			Navigations_CorporateLens.Settings.navigateToAddaPage(driver, workflow);
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			res=Page.enterPageName(driver, refId, testcasename, workflow, data.get("Page Name")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("ddMMyyyy hhmmss"));
			pagedata.put("Page Name", res);
			Page.clickCreate(driver, refId, testcasename, workflow);
			commonMethods.switchToDefaultPage(driver);
			WaitUtil.pause(Constants_TimeOuts.sync_element_load);
			Page.PageDetails(driver, refId, testcasename, workflow, data,res);				
			//Page.check_PageTile(driver, refId, testcasename, workflow, returndata.get("Title")); commented this as crawl will take 15 mins.
			return pagedata;
		}

		public static void check_newsCarouselinHomePage(WebDriver driver,String refId,String testcasename,String workflow,String newsCarouselTitle) throws Throwable{
			String step="Home Page -NewsCarousel Article";
			String locator=objects_objectLocator_NewsCarousel.get(step);
			locator=commonMethods.replaceString("tile", locator, newsCarouselTitle);
			objects_objectLocator_NewsCarousel.put(step, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_NewsCarousel, objects_objectType_NewsCarousel, objects_objectLocator_NewsCarousel, newsCarouselTitle);
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_NewsCarousel.get(step)+"- Failure", "Please refer above details for more details");
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
			String step="Home Page -Blog Article";
			String locator=objects_objectLocator_Blog.get(step);
			locator=commonMethods.replaceString("tile", locator, blogTitle);
			objects_objectLocator_Blog.put(step, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_Blog, objects_objectType_Blog, objects_objectLocator_Blog, blogTitle);
			if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_Blog.get(step)+"- Failure", "Please refer above details for more details");
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
			SiteContents.clickDocumentsLibrary(driver, workflow,testcasename);
			res=Documents_EntryPage.uploadADocumentIntoApplication(driver, refId, testcasename, workflow, data);
			docdata.put("Document Name", res);

			String[] filename=docdata.get("Document Name").split("\\.");
			driver.navigate().refresh();
			DocumentRegisterGridUtil.validateUploadedDocument(driver, refId, workflow, testcasename,filename[0] );
			if(site.contains("CorporateSite")){
				Documents_EntryPage.publishMajorVersion(driver, refId, testcasename, workflow, data, filename[0], data.get("Major version"));
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
			String step="Home Page -My Document-Visitor/Other Contributor";
			String locator=objects_objectLocator_MyDocs.get(step);
			locator=commonMethods.replaceString("documentName", locator, docName);
			objects_objectLocator_MyDocs.put(step, locator);
			WebElement fetchedElement=null;
			ElementPresence.check_ElementNotDisplayed(driver, refId, testcasename, workflow, objects_locatorType_MyDocs.get(step), objects_objectType_MyDocs.get(step), objects_objectLocator_MyDocs.get(step), Constants_TimeOuts.Element_optional_TimeOut, fetchedElement);
			//res=KeyMethods.f_fetchElementDetails(driver, refId, testcasename, workflow, key, objects_locatorType_MyDocs, objects_objectType_MyDocs, objects_objectLocator_MyDocs, docName);
			/*if(res.equals(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_MyDocs.get(key)+"- Failure", "Please refer above details for more details");
			}*/
		}
	}

	//===============================================================================================================
	// 							                       My Favourites
	//===============================================================================================================

	public static class My_Favourites{	

		private static void click_MyFavourites(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="My Favourites -Heading";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_fav.get(step)+"-Failure", "Please refer above details for more details");
			}			
		}

		private static void click_CreateFavourite(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Create Favourite";
			ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow,step , objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_fav.get(step)+"-Failure", "Please refer above details for more details");
			}
		}

		private static void click_Create(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="My Favourite-Create";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_fav.get(step)+"-Failure", "Please refer above details for more details");
			}
		}
		private static void click_Save(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Favourite-Save";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow,step , objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_fav.get(step)+"-Failure", "Please refer above details for more details");
			}
		}

		public static Hashtable<String,String> AsContributor_AddAdminFavourite(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			Hashtable<String,String> favdata=new Hashtable<String,String>();
			Navigations_CorporateLens.Settings.navigateToSiteContents(driver, workflow);
			SiteContents.clickAdminFavouriteLibrary(driver, workflow, testcasename);
			SiteContents.clicknewItem(driver, workflow,testcasename,refId);

			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Title", objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, data.get("Title")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("dd/MM/yyyy hh:mm:ss"));
			favdata.put("Title", res);

			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_fav.get("Title")+"-Failure", "Please refer above details for more details");
			}

			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "URL", objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, data.get("URL"));
			favdata.put("URL", res);

			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Description", objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, data.get("Description"));
			favdata.put("Description", res);
			Documents_EntryPage.clickSave(driver, refId, testcasename, workflow);

			DocumentRegisterGridUtil.searchAndTickRecord(driver,testcasename, workflow, "Title", ObjRepository.container_AdminFavourites, favdata.get("Title"), 2);

			return favdata;

		}

		public static void check_FavouriteinManagemyfavourites(WebDriver driver,String refId,String testcasename,String workflow,String favouriteTitle) throws Throwable{
			ApplicationMethods.switchToLatestDLGframe(driver, testcasename);

			String key="Manage My Favourites -Available Items-Favourite";
			String locator_default=objects_objectLocator_fav.get(key);
			String locator=objects_objectLocator_fav.get(key);
			locator=commonMethods.replaceString("tile", locator, favouriteTitle);
			objects_objectLocator_fav.put(key, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, key, objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, favouriteTitle);
			if(res.equals(Constants_FRMWRK.False)){
				objects_objectLocator_fav.put(key, locator_default);
				CustomExceptions.Exit(testcasename, objects_step_fav.get(key)+"- Failure", "Please refer above details for more details");
			}
			objects_objectLocator_fav.put(key, locator_default);
		}
		public static void validate_AdminFavouriteinHomePage(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>favouriteData) throws Throwable{
			Navigations_CorporateLens.navigateToHome(driver);
			WaitUtil.pause(Constants_TimeOuts.generic_TimeOut); // known pause other wise not clicking sometimes.
			click_MyFavourites(driver, refId, testcasename, workflow);
			check_FavouriteinManagemyfavourites(driver, refId, testcasename, workflow, favouriteData.get("Title"));
			ApplicationMethods.closeAllDialogs(driver, refId, testcasename);
		}


		public static Hashtable<String,String> AsOwner_AddMyFavourite(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			Hashtable<String,String> favdata=new Hashtable<String,String>();
			click_MyFavourites(driver, refId, testcasename, workflow);
			click_CreateFavourite(driver, refId, testcasename, workflow);

			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "My Favourite-Title", objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, data.get("Title")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("dd/MM/yyyy hh:mm:ss"));
			favdata.put("Title", res);

			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_fav.get("My Favourite-Title")+"-Failure", "Please refer above details for more details");
			}
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "My Favourite-URL", objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, data.get("URL"));
			favdata.put("URL", res);
			click_Create(driver, refId, testcasename, workflow);
			check_FavouriteinManagemyfavourites(driver, refId, testcasename, workflow, favdata.get("Title"));
			click_Save(driver, refId, testcasename, workflow);
			WaitUtil.pause(Constants_TimeOuts.processToComplete_Favourite);
			return favdata;
		}

		public static void AsOwner_check_FavouriteinMyFavouritesWebPart(WebDriver driver,String refId,String testcasename,String workflow,String favouriteTitle,String tabTitle) throws Throwable{
			commonMethods.switchToDefaultPage(driver);
			String key="Home Page-My Favourites for Owner";
			ApplicationMethods.validate_homePageLogo(driver, Constants_TimeOuts.Page_TimeOut);
			String locator_default=objects_objectLocator_fav.get(key);
			String locator=objects_objectLocator_fav.get(key);
			locator=commonMethods.replaceString("title", locator, favouriteTitle);
			objects_objectLocator_fav.put(key, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, key, objects_locatorType_fav, objects_objectType_fav, objects_objectLocator_fav, favouriteTitle);
			objects_objectLocator_fav.put(key, locator_default);			

			String current_driver_instance=driver.getWindowHandle();
			WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);
			res=commonMethods.getWindowsOrTabsAndValidateTitle(driver,refId,testcasename,workflow,2,tabTitle);

			if(commonMethods.getWindowsOrTabsCount(driver)==1 && !driver.getTitle().equalsIgnoreCase("Home")){
				driver.navigate().back();
			}else{
				driver.switchTo().window(current_driver_instance);
			}

		}
		public static void AsNotOwner_check_FavouriteinMyFavouritesWebPart(WebDriver driver,String refId,String testcasename,String workflow,String favouriteTitle) throws Throwable{
			String key="Home Page-My Favourites for Non Owner";
			String locator=objects_objectLocator_fav.get(key);
			locator=commonMethods.replaceString("title", locator, favouriteTitle);
			objects_objectLocator_fav.put(key, locator);
			WebElement fetchedElement=null;
			ElementPresence.check_ElementNotDisplayed(driver, refId, testcasename, workflow, objects_locatorType_fav.get(key), objects_objectType_fav.get(key), objects_objectLocator_fav.get(key), Constants_TimeOuts.Element_optional_TimeOut, fetchedElement);

		}
	}

	//===============================================================================================================
	// 							                       Announcements
	//===============================================================================================================

	public static class Announcements{	

		public static HashMap<String,String> AsContributor_AddAnnouncement(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			HashMap<String, String> announcementdata=new HashMap<String,String>();
			Navigations_CorporateLens.Settings.navigateToSiteContents(driver, workflow);
			SiteContents.clickAnnouncementsLibrary(driver, workflow,testcasename);
			SiteContents.clicknewItem(driver, workflow, testcasename,refId);
			announcementdata=Page.PageDetails(driver, refId, testcasename, workflow, data);

			DocumentRegisterGridUtil.searchAndTickRecord(driver,testcasename, workflow, "Title", ObjRepository.container_Announcements, announcementdata.get("Page Title"), 2);
			return announcementdata;			
		}

		public static void validate_Announcement_AnnouncementsWebPart(WebDriver driver,String refId,String testcasename,String workflow,HashMap<String,String> announcementdata,Hashtable<String,String>data) throws Throwable{
			commonMethods.switchToDefaultPage(driver);
			String key_announcement="Home Page-Announcement";
			String key_announcementIcon="Home Page-Announcement Emergency icon";
			String announcementTitle=announcementdata.get("Page Title");



			ApplicationMethods.validate_homePageLogo(driver, Constants_TimeOuts.Page_TimeOut);
			String locator_default=objects_objectLocator_announcement.get(key_announcement);
			String locator=objects_objectLocator_announcement.get(key_announcement);
			locator=commonMethods.replaceString("title", locator, announcementTitle);
			objects_objectLocator_announcement.put(key_announcement, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, key_announcement, objects_locatorType_announcement, objects_objectType_announcement, objects_objectLocator_announcement, announcementTitle);
			objects_objectLocator_announcement.put(key_announcement, locator_default);	

			if(data.get("Category").equalsIgnoreCase("Emergency")){
				locator_default=objects_objectLocator_announcement.get(key_announcementIcon);
				locator=objects_objectLocator_announcement.get(key_announcementIcon);
				locator=commonMethods.replaceString("title", locator, announcementTitle);
				objects_objectLocator_announcement.put(key_announcementIcon, locator);
				res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, key_announcementIcon, objects_locatorType_announcement, objects_objectType_announcement, objects_objectLocator_announcement, announcementTitle);
				objects_objectLocator_announcement.put(key_announcementIcon, locator_default);	
			}


		}
	}

	//===============================================================================================================
	// 							                       Calendar
	//===============================================================================================================

	public static class Calendar{	
		private static void click_Calendar(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Calendar -Heading";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_calendar.get(step)+"-Failure", "Please refer above details for more details");
			}			
		}
		private static void click_Add(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Calendar-Add";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_calendar.get(step)+"-Failure", "Please refer above details for more details");
			}
			ApplicationMethods.waitForOverlayToDisappear(driver);
		}			
		private static String selectDate(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{

			String key="Calendar -Date for Event";
			String locator_default=objects_objectLocator_calendar.get(key);
			String locator=objects_objectLocator_calendar.get(key);
			String date=DateUtil.getCurrentDateInRequiredDateFormat("d/MM/yyyy");
			locator=commonMethods.replaceString("eventDate", locator, date);
			objects_objectLocator_calendar.put(key, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, key, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, input);
			if(res.equals(Constants_FRMWRK.False)){
				objects_objectLocator_calendar.put(key, locator_default);
				CustomExceptions.Exit(testcasename, objects_step_calendar.get(key)+"- Failure", "Please refer above details for more details");
			}
			objects_objectLocator_calendar.put(key, locator_default);
			return date;	

		}
		private static void click_newitems(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Calendar Event- more item";
			boolean isMoreItemDisplayed=true;
			WebElement element;

			isMoreItemDisplayed=ElementPresence.isElementDisplayed(driver, objects_locatorType_calendar.get(step), objects_objectLocator_calendar.get(step), Constants_TimeOuts.Element_optional_TimeOut);
			while (isMoreItemDisplayed==true){
				element=ElementPresence.elementDisplayed(driver, objects_locatorType_calendar.get(step), objects_objectLocator_calendar.get(step), Constants_TimeOuts.Element_optional_TimeOut);
				commonMethods.actionsClick(driver, element);
				isMoreItemDisplayed=ElementPresence.isElementDisplayed(driver, objects_locatorType_calendar.get(step), objects_objectLocator_calendar.get(step), Constants_TimeOuts.Element_optional_TimeOut);
			}

		}

		private static HashMap<String, String> calenderEventDetails(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data) throws Throwable{
			HashMap<String, String> eventData=new HashMap<String,String>();

			ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
			String step="Calender Event-Title";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Title")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("ddMMyyyy hhmmss"));
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_calendar.get(step)+"-Failure", "Please refer above details for more details");
			}	
			eventData.put("Title", res);

			step="Calendar Event-Location";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Location"));
			eventData.put("Location", res);

			step="Calendar Event-Start Time";
			String date=DateUtil.getCurrentDateInRequiredDateFormat("d/MM/yyyy");
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, date);
			eventData.put("Start Time", res);

			step="Calendar Event-End Time";
			date=DateUtil.getCurrentDateInRequiredDateFormat("d/MM/yyyy");
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, date);
			eventData.put("End Time", res);

			step="Calendar Event-Start Hours";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Start Hours"));
			eventData.put("Start Hours", res);

			step="Calendar Event-End Hours";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("End Hours"));
			eventData.put("End Hours", res);

			step="Calendar Event-Description";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Description"));
			eventData.put("Description", res);

			step="Calendar Event-Category ";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Category"));

			step="Calendar Event-Category option";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Category Option"));
			eventData.put("Category Option", res);

			step="Calendar Event-All Day Event";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("All Day Event"));
			eventData.put("All Day Event", res);

			step="Calendar Event-Recurrence";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Recurrence"));
			eventData.put("Recurrence", res);

			step="Calendar Event-Event Page";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, data.get("Event Page"));
			eventData.put("Event Page", res);				

			Documents_EntryPage.clickSave(driver, refId, testcasename, workflow);
			return eventData;
		}

		public static HashMap<String,String> AsContributor_AddCalendarEvent(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			HashMap<String, String> eventdata=new HashMap<String,String>();

			click_Calendar(driver, refId, testcasename, workflow);
			String date=selectDate(driver, refId, testcasename, workflow);

			click_Add(driver, refId, testcasename, workflow);
			eventdata=calenderEventDetails(driver, refId, testcasename, workflow, data);
			eventdata.put("event date", date);
			return eventdata;

		}

		public static void AsContributor_Validate_Event_InCalendar(WebDriver driver,String refId,String testcasename,String workflow,HashMap<String,String>data ) throws Throwable{
			commonMethods.switchToDefaultPage(driver);
			click_newitems(driver, refId, testcasename, workflow);

			String step="Calendar Event in Calendar";
			String locator_default=objects_objectLocator_calendar.get(step);
			String locator=objects_objectLocator_calendar.get(step);

			String[] srthrs=commonMethods.splitString(data.get("Start Hours"), " ");
			String st=NumberConversionUtil.convertToDecimals("DOUBLEDECIMAL", srthrs[0]);				
			locator=commonMethods.replaceString("starthours", locator, st+" "+srthrs[1]);

			String[] endhrs=commonMethods.splitString(data.get("End Hours"), " ");
			String end=NumberConversionUtil.convertToDecimals("DOUBLEDECIMAL", endhrs[0]);	

			locator=commonMethods.replaceString("endhours", locator, end+" "+endhrs[1]);
			locator=commonMethods.replaceString("tile", locator, data.get("Title"));

			locator=commonMethods.replaceString("\\.00", locator, ":00");

			objects_objectLocator_calendar.put(step, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, input);
			objects_objectLocator_calendar.put(step, locator_default);	


		}
		
		
		public static void validate_Event_CalendarWebPart(WebDriver driver,String refId,String testcasename,String workflow,HashMap<String,String>eventdata ) throws Throwable{
			commonMethods.switchToDefaultPage(driver);
			
			String step="Home Page-Calendar Event";
			String locator_default=objects_objectLocator_calendar.get(step);
			String locator=objects_objectLocator_calendar.get(step);
			String EventTitle=eventdata.get("Title");

			locator=commonMethods.replaceString("title", locator, EventTitle);			
			objects_objectLocator_calendar.put(step, locator);
			
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, input);
			
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				objects_objectLocator_calendar.put(step, locator_default);	
				CustomExceptions.Exit(testcasename, objects_step_calendar.get(step)+"-Failure", "Please refer above details for more details");
			}
			objects_objectLocator_calendar.put(step, locator_default);	
			
			//----- Day
			step="Home Page-Calendar Day Icon";
			locator_default=objects_objectLocator_calendar.get(step);
			locator=objects_objectLocator_calendar.get(step);
			EventTitle=eventdata.get("Title");
			String startTime=eventdata.get("Start Time");
			String srtDay=DateUtil.converttoRequiredDateFormat("d/MM/yyyy", "dd", startTime);
			
			locator=commonMethods.replaceString("title", locator, EventTitle);
			locator=commonMethods.replaceString("startday", locator, srtDay);
			
			objects_objectLocator_calendar.put(step, locator);
			
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, input);
			
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				objects_objectLocator_calendar.put(step, locator_default);	
				CustomExceptions.Exit(testcasename, objects_step_calendar.get(step)+"-Failure", "Please refer above details for more details");
			}
			objects_objectLocator_calendar.put(step, locator_default);
			
			//----- Month
			step="Home Page-Calendar Day Icon";
			locator_default=objects_objectLocator_calendar.get(step);
			locator=objects_objectLocator_calendar.get(step);
			EventTitle=eventdata.get("Title");
			startTime=eventdata.get("Start Time");
			String srtMonth=DateUtil.converttoRequiredDateFormat("d/MM/yyyy", "MMM", startTime);

			locator=commonMethods.replaceString("title", locator, EventTitle);
			locator=commonMethods.replaceString("startday", locator, srtMonth);
			
			objects_objectLocator_calendar.put(step, locator);
			
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_calendar, objects_objectType_calendar, objects_objectLocator_calendar, input);
			
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				objects_objectLocator_calendar.put(step, locator_default);	
				CustomExceptions.Exit(testcasename, objects_step_calendar.get(step)+"-Failure", "Please refer above details for more details");
			}
			objects_objectLocator_calendar.put(step, locator_default);
			
			
			


		}

	}
	
	//===============================================================================================================
	// 							                       Marketplace
	//===============================================================================================================

	public static class MarketPlace{	
		private static void click_MarketPlace(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Marketplace -Heading";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_marketplace.get(step)+"-Failure", "Please refer above details for more details");
			}	

			ExplicitWaitUtil.waitTitle(driver, Constants_TimeOuts.Page_Load_TimeOut, ObjRepository.browserpageTile_Marketplace);
		}
		private static void click_PostAd(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Post an Ad";
			commonMethods.switchToDefaultPage(driver);
			ApplicationMethods.switchToLatestMarketplaceframe(driver, testcasename);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_marketplace.get(step)+"-Failure", "Please refer above details for more details");
			}	

			ExplicitWaitUtil.waitTitle(driver, Constants_TimeOuts.Page_Load_TimeOut, ObjRepository.browserpageTile_Marketplace);
		}
		
		private static void click_AddImageAndUpload(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data) throws Throwable{
			String step="Add Image";
			commonMethods.switchToDefaultPage(driver);
			ApplicationMethods.switchToLatestMarketplaceframe(driver, testcasename);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			
			String uploadFilePath=Constants.DataFileLocation_CorporateLens+data.get("Add Image");
			Dialogs.browse(browserName,driver, uploadFilePath, "Marketplace");
		}
		
		private static void click_Publish(WebDriver driver,String refId,String testcasename,String workflow) throws Throwable{
			String step="Publish";
			commonMethods.switchToDefaultPage(driver);
			ApplicationMethods.switchToLatestMarketplaceframe(driver, testcasename);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				CustomExceptions.Exit(testcasename, objects_step_marketplace.get(step)+"-Failure", "Please refer above details for more details");
			}	
			commonMethods.pageLoadWait(driver);
			ExplicitWaitUtil.waitTitle(driver, Constants_TimeOuts.Page_Load_TimeOut, ObjRepository.browserpageTile_Marketplace);
		}
		
		public static void Validate_Marketplace_Ad(WebDriver driver,String refId,String testcasename,String workflow,HashMap<String,String>marketitemData) throws Throwable{
			commonMethods.switchToDefaultPage(driver);
			ApplicationMethods.switchToLatestMarketplaceframe(driver, testcasename);
			
			String step="Marketplace -Kind Category";			
			
			String locator_default=objects_objectLocator_marketplace.get(step);
			String locator=objects_objectLocator_marketplace.get(step);
			String KindofItem=marketitemData.get("Kind of Item");
			
			locator=commonMethods.replaceString("kindofitem", locator, KindofItem);
			
			objects_objectLocator_marketplace.put(step, locator);			
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				objects_objectLocator_marketplace.put(step, locator_default);
				CustomExceptions.Exit(testcasename, objects_step_marketplace.get(step)+"-Failure", "Please refer above details for more details");
			}	
			objects_objectLocator_marketplace.put(step, locator_default);
			commonMethods.pageLoadWait(driver);
			
			
			step="Marketplace Item";			
			
			locator_default=objects_objectLocator_marketplace.get(step);
			locator=objects_objectLocator_marketplace.get(step);
			String ItemTitle=marketitemData.get("Item Title");
			
			locator=commonMethods.replaceString("ItemTitle", locator, ItemTitle);
			
			objects_objectLocator_marketplace.put(step, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				objects_objectLocator_marketplace.put(step, locator_default);
				CustomExceptions.Exit(testcasename, objects_step_marketplace.get(step)+"-Failure", "Please refer above details for more details");
			}	
			objects_objectLocator_marketplace.put(step, locator_default);
			commonMethods.pageLoadWait(driver);
			
		}
		
		public static void Validate_Marketplace_Ad_Webpart(WebDriver driver,String refId,String testcasename,String workflow,HashMap<String,String>marketitemData) throws Throwable{
			
			String step="Home Page-Markpetplace Item";			
			
			String locator_default=objects_objectLocator_marketplace.get(step);
			String locator=objects_objectLocator_marketplace.get(step);
			String ItemTitle=marketitemData.get("Item Title");
			
			locator=commonMethods.replaceString("ItemTitle", locator, ItemTitle);
			
			objects_objectLocator_marketplace.put(step, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				objects_objectLocator_marketplace.put(step, locator_default);
				CustomExceptions.Exit(testcasename, objects_step_marketplace.get(step)+"-Failure", "Please refer above details for more details");
			}	
			objects_objectLocator_marketplace.put(step, locator_default);
			
			
			step="Home Page-Marketplace item icon";			
			
			locator_default=objects_objectLocator_marketplace.get(step);
			locator=objects_objectLocator_marketplace.get(step);
			ItemTitle=marketitemData.get("Item Title");
			String KindofItem=marketitemData.get("Kind of Item");
			
			locator=commonMethods.replaceString("ItemTitle", locator, ItemTitle);
			locator=commonMethods.replaceString("kindofitem", locator, KindofItem);
			
			objects_objectLocator_marketplace.put(step, locator);
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, input);
			if(res.equalsIgnoreCase(Constants_FRMWRK.False)){
				objects_objectLocator_marketplace.put(step, locator_default);
				CustomExceptions.Exit(testcasename, objects_step_marketplace.get(step)+"-Failure", "Please refer above details for more details");
			}	
			objects_objectLocator_marketplace.put(step, locator_default);
			
			
			
		}

		public static HashMap<String,String> AsContributor_PostAddInMarketplace(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			HashMap<String, String> addata=new HashMap<String,String>();

			click_MarketPlace(driver, refId, testcasename, workflow);
			click_PostAd(driver, refId, testcasename, workflow);
			String step="What Kind of Item?";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, data.get("Kind of Item"));
			addata.put("Kind of Item", res);
			step="Item Title";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, data.get("Item Title")+"-"+DateUtil.getCurrentDateInRequiredDateFormat("ddMMyyyy hhmmss"));
			addata.put("Item Title", res);
			step="Price";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, data.get("Price"));
			addata.put("Price", res);
			step="Description";
			res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, step, objects_locatorType_marketplace, objects_objectType_marketplace, objects_objectLocator_marketplace, data.get("Description"));
			addata.put("Description", res);
			click_AddImageAndUpload(driver, refId, testcasename, workflow, data);
			click_Publish(driver, refId, testcasename, workflow);
			
			return addata;
		}
	}
		
		
}
