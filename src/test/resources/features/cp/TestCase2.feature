Feature: Second Scenario
  #○	From the CP home page , hover on  menu Item >> click on New & Features
  #○	Count total number of Videos Feeds and count the videos feeds those are present in the page >= 3d

  Scenario: Second Scenario Steps
    Given I launch the chrome browser
    When I open the DP1 application in prod environment
    And I am on landing page
    And I click Btn_AcceptCookies element
    Then I verify Img_NbaLogo element is displayed