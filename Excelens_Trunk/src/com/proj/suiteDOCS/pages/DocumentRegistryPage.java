package com.proj.suiteDOCS.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.frw.util.PageLoadWaitUtil;
import com.frw.util.WaitUtil;
import com.proj.Constants.Constants;
import com.proj.Constants.Constants_TimeOuts;
import com.proj.Constants.Constants_Workflow;
import com.proj.library.commonMethods;
import com.proj.navigations.Navigations_CorporateLens;
import com.proj.objectRepository.ObjRepository;
import com.proj.suiteDOCS.TestSuiteBase;
import com.proj.suiteDOCS.reusables.DocumentRegisterGridUtil;
import com.proj.utilApp.ToolbarsUtil;
import com.proj.utilApp.WebTableUtil;

public class DocumentRegistryPage extends TestSuiteBase{
	
	public static void selectADocument(WebDriver driver,String workflow,Hashtable<String,String>data) throws Throwable{
		Navigations_CorporateLens.navigateToDocumentRegister(driver);
		DocumentRegisterGridUtil.searchDocumentAndTickRecord(driver, workflow, data.get("AttachDocumentName"));		
	}

	
	public static void sendTransmittal(WebDriver driver,String workFlow) throws Throwable{
		try{
			PageLoadWaitUtil.waitForPageToLoad(driver);
		}catch (Exception ex){
			
		}		
		ToolbarsUtil.clickItems(driver, workFlow);
		WaitUtil.pause(Constants_TimeOuts.Save_TimeOut);
		ToolbarsUtil.Items.clickSendTranmittals(driver, workFlow);
	}
	
	
	public static String searchDocumentAndCheck_Status(WebDriver driver,String page,String workflow,String documentName,String status) throws Throwable{
		return WebTableUtil.searchforDataInsearchColumnAndValidateDataInactionableColumn(driver, testcaseName, workflow+" "+page+" - Approval Status", ObjRepository.container_documentRegister, documentName, status, 4, 6);
	}
	
	public static void docRegister_searchDocumentAndCheck_Status(WebDriver driver,String page,String workflow,String documentName,String approvalStatus) throws Throwable{
		
		WebTableUtil.searchforDataInsearchColumnAndValidateDataInactionableColumn(driver, testcaseName, workflow+" "+page+" - Approval Status", ObjRepository.container_documentRegister, documentName, approvalStatus, 4, 6);
		WebTableUtil.searchforDataInsearchColumnAndValidateDataInactionableColumn(driver, testcaseName, workflow+" "+page+" - Modified Date", ObjRepository.container_documentRegister, documentName, "minute", 4, 10);
	}
	
	public static void documentRegister_document_ApprovalStatus(WebDriver driver,String workflow,String docs,String approvalStatus) throws Throwable{
		if(docs.contains(Constants.delimiter_data)){
			String [] doc=commonMethods.splitString(docs, Constants.delimiter_data);

			for(int eachDoc=0;eachDoc<doc.length;eachDoc++){
				DocumentRegistryPage.docRegister_searchDocumentAndCheck_Status(driver, Constants_Workflow.page_documentRegister, workflow, doc[eachDoc], approvalStatus);
			}
		}else{
			DocumentRegistryPage.docRegister_searchDocumentAndCheck_Status(driver, Constants_Workflow.page_documentRegister, workflow, docs, approvalStatus);
		}
		
	}
	
	public static void documentRegister_AttachdocumentAndSupportDocument_ApprovalStatus(WebDriver driver,String workflow,String attachdocs,String supportdocs,String attachdocs_approvalStatus,String supportdocs_approvalStatus) throws Throwable{
		Navigations_CorporateLens.navigateToDocumentRegister(driver);
		
		documentRegister_document_ApprovalStatus(driver, workflow+"-Attached Document", attachdocs, attachdocs_approvalStatus);
		documentRegister_document_ApprovalStatus(driver, workflow+"-Support Document", supportdocs, supportdocs_approvalStatus);
		
		/*if(!attachdocs.contains(Constants.delimiter_data)){
			String [] doc=commonMethods.splitString(attachdocs, Constants.delimiter_data);

			for(int eachDoc=0;eachDoc<doc.length;eachDoc++){
				DocumentRegistryPage.documentRegister_document_ApprovalStatus(driver, Constants_Workflow.page_documentRegister, workflow, doc[eachDoc], attachdocs_approvalStatus);
				
			}
		}else{
			DocumentRegistryPage.documentRegister_document_ApprovalStatus(driver, Constants_Workflow.page_documentRegister, workflow, attachdocs, attachdocs_approvalStatus);
		}
		
		if(!supportdocs.contains(Constants.delimiter_data)){
			String [] doc=commonMethods.splitString(supportdocs, Constants.delimiter_data);

			for(int eachDoc=0;eachDoc<doc.length;eachDoc++){
				DocumentRegistryPage.documentRegister_document_ApprovalStatus(driver, Constants_Workflow.page_documentRegister, workflow, doc[eachDoc], supportdocs_approvalStatus);
			}
		}else{
			DocumentRegistryPage.navigateToDocRegister_searchDocumentAndCheck_Status(driver, Constants_Workflow.page_documentRegister, workflow, supportdocs, supportdocs_approvalStatus);
		}*/
		
	}
	
}
