package com.qa.cmtester.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import com.microsoft.playwright.Page;
import com.qa.cmtester.base.BaseTest;
import com.qa.cmtester.constants.AppConstants;
import com.qa.cmtester.factory.PlaywrightFactory;
import com.qa.cmtester.pages.LoginPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPageTest extends BaseTest {
	

	@Test
	@Order(1)
	public void loginPageTitleTest() {
		String actual = loginPage.getLoginPagetitle();
		System.out.println("The page title is "+actual);
		String expected = AppConstants.LOGIN_PAGE_TITLE;
		assertEquals(expected, actual);
	}
	

	
	
	
}


