Feature: first homework
  1. Create a new UI project with Maven, JUnit, and Selenide Framework
  1.1 Use Gradle instead of Maven - optional task
  1.2 Create test cases and write 4 BDD tests for https://katalon-demo-cura.herokuapp.com/ using Page Object Model.
  1.2.1 Login with the wrong password


  Open the main page
  Enter an username
  Enter an incorrect password
  Click on Login
  Check message

  1.2.2 Create an appointment in Seoul

  Open the main page
  Login
  Click on “Make an appointment.”
  Choose “​​Seoul CURA Healthcare Center”
  Choose “Medicaid”
  Choose a visit date (current date + 1 day)
  Click on “Book an appointment.”
  Check “Appointment Confirmation”

  1.2.3 Check profile

  Open the main page
  Login
  Open Profile page
  Check the text “Under construction.”

  1.2.4 Check history

  Open the main page
  Login
  Create an appointment (steps from 1.2.2)
  Click on “History”
  Check appointment data (Facility, Apply for hospital readmission, Healthcare Program, Comment, and Date)

  1.2.5 * Add negative cases - optional task

  Scenario: 1.2.1. User can not login with wrong password
    Given url "https://katalon-demo-cura.herokuapp.com/" is opened
    When user clicks on "make appointment" button
    Then element "login input" should become visible
    When user enters "test-login" in "login" input
    And user enters "test-password" in "password" input
    And user clicks on "submit" button
    Then element "error message label" should become visible
    And element "error message label" should contain "Login failed! Please ensure the username and password are valid." text

  Scenario: 1.2.2. User can arrange an appointment
    Given url "https://katalon-demo-cura.herokuapp.com/" is opened
    When user clicks on "make appointment" button
    Then element "login input" should become visible
    When user enters "John Doe" in "login" input
    And user enters "ThisIsNotAPassword" in "password" input
    And user clicks on "submit" button
    Then element "select facility dropdown" should become visible
    When user clicks on "Seoul CURA Healthcare Center" dropdown item
    And user clicks on "Medicaid" radio button
    And user clicks on "Visit date" datepicker
    And user enters next day in "Visit date" datepicker
    And user clicks on "Book appointment" button
    Then element "Appointment confirmation label" should become visible
    And element "Appointment confirmation label" should contain "your appointment has been booked" text

  Scenario: 1.2.3. User can check profile
    Given url "https://katalon-demo-cura.herokuapp.com/" is opened
    When user clicks on "Menu" toggle
    And user clicks on "Login" button
    Then element "login input" should become visible
    When user enters "John Doe" in "login" input
    And user enters "ThisIsNotAPassword" in "password" input
    And user clicks on "submit" button
    And user clicks on "Menu" toggle
    And user clicks on "Profile" button
    Then element "Profile information label" should become visible
    And element "Profile information label" should contain "Under construction" text

  Scenario: 1.2.4. User can check history
    Given url "https://katalon-demo-cura.herokuapp.com/" is opened
    When user clicks on "Menu" toggle
    And user clicks on "Login" button
    Then element "login input" should become visible
    When user enters "John Doe" in "login" input
    And user enters "ThisIsNotAPassword" in "password" input
    And user clicks on "submit" button
    When user clicks on "make appointment" button
    Then element "select facility dropdown" should become visible
    When user clicks on "Seoul CURA Healthcare Center" dropdown item
    And user clicks on "Medicaid" radio button
    And user clicks on "Visit date" datepicker
    And user enters next day in "Visit date" datepicker
    And user clicks on "Book appointment" button
    Then element "Appointment confirmation label" should become visible
    And element "Appointment confirmation label" should contain "your appointment has been booked" text
    When user clicks on "Menu" toggle
    And user clicks on "History" button
    Then element "Appointment table" should become visible
    And element "Appointment table" should contain "Seoul CURA Healthcare Center" text
    And element "Appointment table" should contain "Medicaid" text

