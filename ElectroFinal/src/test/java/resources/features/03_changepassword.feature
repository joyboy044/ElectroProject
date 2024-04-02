Feature: Change Password
  Verify that user is able to change password

  #Automation tasks:
#  Change Password
#  3.1 Navigate to Electro page
#  3.2 Login
#  3.3 Go to ‘Account Details’
#  3.4 Enter ‘Current password’, ‘New password’ and ‘Confirm new password’
#  3.5 Click on Save changes
#  3.6 Verify the “Account details changed successfully.” message is displayed
#  3.7 Log out and verify that the user can login with the new password
#  3.8 Close browser
#
  Scenario: Successful Password Change
    Given the user launch browser
    And user opens URL "https://electro.madrasthemes.com/"
    And user clicks on My Account
    When user enters username as "ChangePasswordAutomation" and last password changed
    And clicks on Log in button
    Then the user should be on dashboard
    And click on Account Details
    When system enters last password changed
    And generates new password
    And user clicks on Save changes
    Then user should receive message "Account details changed successfully."
    And user clicks on log out button
    When user re enters username and new created password
    And clicks on Log in button
    Then the user should be on dashboard
    And close browser