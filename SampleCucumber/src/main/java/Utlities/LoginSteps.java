package Utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginSteps {
	 public LoginSteps(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='Email']")
	WebElement LoginEmail;
	
	@FindBy(how= How.XPATH,using="//input[contains(@id,'Password')]")
	WebElement LoginPassword;
	
	@FindBy(how = How.XPATH,using = "//input[contains(@value,'Log in')]")
	WebElement loginButton;
	
	@FindBy(how = How.XPATH,using ="//a[contains(@href,'/logout')]")
	WebElement logoutlink;
	
	
	//Create action methods for the elements identified
	public void enterEmail(String string) {
		LoginEmail.clear();
		LoginEmail.sendKeys(string);
	}
	
	public void enterPassword(String string) {
		LoginPassword.clear();
		LoginPassword.sendKeys(string);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickLogout() {
		logoutlink.click();
	}


}
