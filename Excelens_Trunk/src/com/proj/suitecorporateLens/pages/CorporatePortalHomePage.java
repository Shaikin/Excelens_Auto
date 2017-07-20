package com.proj.suitecorporateLens.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.DateUtil;
import com.frw.util.Xls_Reader;
import com.proj.Constants.Constants;
import com.proj.library.KeyMethods;
import com.proj.suiteDOCS.pages.Documents_EntryPage;
import com.proj.suiteTRANSMITTALS.pages.Transmittals_EntryPage;
import com.proj.suitecorporateLens.TestSuiteBase;
import com.proj.util.CustomExceptions;
import com.proj.util.fetchObjectRepository;
import com.report.reporter.Reporting;

public class CorporatePortalHomePage extends TestSuiteBase{
	static String input="";	
	static String res ="";
	static String className=CorporatePortalHomePage.class.getSimpleName();
	private static Xls_Reader xlsReader_objects_cl=new Xls_Reader(Constants.OR_CL_Path);
	@SuppressWarnings("unused")
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
}
