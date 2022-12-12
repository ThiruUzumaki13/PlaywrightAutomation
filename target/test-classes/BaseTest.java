//$Id$
package com.qa.cmtester.base;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import java.util.logging.Logger;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.qa.cmtester.constants.AppConstants;
import com.qa.cmtester.factory.PlaywrightFactory;
import com.qa.cmtester.pages.HomePage;
import com.qa.cmtester.pages.IntruderPage;
import com.qa.cmtester.pages.LoginPage;
import com.qa.cmtester.pages.RecordPage;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
	protected PlaywrightFactory pf;
	protected Page page;
	protected LoginPage loginPage;
	protected Properties prop;
	protected HomePage homePage;
	private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	@BeforeAll
	public void setupAppl() {
		pf = new PlaywrightFactory();
		prop = pf.initProp();
		page = pf.initBrowserLoggedin(prop);
		if(page.isVisible(".pcm-module-title")) {  // To ensure the page is loaded with the existing authcookies
		homePage= new HomePage(page);
		logger.info("Login  Successfull ");
		}
		else {										// If authcookies are expired, create new with 
			page = pf.initBrowser(prop);  
			loginPage = new LoginPage(page);
			homePage = loginPage.doLogin();
			pf.setAuthpath();
			logger.info("New Auth Cookies have been updated");
		}

	}
	
	@AfterAll
	public void tearDown() {
		page.context().browser().close();
		
	}
	
	

	
}


 