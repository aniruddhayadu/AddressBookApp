package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book Program");

        boolean exit = false;

        while (!exit) {

            System.out.println("\nChoose an option:");
            System.out.println("1 Add Contact");
            System.out.println("2 Display Contacts");
            System.out.println("3 Edit Contact");
            System.out.println("4 Delete Contact");
            System.out.println("5 Search by City");
            System.out.println("6 Search by State");
            System.out.println("7 Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

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

                case 2:

                    addressBook.displayContacts();
                    break;

                case 3:

                    System.out.print("Enter First Name to edit: ");
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

                    Contact updatedContact =
                            new Contact(newFirst, newLast, newAddress, newCity,
                                    newState, newZip, newPhone, newEmail);

                    addressBook.editContact(editName, updatedContact);

                    break;

                case 4:

                    System.out.print("Enter First Name to delete: ");
                    String deleteName = scanner.nextLine();

                    addressBook.deleteContact(deleteName);

                    break;

                case 5:

                    System.out.print("Enter City: ");
                    String searchCity = scanner.nextLine();

                    addressBook.searchByCity(searchCity);

                    break;

                case 6:

                    System.out.print("Enter State: ");
                    String searchState = scanner.nextLine();

                    addressBook.searchByState(searchState);

                    break;

                case 7:

                    exit = true;
                    System.out.println("Exiting Address Book...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}