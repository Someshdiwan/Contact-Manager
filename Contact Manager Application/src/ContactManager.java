import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> phones = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void handleChoice(String choice) {
        if (choice.equals("1")) {
            addContact();
        } else if (choice.equals("2")) {
            viewContacts();
        } else if (choice.equals("3")) {
            searchContact();
        } else if (choice.equals("4")) {
            updateContact();
        } else if (choice.equals("5")) {
            deleteContact();
        } else if (choice.equals("6")) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter phone number (10 digits): ");
        String phone = scanner.nextLine().trim();

        if (name.isEmpty() || !phone.matches("\\d{10}")) {
            System.out.println("Invalid input!");
            return;
        }

        // check for existing contact case-insensitively
        for (String existing : names) {
            if (existing.equalsIgnoreCase(name)) {
                System.out.println("Contact already exists!");
                return;
            }
        }

        names.add(name);
        phones.add(phone);
        System.out.println("Contact added successfully!");
    }

    public static void viewContacts() {
        if (names.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\nContact List:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + ": " + phones.get(i));
        }
    }

    public static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim();

        int index = -1;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            System.out.println(names.get(index) + ": " + phones.get(index));
        } else {
            System.out.println("Contact not found!");
        }
    }

    public static void updateContact() {
        System.out.print("Enter the contact name to update: ");
        String oldName = scanner.nextLine().trim();
        int index = -1;

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(oldName)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Contact not found!");
            return;
        }

        System.out.print("Enter new name (press Enter to keep same): ");
        String newName = scanner.nextLine().trim();
        System.out.print("Enter new phone number (press Enter to keep same): ");
        String newPhone = scanner.nextLine().trim();

        if (!newName.isEmpty()) {
            // ensure no duplicate name (case-insensitive) except the same index
            for (int i = 0; i < names.size(); i++) {
                if (i == index) continue;
                if (names.get(i).equalsIgnoreCase(newName)) {
                    System.out.println("Another contact with this name already exists!");
                    return;
                }
            }
            names.set(index, newName);
        }

        if (!newPhone.isEmpty()) {
            if (!newPhone.matches("\\d{10}")) {
                System.out.println("Invalid phone number!");
                return;
            }
            phones.set(index, newPhone);
        }

        System.out.println("Contact updated successfully!");
    }

    public static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine().trim();
        int index = -1;

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Contact not found!");
        } else {
            names.remove(index);
            phones.remove(index);
            System.out.println("Contact deleted successfully!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add a Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search for a Contact");
            System.out.println("4. Update a Contact");
            System.out.println("5. Delete a Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("6")) {
                System.out.println("Goodbye!");
                break;
            }
            handleChoice(choice);
        }
    }
}
