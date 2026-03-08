package com.addressbook;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
