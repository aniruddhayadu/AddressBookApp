package com.addressbook;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class AddressBookRESTAssuredTest {

    @BeforeEach
    public void setup() {
        // Server ka base setup
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }

    @Test
    public void givenAddressBookDataInJSONServer_whenRetrieved_shouldMatchCount() {
        // 1. API se data fetch karo
        Response response = RestAssured.get("/contacts");
        
        // Console pe check karne ke liye (Sahi data aa raha hai ya nahi)
        System.out.println("Response Body: " + response.asString());

        // 2. Status code check (200 OK hona chahiye)
        Assertions.assertEquals(200, response.getStatusCode());

        // 3. Mapping ki jagah seedha JsonPath use karo (No dependency error)
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<Object> contacts = jsonPathEvaluator.getList("$");

        // 4. Verification: db.json mein 1 record hai toh yahan size 1 aani chahiye
        System.out.println("Total Contacts found: " + contacts.size());
        Assertions.assertEquals(1, contacts.size());
        
        // Ek step aage: Pehle contact ka naam check karlo
        String firstName = jsonPathEvaluator.get("[0].firstName");
        System.out.println("First Contact Name: " + firstName);
        Assertions.assertNotNull(firstName);
    }
}