package com.addressbook;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

/*
 * AddressBook class containing all UC operations
 */

public class AddressBook {

	private ArrayList<Contact> contactList = new ArrayList<>();

	// UC2 + UC7 Add contact with duplicate check
	public void addContact(Contact contact) {

		for (Contact c : contactList) {

			if (c.getFirstName().equalsIgnoreCase(contact.getFirstName())) {

				System.out.println("Contact already exists.");
				return;
			}
		}

		contactList.add(contact);
		System.out.println("Contact added successfully.");
	}

	// UC2 Display contacts
	public void displayContacts() {

		for (Contact c : contactList)
			System.out.println(c);
	}

	// UC3 Edit contact
	public void editContact(String name, Contact updated) {

		for (int i = 0; i < contactList.size(); i++) {

			if (contactList.get(i).getFirstName().equalsIgnoreCase(name)) {

				contactList.set(i, updated);
				System.out.println("Contact updated.");
				return;
			}
		}

		System.out.println("Contact not found.");
	}

	// UC4 Delete contact
	public void deleteContact(String name) {

		contactList.removeIf(c -> c.getFirstName().equalsIgnoreCase(name));
		System.out.println("Contact deleted.");
	}

	// UC5 Search person by city
	public void searchByCity(String city) {

		for (Contact c : contactList)
			if (c.getCity().equalsIgnoreCase(city))
				System.out.println(c);
	}

	// UC6 Search person by state
	public void searchByState(String state) {

		for (Contact c : contactList)
			if (c.getState().equalsIgnoreCase(state))
				System.out.println(c);
	}

	// UC7 View persons by city
	public void viewPersonsByCity(String city) {

		for (Contact c : contactList)
			if (c.getCity().equalsIgnoreCase(city))
				System.out.println(c);
	}

	// UC8 View persons by state
	public void viewPersonsByState(String state) {

		for (Contact c : contactList)
			if (c.getState().equalsIgnoreCase(state))
				System.out.println(c);
	}

	// UC9 Count persons by city
	public void countByCity(String city) {

		long count = contactList.stream().filter(c -> c.getCity().equalsIgnoreCase(city)).count();

		System.out.println("Persons in city " + city + " : " + count);
	}

	// UC10 Count persons by state
	public void countByState(String state) {

		long count = contactList.stream().filter(c -> c.getState().equalsIgnoreCase(state)).count();

		System.out.println("Persons in state " + state + " : " + count);
	}

	// UC11 Sort contacts by name
	public void sortContactsByName() {

		contactList.sort((c1, c2) -> c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));

		displayContacts();
	}

	// UC12 Sort by city
	public void sortByCity() {

		contactList.sort((c1, c2) -> c1.getCity().compareToIgnoreCase(c2.getCity()));

		displayContacts();
	}

	// UC12 Sort by state
	public void sortByState() {

		contactList.sort((c1, c2) -> c1.getState().compareToIgnoreCase(c2.getState()));

		displayContacts();
	}

	// UC12 Sort by zip
	public void sortByZip() {

		contactList.sort((c1, c2) -> c1.getZip().compareToIgnoreCase(c2.getZip()));

		displayContacts();
	}

	// UC13 Write TXT file
	public void writeContactsToFile() {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter("addressbook.txt"));

			for (Contact c : contactList)
				pw.println(c.getFirstName() + "," + c.getLastName() + "," + c.getCity() + "," + c.getState());

			pw.close();

			System.out.println("Contacts written to TXT.");

		} catch (Exception e) {

			System.out.println("Error writing file.");
		}
	}

	// UC13 Read TXT
	public void readContactsFromFile() {

		try {

			Scanner scanner = new Scanner(new File("addressbook.txt"));

			while (scanner.hasNextLine())
				System.out.println(scanner.nextLine());

			scanner.close();

		} catch (Exception e) {

			System.out.println("Error reading file.");
		}
	}

	// UC14 Write CSV
	public void writeContactsToCSV() {

		try {

			FileWriter writer = new FileWriter("addressbook.csv");

			writer.append("FirstName,LastName,Address,City,State,Zip,Phone,Email\n");

			for (Contact c : contactList) {

				writer.append(c.getFirstName()).append(",").append(c.getLastName()).append(",").append(c.getAddress())
						.append(",").append(c.getCity()).append(",").append(c.getState()).append(",").append(c.getZip())
						.append(",").append(c.getPhoneNumber()).append(",").append(c.getEmail()).append("\n");
			}

			writer.close();

			System.out.println("Contacts written to CSV.");

		} catch (Exception e) {

			System.out.println("Error writing CSV.");
		}
	}

	// UC14 Read CSV
	public void readContactsFromCSV() {

		try {

			Scanner scanner = new Scanner(new File("addressbook.csv"));

			while (scanner.hasNextLine())
				System.out.println(scanner.nextLine());

			scanner.close();

		} catch (Exception e) {

			System.out.println("Error reading CSV.");
		}
	}

	// UC15 Write JSON
	public void writeContactsToJSON() {

		try {

			Gson gson = new Gson();
			FileWriter writer = new FileWriter("addressbook.json");

			gson.toJson(contactList, writer);

			writer.close();

			System.out.println("Contacts written to JSON.");

		} catch (Exception e) {

			System.out.println("Error writing JSON.");
		}
	}

	// UC15 Read JSON
	public void readContactsFromJSON() {

		try {

			Gson gson = new Gson();
			FileReader reader = new FileReader("addressbook.json");

			Contact[] contacts = gson.fromJson(reader, Contact[].class);

			if (contacts != null)
				for (Contact c : contacts)
					System.out.println(c);

			reader.close();

		} catch (Exception e) {

			System.out.println("Error reading JSON.");
		}
	}

	// UC16 Retrieve from MySQL
	public void readContactsFromDatabase() {

		AddressBookDBService dbService = new AddressBookDBService();

		List<Contact> contacts = dbService.readContactsFromDatabase();

		System.out.println("\n--- Contacts from Database ---");

		contacts.forEach(System.out::println);
	}

}