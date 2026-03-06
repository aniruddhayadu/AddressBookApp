package com.addressbook;

import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contactList = new ArrayList<>();

    // UC7 Duplicate Check + UC2 Add Contact
    public void addContact(Contact contact) {

        for (Contact c : contactList) {
            if (c.getFirstName().equalsIgnoreCase(contact.getFirstName())) {
                System.out.println("Contact with this name already exists.");
                return;
            }
        }

        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Display contacts
    public void displayContacts() {

        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    // UC3 Edit Contact
    public void editContact(String firstName, Contact updatedContact) {

        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getFirstName().equalsIgnoreCase(firstName)) {

                contactList.set(i, updatedContact);
                System.out.println("Contact updated successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // UC4 Delete Contact
    public void deleteContact(String firstName) {

        boolean removed = contactList.removeIf(contact ->
                contact.getFirstName().equalsIgnoreCase(firstName));

        if (removed)
            System.out.println("Contact deleted successfully.");
        else
            System.out.println("Contact not found.");
    }

    // UC8 Search by City
    public void searchByCity(String city) {

        boolean found = false;

        for (Contact contact : contactList) {

            if (contact.getCity().equalsIgnoreCase(city)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found)
            System.out.println("No contacts found in city: " + city);
    }

    // UC8 Search by State
    public void searchByState(String state) {

        boolean found = false;

        for (Contact contact : contactList) {

            if (contact.getState().equalsIgnoreCase(state)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found)
            System.out.println("No contacts found in state: " + state);
    }
    
    
 // UC9 - View persons by City
    public void viewPersonsByCity(String city) {

        boolean found = false;

        for (Contact contact : contactList) {

            if (contact.getCity().equalsIgnoreCase(city)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found in city: " + city);
        }
    }


    // UC9 - View persons by State
    public void viewPersonsByState(String state) {

        boolean found = false;

        for (Contact contact : contactList) {

            if (contact.getState().equalsIgnoreCase(state)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found in state: " + state);
        }
    }
    
    
 // UC10 - Count contacts by City
    public void countByCity(String city) {

        int count = 0;

        for (Contact contact : contactList) {

            if (contact.getCity().equalsIgnoreCase(city)) {
                count++;
            }
        }

        System.out.println("Number of contacts in city " + city + " : " + count);
    }


    // UC10 - Count contacts by State
    public void countByState(String state) {

        int count = 0;

        for (Contact contact : contactList) {

            if (contact.getState().equalsIgnoreCase(state)) {
                count++;
            }
        }

        System.out.println("Number of contacts in state " + state + " : " + count);
    }
}