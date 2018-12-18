package com.spice.dataReader;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

 

public class DataSetter {
	
	
	
	public Properties config;
public void getConfig()
{	try {
	config=DataReader.initializeConfig();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	
	
	
/*public  Object[] getData() throws Exception
{
	 return	DataReader.readData();
 
 }*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
