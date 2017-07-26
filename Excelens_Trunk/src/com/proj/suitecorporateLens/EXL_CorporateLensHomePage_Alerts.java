package com.proj.suitecorporateLens;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.frw.Constants.Constants_FRMWRK;
import com.proj.Constants.Constants_ConfigProperties;
import com.proj.suitecorporateLens.pages.CorporatePortalHomePage;
import com.proj.util.CustomExceptions;
import com.proj.util.TestExecutionUtil;
import com.proj.utilApp.ApplicationMethods;


public class EXL_CorporateLensHomePage_Alerts extends TestSuiteBase{

	private static String local_testcaseName=EXL_CorporateLensHomePage_Alerts.class.getSimpleName();
	private static String workflow_contributor_create="As Contributor || Create a new Alert-";
	private static String workflow_contributor_validate="As Contributor || Alert-";
	private static String workflow_visitor_validate="As Visitor || Alert-";
	private static String workflow_contributoranothor_validate="As Another Contributor || Alert-";
	private static String workflow_AlertStatus="";	
	private static String workflow_end=" || ";	

	@Test(dataProviderClass=com.proj.util.DataProviders.class,dataProvider="getData_Global")
	public static void TestEXL_CorporateLensHomePage_Alerts(Hashtable<String,String>data
			) throws Throwable{
		System.out.println("In test");
		logsObj.log("******************************************************");		
		logsObj.log("Executing the test case: "+testcaseName);		

		try{
			if(isBeforeMethodPass_corp==Constants_FRMWRK.FalseB){
				CustomExceptions.Exit(testcaseName, "Before Method-Failure", "Due to above error in the Before Method cannot execute the test..");
			}
			workflow_AlertStatus=data.get("Status")+workflow_end;
			
			//*****************************       CONTRIBUTOR    ******************************************************************
			Hashtable <String,String> returndata=CorporatePortalHomePage.Alerts.AsContributor_CreateAlert(driver_CORP, refID, local_testcaseName, workflow_contributor_create+workflow_AlertStatus, data);
			CorporatePortalHomePage.Alerts.vaidate_AlertInHomePage(driver_CORP, refID, local_testcaseName, workflow_contributor_validate+workflow_AlertStatus, returndata, data);
			ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);
			
			//*****************************       VISITOR    ******************************************************************
			driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_Visitor, Constants_ConfigProperties.password_Visitor,refID);
			
			CorporatePortalHomePage.Alerts.vaidate_AlertInHomePage(driver_CORP, refID, local_testcaseName, workflow_visitor_validate+workflow_AlertStatus, returndata, data);
			ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);
			
			//*****************************      Another CONTRIBUTOR    ******************************************************************
			driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_NonAdminUser, Constants_ConfigProperties.password_NonAdminUser,refID);
			CorporatePortalHomePage.Alerts.vaidate_AlertInHomePage(driver_CORP, refID, local_testcaseName, workflow_contributoranothor_validate+workflow_AlertStatus, returndata, data);
			
			
			
			logsObj.log(" after test of "+testcaseName+"-testresult"+isTestPass);

		}catch(Throwable t){
			CustomExceptions.final_catch_Reporting(driver_CORP,refID,t);			
		}

		TestExecutionUtil.AssertTestStatus(isTestPass);
	}

}
