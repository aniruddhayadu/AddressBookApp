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
}