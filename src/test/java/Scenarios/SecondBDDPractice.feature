Feature: second homework
  2. Create a new UI project with Maven, JUnit, Allure, and Selenide Framework https://magento.softwaretestingboard.com/ using Page Object Model.
  2.1 * Use Gradle instead of Maven - optional task
  2.2 Add one clothes item to the cart (choose a size and color) and create an order.
  2.3 Add a few watches/bags to the cart and delete one
  2.4 * Add negative cases - optional task

  Scenario: 2.2 User can add clothes item to the cart
    Given url "https://magento.softwaretestingboard.com/" is opened
    When user hovers a mouse over "Men button" element
    And user hovers a mouse over "Bottoms button" element
    And user hovers a mouse over "Shorts button" element
    And user clicks on "Shorts" button
    And user selected "yellow" color "32" size "Torque Power Short" shorts
    Then element "Items counter label" should contain "1" text
    When user clicks on "Cart" button
    And element "Checkout button" should become visible
    And user clicks on "Checkout" button
    Then element "Email input" should become visible
    And user enters "testvgkbnbl@gmail.com" in "Email" input
    Then element "First name input" should become visible
    And user clicks on "First name" input
    And user enters "Ivan" in "First name" input
    And user enters "Ivanov" in "Last name" input
    And user enters "SPB.RU" in "Street address" input
    And user enters "Kaliningrad" in "City" input
    And user clicks on "State-province" button
    And user clicks on "California" dropdown item
    And user enters "236011" in "Postal code" input
    And user enters "64237894623" in "Phone number" input
    And user clicks on "Shipping method" radio button
    And user clicks on "Next" button
    And element "Place order button" should become visible
    And user clicks on "Place order" button
    And element "Confirmation label" should become visible
    And element "Confirmation label" should contain "Thank you for your purchase!" text

  Scenario: 2.3 User can add a few watches/bags to the cart and delete one
    Given url "https://magento.softwaretestingboard.com/" is opened
    When user hovers a mouse over "Gear button" element
    And user clicks on "Watches" button
    And user adds to cart watches with title "Bolo Sport Watch"
    Then element "Items counter label" should contain "1" text
    And user adds to cart watches with title "Clamber Watch"
    Then element "Items counter label" should contain "2" text
    And user adds to cart watches with title "Dash Digital Watch"
    Then element "Items counter label" should contain "3" text
    When user clicks on "Cart" button
    And element "Checkout button" should become visible
    When user deletes "Dash Digital Watch" from minicart
    Then element "Confirm button" should become visible
    And user clicks on "Confirm" button
    Then element "Items counter label" should contain "2" text

