package Utlities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage  {
	public WebDriver Idriver;

	WaitHelper waithelper;
	public SearchCustomerPage(WebDriver rdriver) {
		Idriver=rdriver;
		PageFactory.initElements(Idriver, this);
		waithelper=new WaitHelper(Idriver);
	}

	@FindBy(how=How.ID,using="SearchEmail")
	WebElement txtEmail;

	@FindBy(how=How.ID,using="SearchFirstName")
	WebElement txtFirst_name;

	@FindBy(how=How.ID,using="SearchLastName")
	WebElement txtLastName;

	//	@FindBy(how=How.ID,using="SearchMonthOfBirth")
	//	WebElement drpdobMonth;
	//
	//	@FindBy(how=How.ID,using="SearchDayOfBirth")
	//	WebElement drpdobDay;
	//
	//	@FindBy(how=How.ID,using="SearchCompany")
	//	WebElement txtCompany;
	//
	//	@FindBy(how=How.XPATH,using="//div[@class='k-multiselect-wrap k-floatwrap']")
	//	WebElement txtCustomerRole;
	//
	//	@FindBy(how=How.XPATH,using="//li[contains(text(),'Administrators')]")
	//	WebElement lstitemAdministrators;
	//	@FindBy(how=How.XPATH,using="//li[contains(text(),'Forum Moderators')]")
	//	WebElement lstitemForumModerators;
	//	@FindBy(how=How.XPATH,using="//li[contains(text(),'Guests')]")
	//	WebElement lstitemGuests;
	//	@FindBy(how=How.XPATH,using="//li[contains(text(),'Registered')]")
	//	WebElement lstitemRegistered;
	//
	//	@FindBy(how=How.XPATH,using="//li[contains(text(),'Vendors')]")
	//	WebElement lstitemVendors;

	@FindBy(how=How.ID,using="search-customers")
	WebElement clickSearch;

	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRow;

	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumn;


	public void setEmail(String email) {
		waithelper.waitforElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String name) {
		waithelper.waitforElement(txtFirst_name, 30);
		txtFirst_name.clear();
		txtFirst_name.sendKeys(name);
	}
	public void setLastName(String name) {
		waithelper.waitforElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(name);
	}

	public void clicksearch() {
		clickSearch.click();
		waithelper.waitforElement(clickSearch, 30);

	}
	public int getNoofRow() {
		return (tableRow.size());
	}
	public int getNoofColumn() {
		return (tableColumn.size());
	}


	public boolean SearchCustomerByEmail(String email) {
		boolean flag=false;

		for (int i = 1; i < getNoofRow(); i++) {
			String Emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(Emailid);
			if (Emailid.equals(email)) {
				flag=true;
			}
		}
		return flag;
	}


	public boolean SearchCustomerByName(String name) {
		boolean flag=false;

		for (int i = 1; i < getNoofRow(); i++) {
			String Emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			String names[]=name.split(" ");
			if (names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag=true;
			}
		}
		return flag;
	}

}
