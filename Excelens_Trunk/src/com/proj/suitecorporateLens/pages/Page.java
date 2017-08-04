package com.proj.suitecorporateLens.pages;





import java.util.HashMap;
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
import com.proj.suiteDOCS.TestSuiteBase;
import com.proj.suiteDOCS.pages.Documents_EntryPage;
import com.proj.suiteTRANSMITTALS.pages.Transmittals_EntryPage;
import com.proj.util.CustomExceptions;
import com.proj.util.fetchObjectRepository;
import com.proj.utilApp.ApplicationMethods;
import com.report.reporter.Reporting;

public class Page extends TestSuiteBase {

	static String input="";	
	static String res ="";
	
	static String className=Page.class.getSimpleName();
	private static Xls_Reader xlsReader_objects_Settings=new Xls_Reader(Constants.OR_Settings_Path);
	
	private static Hashtable<String,String>objects_step_page=null;
	private static Hashtable<String,String>objects_locatorType_page=null; 
	private static Hashtable<String,String>objects_objectType_page=null;
	private static Hashtable<String,String>objects_objectLocator_page=null;

	static {		
		logsObj.log("fetchExcelobjects method triggred for Class "+className);
		try {
			fetchObjectRepository.getObjects(Page.class,  xlsReader_objects_Settings, "Objects_Page", "page");
		} catch (Throwable e) {
			e.printStackTrace();
			Reporting.logStep("Excel Object Initialization - "+className, "Required Objects for "+className+" are not  initialized due to error-"+e.getStackTrace(), Constants_FRMWRK.Fail);
		}
	}
		
