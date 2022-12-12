//$Id$
package com.qa.cmtester.tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.microsoft.playwright.Page;
import com.qa.cmtester.base.BaseTest;
import com.qa.cmtester.constants.AppConstants;
import com.qa.cmtester.pages.IntruderPage;
import com.qa.excel.reader.XLSReader;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntruderPageTest extends BaseTest{
IntruderPage intruderPage;
XLSReader reader = new XLSReader("/Users/thiru-15574/Codemine/Eclipse.app/Contents/MacOS/ZIDE/PlaywrightPOM/src/main/java/com/qa/excel/reader/testdata.xlsx");
	
	@Test
	@Order(1)
	public void RunXSSTest() {
		intruderPage = homePage.navigateToIntruder();
		String result = intruderPage.RunXSS();
		System.out.println(result);
		reader.setCellData("intruder", "Type", 2, "XSS");
		reader.setCellData("intruder", "Status", 2, "Completed");
		if(result.isEmpty()){
			reader.setCellData("intruder", "Vulnerability", 2, "test failed");
		}
		reader.setCellData("intruder", "Vulnerability", 2, result);
		intruderPage.toggleBack();
		
	}

	@Test
	@Order(2)
	public void RunSql() {
		String result = intruderPage.RunSQL();
		reader.setCellData("intruder", "Type", 3, "SQL");
		reader.setCellData("intruder", "Status", 3, "Completed");
		if(result.isEmpty()) {
			reader.setCellData("intruder", "Vulnerability", 3, "test failed");
		}
		reader.setCellData("intruder", "Vulnerability", 3, result);
		intruderPage.toggleBack();
		
	}
	
	@Test
	@Order(3)
	public void RunSQLAuto() {
		String result = intruderPage.RunSQLAuto();
		reader.setCellData("intruder", "Type", 4, "SQL Auto");
		reader.setCellData("intruder", "Status", 4, "Completed");
		if(result.isEmpty()) {
			reader.setCellData("intruder", "Vulnerability", 4, "test failed");
		}
		reader.setCellData("intruder", "Vulnerability", 4, result);
		intruderPage.toggleBack();
	}
	@Test
	@Order(4)
	public void RunPathTraversal() {
		String result = intruderPage.RunPathTraversal();
		reader.setCellData("intruder", "Type", 5, "PathTraversal");
		reader.setCellData("intruder", "Status", 5, "Completed");
		if(result.isEmpty()) {
			reader.setCellData("intruder", "Vulnerability", 5, "test failed");
		}
		reader.setCellData("intruder", "Vulnerability", 5, result);
		
		intruderPage.toggleBack();
	}
	@Test
	@Order(5)
	public void RunPathUnvalidatedRedirects() {
		String result = intruderPage.RunUnvalidatedRedirects();
		reader.setCellData("intruder", "Type", 6, "Unvalidated Redirects");
		reader.setCellData("intruder", "Status", 6, "Completed");
		if(result.isEmpty()) {
			reader.setCellData("intruder", "Vulnerability", 6, "test failed");
		}
		reader.setCellData("intruder", "Vulnerability", 6, result);
		intruderPage.toggleBack();
	}
	

}

