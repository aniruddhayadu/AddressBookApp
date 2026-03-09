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

	@Test
	public void givenNewCityForContact_WhenUpdated_ShouldSyncWithAddressBook() {
		AddressBook addressBook = new AddressBook();

		// 1. Pehle data fetch karo sync karne ke liye
		Response response = RestAssured.get("/contacts");
		Contact[] contacts = response.as(Contact[].class);
		addressBook.setContactList(Arrays.asList(contacts));

		// 2. Local memory mein city update karo (Example: Aditya ki city update karni
		// hai)
		String contactName = "Aditya";
		String newCity = "Mumbai";

		// 3. API par PUT request bhejo (ID 1 man kar chal rahe hain)
		// Note: Real scenario mein hum pehle contact ki id dhoondte hain
		Response updateResponse = RestAssured.given().contentType("application/json")
				.body("{\"firstName\":\"Aditya\", \"lastName\":\"Jayswal\", \"city\":\"" + newCity
						+ "\", \"state\":\"MH\", \"zip\":\"400001\"}")
				.put("/contacts/1");

		Assertions.assertEquals(200, updateResponse.getStatusCode());

		// 4. Verification: Sync check
		Response finalResponse = RestAssured.get("/contacts/1");
		String updatedCity = finalResponse.jsonPath().get("city");

		System.out.println("UC 24: Updated City in JSON Server: " + updatedCity);
		Assertions.assertEquals(newCity, updatedCity);
	}
}