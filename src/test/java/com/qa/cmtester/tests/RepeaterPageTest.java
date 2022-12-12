//$Id$
package com.qa.cmtester.tests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.qa.cmtester.base.BaseTest;
import com.qa.cmtester.pages.RepeaterPage;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepeaterPageTest extends BaseTest {
RepeaterPage repeaterPage;

@Test
@Order(1)
public void navigateToRepeater() {
	repeaterPage = homePage.navigateToRepeater();
}
@Test
@Order(2)
public void createFvar() {
	repeaterPage.createFlowVar();
}

@Test
@Order(3)
public void edit_Fvar() {
	repeaterPage.editRequest();
}
@Test
@Order(4)
public void runRepeater() {
	repeaterPage.runRepeater();
}
}
