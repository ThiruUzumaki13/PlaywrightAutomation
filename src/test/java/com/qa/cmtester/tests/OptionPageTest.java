//$Id$
package com.qa.cmtester.tests;

import org.junit.jupiter.api.Test;

import com.qa.cmtester.base.BaseTest;
import com.qa.cmtester.pages.OptionPage;

public class OptionPageTest extends BaseTest {
OptionPage  optionPage;

@Test
public void CreateFilter() {
	optionPage = homePage.navigateToOption();
	optionPage.createNewFilter();
	optionPage.displayLastModifiedTime();
}

}
