//$Id$
package com.qa.cmtester.tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import com.microsoft.playwright.Page;
import com.qa.cmtester.base.BaseTest;
import com.qa.cmtester.constants.AppConstants;
import com.qa.cmtester.factory.PlaywrightFactory;
import com.qa.cmtester.pages.HomePage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageTest extends BaseTest {
	Page page;
	@Test
	@Order(1)
	public void doIntercept(){
		String actual = homePage.InterceptStart();
		String expected = AppConstants.INTERCEPT_ON_CHECK;
		assertEquals(expected,actual);
		
	}
	@Test
	@Order(2)
	public void hitRequest() {
		pf.initTarget();
	}
	@Test
	@Order(3)
	public void saveToIntruder() {
		homePage.addToIntruder();
	}

	@Test
	@Order(4)
	public void stopIntercept() {
		String actual = homePage.InterceptStop();
		String expected = AppConstants.INTERCEPT_OFF_CHECK;
		assertEquals(expected,actual);
		
	}
	@Test
	@Order(5)
	public void navigateRecord() {
		homePage.navigateToRecord();
		
	}
	
	}
	
	



