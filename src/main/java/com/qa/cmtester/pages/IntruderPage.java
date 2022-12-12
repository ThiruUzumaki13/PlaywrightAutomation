//$Id$
package com.qa.cmtester.pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.qa.cmtester.constants.AppConstants;


import java.util.logging.Logger;

public class IntruderPage {
	private Page page;
	
	
	//Constructor
	public IntruderPage(Page page) {
		this.page = page;
	}

	//Private page locators
	private static final Logger logger = Logger.getLogger(IntruderPage.class.getName());
	private String IntruderBatch = "lyte-tbody lyte-tr:nth-child(1) lyte-td:nth-child(1)";
	private String batch = "(//lyte-text[@class='pcm-item'])[1]";
	private String chooseVulnDropdown = ".lyteDropPlaceholderNormal";
	private String addVuln = "button[class='lyte-button lytePrimaryBtn'] lyte-yield[yield-name='text']";
	private String payload_qp = "(//span[@class='lyteCheckBoxDefault'])[1]";
	private String save ="cm-primary-button[name='Save'] lyte-yield[yield-name='text']";
	private String savePayload = "button[class='lyte-button lytePrimaryBtn']";
	private String addRunConfig ="(//button[@type='button'])[8]";
	private String timeInterval = "//input[@id='inbrtcti']";
	private String saveRunConfig ="//lyte-yield[normalize-space()='Save']";
	private String run ="cm-primary-button[name='Run'] button[type='button']";
	private String ent_pay = "//div[@id='cenewval']";
	private String runConfig = "cm-config-box[heading='Run configuration'] div[class='cmc-head']";
	private String runConfirm = "lyte-yield[yield-name='alert'] cm-primary-button[name='Run'] lyte-yield[yield-name='text']";
	private String result = "lyte-tab-title[lt-prop-id='inbrtab']";
	private String backarrow = ".pcmicon-left-arrow.pcm-f22";
	private String addNewBatch = "cm-primary-button[name='Create batch'] lyte-yield[yield-name='text']";

	private String addBatchName = "(//input[@id='inb_name'])[1]";
	private String createBatchbtn = "cm-primary-button[name='Create'] lyte-yield[yield-name='text']";
	private String resultConfig = "body > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > intruder-home:nth-child(1) > div:nth-child(1) > intruderbatch-detailview:nth-child(1) > div:nth-child(2) > intruderbatch-config:nth-child(1) > div:nth-child(1) > cm-config-box:nth-child(5) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)";
	private String addResultConfig = "(//button[@type='button'])[8]";
	private String respCriteriadropdown = "div[role='combobox'] lyte-drop-button";
	private String saveResp = "button[class='lyte-button lytePrimaryBtn']";
	private String configuration = "//lyte-tab-title[@class='lyteTabActive']";
	private String run_status = "body > div:nth-child(6) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > intruder-home:nth-child(1) > div:nth-child(1) > intruderbatch-detailview:nth-child(1) > div:nth-child(1) > module-header:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > span:nth-child(2)";
	private String repeater ="#repeater";
	private String intruder = "a[id='intruder'] span";
	private String addQueryParam = "div[class='pcm-mb10'] div[class='addelelnk']";
	
