Feature: Customers 

Background: Below are the commen steps for each scenario 
	Given user open browser 
	When user open URL "https://admin-demo.nopcommerce.com/login" 
	When user enters Email as "admin@yourstore.com" and Password as "admin" 
	Then clicks on login button 
	Then user can see dashBoard 
	
Scenario: Add a new Customer 
	When user click on Cuctomer menu 
	And click on Customer Menu item 
	And click on add new button 
	Then user can view Add new customer page 
	When enter customer info 
	And click on Save button 
	Then user can view configuration message "The new customer has been added successfully." 
	And close browser 
	
	
Scenario: Search Customer by EmailId 
	When user click on Cuctomer menu 
	And click on Customer Menu item 
	And Enter Customer EmailId 
	When click on Search button 
	Then user should found Email in the search table 
	And close browser 
	
	
Scenario: Search Customer by Names 
	When user click on Cuctomer menu 
	And click on Customer Menu item 
	And Enter Customer FirstName 
	And Enter Customer LastName 
	When click on Search button 
	Then user should found Name in the search table 
	And close browser 
	