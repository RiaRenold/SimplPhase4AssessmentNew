package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class ClockApp {
	static AndroidDriver<WebElement> driver;
	@Before
		public void setUp() throws InterruptedException, MalformedURLException {
			URL URL = new URL("http://127.0.0.1:4723/wd/hub");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("appPackage", "com.google.android.deskclock");
			cap.setCapability("appActivity", "com.android.deskclock.DeskClock");
			
			
			driver= new AndroidDriver<WebElement>(URL, cap);
						
			Thread.sleep(2000);
		}
		@After
		public void tearDown() throws Exception {
		}
		
		@Test
		public void testBack() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
			Thread.sleep(2000);
			
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
			Thread.sleep(2000);
			
			driver.navigate().back();
			
		}
		
		
//		@Test
		public void setAlarm() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.google.android.deskclock:id/fab")).click();
			Thread.sleep(2000);
			
			
			String setHrs = driver.findElement(By.id("android:id/hours")).getText();
			setHelper(setHrs, "10");
			
			String setMin = driver.findElement(By.id("android:id/minutes")).getText();
			setHelper(setMin, "55");
			
			
		}
		
		
		public void setHelper(String setSourceUnit, String setTargetUnit) throws InterruptedException {
			WebElement source = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+setSourceUnit+"']"));
			WebElement target = driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+setTargetUnit+"']"));
			
			int startX=source.getLocation().getX();
			int startY=source.getLocation().getY();
			int endX=target.getLocation().getX();
			int endY=target.getLocation().getY();
			System.out.println(startX);
			System.out.println(startY);
			System.out.println(endX);
			System.out.println(endY);
			
			TouchAction action = new TouchAction(driver);
			action
			.longPress(PointOption.point(startX, startY))
			.moveTo(PointOption.point(endX, endY))
			
			.release()
			.perform();
			Thread.sleep(2000);
			
		}
		
	}
