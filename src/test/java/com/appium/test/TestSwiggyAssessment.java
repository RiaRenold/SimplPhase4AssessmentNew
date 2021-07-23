package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestSwiggyAssessment {
	
	static AndroidDriver<WebElement> driver;
	@Before
		public void setUp() throws InterruptedException, MalformedURLException {
			URL URL = new URL("http://127.0.0.1:4723/wd/hub");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("appPackage", "in.swiggy.android");
			cap.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
			
			
			driver= new AndroidDriver<WebElement>(URL, cap);
						
			Thread.sleep(2000);
		}

}
