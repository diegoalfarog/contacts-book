/**
 * contacts book
 * autor Diego Alfaro
 * github diegoalfarog
 * @version 0.1
 * date: 4/15/2021
 */

public class Main {
  public static void main(String[] args) {
    ContactBook contactBook = new ContactBook();
    contactBook.addContact(new Contact("Siego", "50183494", "Diegoag400@gmail.com"));
    contactBook.addContact(new Contact("Diego", "84744027", "hacklol1994@gmail.com"));
    contactBook.addContact(new Contact("chicorita", "61362198", "chicorita1994@gmail.com"));

    new ContactBookMainUI(contactBook);

  }
}
