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


public class EXL_CorporateLensHomePage_CalendarEvent extends TestSuiteBase{

	private static String local_testcaseName=EXL_CorporateLensHomePage_CalendarEvent.class.getSimpleName();
	private static String workflow_contributor_addCalenderEvent="As Contributor || Add a Calendar Event-";
	private static String workflow_contributor_validate="As Contributor || Validate a Event in Calendar-";
	private static String workflow_contributor_validate_mywebpart="As Contributor || Validate a Event in Calendar Webpart-";
	
	private static String workflow_visitor_validate_mywebpart="As Visitor || Validate a Event in Calendar Webpart-";
	private static String workflow_contributoranothor_validate="As Another Contributor || Validate a Event in Calendar Webpart-";


	@Test(dataProviderClass=com.proj.util.DataProviders.class,dataProvider="getData_Global")
	public static void TestEXL_CorporateLensHomePage_CalendarEvent(Hashtable<String,String>data
			) throws Throwable{
		System.out.println("In test");
		logsObj.log("******************************************************");		
		logsObj.log("Executing the test case: "+testcaseName);		

		try{
			if(isBeforeMethodPass_corp==Constants_FRMWRK.FalseB){
				CustomExceptions.Exit(testcaseName, "Before Method-Failure", "Due to above error in the Before Method cannot execute the test..");
			}
			HashMap <String,String> returndata;	
			
			returndata=CorporatePortalHomePage.Calendar.AsContributor_AddCalendarEvent(driver_CORP, refID, local_testcaseName, workflow_contributor_addCalenderEvent, data);
			CorporatePortalHomePage.Calendar.AsContributor_Validate_Event_InCalendar(driver_CORP, refID, local_testcaseName, workflow_contributor_validate, returndata);
			Navigations_CorporateLens.navigateToBreadCrumPage_2(driver_CORP, local_testcaseName, workflow_contributor_validate, "Excelens Portal");
			CorporatePortalHomePage.Calendar.validate_Event_CalendarWebPart(driver_CORP, refID, testcaseName, workflow_contributor_validate_mywebpart, returndata);
			ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);
			
			//*****************************       VISITOR    ******************************************************************
			driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_Visitor, Constants_ConfigProperties.password_Visitor,refID);
			CorporatePortalHomePage.Calendar.validate_Event_CalendarWebPart(driver_CORP, refID, testcaseName, workflow_visitor_validate_mywebpart, returndata);
			
			//*****************************      Another CONTRIBUTOR    ******************************************************************
			driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_NonAdminUser, Constants_ConfigProperties.password_NonAdminUser,refID);
			CorporatePortalHomePage.Calendar.validate_Event_CalendarWebPart(driver_CORP, refID, testcaseName, workflow_contributoranothor_validate, returndata);
			
			
			/*
			if(data.get("Favourite Type").equalsIgnoreCase("Admin")){
				
				//*****************************       CONTRIBUTOR    ******************************************************************
				returndata=CorporatePortalHomePage.My_Favourites.AsContributor_AddAdminFavourite(driver_CORP, refID, local_testcaseName, workflow_contributor_create, data);
				//Navigations_CorporateLens.navigateToHome(driver_CORP);
				CorporatePortalHomePage.My_Favourites.validate_AdminFavouriteinHomePage(driver_CORP, refID, local_testcaseName, workflow_contributor_validate, returndata);
				ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);

				//*****************************       VISITOR    ******************************************************************
				driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_Visitor, Constants_ConfigProperties.password_Visitor,refID);

				CorporatePortalHomePage.My_Favourites.validate_AdminFavouriteinHomePage(driver_CORP, refID, local_testcaseName, workflow_visitor_validate, returndata);
				ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);

				//*****************************      Another CONTRIBUTOR    ******************************************************************
				driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_NonAdminUser, Constants_ConfigProperties.password_NonAdminUser,refID);
				CorporatePortalHomePage.My_Favourites.validate_AdminFavouriteinHomePage(driver_CORP, refID, local_testcaseName, workflow_contributoranothor_validate, returndata);
				
			}else{
				//*****************************       CONTRIBUTOR    ******************************************************************
				returndata=CorporatePortalHomePage.My_Favourites.AsOwner_AddMyFavourite(driver_CORP, refID, local_testcaseName, workflow_contributor_create_Myfavourite, data);
				CorporatePortalHomePage.My_Favourites.AsOwner_check_FavouriteinMyFavouritesWebPart(driver_CORP, refID, local_testcaseName, workflow_owner_validate_Myfavourite, returndata.get("Title"),data.get("Page Title"));
				ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);
				
				//*****************************       VISITOR    ******************************************************************
				driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_Visitor, Constants_ConfigProperties.password_Visitor,refID);
				CorporatePortalHomePage.My_Favourites.AsNotOwner_check_FavouriteinMyFavouritesWebPart(driver_CORP, refID, local_testcaseName, workflow_nonowner_validate_Myfavourite, returndata.get("Title"));
				
				//*****************************       VISITOR    ******************************************************************
				returndata=CorporatePortalHomePage.My_Favourites.AsOwner_AddMyFavourite(driver_CORP, refID, local_testcaseName, workflow_visitor_create_Myfavourite, data);
				CorporatePortalHomePage.My_Favourites.AsOwner_check_FavouriteinMyFavouritesWebPart(driver_CORP, refID, local_testcaseName, workflow_owner_validate_Myfavourite, returndata.get("Title"),data.get("Page Title"));
				ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);
				//*****************************      Another CONTRIBUTOR    ******************************************************************
				driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_NonAdminUser, Constants_ConfigProperties.password_NonAdminUser,refID);
				CorporatePortalHomePage.My_Favourites.AsNotOwner_check_FavouriteinMyFavouritesWebPart(driver_CORP, refID, local_testcaseName, workflow_nonowner_validate_Myfavourite, returndata.get("Title"));
				
			}*/
			

			logsObj.log(" after test of "+testcaseName+"-testresult"+isTestPass);

		}catch(Throwable t){
			CustomExceptions.final_catch_Reporting(driver_CORP,refID,t);			
		}

		TestExecutionUtil.AssertTestStatus(isTestPass);
	}

}
