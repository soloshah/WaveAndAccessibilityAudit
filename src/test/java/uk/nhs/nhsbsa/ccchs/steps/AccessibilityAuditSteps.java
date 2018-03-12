package uk.nhs.nhsbsa.ccchs.steps;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;

import com.google.inject.Inject;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.nhs.nhsbsa.ccchs.config.env.BaseTest;
import uk.nhs.nhsbsa.ccchs.config.env.Env;
import uk.nhs.nhsbsa.ccchs.config.env.EnvConfig;
import uk.nhs.nhsbsa.ccchs.helpers.CommonMethods;
import uk.nhs.nhsbsa.ccchs.helpers.GenericData;
import uk.nhs.nhsbsa.ccchs.helpers.PostgreSQLExample;
import uk.nhs.nhsbsa.ccchs.utils.Utilities;
import uk.nhs.nhsbsa.ccchs.views.CreateNewCustomerDetails;
import uk.nhs.nhsbsa.ccchs.views.CreateNewUserDetails;
import uk.nhs.nhsbsa.ccchs.views.CustomerSearchDetails;
import uk.nhs.nhsbsa.ccchs.views.EditExistingCustomerDetails;
import uk.nhs.nhsbsa.ccchs.views.CreateNewComplaintDetails;


public class AccessibilityAuditSteps implements BaseTest
{
	
	CommonMethods commonMethods = new CommonMethods();
	uk.nhs.nhsbsa.ccchs.config.env.TestBase TestBase;
    
	private Scenario scenario;
	private Logger log = Logger.getLogger(AccessibilityAuditSteps.class);
	private JavascriptExecutor js;
	private String accessibility_content;
    private String jquery_content;

	
	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;
	}
	

	@When("^I run accessibility audit report$")
	public void I_run_accessibility_audit_report() throws Throwable {
		
		Map<String, Object> audit_report = new HashMap<String, Object>();
		
		jquery_content = Jsoup.connect(EnvConfig.getJquerycdnurl()).ignoreContentType(true).execute().body();
		accessibility_content = Jsoup.connect(EnvConfig.getApplicationcdnurl()).ignoreContentType(true).execute().body();
	    
	    js = (JavascriptExecutor) driver;
	    js.executeScript(accessibility_content);
	    String accessibility_tests = "var auditConfig = new axs.AuditConfiguration(); "
				+ "var results = axs.Audit.run(auditConfig);"
				+ "var auditResults = axs.Audit.auditResults(results);"
				+ "var report = axs.Audit.createReport(results);return report";
		
		String report = (String) js.executeScript(accessibility_tests);

		log.info(report);

		final byte[] screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		audit_report.put("screenshot", screenshot);
		audit_report.put("plain_report", report);
		
		assertNotNull(audit_report);
		
		if (audit_report.containsKey("plain_report")) {
			scenario.write(audit_report.get("plain_report").toString());
		}
		
	}
    
    
    
	@When("^I run accessibility audit$")
	public void I_run_accessibility_audit() throws Throwable {
		
		Map<String, Object> audit_report = new HashMap<String, Object>();
		
		jquery_content = Jsoup.connect(EnvConfig.getJquerycdnurl()).ignoreContentType(true).execute().body();
		accessibility_content = Jsoup.connect(EnvConfig.getApplicationcdnurl()).ignoreContentType(true).execute().body();
	    
	    js = (JavascriptExecutor) driver;
	    js.executeScript(accessibility_content);
	    String accessibility_tests = "var auditConfig = new axs.AuditConfiguration(); "
				+ "var results = axs.Audit.run(auditConfig);"
				+ "var auditResults = axs.Audit.auditResults(results);"
				+ "var report = axs.Audit.createReport(results);return report";
		
		String report = (String) js.executeScript(accessibility_tests);

		log.info(report);


		try {
			log.info(js.executeScript("$.active;"));
		} catch (WebDriverException e) {
			System.out.println("messageddfddsf...." + e);
			log.info("++++++++Injecting jQuery+++++++++++++");
			js.executeScript(jquery_content);
		}

		List<Result> errors = parseReport(report, "Error:");
		List<Result> warnings = parseReport(report, "Warning:");
		
		decorateElements(errors, "red");
		decorateElements(warnings, "yellow");
		final byte[] screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		audit_report.put("error", errors);
		audit_report.put("warning", warnings);
		audit_report.put("screenshot", screenshot);
		audit_report.put("plain_report", report);
		
		assertNotNull(audit_report);
		
		if (audit_report.containsKey("plain_report")) {
			scenario.write(audit_report.get("plain_report").toString());
		}
		
	}
	

	@When("^I parse report$")
	public List<Result> parseReport(String report, String filter_on) {
		if (filter_on.toLowerCase().contains("error"))
			filter_on = "Error:";
		else if (filter_on.toLowerCase().contains("warning"))
			filter_on = "Warning:";
		else
			throw new IllegalArgumentException(
					"Currently only support filtering on Error: and Warning:");
		if (report == null)
			throw new NullPointerException("Report to parse cannot be null");
		List<Result> parsed_result = new ArrayList<Result>();
		int start_error = report.indexOf(filter_on);
		while (start_error > 0) {
			Result result = new Result();
			int end = report.indexOf("\n\n", start_error);
			String error = report.substring(start_error + filter_on.length(),
					end).trim();
			result.setRule(error.substring(0, error.indexOf("\n")));
			String link = null;
			String[] locators;
			int element_start = error.indexOf("\n") + 1;
			String element;
			if (error.indexOf("See") > 0) {
				element = error.substring(element_start, error.indexOf("See"));
				link = error.substring(error.indexOf("See"));
			} else {
				element = error.substring(element_start);
			}
			locators = element.split("\n");
			result.setElements(Arrays.asList(locators));
			result.setUrl(link);
			parsed_result.add(result);
			start_error = report.indexOf(filter_on, end);
		}
		
		System.out.println("parsed_result: " + parsed_result);
		return parsed_result;
	}
    
	
	@When("^I decorate elements$")
	public void decorateElements(List<Result> results, String color) {
		for (Result result : results) {
			List<String> locators = result.getElements();
			addBorder(locators, result.getRule(), color);
		}
	}
	
	
	@When("^I add border$")
	public void addBorder(List<String> locators, String rule, String color) {
		for (String locator : locators) {
			rule = "<p>" + rule + "</p>";
			String script = "$(\"" + locator
					+ "\").css(\"border\",\"5px solid " + color + "\")";
			js.executeScript(script);
		}
	}
	
	
	
	
	@Then("^I am able to run the scanner successfully$")
	public void I_am_able_to_run_the_scanner_successfully() throws Throwable {
		
		Map<String, Object> audit_report = new HashMap<String, Object>();
		
		if (audit_report.containsKey("error")) {
			List<Result> errors = (List<Result>) audit_report.get("error");

			for (Result error : errors) {
				log.info(error.getRule());//e.g. AX_TEXT_01 (Controls and media ....
				log.info(error.getUrl());//e.g. See https://github.com/GoogleChrome/accessibility-developer-tools/wiki....
				for (String element : error.getElements())
					log.info(element);//e.g. #myForm > P > INPUT
			}

//			One can add asserts like these
//			assertThat("No accessibility errors expected", errors.size(),
//					equalTo(0));
		}
	}
	
	
	
	@SuppressWarnings("null")
	@When("^I take screenshot of audit page$")
	public void TakeScreenshotWavePage() {
		
		final byte[] screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		
		scenario.embed(screenshot, "image/png");

	}
	
	
}
    

