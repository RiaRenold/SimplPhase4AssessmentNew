package com.appium.test;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class TestContact {
	static AndroidDriver<WebElement> driver;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeTest
  public void setUp() throws MalformedURLException {
	  URL URL = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
		cap.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
		
		
		driver= new AndroidDriver<WebElement>(URL, cap);
					
//		Thread.sleep(2000);
  }
  

}
