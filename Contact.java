import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void viewAllContacts() {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email Address: " + contact.getEmailAddress());
            System.out.println("------------------------");
        }
    }

    public void searchContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email Address: " + contact.getEmailAddress());
                return;
            }
        }
        System.out.println("Contact not found!");
    }
}

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit the program");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    addressBook.viewAllContacts();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    addressBook.searchContactByName(searchName);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
