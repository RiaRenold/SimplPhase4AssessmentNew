package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class TestCalculatorApp2 {
//	static AndroidDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
//		URL URL = new URL("hhttp://localhost:4723/wd/hub");
		URL URL = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
//		driver= new AndroidDriver<WebElement>(URL, cap);
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(URL, cap);
					
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='plus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
		
		String result=driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		Assert.assertEquals("13", result);
		driver.quit();
		System.out.println("Result is "+result);
	}
	}


