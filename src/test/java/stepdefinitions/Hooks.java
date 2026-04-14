package stepdefinitions;

import io.cucumber.java.Before;

import java.io.IOException;


public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        //execute this code only when place id is null
        //write a code that will give place id
        stepdefinitions m = new stepdefinitions();
        //place_id is static so it is stored in class memory not in object memory
        if (stepdefinitions.place_id == null) {
            m.add_place_payload_with("Yus", "english", "Bangalore");
            m.user_calls_with_https_request("AddPlaceAPI", "POST");
            m.verify_place_id_created_maps_to_using("Yus", "getPlaceAPI");
        }
    }
}
