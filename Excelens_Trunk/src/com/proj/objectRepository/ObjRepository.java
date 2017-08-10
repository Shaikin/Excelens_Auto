package com.proj.objectRepository;

public class ObjRepository {
	
	//0365 login objects
	public static String textbox_login_UserName=".//*[@id='cred_userid_inputtext']";
	public static String textbox_login_Password=".//*[@id='cred_password_inputtext']";	
	public static String button_login_Signin=".//*[@id='cred_sign_in_button']";
	public static String button_login_OtherUserLink=".//*[@id='use_another_account_link']";
	public static String logo_homepage_exelens=".//*[@id='ctl00_pmTopNav']";
	// Login page objects	
	/*public static String textbox_login_UserName="logon:username:input";
	public static String textbox_login_Password="logon:userPassword:input";	
	public static String button_login_LoginBeforeCredentials=".//*[@class='realme_button_padding']";
	public static String button_login_Login="logon:logon";	*/
	
	
	//Homepage
	public static String homePage_element=".//*[@name='onetidHeadbnnr0']";
	
	//Overlays
	public static String heading_working=".//*[@title='Working on it...']";
	public static String overlay_working=".//*[text()='Working on it...']";
	public static String spinner_pleasewait="//*[@class='loader']";

	//logout objects
	//public static String link_user="zz5_Menu";
	public static String menu_logout="zz5_Menu";
	public static String link_user=".//*[@id='O365_MeFlexPane_ButtonID']";
	public static String link_signOut=".//*[@class='_fc_4 o365buttonLabel' and text()='Sign out']";

	//frame objects	
	public static String frame_single=".//iframe[contains(@id,'DlgFrame')]";	
	public static String frame_double="(.//iframe[contains(@id,'DlgFrame')])[2]";
	public static String frame_list_pattern="(.//iframe[contains(@id,'DlgFrame')])[framelist]";
	public static String frame_documentList=".//iframe[contains(@class,'doc-lib-view-frame')]";
	//choice objects
	public static String choice_select=".//*[@title='Add the highlighted item to this field']";
	public static String choice_ok=".//*[contains(@id,'OkButton')]";
	public static String choice_prvpage=".//*[@title='Previous Page']";
	
	
	//popup Objects
	
	//autosuggest text box item objects
	public static String js_autosuggest_input="/../input[2]";
	public static String js_autosuggest_items="/../div/ul/li/a/div";
	public static String js_dropdown_items="//div[@class='option']/div";

	//Grid Container
	public static String container_subMenu="//*[@class='ui popup inverted right center']";
	public static String container_transmittals="Transmittals";
	public static String container_documentRegister="Document Register";
	public static String container_transmittalFiles="transmittalFiles";
	public static String container_supportingDocumentFiles="supportingDocumentFiles";
	public static String container_actions="txActionListTbl";
	public static String container_uploadedOrNewDocuments="Documents";
	public static String container_AdminFavourites="Admin Favourites";
	public static String container_Announcements="Announcements";
	public static String grid_nextButton= ".//*[contains(@id,'next')]/a" ; //".//*[@id='pagingWPQ2next']/a";
	
	
	//close and cancel
	public static String icon_close="//*[@title='Close dialog']";
	public static String button_cancel="//*[@name='cancel']";
	public static String button_close=".//*[@class='close' and @value='Close']";
	
	
	//Cookies popup
	


	//session timeout objects

	//Page titles
	public static final String pageTile_transmittals_inbox=".//*[text()='Transmittals - My Inbox']";
	public static final String pageTile_transmittals_mysent=".//*[text()='Transmittals - My Sent']";
	public static final String pageTile_transmittals_overdue=".//*[text()='Transmittals - Actions Overdue']";
	public static final String pageTile_transmittals_actionRequired=".//*[text()='Transmittals - Action Required']";
	public static final String pageTile_DocumentRegister=".//*[text()='Document Register']";
	public static final String pageTile_siteContents=".//*[text()='Site contents']";
	public static final String pageTile_Alerts=".//*[text()='Alerts']";

	//Search components 
	public static String search_inlineSearch=".//*[@id='inplaceSearchDiv_WPQ1_lsinput']";

}
