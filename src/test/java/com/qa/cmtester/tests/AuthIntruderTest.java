//$Id$
package com.qa.cmtester.tests;

import org.junit.jupiter.api.Test;

import com.qa.cmtester.base.BaseTest;
import com.qa.cmtester.pages.AuthIntruderPage;

public class AuthIntruderTest extends BaseTest {

	
AuthIntruderPage authIntruderPage;

@Test
public void authIntruderCreationTest() {
	authIntruderPage = homePage.navigateToAuthIntruder();
	authIntruderPage.createAuthIntruder();
}
}
