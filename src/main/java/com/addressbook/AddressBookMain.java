package com.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        boolean exit = false;

        System.out.println("Welcome to Address Book Program");

        System.out.println("Enter Choice.  ");

        while (!exit) {

            System.out.println("\n1 Add Contact");
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
            System.out.println("19 Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();

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

                    Contact contact = new Contact(firstName, lastName, address,
                            city, state, zip, phone, email);

                    addressBook.addContact(contact);
                    break;

                case 2:
                    addressBook.displayContacts();
                    break;

                case 3:

                    System.out.print("Enter name to edit: ");
                    String editName = scanner.nextLine();

                    System.out.println("Enter new details");

                    Contact updated = new Contact(
                            scanner.nextLine(),
                            scanner.nextLine(),
                            scanner.nextLine(),
                            scanner.nextLine(),
                            scanner.nextLine(),
                            scanner.nextLine(),
                            scanner.nextLine(),
                            scanner.nextLine()
                    );

                    addressBook.editContact(editName, updated);
                    break;

                case 4:

                    System.out.print("Enter name to delete: ");
                    addressBook.deleteContact(scanner.nextLine());
                    break;

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
                    exit = true;
                    System.out.println("Exiting Address Book...");
                    break;
            }
        }

        scanner.close();
    }
}