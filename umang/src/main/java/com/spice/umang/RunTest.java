package com.spice.umang;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spice.dataReader.DataReader;

import io.appium.java_client.android.AndroidDriver;

public class RunTest extends DataReader {

	public static WebDriver driver;

	@BeforeTest
	public void initiateDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "7.0");
		capabilities.setCapability("deviceName", "33575e299904");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "in.gov.umang.negd.g2c.staging");
		capabilities.setCapability("appActivity", "in.spicedigital.umang.activities.SplashScreen");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		/*
		 * driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/cb_i_agree")).
		 * click();
		 * driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click(
		 * );
		 * driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/loginImg")).click(
		 * );
		 * driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/loginImg")).click(
		 * );
		 * driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/loginTxt")).click(
		 * ); driver.findElement(By.id(
		 * "com.android.packageinstaller:id/permission_allow_button")).click();
		 * driver.findElement(By.id(
		 * "com.android.packageinstaller:id/permission_allow_button")).click();
		 * driver.findElement(By.id(
		 * "com.android.packageinstaller:id/permission_allow_button")).click();
		 * driver.findElement(By.id(
		 * "in.gov.umang.negd.g2c.staging:id/mobile_num_input_fld")).sendKeys(
		 * "9592787051");
		 * driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/mpin_input_fld")).
		 * sendKeys("5555");
		 */ }

	/*
	 * @BeforeTest public void initiateDriver() throws IOException { /* Properties
	 * config = new Properties(); try { FileInputStream fis = new FileInputStream(
	 * "C:\\Users\\Ashima\\eclipse-workspace\\SelPrac-Intro\\src\\config.properties"
	 * ); config.load(fis); } catch (Exception e) { e.printStackTrace();
	 * System.out.println("Exception:: file" + e); }
	 * config = initializeConfig(); System.out.println("Config Browser is : " +
	 * config.getProperty("browser"));
	 * String browser="chrome"; if (browser.equalsIgnoreCase("chrome")) {
	 * System.setProperty("webdriver.chrome.driver",
	 * "F:\\appium\\umang\\drivers\\chromedriver.exe"); driver = new ChromeDriver();
	 * } else if (browser.equalsIgnoreCase("firefox")) {
	 * System.setProperty("webdriver.gecko.driver", ""); driver = new
	 * FirefoxDriver(); } else { System.out.println("check browser name"); }
	 * driver.get("https://stgweb.umang.gov.in/web/#/");
	 * driver.manage().window().maximize(); }
	 */
	@Test(dataProvider = "GetTestData")
	public void runTesting(Map<String, String> dataMap) throws Exception {
		System.out.println("user" + dataMap);
		ArrayList<String> header = readHeaders("TestSuite");
		Sheet sheet = DataReader.workbook.getSheet("TestSuite");
		int testStepCount = (dataMap.size() - 2 / header.size()) + (dataMap.size() - 2 % header.size());
		System.out.println(dataMap.size());
		System.out.println(header.size());
		System.out.println("daasd" + testStepCount);
		for (int i = Integer.parseInt(dataMap.get("StartCount")); i <= Integer.parseInt(dataMap.get("EndCount")); i++) {
			Row row = sheet.getRow(i);
			if (row.getCell(0).getStringCellValue().contains("TS_")) {
				String methodKey = header.get(2) + row.getCell(0).getStringCellValue().split(",")[0];
				String dataKey = header.get(3) + row.getCell(0).getStringCellValue().split(",")[0];
				String xpathKey = header.get(4) + row.getCell(0).getStringCellValue().split(",")[0];
				String keyword = dataMap.get(methodKey);
				String data = dataMap.get(dataKey);
				String xpath = dataMap.get(xpathKey);
				Object obj = Class.forName("com.spice.keywordutil.KeywordUtils").newInstance();
				Method method = obj.getClass().getMethod(keyword, String.class, String.class);
				Object objectOut = method.invoke(obj, xpath, data);

				FileOutputStream fos = new FileOutputStream("F:\\appium\\umang\\TestSuite\\TestSuite.xlsx");
				Cell cellOut = row.createCell(5);
				if (objectOut.toString().equals("true")) {
					CellStyle style = DataReader.workbook.createCellStyle();
					style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
					style.setFillPattern(CellStyle.SPARSE_DOTS);
					cellOut.setCellValue("PASS");
					cellOut.setCellStyle(style);
				} else if (objectOut.toString().equals("false")) {
					CellStyle style = DataReader.workbook.createCellStyle();
					// style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setFillForegroundColor(IndexedColors.RED.getIndex());
					cellOut.setCellValue("FAIL");
					cellOut.setCellStyle(style);
				} else {
					cellOut.setCellValue(objectOut.toString());
				}
				DataReader.workbook.write(fos);
				fos.close();
			}
		}
	}
}