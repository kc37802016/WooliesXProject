Feature: GOREST_Validations

  @GoREST
  Scenario: Validation of GO Rest API
    Given I Set Get data service endpoint API
    When I send "GET" HTTP request and validate the response status code "200"
    Then I validate JSON Schema for the "GET" request and Status Code "200"
    #Finish Test
