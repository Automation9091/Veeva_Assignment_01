@Regression
Feature: Test
  #○	From the CP home page , go to >> Shop Menu >> Men’s
  #○	Find all Jackets ( from all paginated pages)
  #○	Store each Jacket Price, Title and Top Seller message to a text file
  #○	Attach the text file to the report

  Scenario: Test Scenario
    Given I launch the Edge browser
    When I open the CP application in prod environment
    And I am on landing page
    And I click Btn_AcceptCookies element if exists
    And I click Btn_Close element if exists
    Then I verify Img_NbaLogo element is displayed
    And I wait for 5 seconds
    And I mouse hover the Btn_Shop element
    And I click Btn_Mens element
    And I wait for 15 seconds
    And I switch the browser tab to child
    When I am on shopMens page
    Then I verify Lbl_Men element is displayed
    And I pull out all products from the selected page
    Then I create a text file and add product details to it
    And I close the browser

