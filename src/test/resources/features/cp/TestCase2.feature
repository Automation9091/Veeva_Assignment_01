Feature: Second Scenario
  #○	From the CP home page , hover on  menu Item >> click on New & Features
  #○	Count total number of Videos Feeds and count the videos feeds those are present in the page >= 3d

  Scenario: Second Scenario Steps
    Given I launch the chrome browser
    When I open the CP application in prod environment
    And I am on landing page
    And I click Btn_AcceptCookies element if exists
    And I click Btn_Close element if exists
    Then I verify Img_NbaLogo element is displayed
    And I wait for 2 seconds
    And I mouse hover the Btn_ThreeDots element
    And I click Lnk_NewsAndFeatures element
    And I am on news page
    Then I verify Lbl_News element is displayed
    And I pull out all videos from Videos section
    And I close the browser
