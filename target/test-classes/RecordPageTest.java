//$Id$
package com.qa.cmtester.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.microsoft.playwright.Page;
import com.qa.cmtester.base.BaseTest;
import com.qa.cmtester.constants.AppConstants;
import com.qa.cmtester.pages.HomePage;
import com.qa.cmtester.pages.RecordPage;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecordPageTest extends BaseTest{
	RecordPage recordPage;
@Test
@Order(1)
public void newRecord() {
	RecordPage page = homePage.navigateToRecord();
	String actual =page.CreateNewRecord();
	String expected = AppConstants.RECORD_STATUS;
	assertEquals(expected,actual);
	
	}
@Test
@Order(2)
public void HitRequest() {
	int i,count = AppConstants.REQUEST_COUNT;
	for(i=0;i<count;i++) {
	pf.initTarget();
	}
}
@Test
@Order(3)
public void StopRecord() {
	recordPage = new RecordPage(page);
	String actual =recordPage.StopRecord();
	String expected = AppConstants.RECORD_END_STATUS;
	assertEquals(expected,actual);
	
}
@Test
@Order(4)
public void SaveAsRepeater() {
	recordPage.saveAsRepeater();
}

}

