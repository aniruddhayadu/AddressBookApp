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
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }

    @Test
    public void givenAddressBookDataInJSONServer_whenRetrieved_shouldMatchCount() {
        Response response = RestAssured.get("/contacts");
        
        System.out.println("Response Body: " + response.asString());

        Assertions.assertEquals(200, response.getStatusCode());

        JsonPath jsonPathEvaluator = response.jsonPath();
        List<Object> contacts = jsonPathEvaluator.getList("$");

        // 4. Verification:
        System.out.println("Total Contacts found: " + contacts.size());
        Assertions.assertEquals(1, contacts.size());
        
        String firstName = jsonPathEvaluator.get("[0].firstName");
        System.out.println("First Contact Name: " + firstName);
        Assertions.assertNotNull(firstName);
    }
}
