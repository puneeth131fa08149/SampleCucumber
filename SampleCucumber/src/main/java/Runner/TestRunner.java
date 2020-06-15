package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="E:\\E\\CucumberProject\\SampleCucumber\\src\\main\\java\\FeatureFile\\",
		glue= {"StepDefination"},
		plugin = {"pretty","html:target/cucumber-html-report",
				"json:target/cucumber-reports/cucumber.json",
		},
		monochrome=true,
		dryRun=false

		)

public class TestRunner {
	//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
//	public static ExtentHtmlReporter htmlreport;
//	public static ExtentReports extent;
//	public ExtentTest test;
//
//	@BeforeTest()
//	public static void setup() {
//		htmlreport=new ExtentHtmlReporter("./reports/extend-html");
//		htmlreport.config().setEncoding("UTF-8");
//		htmlreport.config().setDocumentTitle("Cucumber Project");
//		htmlreport.config().setTheme(Theme.STANDARD);
//
//		extent=new ExtentReports();
//		extent.attachReporter(htmlreport);
//
//		extent.setSystemInfo("Automation Tester", "PUNEETH");
//		extent.setSystemInfo("OS", "windows 10");
//		extent.setSystemInfo("JAVA Version", "8.1");
//
//	}
//	@AfterTest()
//	public void tearDown() {
//		extent.flush();
//	}
}
