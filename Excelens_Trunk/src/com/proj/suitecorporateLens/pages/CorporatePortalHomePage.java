package com.proj.suitecorporateLens.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.DateUtil;
import com.frw.util.WaitUtil;
import com.frw.util.Xls_Reader;
import com.proj.Constants.Constants;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.library.KeyMethods;
import com.proj.library.commonMethods;
import com.proj.navigations.Navigations_CorporateLens;
import com.proj.suiteDOCS.pages.Documents_EntryPage;
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
	

	static {		
		logsObj.log("fetchExcelobjects method triggred for Class "+className);
		try {
			fetchObjectRepository.getObjects(CorporatePortalHomePage.class,  xlsReader_objects_cl, "Objects_Alerts", "alerts");
			
		} catch (Throwable e) {
			e.printStackTrace();
			Reporting.logStep("Excel Object Initialization - "+className, "Required Objects for "+className+" are not  initialized due to error-"+e.getStackTrace(), Constants_FRMWRK.Fail);
          //Reporting.logStep(driver, workflow+" "+page+" - Transmittal ID", "Transmittal ID :-"+res+" is displayed for the record "+subject, Constants_FRMWRK.Pass);    
		}
	}

	
	public static Hashtable<String,String> createAlert(WebDriver driver,String testcasename,String refid,String workFlow,Hashtable<String,String>data) throws Throwable{
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
	
	public static void validate_alert(WebDriver driver,String refid,String testcasename,String workflow,Hashtable<String,String>alertDetails) throws Throwable{
		
		String locator_alert_notification_default=objects_objectLocator_alerts.get("Alerts-Notification");
		String locator_alert_notification=objects_objectLocator_alerts.get("Alerts-Notification");
		locator_alert_notification=commonMethods.replaceString("status", locator_alert_notification, alertDetails.get("Alerts-Status").toLowerCase());
		locator_alert_notification=commonMethods.replaceString("alertName", locator_alert_notification, alertDetails.get("Alerts-Title"));
		
		objects_objectLocator_alerts.put("Alerts-Notification", locator_alert_notification);
		objects_objectLocator_alerts.put("Alerts-Notification-displayed", locator_alert_notification);
		
		res=KeyMethods.f_fetchElementDetails(driver, refid, testcasename, workflow, objects_step_alerts.get("Alerts-Notification"), objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, alertDetails.get("Alerts-Title"));
		objects_objectLocator_alerts.put("Alerts-Notification", locator_alert_notification_default);
		
	}
	
	public static void validate_alert_color(WebDriver driver,String refid,String testcasename,String workflow,Hashtable<String,String>alertData) throws Throwable{
		String locator_alert_notification_tag_default=objects_objectLocator_alerts.get("Alerts-Notification-Tag");
		
		String locator_alert_notification_tag=objects_objectLocator_alerts.get("Alerts-Notification-displayed")+objects_objectLocator_alerts.get("Alerts-Notification-Tag");
				
		objects_objectLocator_alerts.put("Alerts-Notification-Tag", locator_alert_notification_tag);
				
		//Include key as WebElement_Background color in f_fetchelements
		res=KeyMethods.f_fetchElementDetails(driver, refid, testcasename, workflow, objects_step_alerts.get("Alerts-Notification-Tag"), objects_locatorType_alerts, objects_objectType_alerts, objects_objectLocator_alerts, alertData.get("Color"));
		
		objects_objectLocator_alerts.put("Alerts-Notification-Tag", locator_alert_notification_tag_default);
	}
	
	//===============================================================================================================
	// 							                            ALERTS 
	//===============================================================================================================
	
	public static class Alerts{
		
		public static Hashtable<String,String> AsContributor_CreateAlert(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data ) throws Throwable{
			Navigations_CorporateLens.Settings.navigateToSiteContents(driver, workflow);
			SiteContents.clickAlertsLibrary(driver, workflow);
			SiteContents.clicknewItem(driver, workflow);
			Hashtable <String,String> alertdata=CorporatePortalHomePage.createAlert(driver, testcasename, refId, workflow, data);
			WaitUtil.pause(Constants_TimeOuts.processToAlert);
			return alertdata;
		}
		
		public static void vaidate_AlertInHomePage(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>alertData,Hashtable<String,String>alerttestData) throws Throwable{
			Navigations_CorporateLens.navigateToHome(driver);
			CorporatePortalHomePage.validate_alert(driver, refId, testcasename, workflow, alertData);
			WaitUtil.pause(Constants_TimeOuts.processToAlert);
			CorporatePortalHomePage.validate_alert_color(driver, refId, testcasename, workflow, alerttestData);
		}
		
	}
}
