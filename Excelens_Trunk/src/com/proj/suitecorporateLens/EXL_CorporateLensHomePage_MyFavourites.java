package com.proj.suitecorporateLens;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.frw.Constants.Constants_FRMWRK;
import com.proj.Constants.Constants_ConfigProperties;
import com.proj.suitecorporateLens.pages.CorporatePortalHomePage;
import com.proj.util.CustomExceptions;
import com.proj.util.TestExecutionUtil;
import com.proj.utilApp.ApplicationMethods;


public class EXL_CorporateLensHomePage_MyFavourites extends TestSuiteBase{

	private static String local_testcaseName=EXL_CorporateLensHomePage_MyFavourites.class.getSimpleName();
	private static String workflow_contributor_create="As Contributor || Create a new Admin Favourite-";
	private static String workflow_contributor_validate="As Contributor || Manage My Favourites:Admin Favourite-";
	private static String workflow_visitor_validate="As Visitor || Manage My Favourites:Admin Favourite-";
	private static String workflow_contributoranothor_validate="As Another Contributor || Manage My Favourites:Admin Favourite-";

	private static String workflow_contributor_create_Myfavourite="As Contributor || Create a new My Favourite-";
	private static String workflow_owner_validate_Myfavourite="As Owner || Validate Favourite in My Favourites Webpart-";
	private static String workflow_nonowner_validate_Myfavourite="As Non Owner || Validate Favourite in My Favourites Webpart-";
	
	private static String workflow_visitor_create_Myfavourite="As Visitor || Create a new My Favourite-";

	@Test(dataProviderClass=com.proj.util.DataProviders.class,dataProvider="getData_Global")
	public static void TestEXL_CorporateLensHomePage_MyFavourites(Hashtable<String,String>data
			) throws Throwable{
		System.out.println("In test");
		logsObj.log("******************************************************");		
		logsObj.log("Executing the test case: "+testcaseName);		

		try{
			if(isBeforeMethodPass_corp==Constants_FRMWRK.FalseB){
				CustomExceptions.Exit(testcaseName, "Before Method-Failure", "Due to above error in the Before Method cannot execute the test..");
			}
			Hashtable <String,String> returndata;	

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
				
			}
			

			logsObj.log(" after test of "+testcaseName+"-testresult"+isTestPass);

		}catch(Throwable t){
			CustomExceptions.final_catch_Reporting(driver_CORP,refID,t);			
		}

		TestExecutionUtil.AssertTestStatus(isTestPass);
	}

}
