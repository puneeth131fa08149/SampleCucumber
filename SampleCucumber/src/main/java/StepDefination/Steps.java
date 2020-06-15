package StepDefination;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utlities.AddCustomerPage;
import Utlities.LoginSteps;
import Utlities.SearchCustomerPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends BaseClass {

	//	@Before
	//	public void startUp() throws IOException {
	//		
	//	}
	@Given("^user open browser$")
	public void user_open_browser() throws Throwable {
		logger=logger.getLogger("SampleCucumber");
		PropertyConfigurator.configure("log.properties");

		Configprop=new Properties();
		FileInputStream confibPropFile=new FileInputStream("E:\\E\\CucumberProject\\SampleCucumber\\config.properties");
		Configprop.load(confibPropFile);



		System.setProperty("webdriver.chrome.driver", Configprop.getProperty("chrome_path"));
		driver = new ChromeDriver();
		logger.info("********Lanching Browser**************");


		lp=new LoginSteps(driver);
	}

	@Given("^user open URL \"([^\"]*)\"$")
	public void user_open_URL(String url) throws Throwable {
		driver.manage().window().maximize();

		driver.get(url);
		logger.info("********Lanching URL**************");
	}

	@When("^user enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String un, String pwd) throws Throwable {
		logger.info("********Providing login Details**************");
		lp.enterEmail(un);
		lp.enterPassword(pwd);
	}

	@Then("^clicks on login button$")
	public void clicks_on_login_button() throws Throwable {
		logger.info("********Starting loginr**************");
		lp.clickLogin();
	}

	@Then("^page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) throws Throwable {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logger.info("********Login passed**************");
			Assert.assertTrue(false);
		} else {
			logger.info("********Login failure**************");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("^user click on logout link$")
	public void user_click_on_logout_link() throws Throwable {
		logger.info("********Click on logout link**************");
		lp.clickLogout();
	}

	@Then("^pgae title should be \"([^\"]*)\"$")
	public void pgae_title_should_be(String arg1) throws Throwable {
		String actualtitle="Your store. Login";
		String expectedtitle=driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		logger.info("********Closing Browser**************");
		driver.close();
	}
	//Customer feature step Definitions............................ 
	@Then("^user can see dashBoard$")
	public void user_can_see_dashBoard() throws Throwable {
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("^user click on Cuctomer menu$")
	public void user_click_on_Cuctomer_menu() throws Throwable {
		addCust.ClickonCustomerMenu();


	}

	@When("^click on Customer Menu item$")
	public void click_on_Customer_Menu_item() throws Throwable {
		Thread.sleep(3000);
		addCust.ClickonCustomerMenuItem();

	}

	@When("^click on add new button$")
	public void click_on_add_new_button() throws Throwable {
		addCust.ClickOntheAddNew();
	}

	@Then("^user can view Add new customer page$")
	public void user_can_view_Add_new_customer_page() throws Throwable {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("^enter customer info$")
	public void enter_customer_info() throws Throwable {
		logger.info("********Adding new Customer**************");
		logger.info("********Providing customer Details**************");
		String email=randomstring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setpassword("test123");
		addCust.SetManagerofVendor("Vendor 2");
		addCust.SetGender("Male");
		Thread.sleep(3000);
		addCust.setFirstName("puneeth");
		addCust.setlastName("Malepati");
		addCust.SetDOB("5/02/1994");
		addCust.SetCompanyName("busyQA");
		addCust.SetAdminContent("This is for Automation testing");

	}

	@When("^click on Save button$")
	public void click_on_Save_button() throws Throwable {
		logger.info("********Saving cuctomer Data**************");
		addCust.ClickonSave();
	}

	@Then("^user can view configuration message \"([^\"]*)\"$")
	public void user_can_view_configuration_message(String text) throws Throwable {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}

	//Search for searching a customer using EmailId..............	
	@When("^Enter Customer EmailId$")
	public void enter_Customer_EmailId() throws Throwable {
		logger.info("********Searching customer EmailId**************");
		searchcust=new SearchCustomerPage(driver);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("^click on Search button$")
	public void click_on_Search_button() throws Throwable {
		searchcust.clicksearch();
		Thread.sleep(3000);
	}

	@Then("^user should found Email in the search table$")
	public void user_should_found_Email_in_the_search_table() throws Throwable {
		searchcust.SearchCustomerByEmail("victoria_victoria@nopCommerce.com");
		//		System.out.println(status);
		//		Assert. assertEquals(true,status);
	}
	@When("^Enter Customer FirstName$")
	public void enter_Customer_FirstName() throws Throwable {
		logger.info("********Searching yhe customer by firstName**************");
		searchcust=new SearchCustomerPage(driver);
		searchcust.setFirstName("Victoria ");
	}

	@When("^Enter Customer LastName$")
	public void enter_Customer_LastName() throws Throwable {
		logger.info("********Searching the Customer By LastName**************");
		searchcust.setLastName("Terces");
	}

	@Then("^user should found Name in the search table$")
	public void user_should_found_Name_in_the_search_table() throws Throwable {
		searchcust.SearchCustomerByName("Victoria Terces");
		// Assert.assertEquals(true, status);
	}




}
