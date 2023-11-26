Feature: Feature of DP2
  #○	Go to DP2 home page
  #○	Scroll down to the footer
  #○	Different links for various categories (Team, Tickets, Shop, etc..) will be visible
  #○	Find all the hyperlinks of the Footer links into a CSV file and report if any duplicate hyperlinks are present.

  Scenario: First scenario of DP2
    Given I launch the chrome browser
    When I open the DP2 application in prod environment
    And I am on landing page
    And I click Btn_AcceptCookies element
