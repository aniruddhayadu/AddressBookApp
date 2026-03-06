package com.addressbook;

import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void displayContacts() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    // UC3: Edit Contact
    public void editContact(String firstName, Contact updatedContact) {
        boolean found = false;

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                contactList.set(i, updatedContact);
                found = true;
                System.out.println("Contact updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}