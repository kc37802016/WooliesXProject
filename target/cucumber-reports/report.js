$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GOREST_Validations.feature");
formatter.feature({
  "line": 1,
  "name": "GOREST_Validations",
  "description": "",
  "id": "gorest-validations",
  "keyword": "Feature"
});
formatter.before({
  "duration": 45209100,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Validation of GO Rest API",
  "description": "",
  "id": "gorest-validations;validation-of-go-rest-api",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@GoREST"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I Set Get data service endpoint API",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I send \"GET\" HTTP request and validate the response status code \"200\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I validate JSON Schema for the \"GET\" request and Status Code \"200\"",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigationSteps.iSetGetDataServiceEndpointAPI()"
});
formatter.result({
  "duration": 2414715400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 8
    },
    {
      "val": "200",
      "offset": 65
    }
  ],
  "location": "NavigationSteps.iSendHTTPRequestAndValidateTheResponseStatusCode(String,String)"
});
formatter.result({
  "duration": 6496143000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 32
    },
    {
      "val": "200",
      "offset": 62
    }
  ],
  "location": "NavigationSteps.iValidateJSONSchemaForTheRequestAndStatusCode(String,String)"
});
formatter.result({
  "duration": 2580696000,
  "status": "passed"
});
formatter.after({
  "duration": 6218700,
  "status": "passed"
});
formatter.uri("Woolworths_Life_Insurance.feature");
formatter.feature({
  "line": 1,
  "name": "Woolworths_Life_Insurance",
  "description": "",
  "id": "woolworths-life-insurance",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3648400,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Validation of Woolworths life Insurance coverage displayed in Ascending order",
  "description": "",
  "id": "woolworths-life-insurance;validation-of-woolworths-life-insurance-coverage-displayed-in-ascending-order",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@WoolworthsLifeInsurance"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I start the web browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I open Woolworths Insurance Home Page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I navigate to \"Life Insurance\" and then to \"Quotes\" and \"Life Insurance\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I click terms Checkbox and click on \"Get a quote now\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I enter the details in About you Section",
  "rows": [
    {
      "cells": [
        "First Name",
        "DOB",
        "Cigarette",
        "Gender",
        "Annual Income",
        "Cover"
      ],
      "line": 10
    },
    {
      "cells": [
        "HFSTest",
        "15/06/1988",
        "No",
        "Male",
        "Yes",
        ""
      ],
      "line": 11
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I verify Cover Amounts are in \"Ascending order\"",
  "keyword": "Then "
});
formatter.match({
  "location": "BrowserSteps.i_start_the_web_browser()"
});
formatter.result({
  "duration": 7344246300,
  "status": "passed"
});
formatter.match({
  "location": "NavigationSteps.iOpenWoolworthsInsuranceHomePage()"
});
formatter.result({
  "duration": 5654084100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Life Insurance",
      "offset": 15
    },
    {
      "val": "Quotes",
      "offset": 44
    },
    {
      "val": "Life Insurance",
      "offset": 57
    }
  ],
  "location": "NavigationSteps.iNavigateToAndThenToAnd(String,String,String)"
});
formatter.result({
  "duration": 5541388300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Get a quote now",
      "offset": 37
    }
  ],
  "location": "NavigationSteps.iClickTermsCheckboxAndClickOn(String)"
});
formatter.result({
  "duration": 3468341000,
  "status": "passed"
});
formatter.match({
  "location": "QuoteSteps.iEnterTheDetailsInAboutYouSection(DataTable)"
});
formatter.result({
  "duration": 11336742200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ascending order",
      "offset": 31
    }
  ],
  "location": "QuoteSteps.iVerifyCoverAmountsAreIn(String)"
});
formatter.result({
  "duration": 3583985200,
  "status": "passed"
});
formatter.after({
  "duration": 1286114900,
  "status": "passed"
});
});