#This is written for training Purpose
Feature: Login into firebase application
Background:
	Given User open firebase application
	@smoke
  Scenario: Login with valid user and valid password
     
    When user on "LoginPage"
    When User enters value into text box username as "admin123@gmail.com"
    When User enters value into text box password as "admin123"
    When Click on Login button
    When user on "Homepage"
    Then verify page title as "Selenium"
    
    @regression
   Scenario: Login with invalid user and invalid password
   
    When user on "LoginPage"
    When User enters value into text box username as "admin12345@gmail.com"
    When User enters value into text box password as "admin12345"
    When Click on Login button
    Then alert is present with the text "Error : There is no user record corresponding to this identifier. The user may have been deleted."
   

 
