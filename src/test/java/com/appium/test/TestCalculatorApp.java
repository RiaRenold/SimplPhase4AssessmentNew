package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


public class TestCalculatorApp {
	public static AndroidDriver<WebElement> driver;
	@BeforeClass
		public void setUp() throws InterruptedException, MalformedURLException {
			DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "nexus_5_7.1.1");
		cap.setCapability("browserName", "android");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");

		// This is Docker
		URL url = new URL("http://0.0.0.0:4444/wd/hub");
			
			
		driver= new AndroidDriver<WebElement>(url, cap);
						
		}
		@AfterClass
		public void tearDown() throws Exception {
			driver.quit();
		}
		
		
		@Test
		public void addOperation() throws InterruptedException {

			driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
			Thread.sleep(2000);

			driver.findElement(By.id("com.android.calculator2:id/eq")).click();

			String result=driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
			Assert.assertEquals("14", result);
			System.out.println("Result is "+result);

		}
}