	public static String enterPageName(WebDriver driver,String refID, String testcasename,String workflow,String pageName) throws Throwable{
		ApplicationMethods.switchToLatestDLGframe(driver,testcasename);
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Page Name", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, pageName);
		
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Page Name")+"- Failure", "Please refer above details for more details");
		}	
		return res;
	}
	
	public static String clickCreate(WebDriver driver,String refID, String testcasename,String workflow) throws Throwable{
		ApplicationMethods.switchToLatestDLGframe(driver,testcasename);
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Create", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Create")+"- Failure", "Please refer above details for more details");
		}	
		return res;
	}
	
	public static String clickInsert(WebDriver driver,String refID, String testcasename,String workflow) throws Throwable{
		ApplicationMethods.switchToLatestDLGframe(driver,testcasename);
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Insert", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Insert")+"- Failure", "Please refer above details for more details");
		}	
		return res;
	}
	public static String clickSavepage(WebDriver driver,String refID, String testcasename,String workflow) throws Throwable{
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Page-Save", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);

		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Page-Save")+"- Failure", "Please refer above details for more details");
		}	
		return res;
	}
	public static String clickCheckItIn(WebDriver driver,String refID, String testcasename,String workflow) throws Throwable{
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Check it in", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);

		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Check it in")+"- Failure", "Please refer above details for more details");
		}	
		return res;
	}
	public static String clickPublishIt(WebDriver driver,String refID, String testcasename,String workflow) throws Throwable{
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Publish it", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);

		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Publish it")+"- Failure", "Please refer above details for more details");
		}	
		return res;
	}
	public static void CheckInDetails(WebDriver driver,String refID, String testcasename,String workflow,String comments) throws Throwable{
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Check it -Comments", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, comments);

		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Check it -Comments")+"- Failure", "Please refer above details for more details");
		}	
		WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Check it -Continue", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, comments);
		
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Check it -Continue")+"- Failure", "Please refer above details for more details");
		}	
		
	}
	
	public static String checkImage(WebDriver driver,String refID, String testcasename,String workflow,String imageName) throws Throwable{
		ApplicationMethods.switchToLatestDLGframe(driver,testcasename);
		String[] image=commonMethods.splitString(imageName, "\\.");
		String locator_default=objects_objectLocator_page.get("Check Image");
		String locator=objects_objectLocator_page.get("Check Image");
		locator=commonMethods.replaceString("imageName", locator, image[0]);
		objects_objectLocator_page.put("Check Image",locator );
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Check Image", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		objects_objectLocator_page.put("Check Image",locator_default );
		return res;
	}
	
	public static String SelectImage(WebDriver driver,String refID, String testcasename,String workflow,String imageName) throws Throwable{
		ApplicationMethods.switchToLatestDLGframe(driver,testcasename);
		String[] image=commonMethods.splitString(imageName, "\\.");
		String locator_default=objects_objectLocator_page.get("Select Image");
		String locator=objects_objectLocator_page.get("Select Image");
		locator=commonMethods.replaceString("imageName", locator, image[0]);
		objects_objectLocator_page.put("Select Image",locator );
		
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Select Image", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		objects_objectLocator_page.put("Select Image",locator_default );
		return res;
	}
	public static void check_PageTile(WebDriver driver,String refID, String testcasename,String workflow,String tileName) throws Throwable{
		String locator_default=objects_objectLocator_page.get("Page-Tile");
		String locator=objects_objectLocator_page.get("Page-Tile");
		locator=commonMethods.replaceString("tileName", locator, tileName);
		objects_objectLocator_page.put("Page-Tile",locator );
		
		commonMethods.switchToDefaultPage(driver);
		res=KeyMethods.f_performAction(driver, refID, testcasename, workflow, "Page-Tile", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		objects_objectLocator_page.put("Page-Tile",locator_default );
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Page-Tile")+"- Failure", "Please refer above details for more details");
		}	
	}
	public static HashMap<String,String> PageDetails(WebDriver driver,String refId,String testcasename,String workflow,Hashtable<String,String>data,String title ) throws Throwable{
		HashMap<String,String> newsCarouselPageData=new HashMap<String,String>();
		res=KeyMethods.f_fetchElementDetails(driver, refId, testcasename, workflow, objects_step_page.get("Title"), objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, title);
		if(res.equals(Constants_FRMWRK.False)){
			CustomExceptions.Exit(testcasename, objects_step_page.get("Title")+"- Failure", "Please refer above details for more details");
		}
		newsCarouselPageData.put("Title", res);
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Summary", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Summary"));
		newsCarouselPageData.put("Summary", res);
		
		String dueDate=DateUtil.getCurrentDateInRequiredDateFormat("dd/MM/yyyy");
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Date", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, dueDate);
		
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Image Caption", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Caption"));
		
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Click here to add Content", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Content", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Content"));
		
		
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Article Image", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Browse", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		ApplicationMethods.waitForOverlayToDisappear(driver);
		WaitUtil.pause(Constants_TimeOuts.generic_TimeOut);
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Add Image from Local", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
		Transmittals_EntryPage.waitInvisiblilityofWorkingTitle(driver);
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
		WaitUtil.pause(Constants_TimeOuts.sync_element_load);
		String fileName=Constants.DataFileLocation_CorporateLens+data.get("Choose a file");
		Documents_EntryPage.browseAFile(driver, refId, testcasename, workflow, fileName);
		Documents_EntryPage.clickOK(driver, refId, testcasename, workflow);
		Documents_EntryPage.clickSave(driver, refId, testcasename, workflow);
		
		if(!checkImage(driver, refId, testcasename, workflow,data.get("Choose a file")).equalsIgnoreCase(Constants_FRMWRK.False)){
			SelectImage(driver, refId, testcasename, workflow,data.get("Choose a file"));
			clickInsert(driver, refId, testcasename, workflow);
		}else{
			ApplicationMethods.closeAllDialogswithCancel(driver, refId, testcasename);
		}
		WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
		ApplicationMethods.switchToLatestDLGframe(driver, testcasename);
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Browsed Image Path", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, input);
		newsCarouselPageData.put("Browsed Image Path", res);
		Documents_EntryPage.clickOK(driver, refId, testcasename, workflow);
		
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Tag", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Tag"));
		
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Article Type", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Article Type"));
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Enable Likes", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Enable Likes"));
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Enable Comments", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Enable Comments"));
		res=KeyMethods.f_performAction(driver, refId, testcasename, workflow, "Make Article featured?", objects_locatorType_page, objects_objectType_page, objects_objectLocator_page, data.get("Make Article featured?"));
		clickSavepage(driver, refId, testcasename, workflow);
		WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
		clickCheckItIn(driver, refId, testcasename, workflow);
		CheckInDetails(driver, refId, testcasename, workflow, data.get("Check it -Comments"));
		WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
		clickPublishIt(driver, refId, testcasename, workflow);
		
		return newsCarouselPageData;
	}
	
	
}










