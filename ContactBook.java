/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
  private List<Contact> contacts;

  public ContactBook() {
    contacts = new ArrayList<Contact>();
  }

  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }

  public List<Object[]> showAllContacts() {
    List<Object[]> contactsToInsertInTable = new ArrayList<Object[]>();
    for (Contact contact : contacts) {
      contactsToInsertInTable
          .add(new Object[] { contacts.indexOf(contact)+1, contact.getName(), contact.getPhone(), contact.getEmail() });
    }
    return contactsToInsertInTable;
  }

  public Contact searchContact(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().equalsIgnoreCase(name)) {
        return contact;
      }
    }
    return null;
  }

  public Contact searchContact(int index) {
    return index > 0 && index <= contacts.size() ? contacts.get(index - 1) : null;
  }

  public boolean removeContact(String name) {
    Contact toRemoveContact = searchContact(name);
    if (toRemoveContact != null) {
      contacts.remove(toRemoveContact);
      return true;
    }
    return false;
  }

  public boolean removeContact(int index) {
    Contact toRemoveContact = searchContact(index);
    if (toRemoveContact != null) {
      contacts.remove(toRemoveContact);
      return true;
    }
    return false;
  }

  public void removeAllContact() {
    contacts.clear();
  }

  public boolean isEmpty() {
    return contacts.size() == 0;
  }

}
