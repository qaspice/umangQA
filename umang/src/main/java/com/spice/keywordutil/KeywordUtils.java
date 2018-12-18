package com.spice.keywordutil;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spice.umang.RunTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class KeywordUtils {
	
	
      AndroidDriver driver=(AndroidDriver) RunTest.driver;
	
	public boolean click(String xpath,String data)
	{
		driver.findElement(By.id(xpath)).click();
		return true;
	}
	
	
	public void clickElements(String xpath,String data)
	{
		List<WebElement> ele=driver.findElements(By.id(xpath));
		System.out.println("sizeof eke:: "+ele.size());
		
		ele.get(3).click();
	}
	
	
	public String getPageSource(String xpath,String data)
	{
		System.out.println("Page Source:: "+driver.getPageSource());
	
	return driver.getPageSource();
	}
	
	
	public boolean clickUsingpath(String xpath,String data)
	{
		driver.findElement(By.xpath(xpath)).click();
	return true;
	
	}
	public boolean wait(String xpath,String data) throws InterruptedException
	{

	Thread.sleep(4000);
	return true;
	}
	
	public void scrollDown(String xpath,String data)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		
		
	}
	
	public void clickUsingName(String xpath,String data)
	{
		driver.findElement(By.name(xpath)).click();
	}
	public boolean clickUsingClassName(String xpath,String data)
	{
		driver.findElement(By.className(xpath)).click();
	return true;
	}
	
	public String getText(String xpath,String data)
	{
		System.out.println("Error Texrt:: "+driver.findElement(By.id(xpath)).getText());
	
	return driver.findElement(By.id(xpath)).getText();
	}
	
	public boolean clickLink(String xpath,String data)
	{
		driver.findElement(By.linkText(data)).click();
		return true;
	}
	
	public boolean enterText(String xpath,String data)
	{
		driver.findElement(By.id(xpath)).sendKeys(data);
		return true;
	}
	
	public void keyboardSearch(String xpath,String data)
	{
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}
	
}
