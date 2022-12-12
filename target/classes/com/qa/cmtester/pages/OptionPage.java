//$Id$
package com.qa.cmtester.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.qa.cmtester.constants.AppConstants;

public class OptionPage {
private Page page;

//Page Constructor
public OptionPage(Page page){
	this.page = page;
}


//page actions
public void createNewFilter() {
page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Filter")).click();
page.getByPlaceholder("Enter the criteria name").click();
page.getByPlaceholder("Enter the criteria name").fill("New Filter");
page.locator("lyte-yield:has-text(\"Name * Conditions Path Domain Method Path Protocol Cookie Name Cookie Value Head\") i").click();
page.locator("lyte-drop-button:has-text(\"Choose match type\")").click();
page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Domain")).click();
page.getByText("Choose relation").click();
page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Matches")).click();
page.locator("#rcc_val_1").click();
page.locator("#rcc_val_1").fill(AppConstants.FILTER_REQUEST);
page.locator("lyte-yield:has-text(\"Name * Conditions Path Domain Method Path Protocol Cookie Name Cookie Value Head\") i").nth(1).click();
page.locator("lyte-drop-button:has-text(\"Choose match type\")").click();
page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Path")).click();
page.getByText("Choose relation").click();
page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Not Matches")).click();
page.locator("#rcc_val_2").click();
page.locator("#rcc_val_2").fill(AppConstants.FILTER_STATIC);
page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
}
public String displayLastModifiedTime() {
	String text1 = page.innerText("lyte-td:nth-child(4)");
	System.out.println(text1);
	return text1;
}
}

