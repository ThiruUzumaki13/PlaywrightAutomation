//$Id$
package com.qa.cmtester.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.qa.cmtester.constants.AppConstants;

public class RepeaterPage {

	private Page page;
	
	// Page Constructor
	public RepeaterPage(Page page) {
		this.page = page;
	}

	
	//Private String selectors
	private String selectRepeater = ".pcm-item[lt-prop-value='New Repeater']";
	//.pcm-item[lt-prop-value='New Repeater ']
	private String selectRequest = "(//lyte-text[@class='pcm-ml20'])[1]";
	private String flowVarTab = "body > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > repeater-home:nth-child(1) > div:nth-child(1) > repeater-detailview:nth-child(1) > div:nth-child(2) > lyte-tabs:nth-child(1) > lyte-yield:nth-child(2) > lyte-tab-body:nth-child(2) > lyte-tab-content:nth-child(1) > repeater-request:nth-child(1) > div:nth-child(1) > lyte-accordion:nth-child(3) > lyte-yield:nth-child(2) > lyte-accordion-item:nth-child(1) > lyte-accordion-body:nth-child(2) > lyte-tabs:nth-child(1) > lyte-yield:nth-child(2) > lyte-tab-head:nth-child(1) > lyte-tab-title:nth-child(2)";
	private String createNewFvar ="(//lyte-yield[@yield-name='text'][normalize-space()='Create New Variable'])[1]";
	private String paramFilling = "(//span[@class='lyteRadioLayer'])[2]";
	private String valueType = "div[role='combobox'] lyte-drop-button";
	private String parsingFormat = "#fv_pf";
	private String createFvar = "cm-primary-button[name='Create'] button[type='button']";
	private String editParam = ".pcmicon-pencil.pcm-f16";
	private String dynamicInput = "#de_en_inp_0";
	private String addDynamicInput = ".pcm-lnk-txt.csrpntr";
	private String selectDynEntity = "lyte-dropdown[id='dyent'] span[class='lyteMarginRight lyteDropdownLabel']";
	private String selectFvar = ".lyteDropPlaceholderNormal";
	private String flwrName = "#fv_name";
	private String selectOtherRequests = "(//lyte-text[@class='pcm-ml20'])[i]";
	private String queryParamName = "#qp_name_0";
	private String runName = "#rr_name";
	private String runsTab = "lyte-tab-title[lt-prop-id='repeater-runs-tab']";
	private String drop_down = "(//lyte-drop-item[@id='Lyte_Drop_Item_59'])[1]";
	private String flowVariable;
	
	
public void createFlowVar() {
	page.click(selectRepeater);
	page.click(selectRequest);
	page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Edit Request")).first().click();
	String fvarName = page.inputValue(queryParamName);
	flowVariable = fvarName;
	page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
	page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("GET https://reqres.in/api/users")).locator("lyte-tab-head").getByText("Flow Variables").click();
	page.click(createNewFvar);
	page.fill(flwrName,fvarName);
	page.click(paramFilling);
	page.click(valueType);
	page.getByRole(AriaRole.OPTION,new Page.GetByRoleOptions().setName("Parse from Response")).click();
	page.fill(parsingFormat,fvarName);
	page.click(createFvar);
	page.click(selectRequest);
}
public void editRequest() {
	int i;
	int reqCount = AppConstants.REQUEST_COUNT;
	for (i=2;i<=reqCount;i++) {
		String s1 = String.valueOf(i);
		String s2 = selectOtherRequests.replace("i", s1);
		page.click(s2);
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Edit Request")).first().click();
		page.click(editParam);
		page.click(dynamicInput);
		page.click(addDynamicInput);
		page.click(selectDynEntity);
		page.getByRole(AriaRole.OPTION,new Page.GetByRoleOptions().setName("Flow Variable")).click();
		page.click(selectFvar);
		//page.click(drop_down);
		page.getByRole(AriaRole.OPTION,new Page.GetByRoleOptions().setName(flowVariable)).click();
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Add")).click();
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
	}
}

	public void runRepeater() {
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Run")).first().click();
		page.fill(runName, "New Run");
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Run")).click();
	
	}
	
}
