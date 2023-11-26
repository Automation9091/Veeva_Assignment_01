Feature: Feature of DP1
  #○	Go to DP1 home page
  #○	Below Tickets Menu, count number of slides present
  #○	Get the title of each Slide and validate with expected test data
  #○	Count how much duration each slide is playing and validate with the expected duration

  Scenario: First scenario of DP1
    Given I launch the chrome browser
    When I open the DP1 application in prod environment
    And I am on landing page
    And I click Btn_AcceptCookies element
