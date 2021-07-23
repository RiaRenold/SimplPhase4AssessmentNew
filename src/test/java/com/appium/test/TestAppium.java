package com.appium.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestAppium {
  @Test
  public void test() {
	  System.out.println("Inside Test");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside Aftre Test");
  }

}
