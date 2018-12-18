package com.spice.keywordutil;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.spice.umang.RunTest;

	public class KeywordUtilWeb {

		WebDriver driver = RunTest.driver;
		long time1, time2, totalTime;

		public boolean click(String xpath, String data) {
				driver.findElement(By.xpath(xpath)).click();
			
		return true;
		
		}

		public boolean clickTest(String xpath, String data) {
			driver.findElement(By.xpath(xpath)).click();
		
			return true;
		}

		
		public boolean scrollElement(String xpath, String data) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(xpath)));
			return true;
		}

		public boolean sendKeys(String xpath, String data) {
			driver.findElement(By.xpath(xpath)).sendKeys(data);
			return true;
		}

		public boolean getText(String xpath, String data) {
			driver.findElement(By.xpath(xpath)).getText();
			return true;
		}

		public boolean webDriverWait(String xpath, String data) {
			try {
				//long time = (long) Integer.parseInt(data);
				WebDriverWait wait = new WebDriverWait(driver, 3);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			} catch (Exception e) {
				System.out.println("Element not found");
			}
		
			return true;
		}

		
		public boolean hardWait(String xpath, String data) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				System.out.println("Element not found");
			}
		
			return true;
		}
		public long time1(String xpath, String data) {
			time1 = System.currentTimeMillis();
			System.out.println("time1:: "+time1);
		
			return time1;
		}

		public long time2(String xpath, String data) {
			time2 = System.currentTimeMillis();
			System.out.println("time2:: "+time2);
		return time2;
		
		}

		public long calTime(String xpath, String data) {
			totalTime = time1 - time2;
			System.out.println("TotalTime:: "+totalTime);
		return totalTime;
		}
		public void selectFromDropDown(String xpath, String data) {
			Select dropdown= new Select(driver.findElement(By.cssSelector(xpath)));
			dropdown.selectByVisibleText(data);
		}
	}

	


