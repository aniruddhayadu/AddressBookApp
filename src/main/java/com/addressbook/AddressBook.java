package com.addressbook;

import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contactList = new ArrayList<>();

    // UC2
    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Display contacts
    public void displayContacts() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    // UC3 - Edit contact
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

    // UC4 - Delete contact
    public void deleteContact(String firstName) {
        boolean removed = contactList.removeIf(contact ->
                contact.getFirstName().equalsIgnoreCase(firstName));

        if (removed) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}