package com.qa.cmtester.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.cmtester.constants.AppConstants;
import com.qa.cmtester.factory.PlaywrightFactory;

import java.nio.file.Paths;
import java.util.Properties;

public class LoginPage extends PlaywrightFactory{
	
	private  Page page;
	
	
	//Private locators
	private String loginId = "#login_id";
	private String nextBtn = "//form[@id='login']//button[@id='nextbtn']";
	private String passWord = "#password";
	private String signinBtn = "//form[@id='login']//button[@id='nextbtn']";
	private String header = "//body/div[@class='pcm-main']/header[@class='pcm-flex pcm-ai-ctr']/div/img[1]";
	
	
	//Constructor
	public LoginPage(Page page) {
		this.page = page;
	}
	
	//Page actions
	
	public String getLoginPagetitle() {
		return page.title();
		
	}
	
	public String getLoginPageutl() {
		return page.url();
		
	}	
	
	public HomePage doLogin(){
		page.fill(loginId,AppConstants.LOGIN_ID);
		page.click(nextBtn);
		page.fill(passWord, AppConstants.PASSWORD);
		page.click(signinBtn);
		return new HomePage(page);	
	}
	
	
	}
	




