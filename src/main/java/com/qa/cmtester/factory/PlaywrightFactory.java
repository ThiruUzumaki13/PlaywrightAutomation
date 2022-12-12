package com.qa.cmtester.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Proxy;


public class PlaywrightFactory {
protected Playwright playwright;
protected Playwright playwright1;
protected Browser browser;
protected Browser browser2;
protected Browser browserFinal;
protected BrowserContext browserContext;
protected BrowserContext browserContext2;
protected BrowserContext newBrContext;
Page page;
Page page1;
Page pageFinal;
protected Properties prop;

public Page initBrowser(Properties prop) {
	playwright = Playwright.create();
	browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
	browserContext = browser.newContext();
	page = browserContext.newPage();
	page.navigate(prop.getProperty("url"));
	return page;
	
	}
public void setAuthpath() {
	browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auth.json")));
}	
public Page initBrowserLoggedin(Properties prop) {
	playwright1 = Playwright.create();
	browserFinal = playwright1.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	newBrContext = browserFinal.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("auth.json")));
	pageFinal = newBrContext.newPage();
	pageFinal.navigate(prop.getProperty("url"));
	return pageFinal;
}

public void initTarget() {
	browser2 = playwright1.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(3000).setProxy(new Proxy("localhost:7000")));
	browserContext2 = browser2.newContext();
	page1=browserContext2.newPage();
	page1.navigate("https://reqres.in/api/users?page=10");
	page1.context().browser().close();

}

public Properties initProp() {
	try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop = new Properties();
		prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
		e.printStackTrace();
	} 
	return prop;
}


}



