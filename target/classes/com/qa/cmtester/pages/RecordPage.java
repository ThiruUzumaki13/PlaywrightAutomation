//$Id$
package com.qa.cmtester.pages;


import com.microsoft.playwright.Page;
import java.util.logging.Logger;
import com.microsoft.playwright.options.AriaRole;

public class RecordPage {

private Page page;
	
	//Private locators
private static final Logger logger = Logger.getLogger(RecordPage.class.getName());
	private String NewRecord = "button[type='button']";
	private String NewRecordName = "#nr_name";
	private String ChooseFilter = ".lyteDropPlaceholderNormal";
	private String CreateRecord = "cm-primary-button[name='Create'] lyte-yield[yield-name='text']";
	private String SelectRecord = ".pcm-item[lt-prop-value='new dsda']";
	private String Stop = "button[class='lyte-button lytePrimaryBtn'] lyte-yield[yield-name='text']";
	private String Intercept = "lyte-tab-title[lt-prop-id='intercept-container']";
	private String record ="//lyte-tab-title[@lt-prop-id='record-container']";
	private String addFilter = ".lyteDropPlaceholderNormal";
	private String menu = "#recmrmu";
	private String repeater_name = "#rr_name";
	private String save_as_rep = "//lyte-menu-label[normalize-space()='Save as Repeater']";
	//Constructor
	public RecordPage(Page page) {
		this.page = page;
	}
	
	
	//Page actions
	
	public String getRecPageTitle() {
		return page.title();
	}
	public String CreateNewRecord() {
		page.click(NewRecord);
		page.fill(NewRecordName, "New Record");
		page.click(addFilter);
		page.getByRole(AriaRole.OPTION,new Page.GetByRoleOptions().setName("New Filter")).first().click();
		page.click(CreateRecord);
		logger.info("Record started");
		String txt = "Record created successfully";
		return txt;
}
	
	public String StopRecord() {
		page.click(Intercept);
		page.click(record);
		page.locator("lyte-td:has-text(\"New Record\")").first().click();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Stop")).click();
	    String txt = "Success! Record was stopped";
	    logger.info("Record stopped");
	    return txt;
	}
	  
	 public void saveAsRepeater() {
		 page.click(menu);
		 page.click(save_as_rep);
		 page.fill(repeater_name,"New Repeater");
		 page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
		 logger.info("Record Saved to repeater");
	 }
	 
	 
}
