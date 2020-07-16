Feature: Test  the login functionality of mercury tour demo

  Scenario Outline: the user should be able to choose the fastest evening flight in chrome browser
    Given user is in home page opened in chrome browser
    When user enters source <source> 
    And user enters destination <destination>
    And user select the fastest evening flight
    Then user is in flight booking page
    
       Examples: 
      | source   | destination |
      | Delhi  | Bangalore   |
      

      
      
 
