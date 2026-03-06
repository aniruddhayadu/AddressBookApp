package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Welcome to Address Book Program");

        // Add contact
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

        System.out.println("\nCurrent Contacts:");
        addressBook.displayContacts();

        // Delete contact
        System.out.print("\nEnter First Name of contact to delete: ");
        String deleteName = scanner.nextLine();

        addressBook.deleteContact(deleteName);

        System.out.println("\nUpdated Contact List:");
        addressBook.displayContacts();

        scanner.close();
    }
}