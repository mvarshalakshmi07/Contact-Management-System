import java.util.*;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    void display() {
        System.out.println("Name: " + name + " | Phone: " + phone);
    }
}
public class ContactManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== Contact Management System =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = s.nextInt();
                s.nextLine();

                // Decision Making (if-else)

                if (choice == 1) {

                    System.out.print("Enter Name: ");
                    String name = s.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = s.nextLine();

                    contacts.add(new Contact(name, phone));
                    System.out.println("Contact added successfully!");

                }

                else if (choice == 2) {

                    if (contacts.isEmpty()) {
                        System.out.println("No contacts available.");
                    } else {
                        for (Contact c : contacts) {
                            c.display();
                        }
                    }

                }

                else if (choice == 3) {

                    System.out.print("Enter name to search: ");
                    String searchName = s.nextLine();

                    boolean found = false;

                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(searchName)) {
                            c.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Contact not found!");
                    }

                }

                else if (choice == 4) {

                    System.out.print("Enter name to delete: ");
                    String deleteName = s.nextLine();

                    Iterator<Contact> it = contacts.iterator();
                    boolean removed = false;

                    while (it.hasNext()) {
                        Contact c = it.next();

                        if (c.name.equalsIgnoreCase(deleteName)) {
                            it.remove();
                            removed = true;
                            System.out.println("Contact deleted!");
                        }
                    }

                    if (!removed) {
                        System.out.println("Contact not found!");
                    }

                }

                else if (choice == 5) {
                    System.out.println("Exiting program...");
                }

                else {
                    System.out.println("Invalid choice!");
                }

            }

            catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                s.nextLine();
            }
        }

        s.close();
    }
}