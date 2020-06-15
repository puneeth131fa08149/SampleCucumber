Feature: LOGIN

Scenario: Sucessfully login with valid credentials 
Given user open browser
When user open URL "https://admin-demo.nopcommerce.com/login"
When user enters Email as "admin@yourstore.com" and Password as "admin"
Then clicks on login button
And page Title should be "Dashboard / nopCommerce administration"
When user click on logout link
Then  pgae title should be "Your store. Login"
And close browser

#
#
#Scenario Outline: Login Data Driven
#Given user open browser
#When user open URL "https://admin-demo.nopcommerce.com/login"
#When user enters Email as "<email>" and Password as "<password>"
#Then clicks on login button
#And page Title should be "Dashboard / nopCommerce administration"
#When user click on logout link
#Then  pgae title should be "Your store. Login"
#And close browser
#Examples:
#|email|password|
#|admin@yourstore.com| admin|
#|padmin@yourstore.com| admin|

