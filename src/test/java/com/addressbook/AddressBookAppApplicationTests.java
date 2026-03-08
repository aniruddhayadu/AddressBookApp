package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddressBookAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void givenAddressBookDB_whenRetrieved_shouldReturnContacts() {

		AddressBookDBService service = new AddressBookDBService();

		List<Contact> contacts = service.readContactsFromDatabase();

		assertNotNull(contacts);
	}

	@Test
	void givenNewCity_whenUpdated_shouldSyncWithDatabase() {

		AddressBookDBService service = new AddressBookDBService();

		boolean result = service.updateContactCity("Aditya", "Indore");

		assertTrue(result);
	}

	@Test
	void givenDateRange_whenRetrieved_shouldReturnContacts() {

		AddressBookDBService service = new AddressBookDBService();

		List<Contact> contacts = service.getContactsByDateRange("2024-01-01", "2024-12-31");

		assertTrue(contacts.size() > 0);
	}

}
