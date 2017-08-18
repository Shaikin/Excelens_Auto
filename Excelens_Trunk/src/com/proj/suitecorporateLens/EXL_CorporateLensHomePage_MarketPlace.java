package com.proj.suitecorporateLens;

import java.util.HashMap;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.frw.Constants.Constants_FRMWRK;
import com.proj.Constants.Constants_ConfigProperties;
import com.proj.navigations.Navigations_CorporateLens;
import com.proj.suitecorporateLens.pages.CorporatePortalHomePage;
import com.proj.util.CustomExceptions;
import com.proj.util.TestExecutionUtil;
import com.proj.utilApp.ApplicationMethods;


public class EXL_CorporateLensHomePage_MarketPlace extends TestSuiteBase{

	private static String local_testcaseName=EXL_CorporateLensHomePage_MarketPlace.class.getSimpleName();
	private static String workflow_contributor_add="As Contributor || Post an Ad in Marketplace-";
	private static String workflow_contributor_validate="As Contributor/Owner || Marketplace item -";
	private static String workflow_contributor_validate_webpart="As Contributor/Owner || Marketplace item in Marketplace Webpart-";
	private static String workflow_visitor_validate="As Visitor || Marketplace item in Webpart-";
	private static String workflow_contributoranothor_validate="As Another Contributor || Marketplace item in Marketplace Webpart-";
	

	@Test(dataProviderClass=com.proj.util.DataProviders.class,dataProvider="getData_Global")
	public static void TestEXL_CorporateLensHomePage_MarketPlace(Hashtable<String,String>data
			) throws Throwable{
		System.out.println("In test");
		logsObj.log("******************************************************");		
		logsObj.log("Executing the test case: "+testcaseName);		

		try{
			if(isBeforeMethodPass_corp==Constants_FRMWRK.FalseB){
				CustomExceptions.Exit(testcaseName, "Before Method-Failure", "Due to above error in the Before Method cannot execute the test..");
			}
			
			//*****************************       CONTRIBUTOR    ******************************************************************
			HashMap<String, String> returnData=CorporatePortalHomePage.MarketPlace.AsContributor_PostAddInMarketplace(driver_CORP, refID, local_testcaseName, workflow_contributor_add, data);
			CorporatePortalHomePage.MarketPlace.Validate_Marketplace_Ad(driver_CORP, refID, local_testcaseName, workflow_contributor_validate, returnData);
			Navigations_CorporateLens.navigateToHome(driver_CORP);
			CorporatePortalHomePage.MarketPlace.Validate_Marketplace_Ad_Webpart(driver_CORP, refID, testcaseName, workflow_contributor_validate_webpart, returnData);
			ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);
			
			//*****************************       VISITOR    ******************************************************************
			driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_Visitor, Constants_ConfigProperties.password_Visitor,refID);
			CorporatePortalHomePage.MarketPlace.Validate_Marketplace_Ad_Webpart(driver_CORP, refID, testcaseName, workflow_visitor_validate, returnData);
			ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);
			
			//*****************************      Another CONTRIBUTOR    ******************************************************************
			driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_NonAdminUser, Constants_ConfigProperties.password_NonAdminUser,refID);
			CorporatePortalHomePage.MarketPlace.Validate_Marketplace_Ad_Webpart(driver_CORP, refID, testcaseName, workflow_contributoranothor_validate, returnData);
			
			logsObj.log(" after test of "+testcaseName+"-testresult"+isTestPass);

		}catch(Throwable t){
			CustomExceptions.final_catch_Reporting(driver_CORP,refID,t);			
		}

		TestExecutionUtil.AssertTestStatus(isTestPass);
	}

}
