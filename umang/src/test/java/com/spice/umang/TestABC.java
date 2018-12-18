package com.spice.umang;

import java.awt.Scrollbar;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;

//import org.automationtesting.excelreport.Xl;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.jna.platform.unix.X11.Window;
//import com.sun.xml.bind.v2.model.core.Element;

import org.openqa.selenium.interactions.Actions;


	public class TestABC {

	//private static final RemoteWebDriver je = null;
		 static WebDriver driver;
		//Dimension size;
		
		 
		 /*@BeforeTest
			public void appConfigurations() throws MalformedURLException {
				
				
				
				
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("BROWSER_NAME", "Android");
				capabilities.setCapability("VERSION", "7.0"); 
				capabilities.setCapability("deviceName","33575e299904");
				capabilities.setCapability("platformName","Android");
				capabilities.setCapability("appPackage","in.gov.umang.negd.g2c.staging");
				capabilities.setCapability("appActivity","in.spicedigital.umang.activities.SplashScreen");
				
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				
										
				
				
				
				
			}
		*/	
		

		 @BeforeTest
		 public void setUp() throws MalformedURLException {
		
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "29b6dc16");
		  //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		  //capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("unicodeKeyboard", true);
		  capabilities.setCapability("resetKeyboard", true);
		  //capabilities.setCapability("fastReset", "true");
		  //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "CHROME");
		  capabilities.setCapability("appPackage", "in.gov.umang.negd.g2c.staging");
		  capabilities.setCapability("appActivity", "in.spicedigital.umang.activities.SplashScreen");
																				
		 
		  driver = new RemoteWebDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  
		  
		  
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  
		 }
		 
		
		 	@Test
		 	 public void login() throws InterruptedException {
		 		 
		             // Login with crdentials
		 		 
	
	
	            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	             System.out.println("click o id");
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
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/login_btn")).click();
	
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/bannerImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/categoryLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/moreTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/categoryTitleTxt")).click();
		 		 
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/categoryLay")).click();
		 		 driver.findElement(By.className("android.view.View")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/serviceImg")).click();
		 	

		 		String text = "Your Complaint has been successfully lodged and your docket number";
		 		//Thread.sleep(3000);
		 		System.out.println("before");
		 		 driver.findElement(By.id("Layer_1")).click();
		 		 System.out.println("after");
		 		 
		 		 driver.switchTo().alert().accept();
		 		 driver.findElement(By.name("Agree")).click();
		 		 driver.findElement(By.name("Complaint Type")).click();
		 		 driver.findElement(By.name("Complaint Type is required")).click();
		 		 driver.findElement(By.id("State")).click();
		 		 driver.findElement(By.name("Andaman Nicobar")).click();
		 		 driver.findElement(By.name("Purchase City")).click();
		 		 driver.findElement(By.name("Port Blair")).click();
		 		 driver.findElement(By.name("Industry")).click();
		 		 driver.findElement(By.name("Advertisements")).click();
		 		 driver.findElement(By.name("Category")).click();
		 		 driver.findElement(By.name("Advertisements - Others")).click();
		 	WebElement ele=	 driver.findElement(By.name("Company"));
		 		 ele.click();
		 		 
		 		 
		 		 
		 		 int x=ele.getLocation().getX();
		 		 int y=ele.getLocation().getY();
                           
		 		 
		 		TouchAction action =new TouchAction((MobileDriver) driver); 
		 		
		 		action.press(x, y).moveTo(x, y+100).perform().release();
		 		 
		 		 
		 		 
		 		 driver.findElement(By.name("Other")).click();
		 		
		 		 driver.findElement(By.name("Other *")).sendKeys("abc");
		 		 driver.findElement(By.name("Nature of Complaint")).click();
		 		 driver.findElement(By.name("Fraudulent Issue")).click();
		 		 driver.findElement(By.name("Complaint Details *")).sendKeys("abc");
		 		 driver.findElement(By.name("Next")).click();
		 		 //driver.findElement(By.name("Preview before Submit")).click();
		 		 driver.findElement(By.name("Submit")).click();
		 		 driver.findElement(By.name("Submit")).click();
		 		 
		 	 
			 		try {
			 			WebElement element = driver.findElement(By.name("Your Complaint has been successfully lodged and your docket number : "));
			 		
			 		 String Text = element.getText();
			 		 System.out.println(text);
			 		}
			 		 
			 		 
		 		 catch (Exception e) {
		 			
		 			 System.out.println("Your Complaint has been successfully lodged and your docket number");
		 		 }
		 	


}

		 		 
		 		 
		 		 // Register Complaint
                  
		 		public  void yRegisterComplaint() throws Exception {
		 		String text = "Your Complaint has been successfully lodged and your docket number";
		 		Thread.sleep(3000);
		 		System.out.println("before");
		 		 driver.findElement(By.name("Register Complaint")).click();
		 		 System.out.println("after");
		 		 driver.findElement(By.name("Agree")).click();
		 		 driver.findElement(By.name("Complaint Type")).click();
		 		 driver.findElement(By.name("Complaint Type is required")).click();
		 		 driver.findElement(By.id("State")).click();
		 		 driver.findElement(By.name("Andaman Nicobar")).click();
		 		 driver.findElement(By.name("Purchase City")).click();
		 		 driver.findElement(By.name("Port Blair")).click();
		 		 driver.findElement(By.name("Industry")).click();
		 		 driver.findElement(By.name("Advertisements")).click();
		 		 driver.findElement(By.name("Category")).click();
		 		 driver.findElement(By.name("Advertisements - Others")).click();
		 	WebElement ele=	 driver.findElement(By.name("Company"));
		 		 ele.click();
		 		 
		 		 
		 		 
		 		 int x=ele.getLocation().getX();
		 		 int y=ele.getLocation().getY();
                           
		 		 
		 		TouchAction action =new TouchAction((MobileDriver) driver); 
		 		
		 		action.press(x, y).moveTo(x, y+100).perform().release();
		 		 
		 		 
		 		 
		 		 driver.findElement(By.name("Other")).click();
		 		 
		 		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 		 js.executeScript("window.scrollBy(0,1000)");
		 		
		 		 driver.findElement(By.name("Other *")).sendKeys("abc");
		 		 driver.findElement(By.name("Nature of Complaint")).click();
		 		 driver.findElement(By.name("Fraudulent Issue")).click();
		 		 driver.findElement(By.name("Complaint Details *")).sendKeys("abc");
		 		 driver.findElement(By.name("Next")).click();
		 		 //driver.findElement(By.name("Preview before Submit")).click();
		 		 driver.findElement(By.name("Submit")).click();
		 		 driver.findElement(By.name("Submit")).click();
		 		 
		 	 
			 		try {
			 			WebElement element = driver.findElement(By.name("Your Complaint has been successfully lodged and your docket number : "));
			 		
			 		 String Text = element.getText();
			 		 System.out.println(text);
			 		}
			 		 
			 		 
		 		 catch (Exception e) {
		 			
		 			 System.out.println("Your Complaint has been successfully lodged and your docket number");
		 		 }
		 			 
		 		 }
		 			 
		 		 
		 			 
		 		 
		 		 
		 		 
		 		 
			 		 
		 		 
		 		/* driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/recent_drawer_img")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/home_bottom_btn")).click();
		 		 
		 		 }
		 		 @Test
		 		public  void zedit() throws Exception {
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/menuImg")).click();	 
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_myprofile")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/generalLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/edit_profile_txt")).click();
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/change_pic_txt")).click();
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/dialog_gallery_txt")).click();
		 		 //driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		 		 //driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		 		 //driver.findElement(By.id("MENUID_SHUTTER")).click();
		 		 //driver.findElement(By.id("android:id/title")).click();
		 		 //driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'icon_mime')]")).click();
		 		// driver.findElement(By.id("com.android.documentsui:id/icon_mime")).click();
		 		// driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/crop_image_menu_crop")).click();
		 		//WebElement ele =  driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_name_fld"));
		 		// if (ele.getAttribute("value").isEmpty()) {
		 			    //System.out.println("empty");
		 			   // ele.sendKeys("Gurkirat");
		 			//}
		 		 
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_name_fld")).clear();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_name_fld")).sendKeys("Gurkirat");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_gender_fld")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/dialogMaleTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_dob_fld")).click();
		 		 driver.findElement(By.id("android:id/date_picker_header_year")).click();
		 		 driver.findElement(By.id("android:id/text1")).click();
		 		 driver.findElement(By.id("android:id/button1")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_edu_fld")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/txt_item")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_occu_lay_fld")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/txt_item")).click();
		 		 
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_state_fld")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/txt_item")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_distict_fld")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/txt_item")).click();
		 		 
		 		 
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/register_address_fld")).sendKeys("mohali");
		 		 
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/email_remove_action_txt")).click();
		 		 //driver.findElement(By.className("android.widget.LinearLayout")).click();
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/email_add_update_action_txt")).click();
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/email_address_input_fld")).sendKeys("guri@yopmail.com");
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/doneTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_aadhaar")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/link_aadhaar_plus_btn")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/aadhar_complete")).sendKeys("234778736108");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/aadhaarCheck")).click();
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		 		 //driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/iv_back")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/iv_back")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_accounts")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/change_registered_mob_lay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/doneTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/alt_mobile_input_fld")).sendKeys("9592787051");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/iv_back")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/change_mpin_lay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/oldMpinEditComplete")).sendKeys("5555");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/newMpinEditComplete")).sendKeys("5555");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/confirmMpinEditComplete")).sendKeys("5555");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/iv_back")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/forgot_mpin_lay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/update_security_ques_lay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/setSecurityQuesTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/ques_lay1")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/radioBtn")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/ans_edit1")).sendKeys("chd");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/ques_lay2")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/radioBtn")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/ans_edit2")).sendKeys("black");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/next_txt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/pass_code_view")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/doneTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/socialMediaLay")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/menuImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_service_directory")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/search_service_dir")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/et_search_directory")).sendKeys("digisevak");
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/tv_servicedir_title")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/visit_service_txt")).click();
		 		 driver.findElement(By.className("android.widget.Image")).click();
		 		 driver.findElement(By.className("android.widget.Button")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("android.widget.ImageButton")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/menuImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_trans_history")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/filterImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/sortAlphaLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/filterServiceLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/selectServiceLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/item_container")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/ll_apply_services")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/applyBtn")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/menuImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_settings")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/defaultTabLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/radioBtn")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/toggleBannerImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/toggleBannerImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/notifLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/toggleNotificationImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/toggleNotificationImg")).click();
		 		 driver.findElement(By.id("android.widget.ImageButton")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/languageLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/languageLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/menuImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_settings")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/languageLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/languageLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/okTxt")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/menuImg")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/layout_settings")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/fontSizeLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/smallRadio")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/fontSizeLay")).click();
		 		 driver.findElement(By.id("in.gov.umang.negd.g2c.staging:id/normalRadio")).click();
		 		 driver.findElement(By.className("android.widget.ImageButton")).click();
		 	     
		 		
		 }*/
		 

			
			
			 
			 
			 
		     
			
	

		 
		 @AfterTest
		 public void quitDriver()
		 {
			 driver.quit();
		 }
		 
	
	}
	

			
				
				

		 
	
	


