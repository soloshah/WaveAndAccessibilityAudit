//package uk.nhs.nhsbsa.ccchs.steps;
//
//import static org.junit.Assert.*;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.InputEvent;
//import java.awt.event.KeyEvent;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.Map;
//import org.apache.log4j.Logger;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//import org.sikuli.script.FindFailed;
//
////import com.accessibility.AccessibilityScanner;
////import com.accessibility.Result;
////import com.google.inject.Inject;
//
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
//import uk.nhs.nhsbsa.ccchs.config.env.Env;
//import uk.nhs.nhsbsa.ccchs.config.env.EnvConfig;
//import uk.nhs.nhsbsa.ccchs.helpers.CommonMethods;
//import uk.nhs.nhsbsa.ccchs.helpers.GenericData;
//import uk.nhs.nhsbsa.ccchs.helpers.PostgreSQLExample;
//import uk.nhs.nhsbsa.ccchs.utils.Utilities;
//import uk.nhs.nhsbsa.ccchs.views.CreateNewCustomerDetails;
//import uk.nhs.nhsbsa.ccchs.views.CreateNewUserDetails;
//import uk.nhs.nhsbsa.ccchs.views.CustomerSearchDetails;
//import uk.nhs.nhsbsa.ccchs.views.EditExistingCustomerDetails;
//import uk.nhs.nhsbsa.ccchs.views.CreateNewComplaintDetails;
//
//
//public class WaveAccessibilitySteps implements BaseTest
//{
//	public Robot robot;
//	
//	CommonMethods commonMethods = new CommonMethods();
//	
//	uk.nhs.nhsbsa.ccchs.config.env.TestBase TestBase;
//    
//	private static Map<String, Object> wave_report;
//	private static Scenario scenario;
//	private Logger log = Logger.getLogger(WaveAccessibilitySteps.class);
//
//	
//
//	@Before
//	public void setup(Scenario scenario) {
//		this.scenario = scenario;
//	}
//	
//	
//	@Given("^I click WAVE extension$")
//    public void clickWaveExt() throws AWTException, InterruptedException {
//		
//		robot = new Robot();
//		
//		int BUTTON1_MASK=InputEvent.BUTTON1_DOWN_MASK;
//		
//		robot.mouseMove(1380, 82);
//		robot.mousePress(InputEvent.BUTTON1_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_MASK);
//		
//		
//		Thread.sleep(5000);
//	}
//	
//	
//	
//	@Given("^I click WAVE image$")
//    public void clickWaveImage() throws FindFailed {
//		
//		commonMethods.Click_Image("images//wave.png");
//
//	}
//	
//	
//	@Then("^I show WAVE errors$")
//	public static void WAVEErrors()
//	{
//		Map<String, Object> wave_report = new HashMap<String, Object>();
//		
//		List<WebElement> waveTips = driver.findElements(By.className("wave5icon"));
//	
//        Iterator<WebElement> iter = waveTips.iterator();
//        String waveReport = "WAVE ACCESSIBILITY REPORT >>>>>\n";
//        while(iter.hasNext())
//        {
//        	WebElement waveTip = iter.next();
//            if (!waveTip.getAttribute("alt").startsWith("ERRORS:")) continue;
//        	String waveTipAlt = waveTip.getAttribute("alt");
//        	WebElement parentElement = waveTip.findElement(By.xpath("./.."));
//        	String parentID = parentElement.getAttribute("id");
//        	if (parentID.length()<1){
//        		parentElement = parentElement.findElement(By.xpath("./.."));
//            	parentID = "GrandParentID: "+parentElement.getAttribute("id");
//        	}
//        	System.out.println(waveTipAlt);
//        	waveReport += "Error: "+ waveTipAlt+ " ParentID: "+ parentID + "\n"; 
//        }
//
//		wave_report.put("plain_report", waveReport);
//		scenario.write("***** Wave Errors *****\n" + wave_report);
//		  
//    }
//	
//	@Then("^I show WAVE alerts$")
//	public static void WAVEAlerts()
//	{
//		Map<String, Object> wave_report = new HashMap<String, Object>();
//		
//		List<WebElement> waveTips = driver.findElements(By.className("wave5icon"));
//	
//        Iterator<WebElement> iter = waveTips.iterator();
//        String waveReport = "WAVE ACCESSIBILITY REPORT >>>>>\n";
//        while(iter.hasNext())
//        {
//        	WebElement waveTip = iter.next();
//            if (!waveTip.getAttribute("alt").startsWith("ALERTS:")) continue;
//        	String waveTipAlt = waveTip.getAttribute("alt");
//        	WebElement parentElement = waveTip.findElement(By.xpath("./.."));
//        	String parentID = parentElement.getAttribute("id");
//        	if (parentID.length()<1){
//        		parentElement = parentElement.findElement(By.xpath("./.."));
//            	parentID = "GrandParentID: "+parentElement.getAttribute("id");
//        	}
//        	System.out.println(waveTipAlt);
//        	waveReport += "Alerts: "+ waveTipAlt+ " ParentID: "+ parentID + "\n"; 
//        }
//
//		wave_report.put("plain_report", waveReport);
//		scenario.write("***** Wave Alerts *****\n" + wave_report);
//		  
//    }
//	
//	@Then("^I show WAVE features$")
//	public static void WAVEFeatures()
//	{
//		Map<String, Object> wave_report = new HashMap<String, Object>();
//		
//		List<WebElement> waveTips = driver.findElements(By.className("wave5icon"));
//	
//        Iterator<WebElement> iter = waveTips.iterator();
//        String waveReport = "WAVE ACCESSIBILITY REPORT >>>>>\n";
//        while(iter.hasNext())
//        {
//        	WebElement waveTip = iter.next();
//            if (!waveTip.getAttribute("alt").startsWith("FEATURES:")) continue;
//        	String waveTipAlt = waveTip.getAttribute("alt");
//        	WebElement parentElement = waveTip.findElement(By.xpath("./.."));
//        	String parentID = parentElement.getAttribute("id");
//        	if (parentID.length()<1){
//        		parentElement = parentElement.findElement(By.xpath("./.."));
//            	parentID = "GrandParentID: "+parentElement.getAttribute("id");
//        	}
//        	System.out.println(waveTipAlt);
//        	waveReport += "Features: "+ waveTipAlt+ " ParentID: "+ parentID + "\n"; 
//        }
//
//		wave_report.put("plain_report", waveReport);
//		scenario.write("***** Wave Features *****\n" + wave_report);
//		  
//    }
//	
//	
//	@Then("^I show WAVE structural elements$")
//	public static void WAVEStructuralElements()
//	{
//		Map<String, Object> wave_report = new HashMap<String, Object>();
//		
//		List<WebElement> waveTips = driver.findElements(By.className("wave5icon"));
//	
//        Iterator<WebElement> iter = waveTips.iterator();
//        String waveReport = "WAVE ACCESSIBILITY REPORT >>>>>\n";
//        while(iter.hasNext())
//        {
//        	WebElement waveTip = iter.next();
//            if (!waveTip.getAttribute("alt").startsWith("STRUCTURAL ELEMENTS:")) continue;
//        	String waveTipAlt = waveTip.getAttribute("alt");
//        	WebElement parentElement = waveTip.findElement(By.xpath("./.."));
//        	String parentID = parentElement.getAttribute("id");
//        	if (parentID.length()<1){
//        		parentElement = parentElement.findElement(By.xpath("./.."));
//            	parentID = "GrandParentID: "+parentElement.getAttribute("id");
//        	}
//        	System.out.println(waveTipAlt);
//        	waveReport += "Structural Elements: "+ waveTipAlt+ " ParentID: "+ parentID + "\n"; 
//        }
//
//		wave_report.put("plain_report", waveReport);
//		scenario.write("***** Wave Structural Elements *****\n" + wave_report);
//		  
//    }
//
//	
//	@Then("^I show WAVE html5 and aria$")
//	public static void WAVEHtml5AndAria()
//	{
//		Map<String, Object> wave_report = new HashMap<String, Object>();
//		
//		List<WebElement> waveTips = driver.findElements(By.className("wave5icon"));
//	
//        Iterator<WebElement> iter = waveTips.iterator();
//        String waveReport = "WAVE ACCESSIBILITY REPORT >>>>>\n";
//        while(iter.hasNext())
//        {
//        	WebElement waveTip = iter.next();
//            if (!waveTip.getAttribute("alt").startsWith("HTML5 AND ARIA:")) continue;
//        	String waveTipAlt = waveTip.getAttribute("alt");
//        	WebElement parentElement = waveTip.findElement(By.xpath("./.."));
//        	String parentID = parentElement.getAttribute("id");
//        	if (parentID.length()<1){
//        		parentElement = parentElement.findElement(By.xpath("./.."));
//            	parentID = "GrandParentID: "+parentElement.getAttribute("id");
//        	}
//        	System.out.println(waveTipAlt);
//        	waveReport += "Html5 and Aria: "+ waveTipAlt+ " ParentID: "+ parentID + "\n"; 
//        }
//
//		wave_report.put("plain_report", waveReport);
//		scenario.write("***** Wave Html5 and Aria *****\n" + wave_report);
//		  
//    }
//	
//	
//	@Then("^I show WAVE contrast errors$")
//	public static void WAVEContrastErrors()
//	{
//		Map<String, Object> wave_report = new HashMap<String, Object>();
//		
//		List<WebElement> waveTips = driver.findElements(By.className("wave5icon"));
//	
//        Iterator<WebElement> iter = waveTips.iterator();
//        String waveReport = "WAVE ACCESSIBILITY REPORT >>>>>\n";
//        while(iter.hasNext())
//        {
//        	WebElement waveTip = iter.next();
//            if (!waveTip.getAttribute("alt").startsWith("CONTRAST ERRORS:")) continue;
//        	String waveTipAlt = waveTip.getAttribute("alt");
//        	WebElement parentElement = waveTip.findElement(By.xpath("./.."));
//        	String parentID = parentElement.getAttribute("id");
//        	if (parentID.length()<1){
//        		parentElement = parentElement.findElement(By.xpath("./.."));
//            	parentID = "GrandParentID: "+parentElement.getAttribute("id");
//        	}
//        	System.out.println(waveTipAlt);
//        	waveReport += "Contrast Errors: "+ waveTipAlt+ " ParentID: "+ parentID + "\n"; 
//        }
//
//		wave_report.put("plain_report", waveReport);
//		scenario.write("***** Wave Contrast Errors *****\n" + wave_report);
//		  
//    }
//	
//
//	
//	
//	@SuppressWarnings("null")
//	@When("^I take screenshot of wave page$")
//	public void TakeScreenshotWavePage() {
//		
//		final byte[] screenshot = ((TakesScreenshot) driver)
//				.getScreenshotAs(OutputType.BYTES);
//		
//		scenario.embed(screenshot, "image/png");
//
//	}
//	
//	
//
//
////	@After
////	public void tearDown(Scenario scenario) {
////	try {
////		if (audit_report != null && audit_report.containsKey("screenshot")) {
////			final byte[] screenshot = (byte[]) audit_report
////					.get("screenshot");
////			log.warn("Writing screenshot ");
////			scenario.embed(screenshot, "image/png");
////		}
////	} finally {
////		driver.quit();
////	}
////}
//	
////}
//	
//
//}
//
