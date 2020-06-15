package StepDefination;



import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Utlities.AddCustomerPage;
import Utlities.LoginSteps;
import Utlities.SearchCustomerPage;

public class BaseClass {
	public LoginSteps lp;
	public	WebDriver driver;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchcust;
	public Logger logger;
	public  Properties Configprop;
	public static String generstedstring1;
	
	
	//Created for generating random string Unique EmailId
	public static String randomstring() {
		generstedstring1 = RandomStringUtils.randomAlphabetic(5);
		return (generstedstring1);
	}
}
