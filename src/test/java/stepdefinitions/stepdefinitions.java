package stepdefinitions;

import Resources.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testData.AddPlacePayload;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class stepdefinitions extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    AddPlacePayload Data = new AddPlacePayload();
    static String place_id;


    @Given("add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        // Write code here that turns the phrase above into concrete actions

        res = given().spec(requestSpecification()).body(Data.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with {string} https request")
    public void user_calls_with_https_request(String resource, String method) {
        // Write code here that turns the phrase above into concrete actions
        //Constructor will be called with value of resource which you pass
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        resspec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
        if (method.equalsIgnoreCase("POST"))
            response = res.when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource());
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(), 200);


    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String ExpectedValue) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(getJsonPath(response, keyValue), ExpectedValue);
    }

    @Then("verify placeId created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        //req spec
        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_https_request(resource, "GET");
        String actualName = getJsonPath(response, "name");
        assertEquals(actualName, expectedName);

    }

    @Given("DeletePlace Payload")
    public void delete_place_payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification()).body(Data.deletePlacePayload(place_id));
    }

}
