Feature: login Functionality
Background:
Given User opens SalesForce App

Scenario: password feild blank 
When user on  "LoginPage"
When user enters Username as  "chaithrahuragi@tekarch.com"
And click on loginButton
Then verify the error message displayed 


Scenario:  login with valid usename and valid password
When user on  "LoginPage"
When user enters Username as  "chaithrahuragi@tekarch.com"
And user enters password as  "Samarth@2016"
And click on loginButton
When user on  "HomePage"
Then verify for homepage


Scenario:  test the remember username checkbox
When user on  "LoginPage"
When user enters Username as  "chaithrahuragi@tekarch.com"
And user enters password as  "Samarth@2016"
And click RememberMe
And click on loginButton
When user on  "HomePage"
And click LogoutButton
When user on  "LoginPage"
Then check for RememberMe

Scenario:  login with invalid usename and invalid password
When user on  "LoginPage"
When user enters Username as  "123"
And user enters password as  "2345"
And click on loginButton
Then verify for errorLoginMessage


Scenario:  validate forgotpassword
When user on  "LoginPage"
And click on forgotPassword
When user on  "ForgotPassword"
Then verify for forgotPageTitle