	//XSS 
	public String RunXSS() {
		page.click(IntruderBatch);
		page.click(batch);
		page.getByText("Vulnerability to test Add").click();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		page.click(chooseVulnDropdown);
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("XSS")).click();
		page.click(addVuln);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		String emptyPayloadAlert =  page.getByText("No Places Found").textContent();
		System.out.println(emptyPayloadAlert);
		if(emptyPayloadAlert!=null){
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
			 page.getByText("Request View Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
			 page.click(addQueryParam);
			 page.fill("#qp_name_0", "qParam");
			 page.fill("#qp_value_0","10");
			 page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
			 page.getByText("Payload Places Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		}
		page.click(payload_qp);
		page.click(save);
		page.getByText("Payloads").nth(1).click();
		page.getByText("Payloads Add").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		
		page.fill(ent_pay,AppConstants.XSS_PAYLOAD);
		page.click(savePayload);
		page.click(runConfig);
		page.click(addRunConfig);
		page.fill(timeInterval, AppConstants.TIME_INTERVAL);
		page.click(saveRunConfig);
		logger.info("XSS Batch created");
		page.click(run);
		page.click(runConfirm);
		page.click(result);	
		page.waitForTimeout(60000);
		String text = page.innerText("lyte-td:nth-child(5)");	
		if(text!=null) {
			logger.info("XSS test completed, and the possibility is "+text);
		}
		else {
			logger.info("XSS not completed");
		}
		return text;
	}
	
	public void toggleBack() {
		page.click(backarrow);
	}
	//SQL 
	public String RunSQL() {
		page.click(addNewBatch);
		page.fill(addBatchName,"SQL injection");
		page.click(chooseVulnDropdown);
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("SQL Injection")).click();
		page.click(createBatchbtn);
		page.click(batch);
		page.getByText("Payload Places Edit").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		String emptyPayloadAlert =  page.getByText("No Places Found").textContent();
		System.out.println(emptyPayloadAlert);
		if(emptyPayloadAlert!=null){
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
			 page.getByText("Request View Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
			 page.click(addQueryParam);
			 page.fill("#qp_name_0", "qParam");
			 page.fill("#qp_value_0","10");
			 page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
			 page.getByText("Payload Places Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		}
		page.click(payload_qp);
		page.click(save);
		page.getByText("Payloads").nth(1).click();
		page.getByText("Payloads Add").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		
		page.locator("cm-content-editor:has-text(\"Type payload value, hit Enter to add\") div").first().click();
		page.fill(ent_pay,AppConstants.SQl_PAYLOAD);
		page.click(savePayload);
		page.getByText("Result Configuration Add").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		page.click(respCriteriadropdown);
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Response contains payload")).click();
		page.click(saveResp);
		page.click(runConfig);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		page.fill(timeInterval, AppConstants.TIME_INTERVAL);
		page.click(saveRunConfig);
		page.click(run);
		page.click(runConfirm);
		page.click(result);	
		page.waitForTimeout(60000);
		String text = page.innerText("lyte-td:nth-child(5)");
		if(text!=null) {
			logger.info("SQL test completed, and the possibility is "+text);
		}
		else {
			logger.info("SQL not completed");
		}
		return text;

	}
	//SQL auto
	public String RunSQLAuto() {
		page.click(addNewBatch);
		page.fill(addBatchName, "SQL injection -Auto");
		page.click(chooseVulnDropdown);
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("SQL Injection (automatic)")).click();
		page.click(createBatchbtn);
		page.click(batch);
		page.getByText("Payload Places Edit").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		String emptyPayloadAlert =  page.getByText("No Places Found").textContent();
		System.out.println(emptyPayloadAlert);
		if(emptyPayloadAlert!=null){
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
			 page.getByText("Request View Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
			 page.click(addQueryParam);
			 page.fill("#qp_name_0", "qParam");
			 page.fill("#qp_value_0","10");
			 page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
			 page.getByText("Payload Places Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		}
		page.click(payload_qp);
		page.click(save);
		page.click(runConfig);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		page.fill(timeInterval, AppConstants.TIME_INTERVAL);
		page.click(saveRunConfig);
		page.click(run);
		page.click(runConfirm);
		page.click(result);
		page.waitForTimeout(60000);
		String text = page.innerText("lyte-td:nth-child(5)");
		if(text!=null) {
			logger.info("SQL AUTO test completed, and the possibility is "+text);
		}
		else {
			logger.info("SQL AUTO not completed");
		}
		return text;
	}
	//Path Traversal
	public String RunPathTraversal() {
		page.click(addNewBatch);
		page.fill(addBatchName,"Path Traversal");
		page.click(chooseVulnDropdown);
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Path Traversal")).click();
		page.click(createBatchbtn);
		page.click(batch);
		page.getByText("Payload Places Edit").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		String emptyPayloadAlert =  page.getByText("No Places Found").textContent();
		System.out.println(emptyPayloadAlert);
		if(emptyPayloadAlert!=null){
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
			 page.getByText("Request View Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
			 page.click(addQueryParam);
			 page.fill("#qp_name_0", "qParam");
			 page.fill("#qp_value_0","10");
			 page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
			 page.getByText("Payload Places Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		}
		page.click(payload_qp);
		page.click(save);
		page.getByText("Payloads").nth(1).click();
		page.getByText("Payloads Add").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		
		page.locator("cm-content-editor:has-text(\"Type payload value, hit Enter to add\") div").first().click();
		page.fill(ent_pay,AppConstants.PATH_TRAVERSAL_PAYLOAD);
		page.click(savePayload);
		page.click(runConfig);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		page.fill(timeInterval, AppConstants.TIME_INTERVAL);
		page.click(saveRunConfig);
		page.click(run);
		page.click(runConfirm);
		page.click(result);	
		page.waitForTimeout(60000);
		String text = page.innerText("lyte-td:nth-child(5)");
		if(text!=null) {
			logger.info("Path Traversal test completed, and the possibility is "+text);
		}
		else {
			logger.info("Path Traversal not completed");
		}
		return text;
	}
	//invalidated Redirects
	public String RunUnvalidatedRedirects() {
		page.click(addNewBatch);
		page.fill(addBatchName,"Unvalidated Redirects");
		page.click(chooseVulnDropdown);
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Unvalidated Redirects")).click();
		page.click(createBatchbtn);
		page.click(batch);
		page.getByText("Payload Places Edit").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		String emptyPayloadAlert =  page.getByText("No Places Found").textContent();
		System.out.println(emptyPayloadAlert);
		if(emptyPayloadAlert!=null){
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ok")).click();
			 page.getByText("Request View Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
			 page.click(addQueryParam);
			 page.fill("#qp_name_0", "qParam");
			 page.fill("#qp_value_0","10");
			 page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Save")).click();
			 page.getByText("Payload Places Edit").click();
			 page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Edit")).click();
		}
		page.click(payload_qp);
		page.click(save);
		page.getByText("Payloads").nth(1).click();
		page.getByText("Payloads Add").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();		
		page.locator("cm-content-editor:has-text(\"Type payload value, hit Enter to add\") div").first().click();
		page.fill(ent_pay,AppConstants.UNVALIDATED_REDIRECTS_PAYLOAD);
		page.click(savePayload);
		page.click(runConfig);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
		page.fill(timeInterval, AppConstants.TIME_INTERVAL);
		page.click(saveRunConfig);
		page.click(run);
		page.click(runConfirm);
		page.click(result);	
		page.waitForTimeout(60000);
		String text = page.innerText("lyte-td:nth-child(5)");
		if(text!=null) {
			logger.info("Unvalidated Redirects test completed, and the possibility is "+text);
		}
		else {
			logger.info("Unvalidated Redirects not completed");
		}
		return text;
	}
}
