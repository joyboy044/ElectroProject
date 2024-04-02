Feature: Login
Verify that the user is able to login with valid credentials

#Automation tasks:
#
#1.1 Navigate to Electro page
#1.2 Click on ‘My Account’
#1.3 Enter pre-registered ‘Email’ and ‘Password’
#1.4 Click on the ‘Log In’ button
#1.5 Verify that the user is logged in and on the ‘My Account’ page
#1.6 Close browser
#
  Scenario:Successful login with valid credentials
    Given the user launch browser
    When user opens URL "https://electro.madrasthemes.com/"
    And user clicks on My Account
    And user enters username as "ChangePasswordAutomation" and last password changed
    And clicks on Log in button
    Then the user should be on dashboard
    And close browser