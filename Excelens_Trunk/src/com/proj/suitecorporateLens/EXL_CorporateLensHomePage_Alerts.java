package com.proj.suitecorporateLens;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.frw.Constants.Constants_FRMWRK;
import com.proj.Constants.Constants_ConfigProperties;
import com.proj.Constants.Constants_Workflow;
import com.proj.navigations.Navigations_CorporateLens;
import com.proj.suiteTRANSMITTALS.workflows.Workflows;
import com.proj.suitecorporateLens.pages.CorporatePortalHomePage;
import com.proj.suitecorporateLens.pages.SiteContents;
import com.proj.util.CustomExceptions;
import com.proj.util.TestExecutionUtil;
import com.proj.utilApp.ApplicationMethods;


public class EXL_CorporateLensHomePage_Alerts extends TestSuiteBase{

	static Hashtable<String,String>transmittalData=new Hashtable<String,String>();
	private static String workflow_l1="Create a new Alert";
	private static String workflow_l2="Level-2:- ";	
	private static String workflow_end=" || ";

	private static String username2;
	private static String password2;


	

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
			/*Navigations_CorporateLens.Settings.navigateToSiteContents(driver_CORP, workflow_l1);
			SiteContents.clickAlertsLibrary(driver_CORP, workflow_l1);
			SiteContents.clicknewItem(driver_CORP, workflow_l1);
			Hashtable <String,String> returndata=CorporatePortalHomePage.createAlert(driver_CORP, testcaseName, refID, workflow_l1, data);
			System.out.println(returndata);*/
			
		/*	if(data.get("RecieverRole").equalsIgnoreCase(Constants_Workflow.role_admin)){
				username2 = Constants_ConfigProperties.username_BusinessOwner;
				password2 = Constants_ConfigProperties.password_BusinessOwner;
			}else{
				username2 = Constants_ConfigProperties.username_NonAdminUser;
				password2 = Constants_ConfigProperties.password_NonAdminUser;
			}

			
			String siteName=ApplicationMethods.getSiteName(Constants_ConfigProperties.testSiteName);
			String condition="";
			condition=" ["+data.get("RecieverRole")+"-"+data.get("Action-Level2")+"]";

			//************************************** LEVEL 1 *****************************************************************************
			String workflow_lvl1=workflow_l1+condition+workflow_end;		

			transmittalData=Workflows.Level1_Initaite_Transmittal(driver_TRANS, Constants_ConfigProperties.testSiteName, workflow_lvl1, data);

			//************************************** LEVEL 2 *****************************************************************************		
			driver_TRANS=Workflows.Level2_Close_Cancel_Transmittal(siteName,Constants_Workflow.page_actionRequired,driver_TRANS,refID,testcaseName,workflow_l2,condition,workflow_end,Constants_ConfigProperties.testSiteName,browserName,username2, password2, transmittalData, data);
			*/
			
			logsObj.log(" after test of "+testcaseName+"-testresult"+isTestPass);

		}catch(Throwable t){
			CustomExceptions.final_catch_Reporting(driver_CORP,refID,t);			
		}

		TestExecutionUtil.AssertTestStatus(isTestPass);
	}

}
