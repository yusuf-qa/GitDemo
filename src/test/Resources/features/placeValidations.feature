Feature: Validating place API's

  @AddPlace
  Scenario Outline: Verify if Place is being added using AddPlaceAPI
    Given add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "Post" https request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify placeId created maps to "<name>" using "getPlaceAPI"

    Examples:
      | name    | language | address            |
      | mvn     | English  | World cross center |
      | BBhouse | Spanish  | Sea cross center   |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" https request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

  @Regression1
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" https request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

    //added by project X
  @Regression2
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" https request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

    //added by GitDemo Develop branch IST
  @Regression4
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" https request
    Then the API call got success with status code 200
    And "status" in response body is "OK"




