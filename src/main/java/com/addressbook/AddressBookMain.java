package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class AddressBookMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		boolean exit = false;

		System.out.println("Welcome to Address Book Program");

		while (!exit) {

			System.out.println("\n--- Address Book Menu ---");
			System.out.println("1 Add Contact");
			System.out.println("2 Display Contacts");
			System.out.println("3 Edit Contact");
			System.out.println("4 Delete Contact");
			System.out.println("5 Search by City");
			System.out.println("6 Search by State");
			System.out.println("7 View Persons by City");
			System.out.println("8 View Persons by State");
			System.out.println("9 Count persons by City");
			System.out.println("10 Count persons by State");
			System.out.println("11 Sort Contacts by Name");
			System.out.println("12 Sort by City");
			System.out.println("13 Sort by State");
			System.out.println("14 Sort by Zip");
			System.out.println("15 Write Contacts to File");
			System.out.println("16 Read Contacts from File");
			System.out.println("17 Write Contacts to CSV");
			System.out.println("18 Read Contacts from CSV");
			System.out.println("19 Write Contacts to JSON");
			System.out.println("20 Read Contacts from JSON");
			System.out.println("21 Read Contacts from MySQL Database");
			System.out.println("22 Update Contact City in Database");
			System.out.println("23 Retrieve Contacts by Date Range");
			System.out.println("24 Add Contact to Database");
			System.out.println("25 View Contacts Grouped by City");
			System.out.println("26 View Contacts Grouped by State");
			System.out.println("27 Count Contacts by City in DB");
			System.out.println("28 Count Contacts by State in DB");
			System.out.println("29 Add Multiple Contacts using Threads");
			System.out.println("30 Exit");

			System.out.print("Enter Choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); 
			
			switch (choice) {

			// UC1 & UC2: Add a new contact
			case 1:
				System.out.print("First Name: ");
				String first = scanner.nextLine();

				System.out.print("Last Name: ");
				String last = scanner.nextLine();

				System.out.print("Address: ");
				String address = scanner.nextLine();

				System.out.print("City: ");
				String city = scanner.nextLine();

				System.out.print("State: ");
				String state = scanner.nextLine();

				System.out.print("Zip: ");
				String zip = scanner.nextLine();

				System.out.print("Phone: ");
				String phone = scanner.nextLine();

				System.out.print("Email: ");
				String email = scanner.nextLine();

				Contact contact = new Contact(first, last, address, city, state, zip, phone, email);
				addressBook.addContact(contact);
				break;

			// UC2: Display all contacts
			case 2:
				addressBook.displayContacts();
				break;

			// UC3: Edit an existing contact
			case 3:
				System.out.print("Enter First Name of contact to edit: ");
				String editName = scanner.nextLine();
				System.out.println("Enter new details:");

				System.out.print("New First Name: ");
				String newFirst = scanner.nextLine();

				System.out.print("New Last Name: ");
				String newLast = scanner.nextLine();

				System.out.print("New Address: ");
				String newAddress = scanner.nextLine();

				System.out.print("New City: ");
				String newCity = scanner.nextLine();

				System.out.print("New State: ");
				String newState = scanner.nextLine();

				System.out.print("New Zip: ");
				String newZip = scanner.nextLine();

				System.out.print("New Phone: ");
				String newPhone = scanner.nextLine();

				System.out.print("New Email: ");
				String newEmail = scanner.nextLine();

				Contact updatedContact = new Contact(newFirst, newLast, newAddress, newCity, newState, newZip, newPhone,
						newEmail);
				addressBook.editContact(editName, updatedContact);
				break;

			// UC4: Delete a contact
			case 4:
				System.out.print("Enter First Name of contact to delete: ");
				String deleteName = scanner.nextLine();
				addressBook.deleteContact(deleteName);
				break;

			// UC5: Search by City
			case 5:
				System.out.print("Enter City to search: ");
				addressBook.searchByCity(scanner.nextLine());
				break;

			// UC6: Search by State
			case 6:
				System.out.print("Enter State to search: ");
				addressBook.searchByState(scanner.nextLine());
				break;

			// UC7: View Persons by City
			case 7:
				System.out.print("Enter City to view persons: ");
				addressBook.viewPersonsByCity(scanner.nextLine());
				break;

			// UC8: View Persons by State
			case 8:
				System.out.print("Enter State to view persons: ");
				addressBook.viewPersonsByState(scanner.nextLine());
				break;

			// UC9: Count by City
			case 9:
				System.out.print("Enter City to count: ");
				addressBook.countByCity(scanner.nextLine());
				break;

			// UC10: Count by State
			case 10:
				System.out.print("Enter State to count: ");
				addressBook.countByState(scanner.nextLine());
				break;

			// UC11: Sort by Name
			case 11:
				addressBook.sortContactsByName();
				break;

			// UC12: Sort by City
			case 12:
				addressBook.sortByCity();
				break;

			// UC12: Sort by State
			case 13:
				addressBook.sortByState();
				break;

			// UC12: Sort by Zip
			case 14:
				addressBook.sortByZip();
				break;

			// UC13: Write to TXT File
			case 15:
				addressBook.writeContactsToFile();
				break;

			// UC13: Read from TXT File
			case 16:
				addressBook.readContactsFromFile();
				break;

			// UC14: Write to CSV File
			case 17:
				addressBook.writeContactsToCSV();
				break;

			// UC14: Read from CSV File
			case 18:
				addressBook.readContactsFromCSV();
				break;

			// UC15: Write to JSON File
			case 19:
				addressBook.writeContactsToJSON();
				break;

			// UC15: Read from JSON File
			case 20:
				addressBook.readContactsFromJSON();
				break;

			// UC16: Read from MySQL Database
			case 21:
				addressBook.readContactsFromDatabase();
				break;

			// UC17: Update Contact City in Database
			case 22:
				System.out.print("Enter First Name: ");
				String dbName = scanner.nextLine();
				System.out.print("Enter New City: ");
				String dbNewCity = scanner.nextLine();
				addressBook.updateContactCityInDatabase(dbName, dbNewCity);
				break;

			// UC18: Retrieve Contacts by Date Range
			case 23:
				System.out.print("Enter Start Date (YYYY-MM-DD): ");
				String startDate = scanner.nextLine();
				System.out.print("Enter End Date (YYYY-MM-DD): ");
				String endDate = scanner.nextLine();
				addressBook.getContactsBetweenDates(startDate, endDate);
				break;

			case 24:
				System.out.println("--- Add Contact to Database ---");
				System.out.print("First Name: ");
				String fn = scanner.nextLine();
				System.out.print("Last Name: ");
				String ln = scanner.nextLine();
				System.out.print("Address: ");
				String addr = scanner.nextLine();
				System.out.print("City: ");
				String ci = scanner.nextLine();
				System.out.print("State: ");
				String st = scanner.nextLine();
				System.out.print("Zip: ");
				String zp = scanner.nextLine();
				System.out.print("Phone: ");
				String ph = scanner.nextLine();
				System.out.print("Email: ");
				String em = scanner.nextLine();

				Contact newDBContact = new Contact(fn, ln, addr, ci, st, zp, ph, em);
				addressBook.addContactToDatabase(newDBContact);
				break;

			// View Grouped by City
			case 25:
				addressBook.displayContactsByCity();
				break;

			// View Grouped by State
			case 26:
				addressBook.displayContactsByState();
				break;

			// UC19: Count Contacts by City in DB
			case 27:
				System.out.print("Enter City to count in DB: ");
				String dbCityCount = scanner.nextLine();
				addressBook.countContactsByCityInDB(dbCityCount);
				break;

			// UC19: Count Contacts by State in DB
			case 28:
				System.out.print("Enter State to count in DB: ");
				String dbStateCount = scanner.nextLine();
				addressBook.countContactsByStateInDB(dbStateCount);
				break;

			// UC 21: Add Multiple Contacts using Threads
			case 29:
    			List<Contact> threadContacts = new ArrayList<>();
    			System.out.println("Enter number of contacts to add via Threads:");
    			int numContacts = scanner.nextInt();
    			scanner.nextLine(); // consume newline character

    			for (int i = 0; i < numContacts; i++) {
       	 			System.out.println("\nEnter details for Contact " + (i + 1) + ":");
        
        			System.out.print("First Name: ");
        			String fName = scanner.nextLine();
        
       				System.out.print("Last Name: ");
        			String lName = scanner.nextLine();
        
        			System.out.print("Address: ");
        			String addr = scanner.nextLine();
        
        			System.out.print("City: ");
        			String city = scanner.nextLine();
        
        			System.out.print("State: ");
        			String state = scanner.nextLine();
        
        			System.out.print("Zip: ");
        			String zip = scanner.nextLine();
        
        			System.out.print("Phone: ");
        			String phone = scanner.nextLine();
        
        			System.out.print("Email: ");
        			String email = scanner.nextLine();

        			threadContacts.add(new Contact(fName, lName, addr, city, state, zip, phone, email));
    			}

					
    			long start = System.currentTimeMillis();

					
    			addressBook.addMultipleContactsWithThreads(threadContacts);
    
    			long end = System.currentTimeMillis();
    			System.out.println("Execution time using Multithreading: " + (end - start) + " ms");
    			break;

			// Exit Program
			case 30:
				exit = true;
				System.out.println("Exiting Address Book...");
				break;

			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}

		scanner.close();
	}
}
