Feature: Change Account Details
  Changing the users First name, Last name and Display name

  #Automation tasks:
#  Change Account Details
#  2.1 Navigate to Electro page
#  2.2 Login
#  2.3 Go to ‘Account details’
#  2.4 Enter ‘First name’, ‘Last name’ and ‘Display name’
#  2.5 Click on Save changes
#  2.6 Verify the “Account details changed successfully.” message is displayed
#  2.7 Close browser
#
  Scenario: Successfully updating users name, last and display name
    Given the user launch browser
    And user opens URL "https://electro.madrasthemes.com/"
    And user clicks on My Account
    When user enters username as "ChangePasswordAutomation" and last password changed
    And clicks on Log in button
    Then the user should be on dashboard
    And click on Account Details
    When system generates random First, Last and Display name
    And user clicks on Save changes
    Then user should receive message "Account details changed successfully."
    And close browser