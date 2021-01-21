Feature: Checking functionality of registration page

  Scenario: Check registration is successful with valid credentials
    Given Open the Chrome and start application
    And user is on registration page
    When User enter all valid details
    And user clicks on signup button
    Then user is navigated to login
    When user enters username and password
    And user clicks on login
    Then user is navigated to homepage
   # And user click on profile image
   # And user click on books
    Then user clicks on search button
    Then user clicks search bar and  search the books
    Then user clicks search button
    Then user clicks on add to favorite button
    Then user clicks favirote textlink
    And user navigated to HomePage
    #Then user click on profile
    #Then user selects on books
    Then user clicks on search btn
    Then user clicks search bar for recommendation
    Then user click search button
    Then user clicks on add to recommendation button
   # And user will navigated to HomePage
    #Then user clicks on profile image for recommendation
    Then user selects recommendation
    

