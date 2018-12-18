package com.spice.umang;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class AppConfiguration {

	long timespan;
	WebDriver driver;

	@BeforeTest
	public void appConfigurations() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "7.0");
		capabilities.setCapability("deviceName", "33575e299904");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "in.gov.umang.negd.g2c.staging");
		capabilities.setCapability("appActivity", "in.spicedigital.umang.activities.SplashScreen");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/cb_i_agree")).click();
		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/loginImg")).click();
		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/loginImg")).click();
		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/loginTxt")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/mobile_num_input_fld")).sendKeys("9592787051");
		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/mpin_input_fld")).sendKeys("5555");
        
	}

	@Test
	public void loginTime() {

		driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/login_btn")).click();
		long starttime = System.currentTimeMillis();
		driver.findElement(By.className("android.widget.ImageView"));

		long endtime = System.currentTimeMillis();

		timespan = endtime - starttime;
		System.out.println("time taken" + timespan);

	}

	@AfterTest
	public void writeInExcel() throws Exception {

		File f = new File("F:\\timespan\\timespan.xlsx");
		FileOutputStream fos = new FileOutputStream(f);

		Workbook wb = new XSSFWorkbook();

		XSSFSheet sheet = (XSSFSheet) wb.createSheet("OutTime");

		Row row = sheet.createRow(0);

		Cell cell1 = row.createCell(0);

		cell1.setCellValue("Time Taken");
		Row row2 = sheet.createRow(1);

		Cell cell2 = row2.createCell(0);

		cell2.setCellValue(timespan);

		wb.write(fos);

		fos.close();

	}

}
