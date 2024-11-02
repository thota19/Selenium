Feature: User Login
  As a registered user
  I want to log in to my account
  So that I can access my dashboard

  Scenario: Successful login
    Given I am on the login page
    And I have a valid account
    When I enter valid credentials
    Then I should be redirected to the dashboard
    But I should not see any error message

 
    
  Scenario Outline: Unsuccessful login attempts
    Given I am on the login page
    And I have an account
    When I enter the "<username>" and "<password>"
    Then I should see an error message
    But I should remain on the login page  
    
    Examples: 
      | username      | password    |
      | inavalidUser1 | wrongPass1  |
      | inavalidUser2 | wrongPass2  |
      | inavalidUser3 | wrongPass3  |
