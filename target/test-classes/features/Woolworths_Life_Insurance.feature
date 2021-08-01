Feature: Woolworths_Life_Insurance

  @WoolworthsLifeInsurance
  Scenario: Validation of Woolworths life Insurance coverage displayed in Ascending order
    Given I start the web browser
    When I open Woolworths Insurance Home Page
    When I navigate to "Life Insurance" and then to "Quotes" and "Life Insurance"
    When I click terms Checkbox and click on "Get a quote now"
    When I enter the details in About you Section
      | First Name | DOB        | Cigarette | Gender | Annual Income | Cover |
      | HFSTest    | 15/06/1988 | No        | Male   | Yes           |       |
    Then I verify Cover Amounts are in "Ascending order"
    #Finish Test