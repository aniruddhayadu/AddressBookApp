package com.addressbook;

import java.util.Scanner;

/*
 * Main class running AddressBook program
 */

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
			System.out.println("24 Exit");

			System.out.print("Enter Choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

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

			case 2:
				addressBook.displayContacts();
				break;
			case 3:
				/* edit code same as before */ break;
			case 4:
				/* delete code */ break;
			case 5:
				addressBook.searchByCity(scanner.nextLine());
				break;
			case 6:
				addressBook.searchByState(scanner.nextLine());
				break;
			case 7:
				addressBook.viewPersonsByCity(scanner.nextLine());
				break;
			case 8:
				addressBook.viewPersonsByState(scanner.nextLine());
				break;
			case 9:
				addressBook.countByCity(scanner.nextLine());
				break;
			case 10:
				addressBook.countByState(scanner.nextLine());
				break;
			case 11:
				addressBook.sortContactsByName();
				break;
			case 12:
				addressBook.sortByCity();
				break;
			case 13:
				addressBook.sortByState();
				break;
			case 14:
				addressBook.sortByZip();
				break;
			case 15:
				addressBook.writeContactsToFile();
				break;
			case 16:
				addressBook.readContactsFromFile();
				break;
			case 17:
				addressBook.writeContactsToCSV();
				break;
			case 18:
				addressBook.readContactsFromCSV();
				break;
			case 19:
				addressBook.writeContactsToJSON();
				break;
			case 20:
				addressBook.readContactsFromJSON();
				break;
			case 21:
				addressBook.readContactsFromDatabase();
				break;

			case 22:

				System.out.print("Enter First Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter New City: ");
				String newCity = scanner.nextLine();
				addressBook.updateContactCityInDatabase(name, newCity);
				break;

			case 23: {
				System.out.print("Enter Start Date (YYYY-MM-DD): ");
				String startDate = scanner.nextLine();
				System.out.print("Enter End Date (YYYY-MM-DD): ");
				String endDate = scanner.nextLine();
				addressBook.getContactsBetweenDates(startDate, endDate);
				break;
			}

			case 24:
				exit = true;
				System.out.println("Exiting Address Book...");
				break;
			}
		}

		scanner.close();
	}
}