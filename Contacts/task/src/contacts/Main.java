package contacts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        loop:
        while (true) {
            System.out.println("[menu] Enter action (add, list, search, count, exit):");
            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    addContact();
                    break;
                case "remove":
                    removeContact();
                    break;
                case "edit":
                    editContact();
                    break;
                case "count":
                    countContacts();
                    break;
                case "list":
                    listContacts();
                    break;
                case "search":
                    searchContacts();
                case "exit":
                    break loop;
            }
        }


    }

    private static void searchContacts() {
        System.out.println("Enter search query:");
        String searchQuery = scanner.nextLine();
        List<Contact> filteredList = contactList.stream()
                .filter(contact -> contact.getDetails().toLowerCase().contains(searchQuery.toLowerCase()))
                .collect(Collectors.toList());
        System.out.printf("Found %d results:", filteredList.size());
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(i + 1 + "." + " " + filteredList.get(i).getName());
        }
        System.out.println();
        System.out.println("[search] Enter action ([number], back, again):");
        String input = scanner.nextLine();
        if ("again".equals(input)) {
            searchContacts();
        }
        if (!"back".equals(input)) {
            int selection = Integer.parseInt(input);
            filteredList.get(selection - 1).getDetails();

            System.out.println();
            System.out.println("[record] Enter action (edit, delete, menu):");
            String action = scanner.nextLine();
            switch (action) {
                case "edit":
                    editContact(contactList.get(selection - 1), contactList.indexOf(filteredList.get(selection - 1)));
                    break;
                case "delete":
                    removeContact(contactList.indexOf(filteredList.get(selection - 1)));
                    break;
            }
        }
    }

    private static void listContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No records to list!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + "." + " " + contactList.get(i).getName());
            }
            System.out.println("[list] Enter action ([number], back):");
            String action = scanner.nextLine();
            if (!"back".equals(action)) {
                int indexToViewInfo = Integer.parseInt(action);
                System.out.println(contactList.get(indexToViewInfo - 1).getDetails());
                System.out.println();
                System.out.println("[record] Enter action (edit, delete, menu):");
                action = scanner.nextLine();
                switch (action) {
                    case "edit":
                        editContact(contactList.get(indexToViewInfo - 1), indexToViewInfo);
                        break;
                    case "delete":
                        removeContact(indexToViewInfo);
                        break;
                }
            }

        }
        System.out.println();
    }

    private static void removeContact(int indexToViewInfo) {
        contactList.remove(indexToViewInfo - 1);
        System.out.println("The record removed!");
    }

    private static void countContacts() {
        System.out.printf("The phone book has %d records", contactList.size());
        System.out.println();
    }

    private static void editContact() {
        if (contactList.isEmpty()) {
            System.out.println("No records to edit!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + "." + " " + contactList.get(i).getName());
            }
            System.out.println("Select a record:");
            int recordIndex = Integer.parseInt(scanner.nextLine());
            Contact contact = contactList.get(recordIndex - 1);
            System.out.println("Select a field (" + contact.printListOfModifiableFields() + "): ");
            String fieldToEdit = scanner.nextLine();
            System.out.println("Enter " + fieldToEdit);
            String editedField = scanner.nextLine();

            contact.modifyField(fieldToEdit, editedField);
            contactList.set(recordIndex - 1, contact);
            contact.setLastEditTimestamp(LocalDateTime.now().withSecond(0));
            contactList.set(recordIndex - 1, contact);
            System.out.println("The record updated!");
            System.out.println();
        }
    }

    private static void editContact(Contact contact, int recordIndex) {
        System.out.println("Select a field (" + contact.printListOfModifiableFields() + "): ");
        String fieldToEdit = scanner.nextLine();
        System.out.println("Enter " + fieldToEdit);
        String editedField = scanner.nextLine();

        contact.modifyField(fieldToEdit, editedField);
        contactList.set(recordIndex - 1, contact);
        contact.setLastEditTimestamp(LocalDateTime.now().withSecond(0));
        contactList.set(recordIndex - 1, contact);
        System.out.println("The record updated!");
        System.out.println();
    }

    private static void removeContact() {
        if (contactList.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(i + 1 + "." + " " + contactList.get(i).getName());
            }
            System.out.println("Select a record:");
            int numberToRemove = Integer.parseInt(scanner.nextLine());
            contactList.remove(numberToRemove - 1);
            System.out.println("The record removed!");
        }
    }

    private static void addContact() {
        System.out.println("Enter the type (person, organization):");
        String type = scanner.nextLine();
        switch (type) {
            case "person":
                System.out.println("Enter the name:");
                String firstName = scanner.nextLine();
                System.out.println("Enter the surname:");
                String surname = scanner.nextLine();
                System.out.println("Enter the birth date:");
                String birthDate = scanner.nextLine();
                if (birthDate.isEmpty()) {
                    System.out.println("Bad birth date!");
                }
                System.out.println("Enter the gender (M, F):");
                String gender = scanner.nextLine();
                if (gender.isEmpty()) {
                    System.out.println("Bad gender!");
                }
                System.out.println("Enter the number:");
                String phoneNumber = scanner.nextLine();
                contactList.add(new PersonContact(phoneNumber, true, firstName, surname, gender, birthDate));
                break;
            case "organization":
                System.out.println("Enter the organization name:");
                String orgName = scanner.nextLine();
                System.out.println("Enter the address:");
                String address = scanner.nextLine();
                System.out.println("Enter the number:");
                phoneNumber = scanner.nextLine();
                contactList.add(new OrgContact(phoneNumber, false, orgName, address));
                break;
        }

        System.out.println("The record added.");
        System.out.println();
    }
}
