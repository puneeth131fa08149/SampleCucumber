package Utlities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	By lnkCustomers_Menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomer_MenuItem=By.xpath("//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]");
	By btnAddNew=By.xpath("//a[@class='btn bg-blue']");
	By txtEmail=By.xpath("//input[@name='Email']");
	By txtpassword=By.xpath("//input[@id='Password']");
	By CustomerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

	//By AlreadySelected_custrole = By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[contains(text(),'Registered')]");
	By Administrators_option = By.xpath("//li[contains(text(),'Administrators')]");
	By ForumModerators_option  = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By Guest_option = By.xpath("//li[contains(text(),'Guests')]");
	By Vendors_option = By.xpath("//li[contains(text(),'Vendors')]");

	By drpmgrofVendor=By.id("VendorId");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");

	By FirstName_text=By.id("FirstName");
	By LastName_text=By.name("LastName");
	By DOB_date=By.name("DateOfBirth");
	By Company_name_text=By.id("Company");
	By Admin_comment=By.id("AdminComment");
	By save_button=By.name("save");


	//Actions Methods







	public void ClickonCustomerMenu() {
		driver.findElement(lnkCustomers_Menu).click();
	}
	public void ClickonCustomerMenuItem() {
		driver.findElement(lnkCustomer_MenuItem).click();
	}
	public void ClickOntheAddNew() {
		driver.findElement(btnAddNew).click();
	}
	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);;
	}
	public void setpassword(String password) {
		driver.findElement(txtpassword).sendKeys(password);;
	}
	public void SetManagerofVendor(String value) {
		Select drp=new Select(driver.findElement(drpmgrofVendor));
		drp.selectByVisibleText(value);
	}
	public void SetGender(String gender) {
		if (gender.equals("Male")) {
			driver.findElement(rdMaleGender).click();
		}else if (gender.equals("Female")) {
			driver.findElement(rdFemaleGender).click();
		}else {
			driver.findElement(rdMaleGender).click();
		}
	}

	public void setFirstName(String name) {
		driver.findElement(FirstName_text).sendKeys(name);

	}
	public void setlastName(String name) {
		driver.findElement(LastName_text).sendKeys(name);
	}
	public void SetDOB(String dob) {
		driver.findElement(DOB_date).sendKeys(dob);
	}
	public void SetCompanyName(String company) {
		driver.findElement(Company_name_text).sendKeys(company);
	}
	public void SetAdminContent(String content) {
		driver.findElement(Admin_comment).sendKeys(content);
	}
	public void ClickonSave() {
		driver.findElement(save_button).click();
	}


}
