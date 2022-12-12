//$Id$
package com.qa.cmtester.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.options.AriaRole;
import com.qa.cmtester.constants.AppConstants;

public class AuthIntruderPage {
	Page page;
	
	
	private String create_authIntr = "div[class='pcm-heading-action'] lyte-yield[yield-name='text']";
	private String enter_name = "#ain_name";
	private String choose_record = ".lyteDropPlaceholderNormal";
	
	public AuthIntruderPage(Page page) {
		this.page = page;
	}


	
	
	

	public void createAuthIntruder() {
		//page.click(create_authIntr);
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Create")).click();
		page.fill(enter_name, AppConstants.AUTH_INTR_NAME);
		page.click(choose_record);
		page.getByRole(AriaRole.OPTION,new Page.GetByRoleOptions().setName(AppConstants.REC_NAME)).click();
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Create")).first().click();
		
		
	}
}
