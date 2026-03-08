package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class AddressBook {

    private ArrayList<Contact> contactList = new ArrayList<>();

    // UC2 + UC7
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

    // UC2
    public void displayContacts() {
        for (Contact c : contactList) {
            System.out.println(c);
        }
    }

    // UC3
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

    // UC4
    public void deleteContact(String name) {

        contactList.removeIf(c ->
                c.getFirstName().equalsIgnoreCase(name));

        System.out.println("Contact deleted if existed.");
    }

    // UC8
    public void searchByCity(String city) {

        for (Contact c : contactList) {

            if (c.getCity().equalsIgnoreCase(city)) {
                System.out.println(c);
            }
        }
    }

    // UC8
    public void searchByState(String state) {

        for (Contact c : contactList) {

            if (c.getState().equalsIgnoreCase(state)) {
                System.out.println(c);
            }
        }
    }

    // UC9
    public void viewPersonsByCity(String city) {

        for (Contact c : contactList) {

            if (c.getCity().equalsIgnoreCase(city)) {
                System.out.println(c);
            }
        }
    }

    // UC9
    public void viewPersonsByState(String state) {

        for (Contact c : contactList) {

            if (c.getState().equalsIgnoreCase(state)) {
                System.out.println(c);
            }
        }
    }

    // UC10
    public void countByCity(String city) {

        int count = 0;

        for (Contact c : contactList) {
            if (c.getCity().equalsIgnoreCase(city)) {
                count++;
            }
        }

        System.out.println("Persons in city " + city + " : " + count);
    }

    // UC10
    public void countByState(String state) {

        int count = 0;

        for (Contact c : contactList) {
            if (c.getState().equalsIgnoreCase(state)) {
                count++;
            }
        }

        System.out.println("Persons in state " + state + " : " + count);
    }

    // UC11
    public void sortContactsByName() {

        contactList.sort((c1, c2) ->
                c1.getFirstName().compareToIgnoreCase(c2.getFirstName()));

        displayContacts();
    }

    // UC12
    public void sortByCity() {

        contactList.sort((c1, c2) ->
                c1.getCity().compareToIgnoreCase(c2.getCity()));

        displayContacts();
    }

    // UC12
    public void sortByState() {

        contactList.sort((c1, c2) ->
                c1.getState().compareToIgnoreCase(c2.getState()));

        displayContacts();
    }

    // UC12
    public void sortByZip() {

        contactList.sort((c1, c2) ->
                c1.getZip().compareToIgnoreCase(c2.getZip()));

        displayContacts();
    }

    // UC13 Write File
    public void writeContactsToFile() {

        try {

            FileWriter fw = new FileWriter("addressbook.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (Contact c : contactList) {

                pw.println(c.getFirstName() + "," +
                        c.getLastName() + "," +
                        c.getCity() + "," +
                        c.getState());
            }

            pw.close();

            System.out.println("Contacts written to file.");

        } catch (Exception e) {

            System.out.println("Error writing file.");
        }
    }

    // UC13 Read File
    public void readContactsFromFile() {

        try {

            File file = new File("addressbook.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                System.out.println(scanner.nextLine());
            }

            scanner.close();

        } catch (Exception e) {

            System.out.println("Error reading file.");
        }
    }
    
 // UC14 Write CSV File
    public void writeContactsToCSV() {

        try {

            FileWriter writer = new FileWriter("addressbook.csv");

            writer.append("FirstName,LastName,Address,City,State,Zip,Phone,Email\n");

            for (Contact c : contactList) {

                writer.append(c.getFirstName()).append(",");
                writer.append(c.getLastName()).append(",");
                writer.append(c.getAddress()).append(",");
                writer.append(c.getCity()).append(",");
                writer.append(c.getState()).append(",");
                writer.append(c.getZip()).append(",");
                writer.append(c.getPhoneNumber()).append(",");
                writer.append(c.getEmail()).append("\n");

            }

            writer.flush();
            writer.close();

            System.out.println("Contacts written to CSV file.");

        } catch (Exception e) {

            System.out.println("Error writing CSV file.");
        }
    }
    
 // UC14 Read CSV File
    public void readContactsFromCSV() {

        try {

            File file = new File("addressbook.csv");
            Scanner scanner = new Scanner(file);

            System.out.println("Reading CSV File:");

            while (scanner.hasNextLine()) {

                System.out.println(scanner.nextLine());

            }

            scanner.close();

        } catch (Exception e) {

            System.out.println("Error reading CSV file.");
        }
    }
}