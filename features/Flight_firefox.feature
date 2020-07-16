Feature: Test  the login functionality of mercury tour demo

  Scenario Outline: the user should be able to choose the fastest evening flight in firefox browser
    Given user is in home page opened in firefox browser
    When user enters FromCity in firefox <source> 
    And user enters ToCity <destination>
    And user select the fastest evening flight
    Then user is in flight booking page
    
       Examples: 
      | source   | destination |
      | Delhi  | Bangalore   |
      
      
 
