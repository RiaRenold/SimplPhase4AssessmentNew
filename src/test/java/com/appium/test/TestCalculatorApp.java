package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class TestCalculatorApp {
	public static AndroidDriver<WebElement> driver;
	@Before
		public void setUp() throws InterruptedException, MalformedURLException {
//			URL URL = new URL("http://127.0.0.1:4723/wd/hub");
			URL URL = new URL("hhttp://0.0.0.0:4444/wd/hub");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "5.1.1");
			cap.setCapability("appPackage", "com.google.android.calculator");
			cap.setCapability("appActivity", "com.android.calculator2.Calculator");
			
			
			driver= new AndroidDriver<WebElement>(URL, cap);
						
		}
		@After
		public void tearDown() throws Exception {
			driver.quit();
		}
		
		
		@Test
		public void addOperation() throws InterruptedException {
			driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='plus']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
			
			String result=driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
			Assert.assertEquals("13", result);
			System.out.println("Result is "+result);

		}
}
