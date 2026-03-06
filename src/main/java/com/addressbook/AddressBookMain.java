package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, AddressBook> addressBookMap = new HashMap<>();

        System.out.println("Welcome to Address Book Program");

        boolean exit = false;

        while (!exit) {

            System.out.println("\nChoose an option:");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Address Book Name: ");
                    String bookName = scanner.nextLine();

                    addressBookMap.put(bookName, new AddressBook());

                    System.out.println("Address Book created: " + bookName);

                    break;

                case 2:

                    System.out.print("Enter Address Book Name: ");
                    String name = scanner.nextLine();

                    AddressBook addressBook = addressBookMap.get(name);

                    if (addressBook == null) {
                        System.out.println("Address Book not found.");
                        break;
                    }

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();

                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();

                    System.out.print("Enter Zip: ");
                    String zip = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

                    addressBook.addContact(contact);

                    break;

                case 3:

                    System.out.print("Enter Address Book Name: ");
                    String displayBook = scanner.nextLine();

                    AddressBook displayAddressBook = addressBookMap.get(displayBook);

                    if (displayAddressBook != null) {
                        displayAddressBook.displayContacts();
                    } else {
                        System.out.println("Address Book not found.");
                    }

                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting Address Book System");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }

        scanner.close();
    }
}