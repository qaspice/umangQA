package com.spice.dataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.spice.umang.RunTest;

public class DataReader {

	public static Workbook workbook;
	public static HashMap<String, String> dataMap;
	public static Workbook loadExcel(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		return workbook;
	}

	// Method to Read Headers of an Excel File
	@SuppressWarnings({ "incomplete-switch", "deprecation" })
	public static ArrayList<String> readHeaders(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(0);
		ArrayList<String> header = new ArrayList<String>();
		System.out.println("check sizw" + row.getLastCellNum());
		Iterator itr = row.cellIterator();
		int i = 0;
		while (itr.hasNext()) {
			// System.out.println("chekciterations");
			itr.next();
			Cell cell = row.getCell(i);
			switch (cell.getCellTypeEnum()) {
			case BLANK: {
				break;
			}
			case STRING: {
				header.add(cell.getStringCellValue());
				break;
			}
			}
			i++;
		}
		return header;
	}

	@DataProvider(name = "GetTestData")
	public Object[] readData() throws Exception {
		int k = 0;
		Workbook wb = loadExcel(System.getProperty("user.dir")+"\\TestSuite\\"+config.getProperty("suiteName"));
		Sheet sheet = wb.getSheet("TestSuite");
		int lastRow = sheet.getLastRowNum();
		// ArrayList<Map<String, String>> dataList = new ArrayList<Map<String,
		// String>>();
		Object[] obj = new Object[1];
		ArrayList<String> headerData = readHeaders("TestSuite");
		System.out.println("checkHeaderData" + headerData);
		for (int i = 1; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			Cell cell1 = row.getCell(0);
			if (cell1.getStringCellValue().split(",")[0].contains("TC_")) {
				if (cell1.getStringCellValue().split(",")[1].contains("Y")) {
					dataMap = new HashMap<String, String>();
					dataMap.put("StartCount", Integer.toString(row.getRowNum() + 1));
					obj[k] = dataMap;
					k++;
					continue;
				}
			} else {
				for (int j = 0; j < row.getLastCellNum(); j++) {
					if (cell1.getStringCellValue().split(",")[1].contains("N")) {
						break;
					} else {
						Cell cell = row.getCell(j);
						switch (cell.getCellTypeEnum()) {
						case BLANK:
							break;
						case STRING: {
							dataMap.put(headerData.get(j) + cell1.getStringCellValue().split(",")[0],
									cell.getStringCellValue()); // TCNOTS_1 value TS_1,Y
							break;
						}
						}
					}	
					try {
						String check = cell1.getStringCellValue().split(",")[1].split("-")[1];
						if (cell1.getStringCellValue().split(",")[1].split("-")[1].equalsIgnoreCase("E")) {
							dataMap.put("EndCount", Integer.toString(row.getRowNum()));
							}
					} catch (Exception e) {}
				}
			}
		}
		return obj;
	}

	// Method to initialize config
	public static Properties config;

	public static Properties initializeConfig() throws IOException {
		config = new Properties();
		// F:\Automation Workspace\ApiAutomationRestAssured
		// String configAddress = "F:\\Automation
		// Workspace\\ApiAutomationRestAssured\\config\\config.properties";
		String y = System.getProperty("user.dir");
		String configAddress = y + "//config//config.properties";
		System.out.println("config address is " + configAddress);
		try {
			FileInputStream input = new FileInputStream(configAddress);
			config.load(input);
			System.out.println("config loaded");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("input noot loaded");
			e.printStackTrace();
		}
		return config;

	}

}
