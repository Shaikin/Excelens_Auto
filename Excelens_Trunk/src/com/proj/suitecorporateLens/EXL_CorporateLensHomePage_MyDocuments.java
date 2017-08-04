package com.proj.suitecorporateLens;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.frw.Constants.Constants_FRMWRK;
import com.frw.util.WaitUtil;
import com.proj.Constants.Constants_ConfigProperties;
import com.proj.library.commonMethods;
import com.proj.navigations.Navigations_CorporateLens;
import com.proj.suitecorporateLens.pages.CorporatePortalHomePage;
import com.proj.util.CustomExceptions;
import com.proj.util.TestExecutionUtil;
import com.proj.utilApp.ApplicationMethods;


public class EXL_CorporateLensHomePage_MyDocuments extends TestSuiteBase{

	private static String local_testcaseName=EXL_CorporateLensHomePage_MyDocuments.class.getSimpleName();
	private static String workflow_contributor_upload_corporatePortal="As Contributor/Owner || Upload a Document in Corporate Portal-";
	private static String workflow_contributor_upload_prolensPortal="As Contributor/Owner || Upload a Document in ProLens Portal-";
	private static String workflow_contributor_validate="As Contributor/Owner || Validate uploaded document in My Documents Webpart-";
//	private static String workflow_visitor_validate="As Visitor || Validate document uploaded by Other user in My Documents Webpart-";
	private static String workflow_contributoranothor_validate="As Another Contributor || Validate document uploaded by Other user in My Documents Webpart-";


	@Test(dataProviderClass=com.proj.util.DataProviders.class,dataProvider="getData_Global")
	public static void TestEXL_CorporateLensHomePage_MyDocuments(Hashtable<String,String>data
			) throws Throwable{
		System.out.println("In test");
		logsObj.log("******************************************************");		
		logsObj.log("Executing the test case: "+testcaseName);		

		try{
			if(isBeforeMethodPass_corp==Constants_FRMWRK.FalseB){
				CustomExceptions.Exit(testcaseName, "Before Method-Failure", "Due to above error in the Before Method cannot execute the test..");
			}
			String[] filename = null;
			if(data.get("SiteToUpload").contains("CorporateSite")){
				//*****************************       CONTRIBUTOR    ******************************************************************
				Hashtable<String, String> returnData=CorporatePortalHomePage.My_Documents.AsContributor_UploadADocument(data.get("SiteToUpload"),driver_CORP, refID, testcaseName, workflow_contributor_upload_corporatePortal, data);
				filename=returnData.get("Document Name").split("\\.");
				Navigations_CorporateLens.navigateToBreadCrumPage_2(driver_CORP, local_testcaseName, workflow_contributor_validate, "Excelens Portal");
				

			}else{
				Navigations_CorporateLens.Settings.navigateToSiteContents(driver_CORP, workflow_contributor_upload_prolensPortal);
				Navigations_CorporateLens.Settings.navigateToSubsite(driver_CORP, workflow_contributor_upload_prolensPortal, "prolens");
				commonMethods.switchToDefaultPage(driver_CORP);
				WaitUtil.pause(5);
				Hashtable<String, String> returnData=CorporatePortalHomePage.My_Documents.AsContributor_UploadADocument(data.get("SiteToUpload"),driver_CORP, refID, testcaseName, workflow_contributor_upload_corporatePortal, data);
				filename=returnData.get("Document Name").split("\\.");
				Navigations_CorporateLens.navigateToCorporatePortal(driver_CORP,workflow_contributor_upload_prolensPortal);
			}
			CorporatePortalHomePage.My_Documents.AsContributor_check_documentinMyDocumentsWebPart(driver_CORP, refID, testcaseName, workflow_contributor_validate, filename[0]);
			ApplicationMethods.logOutFromApplicationAndcloseBrowser(driver_CORP,refID,local_testcaseName);

			//*****************************      Another CONTRIBUTOR    ******************************************************************
			driver_CORP=ApplicationMethods.launchBrowserAndlogIntoApplication(browserName,Constants_ConfigProperties.corporateSiteName, Constants_ConfigProperties.username_NonAdminUser, Constants_ConfigProperties.password_NonAdminUser,refID);
			CorporatePortalHomePage.My_Documents.AsNotOwner_check_documentinMyDocumentsWebPart(driver_CORP, refID, local_testcaseName, workflow_contributoranothor_validate, filename[0]);


			logsObj.log(" after test of "+testcaseName+"-testresult"+isTestPass);

		}catch(Throwable t){
			CustomExceptions.final_catch_Reporting(driver_CORP,refID,t);			
		}

		TestExecutionUtil.AssertTestStatus(isTestPass);
	}

}
