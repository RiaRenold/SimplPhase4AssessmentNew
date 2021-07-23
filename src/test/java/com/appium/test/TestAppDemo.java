package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestAppDemo {
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		URL URL = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//		
//		{
//			  "platformName": "Android",
//			  "platformVersion ": "11",
//			  "appPackage": "io.appium.android.apis",
//			  "appActivity": "io.appium.android.apis.ApiDemos"
//			}
		
		//android.widget.TextView[@content-desc="Views"]
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(URL, cap);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("io.appium.android.apis:id/toggle1")).getAttribute("text"));
		driver.findElement(By.id("io.appium.android.apis:id/toggle1")).click();
		System.out.println(driver.findElement(By.id("io.appium.android.apis:id/toggle1")).getAttribute("text"));
		
		
		
//		Get the defualt value of Togle Button > exp OFF
//		Click on First Toggle button 
//		Get the  value of Togle Button > exp ON
		
		
//		Checkbox
		//android.widget.CheckBox[@content-desc="Checkbox 1"]
		
//		WRONG: Click on CB
//		Checkbox is ON
		MobileElement cb1 = (MobileElement) driver.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"Checkbox 1\"]"));
		Boolean checkedCB1 = Boolean.parseBoolean(cb1.getAttribute("checked"));
		if (!checkedCB1) {
			cb1.click();
		}
		
	
		
//		/ OFF
		
		
		
//		TC: Select the CB1
//		Get the default values for RB1 and RB2
//		Handle RB1 and check the statis for RB1 and 2
//		Select earth for Spinner
		
		System.out.println("Default status of RadioButton1 is: "+driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"RadioButton 1\"]")).getAttribute("checked"));
		System.out.println("Default status of RadioButton2 is: "+driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"RadioButton 2\"]")).getAttribute("checked"));
		MobileElement rb1 = (MobileElement) driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"RadioButton 1\"]"));

		Boolean radioButtonRB1 = Boolean.parseBoolean(cb1.getAttribute("checked"));
		if (!checkedCB1) {
			rb1.click();
		}
		
		System.out.println("Status of RadioButton1 is: "+driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"RadioButton 1\"]")).getAttribute("checked"));
		
		driver.findElement(By.className("android.widget.Spinner")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"Earth\"]")).click();
		Thread.sleep(2000);
		
		System.out.println("Text on Spinner/Dropdown after selecting Earth is: "+driver.findElement(By.xpath("//android.widget.TextView[@text=\"Earth\"]")).getAttribute("text"));
		
		
		
		
		
		
	
	
	}	

}
