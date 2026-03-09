package com.addressbook;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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
		// 1. Get Response
		Response response = RestAssured.get("/contacts");
		Assertions.assertEquals(200, response.getStatusCode());

		// 2. Count names using JsonPath (Internal RestAssured tool)
		List<String> names = response.jsonPath().getList("firstName");

		System.out.println("UC 22: Names found in DB: " + names);
		Assertions.assertTrue(names.size() > 0);
	}

	@Test
	public void givenMultipleContacts_WhenAddedToJSONServer_ShouldSyncWithAddressBook() {
		// 1. Data to add
		String contact1 = "{\"firstName\":\"Rahul\",\"lastName\":\"Dravid\",\"address\":\"Indiranagar\",\"city\":\"Bangalore\",\"state\":\"KA\",\"zip\":\"560038\",\"phoneNumber\":\"9988776655\",\"email\":\"rahul@test.com\"}";
		String contact2 = "{\"firstName\":\"MS\",\"lastName\":\"Dhoni\",\"address\":\"Harmu\",\"city\":\"Ranchi\",\"state\":\"JH\",\"zip\":\"834002\",\"phoneNumber\":\"8877665544\",\"email\":\"msd@test.com\"}";

		String[] newContacts = { contact1, contact2 };

		// 2. POST requests
		for (String contact : newContacts) {
			Response response = RestAssured.given().contentType("application/json").body(contact).post("/contacts");
			Assertions.assertEquals(201, response.getStatusCode());
		}

		// 3. Final Verification
		Response finalResponse = RestAssured.get("/contacts");
		List<String> allNames = finalResponse.jsonPath().getList("firstName");

		System.out.println("UC 23: Total contacts now: " + allNames.size());
		// Initial 1 + Added 2 = 3
		Assertions.assertTrue(allNames.size() >= 3);
	}
}