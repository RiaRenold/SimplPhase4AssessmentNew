package com.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class TestAppDemo2 {
	static AndroidDriver<WebElement> driver;
	@Before 
	public void setUp() throws InterruptedException, MalformedURLException {
		URL URL = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		
		driver= new AndroidDriver<WebElement>(URL, cap);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		Thread.sleep(2000);
	}
	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testBackButton() throws InterruptedException {
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
	}

	//	@Test
	public void testRadioGroup() throws InterruptedException {

		//		1. find the Radio Group
		//		2. Find all the Radio Buttons inside  List
		//		3. Iterate > Print the text
		//		4. Condition  > check Radio Button 1
		//		CP: Check the default Status for all the RBs
		//		Checked on RB and again check status of RB

		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Controls\"]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]").click();
		Thread.sleep(1000);


		MobileElement RadioGroup = (MobileElement) driver.findElement(By.xpath("//android.widget.RadioGroup"));
		List<MobileElement> lstRB = RadioGroup.findElements(By.xpath(".//android.widget.RadioButton"));
		for (MobileElement RB : lstRB) {
			System.out.println(RB.getAttribute("text"));
			if (RB.getAttribute("text").equals("RadioButton 1")) {
				RB.click();

			}
		}


		//		testSpinner
		//		testCheckBox





	}





//	@Test
	public void testSeekBar() throws InterruptedException {
		clickOnView("Seek Bar");
		//		scroll_Up();

		Thread.sleep(5000);

	}



	public void clickOnView(String ExpVName) throws InterruptedException {
		MobileElement parent = (MobileElement) driver.findElement(By.id("android:id/content"));
		boolean flgFound = false;

		while (!flgFound) {

			List<MobileElement> views = parent.findElements(By.id("android:id/text1"));
			for (MobileElement view : views) {
				System.out.println(view.getAttribute("text"));
				if (view.getAttribute("text").equals(ExpVName)) {
					view.click();
					flgFound = true;
					break;

				}
			}

			if (!flgFound) {
				scroll_Up();
			}

		}
	}
	public void scroll_Up() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Scroll UP ....");
		//		Ht
		int height = driver.manage().window().getSize().getHeight();
		//		WD
		int width = driver.manage().window().getSize().getWidth();


		//		
		//		StartY  90% of Ht
		int startY = (int) (height * 0.9); 
		//		StartX 50% of W
		int startX = (int) (width * 0.5);
		//		EndY  10% of Ht
		int endY = (int) (height * 0.1);
		//		EndX = StartX
		int endX = startX;


		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
		
		Thread.sleep(1000);


	}
		
	
//	@Test
	public void DragAndDrop() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		Thread.sleep(1000);
		MobileElement source=(MobileElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		MobileElement target=(MobileElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
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
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.release()
		.perform();
		Thread.sleep(7000);
		String actualText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals("Dropped!", actualText);
		
	}



	}
	

