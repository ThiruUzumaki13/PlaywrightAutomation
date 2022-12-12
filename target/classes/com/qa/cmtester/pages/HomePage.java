//$Id$
package com.qa.cmtester.pages;

import java.util.Random;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
	
private Page page;
Random random = new Random();
	
	//Private locators
	private String Start = "//button[@class='lyte-button lytePrimaryBtn']";
	private String Stop = "//lyte-yield[normalize-space()='Stop']";
	private String record ="//lyte-tab-title[@lt-prop-id='record-container']";
	private String intruder = "a[id='intruder'] span";
	private String options = "lyte-tab-title[lt-prop-id='options-container']";
	private String repeater ="#repeater";
	private String filter_dropdown = ".lyteDropPlaceholderNormal";
	private String save_to = "lyte-dropdown[class='cm-drpdwn inreq-saveto'] lyte-drop-button";
	private String auth_intruder  = "a[id='authintruder'] i[class='pcmicon-projects']";
	private String proxy = ".pcm-module-title";
	
	//Constructor
	public HomePage(Page page) {
		this.page = page;
	}

	// Page actions
		
	public String HomePageTitle() {
		return page.title();
	}
			
	public String InterceptStart(){
		page.click(filter_dropdown);
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("New Filter")).first().click();
		page.click(Start);
		page.onDialog(dialog ->{
			String text = dialog.message();
			dialog.accept();
		});
		//page.click(filter_dropdown);
		//page.getByText("Choose Filter").click();
		//page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("New Filter")).click();
		String text = page.textContent(Stop);
		return text;

	}
	public String InterceptStop() {
		page.click(Stop);
		String text = page.textContent(Start);
		return text;
	}
	
	public RecordPage navigateToRecord() {
		page.click(record);
		return new RecordPage(page);
	}
	
	
	
	public IntruderPage navigateToIntruder() {
		page.click(intruder);
		return new IntruderPage(page);
	}
	
	public OptionPage navigateToOption() {
		page.click(options);
		return new OptionPage(page);
			
	}
	 public RepeaterPage  navigateToRepeater() {
		 page.click(repeater);
		 return new RepeaterPage(page);
	 }
	 public void addToIntruder(){
		 page.click(save_to);
		 page.getByRole(AriaRole.OPTION,new Page.GetByRoleOptions().setName("Intruder")).click();
	 }

	 public AuthIntruderPage navigateToAuthIntruder() {
		 page.click(auth_intruder);
		 return new AuthIntruderPage(page);
	 }
	
}
	

